package demik.springcloud.singlesignon80.service;


import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import demik.springcloud.entity.commonbox.ResultCode;
import demik.springcloud.entity.domain.dto.*;
import demik.springcloud.entity.domain.po.PermissionPO;
import demik.springcloud.entity.domain.po.RolePO;
import demik.springcloud.entity.domain.po.UserPO;
import demik.springcloud.entity.domain.vo.UserDetailInfoVO;
import demik.springcloud.singlesignon80.manager.AuthManager;
import demik.springcloud.singlesignon80.shiro.JWTUtil;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.UnauthenticatedException;
import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Function: 鉴权服务类 (一级)
 *
 * @author miluo
 * Date: 2018/9/6 下午4:25
 * @since JDK 1.8
 */
@Service
public class AuthService {
    /**
     * 鉴权实现类
     */
    @Autowired
    private AuthManager authManager;

    /**
     * 从数据库中获取用户信息
     *
     * @param userName 用户名
     * @return 用户传输信息
     */

    public UserDTO checkUserInfo(String userName) {
        UserDTO userInfoDTO = new UserDTO();
        UserPO userInfoPO = authManager.getUserInfoByUserName(userName);

        if (userInfoPO == null) {
            return null;
        }

        //获取角色名
        List<String> roleNames = authManager.getRoleNameByUserName(userName);
        //组装成对象
        userInfoDTO.setUserName(userName);
        System.out.println("用户名称：" + userName);
        userInfoDTO.setUserPassword(userInfoPO.getUserPassword());
        userInfoDTO.setRole(StringUtils.join(roleNames, ","));
        System.out.println("角色集合:" + StringUtils.join(roleNames, ","));
        List<String> permissionNameByUserName = authManager.getPermissionNameByUserName(roleNames);
        userInfoDTO.setPermission(StringUtils.join(permissionNameByUserName, ","));
        System.out.println("权限集合:" + permissionNameByUserName);
        userInfoDTO.setUserPhone(userInfoPO.getUserPhone());
        System.out.println("用户的手机号" + userInfoPO.getUserPhone());
        userInfoDTO.setUserMail(userInfoPO.getUserMail());
        System.out.println("用户的邮箱" + userInfoPO.getUserMail());
        userInfoDTO.setUserSex(userInfoPO.getUserSex());
        System.out.println("用户的性别" + userInfoDTO.getUserSex());
        return userInfoDTO;
    }

    /**
     * 获取用户角色以及其权限
     * @return
     */
    public RoleAndPermission getRoleAndPermission(){
        RoleAndPermission roleAndPermission = new RoleAndPermission();
        String token = SecurityUtils.getSubject().getPrincipal().toString();
        //从jwt中获取token
        String username = JWTUtil.getUsername(token);
        if(username==null){
            return null;
        }
        // 获取用户信息
        UserDTO info = checkUserInfo(username);
        String role = info.getRole();
        String permission = info.getPermission();
        roleAndPermission.setRoleName(role);
        roleAndPermission.setPermissionName(permission);
        return roleAndPermission;
    }

    /**
     * 组合用户信息
     *
     * @param token 用户的token
     * @return 用户详细信息
     */
    public UserDetailInfoVO getUserDetailInfo(String token) {
        String userName = JWTUtil.getUsername(token);
        if (userName == null) {
            return null;
        }
        //获取用户信息
        UserPO userInfoPO = authManager.getUserInfoByUserName(userName);
        if (userInfoPO == null) {
            return null;
        }

        //获取用户详细信息
        UserDetailInfoVO userDetailInfoVO = new UserDetailInfoVO();
        List<Integer> roleIdList = authManager.getUserToRoleInfoByUserId(userInfoPO.getUserId());

        List<RolePO> roleInfoList = authManager.getRoleInfoByRoleId(roleIdList);
        List<Integer> tempRoleIdList = Lists.newArrayList();
        //将多个roleId以，号分隔
        roleInfoList.forEach(x -> tempRoleIdList.add(x.getRoleId()));
        List<Integer> perssionIdList = authManager.getRoleToPermissionByRoleId(tempRoleIdList);

        List<PermissionPO> permissionInfoPOList = new ArrayList<>();
        if (perssionIdList.size() == 0) {
            PermissionPO permissionInfoPO = new PermissionPO();
            permissionInfoPO.setPermissionId(0);
            permissionInfoPO.setPermissionDescription("");
            permissionInfoPO.setPermissionName("null");
            permissionInfoPOList.add(permissionInfoPO);
        } else {
            permissionInfoPOList = authManager.getPermissionInfoByPerssionId(perssionIdList);
        }

        userDetailInfoVO.setUserPO(userInfoPO);
        userDetailInfoVO.setRoleInfoList(roleInfoList);
        userDetailInfoVO.setPermissionInfoList(permissionInfoPOList);

        return userDetailInfoVO;
    }

    /**
     * 根据用户id查找用户名
     *
     * @param userId 用户id
     * @return
     */
    public String getUsernameById(Integer userId) {
        return authManager.getUsernameById(userId);
    }

    /**
     * 获取ip的id
     *
     * @param userName 用户名
     * @return 用户id
     */
    public Boolean getUserIdByUserName(String userName){
        return authManager.getUserIdByUserName(userName);
    }


    /**
     * 根据登录用户获取用户信息
     *
     * @return
     */
    public UserPO getUserInfoByUserName() {
        //获取登陆用户名
        String token  = SecurityUtils.getSubject().getPrincipal().toString();
        String userName = JWTUtil.getUsername(token);
        if (userName == null) {
            throw new UnauthenticatedException();
        }
        //获取用户完整信息
        UserPO userInfoPO = authManager.getUserInfoByUserName(userName);
        if (userInfoPO == null) {
            throw new UnauthorizedException("用户名错误");
        }
        return userInfoPO;
    }

    /**
     * 插入一条用户信息
     * @param userPO
     * @return
     */
    public boolean addUserInfo(UserPO userPO) {
        if(userPO.getUserName().contains(".")){
            return false;
        }
        return authManager.addUserInfo(userPO);
    }
    /**
     * 获取用户是否上锁
     */
    public boolean getLockedByName(String name){
        return authManager.getLockedByName(name);
    }

    /**
     * excel学生用户批量添加到数据库
     * @param dtos
     * @return
     */
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, timeout = 3600)
    public Map<Integer,String> addStudentUser(List<StudentExcelDTO> dtos) {
        Map<Integer,String> map = Maps.newHashMap();
        dtos.forEach(x->{
            int xh = x.getId()+10;
            try{
                if(!authManager.addStudentUserInfo(authManager.getUserPO(x))){
                    throw new RuntimeException();
                }
            }catch (Exception e){
                map.put(xh,xh+"行用户数据有错误");
            }
        });
        return map;
    }
    /**
     * excel学生用户批量添加到数据库
     * @param dtos
     * @return
     */
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, timeout = 3600)
    public Map<Integer,String> addTeacherUser(List<TeacherExcelDTO> dtos) {
        Map<Integer,String> map = Maps.newHashMap();
        dtos.forEach(x->{
            int xh = x.getId()+10;
            try{
                if(!authManager.addTeacherUserInfo(authManager.getUserPO(x))){
                    throw new RuntimeException();
                }
            }catch (Exception e){
                map.put(xh,xh+"行用户数据有错误");
            }
        });
        return map;
    }

}
