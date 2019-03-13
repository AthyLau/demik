package demik.springcloud.entity.domain.dto;

/**
 * Function:角色名字的dto类
 *
 * @author liubing
 * Date: 2018/12/24 下午2:39
 * @since JDK 1.8
 */


public class RoleNameDTO {
    /**
     * 角色名字
     */
    private String roleName;

    public RoleNameDTO() {
    }

    public RoleNameDTO(String roleName) {
        this.roleName = roleName;
    }

    @Override
    public String toString() {
        return "RoleNameVO{" +
                "roleName='" + roleName + '\'' +
                '}';
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
