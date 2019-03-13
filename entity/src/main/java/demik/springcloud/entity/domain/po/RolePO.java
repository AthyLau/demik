package demik.springcloud.entity.domain.po;

/**
 * Function:角色信息表
 *
 * @author liubing
 * Date: 2018/12/21 下午4:30
 * @since JDK 1.8
 */


public class RolePO {
    /**
     * id
     */
    private Integer roleId;
    /**
     * 角色名字
     */
    private String roleName;
    /**
     * 角色描述
     */
    private String roleDescription;

    public RolePO() {
    }

    public RolePO(Integer roleId, String roleName, String roleDescription) {
        this.roleId = roleId;
        this.roleName = roleName;
        this.roleDescription = roleDescription;
    }

    @Override
    public String toString() {
        return "RolePO{" +
                "roleId=" + roleId +
                ", roleName='" + roleName + '\'' +
                ", roleDescription='" + roleDescription + '\'' +
                '}';
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleDescription() {
        return roleDescription;
    }

    public void setRoleDescription(String roleDescription) {
        this.roleDescription = roleDescription;
    }
}
