package demik.springcloud.entity.domain.po;

/**
 * Function:
 *
 * @author liubing
 * Date: 2019/4/15 2:02 AM
 * @since JDK 1.8
 */
public class UsersRolesPO {
    private Integer userId;
    private Integer roleId;

    public UsersRolesPO() {
    }

    public UsersRolesPO(Integer userId, Integer roleId) {
        this.userId = userId;
        this.roleId = roleId;
    }

    @Override
    public String toString() {
        return "UsersRolesPO{" +
                "userId=" + userId +
                ", roleId=" + roleId +
                '}';
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }
}
