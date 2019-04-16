package demik.springcloud.teachermanagementsystem8001.shiro;

import org.apache.shiro.authc.AuthenticationToken;


/**
 * Function: token实体类 继承自AuthenticationToken ，实现获取用户名和密码
 *
 * @author miluo
 * Date: 2018/9/6 下午4:28
 * @since JDK 1.8
 */
public class JWTToken implements AuthenticationToken {

    public JWTToken(String token) {
        this.token = token;
    }

    // 密钥
    private String token;

    /**
     * 用户名
     * @return
     */
    @Override
    public Object getPrincipal() {
        return token;
    }

    /**
     * 用户密码
     * @return
     */
    @Override
    public Object getCredentials() {
        return token;
    }
}
