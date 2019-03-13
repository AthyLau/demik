package demik.springcloud.singlesignon80.shiro;

import demik.springcloud.entity.domain.dto.UserDTO;
import demik.springcloud.singlesignon80.controller.AuthController;
import demik.springcloud.singlesignon80.service.AuthService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;


/**
 * Function: shiro作用域类 用来规定shior如何鉴权
 *
 * @author miluo
 * Date: 2018/9/6 下午4:28
 * @since JDK 1.8
 */
@Service
public class MyRealm extends AuthorizingRealm {

    private static final Logger logger = LoggerFactory.getLogger(AuthController.class);

    /**
     * 得懒加载才能保证 redis缓存能正常使用
     */
    @Lazy
    @Autowired
    private AuthService authService;

    /**
     * 大坑！，必须重写此方法，不然Shiro会报错
     */
    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof JWTToken;
    }

    /**
     * 只有当需要检测用户权限的时候才会调用此方法，例如checkRole,checkPermission之类的
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        System.out.println("===================进行用户权限校验========================");
        System.out.println("传值方法：" + principals.toString());
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        //从jwt域中获取到用户名称
        String username = JWTUtil.getUsername(principals.toString());
        //通过用户名查询用户信息
        UserDTO userInfo = authService.checkUserInfo(username);
        //将用户的角色放入shiro中
        System.out.println("用户角色：" + userInfo.getRole());
        Set<String> roles = new HashSet<>(Arrays.asList(userInfo.getRole().split(",")));
        simpleAuthorizationInfo.addRoles(roles);
        //将用户的所有权限，放入shiro中
        Set<String> permission = new HashSet<>(Arrays.asList(userInfo.getPermission().split(",")));
        simpleAuthorizationInfo.addStringPermissions(permission);
        return simpleAuthorizationInfo;
    }

    /**
     * 只有在登陆时才会进行判断
     * 默认使用此方法进行用户名正确与否验证，错误抛出异常即可。
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken auth) throws AuthenticationException {
        System.out.println("===================进行用户登陆校验========================");
        String token = (String) auth.getCredentials();
        System.out.println("getCredentials：" + auth.getCredentials().toString() + '\n' + "getPrincipal：" + auth.getPrincipal().toString());
        // 解密获得username，用于和数据库进行对比
        String username = JWTUtil.getUsername(token);
        //token不存在
        if (username == null) {
            throw new AuthenticationException("token invalid");
        }

        UserDTO userBean = authService.checkUserInfo(username);
        if (userBean == null) {
            throw new AuthenticationException("User didn't existed!");
        }

        //用户名和密码校验失败
        if (!JWTUtil.verify(token, username, userBean.getUserPassword())) {
            throw new AuthenticationException("Username or password error");
        }

        //第一个参数可以是对象，这里是token信息
        //第二个参数是密码，这里传的还是token
        //第三个参数是realm，是realm的名称
        return new SimpleAuthenticationInfo(token, token, "my_realm");
    }

}

