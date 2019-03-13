package demik.springcloud.singlesignon80.mapper;
import demik.springcloud.entity.domain.po.PermissionPO;
import demik.springcloud.entity.domain.po.RolePO;
import demik.springcloud.entity.domain.po.UserPO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * Function:
 *
 * @author liubing
 * Date: 2019/3/7 上午10:42
 * @since JDK 1.8
 */

@Mapper
public interface AuthMapper {


//    /**
//     * 根据用户名和密码获取账号是否被锁定
//     *
//     * @param userName 用户名
//     * @return 用户信息
//     */
//    @Select("SELECT locked FROM user_info WHERE user_name = #{userName} ")
//    boolean checkUserName(@Param("userName") String userName);


    /**
     * 根据用户名，获取用户id
     *
     * @param userName 用户名
     * @return 用户id
     */
    @Select("SELECT id FROM users WHERE user_name=#{userName}")
    Integer getUserIdByUserName(@Param("userName") String userName);


    /**
     * 获取用户所有信息，测试
     *
     * @return
     */
    @Select("SELECT * FROM users")
    List<UserPO> getUserInfoAll();

    /**
     * 根据用户名和密码获取用户信息
     *
     * @param userName
     * @param userPassword
     * @return
     */
    @Select("SELECT * FROM users WHERE user_name = #{userName} AND user_password = #{userPassword}")
    UserPO getUserInfoByUserNameAndPasswd(@Param("userName") String userName, @Param("userPassword") String userPassword);


    /**
     * 根据用户名和密码获取账号是否被锁定
     *
     * @param userName 用户名
     * @param userPassword 密码
     * @return 用户信息
     */
    @Select("SELECT locked FROM users WHERE user_name = #{userName} AND user_password = #{userPassword}")
    boolean checkUserNameAndPasswd(@Param("userName") String userName, @Param("userPassword") String userPassword);


    /**
     * 获取用户角色名称
     *
     * @param userName
     * @return
     */
    @Select("SELECT role_name from users_roles left join roles using(role_id) left join users using(user_id) WHERE user_name = #{userName}")
    List<String> getRoleNameByUserName(String userName);


    /**
     * 根据角色获取所有权限信息
     *
     * @param roleNames
     * @return
     */
//    @Select("SELECT permission_name FROM role_to_permission_info left join role_info using(role_id) left join permission_info using(permission_id) WHERE role_name = #{roleName};")
    @Select({
            "<script>",
            "SELECT permission_name FROM roles_permissions left join roles using(role_id) left join permissions using(permission_id) ",
            "where role_name in ",
            "<foreach collection='roleNames' item='roleName' open='(' separator=',' close=')'>",
            "#{roleName}",
            "</foreach>",
            "</script>"
    })
    List<String> getPermissionNameByUserName(@Param("roleNames") List<String> roleNames);



    /**
     * 根据用户名获取用户信息
     *
     * @param userName
     * @return
     */
    @Select("SELECT user_id, user_name, locked, user_sex, user_password, user_phone, user_mail, create_time,update_time FROM users WHERE user_name = #{userName} ")
    UserPO getUserInfoByUserName(@Param("userName") String userName);

    /**
     * 根据用户获取角色信息
     *
     * @param roleId 角色id
     * @return 角色集合
     */
    @Select("SELECT * FROM role WHERE role_id IN " +
            "<foreach collection=\"roleIds\" index = \"index\" item = \"id\" open= \"(\" separator=\",\" close=\")\"> " +
            "#{id} \n" +
            "</foreach>")
    List<RolePO> getRoleInfoByRoleId(String roleId);

    @Select({
            "<script>",
            "select * ",
            "from roles ",
            "where role_id in ",
            "<foreach collection='roleIds' item='id' open='(' separator=',' close=')'>",
            "#{id}",
            "</foreach>",
            "</script>"
    })
    List<RolePO> getRoleInfoByRoleIds(@Param("roleIds") List<Integer> roleIds);


    /**
     * 根据角色获取所有权限信息
     *
     * @param permissionId 权限ID
     * @return 权限集合
     */
//    @Select("SELECT * FROM permission_info WHERE permission_id IN ( #{perssionId} );")
    @Select({
            "<script>",
            "select * ",
            "from permissions ",
            "where permission_id in ",
            "<foreach collection='permissionId' item='id' open='(' separator=',' close=')'>",
            "#{id}",
            "</foreach>",
            "</script>"
    })
    List<PermissionPO> getPermissionInfoByPerssionId(@Param("permissionId") List<Integer> permissionId);

    /**
     * 根据用户id，获取用户所对应的权限
     *
     * @param userId 用户id
     * @return 角色集
     */
    @Select("SELECT role_id FROM users_roles WHERE user_id = #{userId}")
    List<Integer> getUserToRoleInfoByUserId(Integer userId);


    /**
     * 根据角色id，获取角色对应的权限
     *
     * @param roleIds 角色id
     * @return 权限集
     */
//    @Select("SELECT * FROM role_to_permission_info WHERE role_id IN ( #{roleId} );")
    @Select({
            "<script>",
            "select permission_id ",
            "from roles_permissions ",
            "where role_id in ",
            "<foreach collection='roleIds' item='id' open='(' separator=',' close=')'>",
            "#{id}",
            "</foreach>",
            "</script>"
    })
    List<Integer> getRoleToPermissionByRoleId(@Param("roleIds") List<Integer> roleIds);


    /**
     * 查询所有角色信息
     *
     * @return
     */
    @Select("SELECT * FROM roles")
    List<RolePO> getRoleInfoAll();


    /**
     * 查询所有权限信息
     *
     * @return
     */
    @Select("SELECT * FROM permissions")
    List<PermissionPO> getPermissionInfoAll();


    /**
     * 根据用户id更新角色信息
     *
     * @param roleId
     * @param userId
     */
    @Update("UPDATE users_roles SET role_id=#{roleId} WHERE user_id=#{userId}")
    void updateUserToRoleInfo(@Param("roleId") Integer roleId, @Param("userId") Integer userId);

    /**
     * 根据用户id查找用户名
     * @param userId 用户id
     * @return
     */
    @Select("SELECT user_name FROM users WHERE user_id=#{userId}")
    String getUsernameById(Integer userId);


    //添加角色信息


    //添加权限信息


    //根据角色id映射权限 role_to_permission_info表

    //根据用户映射角色  user_role_info

}
