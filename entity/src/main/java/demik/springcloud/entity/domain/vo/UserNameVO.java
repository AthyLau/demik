package demik.springcloud.entity.domain.vo;

/**
 * Function:
 *
 * @author liubing
 * Date: 2019/3/28 1:50 PM
 * @since JDK 1.8
 */
public class UserNameVO {
    private String userName;

    public UserNameVO() {
    }

    public UserNameVO(String userName) {
        this.userName = userName;
    }

    @Override
    public String toString() {
        return "UserNameVO{" +
                "userName='" + userName + '\'' +
                '}';
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
