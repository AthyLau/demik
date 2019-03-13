package demik.springcloud.entity.domain.dto;

/**
 * Function:
 *
 * @author liubing
 * Date: 2018/12/24 上午10:44
 * @since JDK 1.8
 */


public class LoginDTO {
    /**
     * 用户名
     */
    private String userName;
    /**
     * 用户密码
     */
    private String userPassword;

    public LoginDTO(String userName, String userPassword) {
        this.userName = userName;
        this.userPassword = userPassword;
    }

    public LoginDTO() {
    }

    @Override
    public String toString() {
        return "LoginVO{" +
                "userName='" + userName + '\'' +
                ", userPassword='" + userPassword + '\'' +
                '}';
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }
}
