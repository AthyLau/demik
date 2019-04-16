package demik.springcloud.studentmanagementsystem9001.shiro;

import demik.springcloud.entity.domain.dto.UserDTO;
import demik.springcloud.entity.domain.vo.UserNameVO;
import demik.springcloud.entity.feignservice.FeignService;
import demik.springcloud.studentmanagementsystem9001.service.URLPermissionService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.web.filter.authc.BasicHttpAuthenticationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Function: jwt过滤器，需要和shiro配合 由于继承了基础拦截器，因此会在请求过来时，进行验证
 *
 * @author miluo
 * Date: 2018/9/6 下午4:28
 * @since JDK 1.8
 */
@Configuration
public class JWTFilter extends BasicHttpAuthenticationFilter {
    public static String error = "";
    @Autowired
    private FeignService feignService;
    @Autowired
    private URLPermissionService urlPermissionService;
    /**
     * 检测header里面是否包含Authorization字段即可
     *
     * @param request  request
     * @param response respone
     * @return true有权限  false没权限
     */
    @Override
    protected boolean isLoginAttempt(ServletRequest request, ServletResponse response) {
        HttpServletRequest req = (HttpServletRequest) request;
        String authorization = req.getHeader("Authorization");
        if(authorization != null){
            if(authorization.equals("Basic Og==")){
                return false;
            }
            return true;
        }
        return false;
    }

    /**
     * 进行登陆的方法，如果登陆成功就有权限，登陆失败就没权限
     *
     * @param request  request
     * @param response response
     * @return true有权限  false没权限
     * @throws Exception 异常
     */
    @Override
    protected boolean executeLogin(ServletRequest request, ServletResponse response) throws Exception {
        System.out.println("===================执行登陆方法========================");
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        //从header中获取Authorization的值
        String authorization = httpServletRequest.getHeader("Authorization");
        JWTToken token = new JWTToken(authorization);
        //判断token是不是空或者默认token
        if(authorization==null||authorization.equals("Basic Og==")){
            error = "Token is null!";
            throw new AuthenticationException("Token is null!");
        }
        // 解密获得username，用于和数据库进行对比
        String username = JWTUtil.getUsername(authorization);
        UserDTO userBean = feignService.checkUserInfo(new UserNameVO(username)).getData();
        if (userBean == null) {
            error = "User didn't existed!";
            throw new AuthenticationException("User didn't existed!");
        }

        //用户名和密码校验失败
        if (!JWTUtil.verify(authorization, username, userBean.getUserPassword())) {
            error = "Username or password error!";
            throw new AuthenticationException("Username or password error!");
        }
        //校验权限
        String uri = ((HttpServletRequest) request).getRequestURI();
        String[] uris = uri.split("/");
        System.out.println(uri);
        String url = uris[uris.length-1];
        String permission = urlPermissionService.getPermissionByURL("/"+url);
        if(!(userBean.getPermission()!=null&&permission!=null&&userBean.getPermission().contains(permission))){
            error = "Permission error！";
            //权限不正确
            throw new AuthenticationException("Permission error");
        }
//        urlPermissionService.getPermissionByURL(name);
////        // 提交给realm进行登入，如果错误他会抛出异常并被捕获
//        getSubject(request, response).login(token);
////         如果没有抛出异常则代表登入成功，返回true
        //接下来校验用户与token是否正确

        return true;
    }

    /**
     * 详细说明下为什么最终返回的都是true，即允许访问
     * 例如我们提供一个地址 GET /article
     * 登入用户和游客看到的内容是不同的
     * 如果在这里返回了false，请求会被直接拦截，用户看不到任何东西
     * 所以我们在这里返回true，Controller中可以通过 subject.isAuthenticated() 来判断用户是否登入
     * 如果有些资源只有登入用户才能访问，我们只需要在方法上面加上 @RequiresAuthentication 注解即可
     * 但是这样做有一个缺点，就是不能够对GET,POST等请求进行分别过滤鉴权(因为我们重写了官方的方法)，但实际上对应用影响不大
     */
    @Override
    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) {
//        String url = "http://127.0.0.1:8081/error/error_get";
        System.out.println("===================执行全局拦截========================");
        if (isLoginAttempt(request, response)) {
            try {
                executeLogin(request, response);
            } catch (Exception e) {
//                try {
//                    HttpServletResponse httpServletResponse = (HttpServletResponse)response;
//                    httpServletResponse.sendRedirect(url);
//                } catch (IOException io) {
//                    io.printStackTrace();
//                }
                response401(request, response);
                return false;
            }
        }
        return true;
    }

    /**
     * 对跨域提供支持
     * 其实就是在请求头里，人为的把服务器的地址填上
     * http没那么智能，就是看头部信息的，Origin 和Access……
     */
    @Override
    protected boolean preHandle(ServletRequest request, ServletResponse response) throws Exception {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;
        httpServletResponse.setHeader("Access-control-Allow-Origin", httpServletRequest.getHeader("Origin"));
        httpServletResponse.setHeader("Access-Control-Allow-Methods", "GET,POST,OPTIONS,PUT,DELETE,PATCH");
        httpServletResponse.setHeader("Access-Control-Allow-Headers", httpServletRequest.getHeader("Access-Control-Request-Headers"));
        // 跨域时会首先发送一个option请求，这里我们给option请求直接返回正常状态
        if (httpServletRequest.getMethod().equals(RequestMethod.OPTIONS.name())) {
            httpServletResponse.setStatus(HttpStatus.OK.value());
            return false;
        }
        if(isAccessAllowed(request,response,null)){
            return true;
        }
        return false;
    }

    /**
     * 将非法请求跳转到 /401
     * 这个方法特别爱出错，后面优化的时候注意一下
     */
    private void response401(ServletRequest req, ServletResponse resp) {
        try {
            HttpServletResponse httpServletResponse = (HttpServletResponse) resp;
            //这边如果写返回到/401的话是不对的因为没有设置访问401不通过自己的过滤器访问。
            if(error.equals("Token is null!")){
                httpServletResponse.sendRedirect("http://127.0.0.1:8080/error/error_token_null");
            }else if(error.equals("User didn't existed!")){
                httpServletResponse.sendRedirect("http://127.0.0.1:8080/error/error_user_not_existed");
            }else if(error.equals("Username or password error!")){
                httpServletResponse.sendRedirect("http://127.0.0.1:8080/error/error_user_or_password");
            }else if(error.equals("Permission error！")){
                httpServletResponse.sendRedirect("http://127.0.0.1:8080/error/error_permission");
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}

