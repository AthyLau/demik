package demik.springcloud.singlesignon80.manager;

import com.google.common.collect.Lists;
import demik.springcloud.entity.domain.dto.StudentExcelDTO;
import demik.springcloud.entity.domain.dto.TeacherExcelDTO;
import demik.springcloud.entity.domain.po.PermissionPO;
import demik.springcloud.entity.domain.po.RolePO;
import demik.springcloud.entity.domain.po.UserPO;
import demik.springcloud.entity.domain.po.UsersRolesPO;
import demik.springcloud.singlesignon80.mapper.AuthenticationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
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
    private AuthenticationMapper authMapper;


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
     * 获取ip的id
     *
     * @param userName 用户名
     * @return 用户id
     */
    public Boolean getUserIdByUserName(String userName) {
        System.out.println("AuthService_UserIdByUserName-->没有执行缓存");
        if (authMapper.getUserIdByUserName(userName)==null){
            return false;
        }
        return true;
    }


    /**
     * 根据角色名获取用户权限
     *
     * @param roleNames 角色名
     * @return 权限集合
     */
    public List<String> getPermissionNameByUserName(List<String> roleNames) {
        System.out.println("AuthService_PermissionNameByUserName-->没有执行缓存");
        List<String> list = Lists.newArrayList();
        roleNames.forEach(x->{
            list.add(authMapper.getPermissionNameByUserName(x));
        });
        return list;
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

    /**
     * 插入用户信息
     * @param userPO
     * @return
     */
    public boolean addUserInfo(UserPO userPO){
        return authMapper.addUserInfo(userPO);
    }
    /**
     *插入一条学生excel来的用户信息
     * @param userPO
     * @return
     */
    public boolean addStudentUserInfo(UserPO userPO) throws Exception{
        Boolean flag = authMapper.addUserInfo(userPO);
        if(userPO.getUserId()==null){
            throw new Exception();
        }
        flag &= authMapper.addUserRoles(new UsersRolesPO(userPO.getUserId(),4));
        return flag;
    }

    /**
     * 获取用户是否上锁
     * @param name
     * @return
     */
    public boolean getLockedByName(String name) {
        return authMapper.getLockedByName(name);
    }

    /**
     * StudentExcelDTO对象转为userpo对象
     * @param x
     * @return
     */
    public UserPO getUserPO(StudentExcelDTO x) {
//        user_name, user_sex, user_phone, user_mail, user_password, locked
        UserPO userPO = new UserPO();
        userPO.setUserName(x.getUserName());
        userPO.setUserSex(x.getStudentSex());
        userPO.setUserPhone(x.getStudentPhone());
        userPO.setUserMail(x.getStudentMail());
        userPO.setUserPassword(x.getPassword());
        userPO.setLocked(x.getLocked());
        return userPO;
    }
    public UserPO getUserPO(TeacherExcelDTO x) {
//        user_name, user_sex, user_phone, user_mail, user_password, locked
        UserPO userPO = new UserPO();
        userPO.setUserName(x.getUserName());
        userPO.setUserSex(x.getTeacherSex());
        userPO.setUserPhone(x.getTeacherPhone());
        userPO.setUserMail(x.getTeacherMail());
        userPO.setUserPassword(x.getPassword());
        userPO.setLocked(x.getLocked());
        return userPO;
    }
    public boolean addTeacherUserInfo(UserPO userPO) throws Exception{
        Boolean flag = authMapper.addUserInfo(userPO);
        if(userPO.getUserId()==null){
            throw new Exception();
        }
        flag &= authMapper.addUserRoles(new UsersRolesPO(userPO.getUserId(),4));
        return flag;
    }
}
