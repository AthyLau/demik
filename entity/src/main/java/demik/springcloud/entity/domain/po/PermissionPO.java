package demik.springcloud.entity.domain.po;

/**
 * Function:权限信息表
 *
 * @author liubing
 * Date: 2018/12/21 下午4:30
 * @since JDK 1.8
 */


public class PermissionPO {
    /**
     * id
     */
    private Integer permissionId;
    /**
     * 权限名字
     */
    private String permissionName;
    /**
     * 权限描述
     */
    private String permissionDescription;

    public PermissionPO() {
    }

    public PermissionPO(Integer permissionId, String permissionName, String permissionDescription) {
        this.permissionId = permissionId;
        this.permissionName = permissionName;
        this.permissionDescription = permissionDescription;
    }

    @Override
    public String toString() {
        return "PermissionPO{" +
                "permissionId=" + permissionId +
                ", permissionName='" + permissionName + '\'' +
                ", permissionDescription='" + permissionDescription + '\'' +
                '}';
    }

    public Integer getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(Integer permissionId) {
        this.permissionId = permissionId;
    }

    public String getPermissionName() {
        return permissionName;
    }

    public void setPermissionName(String permissionName) {
        this.permissionName = permissionName;
    }

    public String getPermissionDescription() {
        return permissionDescription;
    }

    public void setPermissionDescription(String permissionDescription) {
        this.permissionDescription = permissionDescription;
    }
}
