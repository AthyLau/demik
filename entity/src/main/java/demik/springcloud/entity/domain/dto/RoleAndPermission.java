package demik.springcloud.entity.domain.dto;

/**
 * Function:
 *
 * @author liubing
 * Date: 2018/12/24 下午6:15
 * @since JDK 1.8
 */


public class RoleAndPermission {
    /**
     * 角色名
     */
    private String roleName;
    /**
     * 权限名称
     */
    private String permissionName;

    public RoleAndPermission() {
    }

    public RoleAndPermission(String roleName, String permissionName) {
        this.roleName = roleName;
        this.permissionName = permissionName;
    }

    @Override
    public String toString() {
        return "RoleAndPermission{" +
                "roleName='" + roleName + '\'' +
                ", permissionName='" + permissionName + '\'' +
                '}';
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getPermissionName() {
        return permissionName;
    }

    public void setPermissionName(String permissionName) {
        this.permissionName = permissionName;
    }
}
