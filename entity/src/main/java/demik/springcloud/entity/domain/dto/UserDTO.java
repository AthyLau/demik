package demik.springcloud.entity.domain.dto;


/**
 * Function:
 *
 * @author liubing
 * Date: 2018/12/24 上午10:24
 * @since JDK 1.8
 */


public class UserDTO {
    /**
     * 用户名
     */
    private String userName;
    /**
     * 用户性别
     */
    private String userSex;
    /**
     * 用户手机号
     */
    private String userPhone;
    /**
     * 用户邮箱
     */
    private String userMail;
    /**
     * 用户密码
     */
    private String userPassword;

    /**
     * 用户角色信息
     */
    private String role;

    /**
     * 用户权限信息
     */
    private String permission;



    public UserDTO() {
    }

    public UserDTO(String userName, String userSex, String userPhone, String userMail, String userPassword, String role, String permission) {
        this.userName = userName;
        this.userSex = userSex;
        this.userPhone = userPhone;
        this.userMail = userMail;
        this.userPassword = userPassword;
        this.role = role;
        this.permission = permission;
    }

    @Override
    public String toString() {
        return "UserVO{" +
                "userName='" + userName + '\'' +
                ", userSex='" + userSex + '\'' +
                ", userPhone='" + userPhone + '\'' +
                ", userMail='" + userMail + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", role='" + role + '\'' +
                ", permission='" + permission + '\'' +
                '}';
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserSex() {
        return userSex;
    }

    public void setUserSex(String userSex) {
        this.userSex = userSex;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getUserMail() {
        return userMail;
    }

    public void setUserMail(String userMail) {
        this.userMail = userMail;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

}
