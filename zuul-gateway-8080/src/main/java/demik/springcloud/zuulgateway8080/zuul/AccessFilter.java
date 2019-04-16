package demik.springcloud.zuulgateway8080.zuul;

/**
 * Function:
 *
 * @author liubing
 * Date: 2019/3/27 2:03 PM
 * @since JDK 1.8
 */
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import demik.springcloud.entity.commonbox.ResultCode;
import demik.springcloud.entity.commonbox.ResultGenerator;
import demik.springcloud.entity.domain.vo.UserNameVO;
import demik.springcloud.entity.feignservice.FeignService;
import demik.springcloud.entity.util.ClientIp;
import demik.springcloud.singlesignon80.service.AuthService;
import demik.springcloud.singlesignon80.shiro.JWTUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

/**
  * 访问拦截器
  * 
  * @author Star.Guo
  *
  */
@Component
public class AccessFilter extends ZuulFilter {

    private static final Logger log = LoggerFactory.getLogger(AccessFilter.class);
    @Autowired
    private FeignService feignService;
    @Override
    // 是否要过滤，false不过滤，true则需要过滤
    public boolean shouldFilter() {
        // TODO Auto-generated method stub
        return true;
    }
    public Boolean judgeIpAddr(HttpServletRequest request){
        System.out.println(feignService);
        if(feignService.isNameExists(new UserNameVO(ClientIp.getIpAddr(request))).getData().toString().equals("true")){
            System.out.println("ip存在");
            return true;
        }
        return false;
    }
    @Override
    // 具体实施过滤逻辑的地方
    // 只拦截没有带token与用户名的
    /**
     * 非本服务架构内的项目获取临时token时不带token与用户名
     */
    public Object run() {
        System.out.println("进入zuul过滤器");
        //获取请求上下文
        RequestContext requestContext = RequestContext.getCurrentContext();
        HttpServletRequest request = requestContext.getRequest();
        String token = request.getHeader("Authorization");
        String userName = (String)request.getAttribute("userName");
        HttpServletResponse response = requestContext.getResponse();
        String uri = request.getRequestURI();
        String requestType = request.getMethod();
        System.out.println(requestType);
        Boolean flag = true;
        String errorUrl = "error_get";
        //todo 业务逻辑还得改
        //zuul外部的系统想访问zuul里边的接口肯定不让
        if(uri.contains("server_in")){
            errorUrl = "error_url";
            //请求路径问题
            flag = false;
        }
        //没带token而且不是想登陆的请求
        if((token==null||token.equals("Basic Og==")||token.trim().equals(""))){
            if(uri.equals("/demik/sso/user/temporary_token")){
                //想调用获取临时token的接口
                if(judgeIpAddr(request)){
                    //ip地址作为用户存在于数据库
                    System.out.println("获取临时token,放行");
                }else {
                    //ip地址不存在于数据库
                    errorUrl = "error_ip_not_existed";
                    System.out.println("ip地址不存在于数据库");
                    flag = false;
                }
            }else if(uri.contains("/error/")){
                //没带token但是是想访问错误界面
                System.out.println("没带token但是是想访问错误界面,放行");
            }else{
                errorUrl = "error_token_null";
                //想调用应该带token的接口但是没带token
                System.out.println("想调用应该带token的接口但是没带token");
                flag = false;
            }
        }else {
            if(uri.equals("/demik/sso/user/temporary_token")){
                errorUrl = "error_token_not_null";
                //想调用获取临时token的接口但是带了token
                System.out.println("想调用获取临时token的接口但是带了token");
                flag = false;
            }
            //访问其他的接口不管他全部交给jwt
        }
        if(!flag){
            String url = "http://127.0.0.1:8080/error/"+errorUrl;
            try {
                //跳转请求到不同的错误页面
                response.sendRedirect(url);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
    @Override
    // 过滤器类型
    public String filterType() {
        // pre：路由之前 routing：路由之时 post： 路由之后 error：发送错误调用
        return FilterConstants.PRE_TYPE;
    }

    @Override
    // 过滤的顺序
    public int filterOrder() {
        return 2;
    }

    /**
     * 判断是否是Ajax请求
     * 
     * @param request
     * @return
     */
    private boolean isAjaxRequest(HttpServletRequest request) {
        return (request.getHeader("accept") != null && request.getHeader("accept").contains("application/json"))
        || (request.getHeader("X-Requested-With") != null
        && request.getHeader("X-Requested-With").contains("XMLHttpRequest"));
    }


    /**
     * 跳转页面
     * 
     * @param response
     * @param url      需要跳转页面的全路径
     */
    private void turnPage(HttpServletResponse response, String url) {
        try {
            response.setContentType("text/html; charset=utf-8");
            java.io.PrintWriter out = response.getWriter();
            out.println("<html><meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" /> ");
            out.println("<script>");out.println("window.open ('" + url + "','_top')");
            out.println("</script>");
            out.println("</html>");
            out.flush();out.close();
        } catch (IOException e) {
            log.error("responseHTML", e);
        }
    }
}
