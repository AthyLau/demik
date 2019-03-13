package demik.springcloud.entity.domain.vo;



import demik.springcloud.entity.domain.po.PermissionPO;
import demik.springcloud.entity.domain.po.RolePO;
import demik.springcloud.entity.domain.po.UserPO;

import java.util.List;

/**
 * Function:
 *
 * @author liubing
 * Date: 2018/12/24 上午10:38
 * @since JDK 1.8
 */


public class UserDetailInfoVO {
    private UserPO userPO;

    private List<RolePO> roleInfoList;

    private List<PermissionPO> permissionInfoList;

    public UserDetailInfoVO(UserPO userPO, List<RolePO> roleInfoList, List<PermissionPO> permissionInfoList) {
        this.userPO = userPO;
        this.roleInfoList = roleInfoList;
        this.permissionInfoList = permissionInfoList;
    }

    public UserDetailInfoVO() {
    }

    public UserPO getUserPO() {
        return userPO;
    }

    public void setUserPO(UserPO userPO) {
        this.userPO = userPO;
    }

    public List<RolePO> getRoleInfoList() {
        return roleInfoList;
    }

    public void setRoleInfoList(List<RolePO> roleInfoList) {
        this.roleInfoList = roleInfoList;
    }

    public List<PermissionPO> getPermissionInfoList() {
        return permissionInfoList;
    }

    public void setPermissionInfoList(List<PermissionPO> permissionInfoList) {
        this.permissionInfoList = permissionInfoList;
    }

    @Override
    public String toString() {
        return "UserDetailInfoVO{" +
                "userPO=" + userPO +
                ", roleInfoList=" + roleInfoList +
                ", permissionInfoList=" + permissionInfoList +
                '}';
    }
}
