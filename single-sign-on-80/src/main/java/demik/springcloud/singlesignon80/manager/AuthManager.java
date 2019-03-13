package demik.springcloud.singlesignon80.manager;


import demik.springcloud.entity.domain.po.PermissionPO;
import demik.springcloud.entity.domain.po.RolePO;
import demik.springcloud.entity.domain.po.UserPO;
import demik.springcloud.singlesignon80.mapper.AuthMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Function:鉴权实现类
 *
 * @author miluo
 * Date: 2018/11/13 5:24 PM
 * @since JDK 1.8
 */
@Repository
public class AuthManager {

    /**
     * 鉴权映射库
     */
    @Autowired
    private AuthMapper authMapper;


    /**
     * 根据用户id查找用户名
     *
     * @param userId 用户id
     * @return
     */
    public String getUsernameById(Integer userId) {
        return authMapper.getUsernameById(userId);
    }


    /**
     * 获取所有用户信息
     *
     * @return 返回用户集合
     */
    public List<UserPO> getUserInfoAll() {
        System.out.println("userInfoDemo-->没有执行缓存");
        return authMapper.getUserInfoAll();
    }

    /**
     * 根据用户名获取用户角色信息
     *
     * @param userName 用户名
     * @return 角色名
     */
    public List<String> getRoleNameByUserName(String userName) {
        System.out.println("AuthService_RoleNameByUserName-->没有执行缓存");
        return authMapper.getRoleNameByUserName(userName);
    }

    /**
     * 根据用户名，获取用户id
     *
     * @param userName 用户名
     * @return 用户id
     */
    public Integer getUserIdByUserName(String userName) {
        System.out.println("AuthService_UserIdByUserName-->没有执行缓存");
        return authMapper.getUserIdByUserName(userName);
    }


    /**
     * 根据角色名获取用户权限
     *
     * @param roleNames 角色名
     * @return 权限集合
     */
    public List<String> getPermissionNameByUserName(List<String> roleNames) {
        System.out.println("AuthService_PermissionNameByUserName-->没有执行缓存");
        return authMapper.getPermissionNameByUserName(roleNames);
    }


    /**
     * 根据用户名，到数据库中或缓存中获取用户信息
     *
     * @param userName 用户名
     * @return 用户信息
     */
    public UserPO getUserInfoByUserName(String userName) {
        System.out.println("AuthService_UserInfoByUserName-->没有执行缓存");
        return authMapper.getUserInfoByUserName(userName);
    }

    /**
     * 根据用户获取角色信息
     *
     * @param roleIds 角色id
     * @return 角色集合
     */
    public List<RolePO> getRoleInfoByRoleId(List<Integer> roleIds) {
        System.out.println("AuthService_RoleInfoByUserName-->没有执行缓存");
        return authMapper.getRoleInfoByRoleIds(roleIds);
    }


    /**
     * 根据角色获取所有权限信息
     *
     * @param perssionId 权限ID
     * @return 权限集合
     */
    public List<PermissionPO> getPermissionInfoByPerssionId(List<Integer> perssionId) {
        System.out.println("AuthService_PermissionInfoByPerssionId-->没有执行缓存");
        return authMapper.getPermissionInfoByPerssionId(perssionId);
    }

    /**
     * 根据用户id，获取用户所对应的权限
     *
     * @param userId 用户id
     * @return 角色集
     */
    public List<Integer> getUserToRoleInfoByUserId(Integer userId) {
        System.out.println("AuthService_UserToRoleInfoByUserId-->没有执行缓存");
        return authMapper.getUserToRoleInfoByUserId(userId);
    }


    /**
     * 根据角色id，获取角色对应的权限
     *
     * @param roleId 角色id
     * @return 权限集
     */
    public List<Integer> getRoleToPermissionByRoleId(List<Integer> roleId) {
        System.out.println("AuthService_RoleToPermissionByRoleId-->没有执行缓存");
        return authMapper.getRoleToPermissionByRoleId(roleId);
    }
}
