package demik.springcloud.singlesignon80.controller;

import demik.springcloud.entity.domain.vo.UserNameVO;
import demik.springcloud.singlesignon80.service.AuthService;
import net.sf.json.JSONObject;
import demik.springcloud.entity.commonbox.Result;
import demik.springcloud.entity.commonbox.ResultCode;
import demik.springcloud.entity.commonbox.ResultGenerator;
import demik.springcloud.entity.domain.doo.ServerInfoDO;
import demik.springcloud.entity.domain.dto.*;
import demik.springcloud.entity.domain.po.UserPO;
import demik.springcloud.entity.domain.vo.UserDetailInfoVO;
import demik.springcloud.entity.exception.SuccessException;
import demik.springcloud.singlesignon80.shiro.ClientIp;
import demik.springcloud.singlesignon80.shiro.JWTUtil;
import demik.springcloud.singlesignon80.shiro.ServerIP;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.UnauthorizedException;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * Function:
 *
 * @author liubing
 * Date: 2019/3/7 上午10:42
 * @since JDK 1.8
 */

@Validated
@RestController
@RequestMapping("/user")
@Api(description = "鉴权controller")
public class AuthController {
    private static final Logger logger = LoggerFactory.getLogger(AuthController.class);
    /**
     * 鉴权service
     */
    @Autowired
    private AuthService authService;

    /**
     * excel批量添加学生用户
     * @param dtos
     * @return
     */
    @PostMapping("/server_in/add_student_user")
    @ApiOperation(value = "excel批量添加学生用户", httpMethod = "POST")
    public Result addStudentUser(@RequestBody List<StudentExcelDTO> dtos){
        Map<Integer,String> map = authService.addStudentUser(dtos);
        if(map.size()!=0){
            return ResultGenerator.genSuccessResult(map);
        }
        return ResultGenerator.genSuccessResult();
    }
    /**
     * excel批量添加教师用户
     * @param dtos
     * @return
     */
    @PostMapping("/server_in/add_teacher_user")
    @ApiOperation(value = "excel批量添加教师用户", httpMethod = "POST")
    public Result addTeacherUser(@RequestBody List<TeacherExcelDTO> dtos){
        Map<Integer,String> map = authService.addTeacherUser(dtos);
        if(map.size()!=0){
            return ResultGenerator.genSuccessResult(map);
        }
        return ResultGenerator.genSuccessResult();
    }
    /**
     * 校验用户是否存在
     * @param userNameVO
     * @return
     */
    @ApiOperation(value = "校验用户是否存在", httpMethod = "POST")
    @PostMapping("/server_in/is_name_exisit")
    public Result isNameExists(@RequestBody UserNameVO userNameVO){
        System.out.println("校验用户是否存在");
        return ResultGenerator.genSuccessResult(authService.getUserIdByUserName(userNameVO.getUserName()));
    }

    @ApiOperation(value = "校验用户是否上锁", httpMethod = "POST")
    @PostMapping("/get_locked")
    @RequiresAuthentication
    public Result getLockedByName(@RequestBody UserNameVO userNameVO){
        return ResultGenerator.genSuccessResult(authService.getLockedByName(userNameVO.getUserName()));
    }
    /**
     * 获取临时token
     *
     * @return
     */
    @ApiOperation(value = "获取临时token", httpMethod = "POST")
    @PostMapping("/temporary_token")
    public Result getTemporaryToken() {
        //获取客户端的ip
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        String ip = ClientIp.getIpAddr(request);
        if(authService.getUserIdByUserName(ip)==null){
            //数据库中没有该IP地址所以返回没有权限
            return ResultGenerator.genSuccessResult(ResultCode.NOT_AUTH);
        }
        //根据客户端ip生成一个临时token
        TokenDTO tokenDTO = new TokenDTO(JWTUtil.temporarySign(ip, ip));
        //获取本机的信息
        ServerInfoDO serverInfoDO = ServerIP.getServerIp();
        //开启zuul
        ClientSSODTO clientSSODTO = new ClientSSODTO(tokenDTO,"http://"+serverInfoDO.getIp()+":8080/demik/sms/user/login");
        //不开启zuul
        //ClientSSODTO clientSSODTO = new ClientSSODTO(tokenDTO,"http://"+serverInfoDO.getIp()+":8081/user/login");
        LoginDTO loginDTO = new LoginDTO("template","template");
        clientSSODTO.setRequestType("POST");
        JSONObject object = JSONObject.fromObject(loginDTO);
        String json = object.toString();
        clientSSODTO.setJsonTemplate(json);
        return ResultGenerator.genSuccessResult(clientSSODTO);
    }

    /**
     * demik微服务项目内的微服务的用户校验
     * @param userNameVO
     * @return
     */
    @ApiOperation(value = "demik微服务项目内的微服务的用户校验", httpMethod = "POST")
    @PostMapping("/server_in/check_user_info")
    public Result<UserDTO> checkUserInfo(@RequestBody UserNameVO userNameVO){
        UserDTO userDTO = authService.checkUserInfo(userNameVO.getUserName());
        if(userDTO==null){
            return ResultGenerator.genSuccessResult(ResultCode.NONE_DATA);
        }
        return ResultGenerator.genSuccessResult(userDTO);
    }
    /**
     * 登陆校验
     *
     * @return
     */
    @ApiOperation(value = "其他系统登陆时的登录校验", httpMethod = "POST")
    @PostMapping("/login")
    @RequiresAuthentication
    public Result otherLogin(@RequestBody @Validated LoginDTO loginDTO) {
        //获取用户信息
        UserDTO userBean = authService.checkUserInfo(loginDTO.getUserName());
        System.out.println(loginDTO);
        if (userBean == null) {
            throw new UnauthorizedException("用户名有误！");
        }
        if (userBean.getUserPassword().equals(loginDTO.getUserPassword())) {
            return ResultGenerator.genSuccessResult(new TokenDTO(JWTUtil.sign(loginDTO.getUserName(), loginDTO.getUserPassword())));
        } else {
            //别捕获这个异常，这个异常有一个具体捕获地点
            //一定要这么传，别把这流程改了
            throw new UnauthorizedException("密码有误！");
        }
    }
    /**
     * 登陆校验
     *
     * @return
     */
    @ApiOperation(value = "自己系统内登陆时的登录校验", httpMethod = "POST")
    @PostMapping("/server_in/login")
    public Result login(@RequestBody @Validated LoginDTO loginDTO) {
        //获取用户信息
        UserDTO userBean = authService.checkUserInfo(loginDTO.getUserName());
        System.out.println(loginDTO);
        if (userBean == null) {
            throw new UnauthorizedException("用户名有误！");
        }
        if (userBean.getUserPassword().equals(loginDTO.getUserPassword())) {
            return ResultGenerator.genSuccessResult(new TokenDTO(JWTUtil.sign(loginDTO.getUserName(), loginDTO.getUserPassword())));
        } else {
            //别捕获这个异常，这个异常有一个具体捕获地点
            //一定要这么传，别把这流程改了
            throw new UnauthorizedException("密码有误！");
        }
    }

    /**
     * 根据旧token更换新token
     *
     * @return
     */
    @PostMapping("/refresh_token")
    @RequiresAuthentication
    public Result refreshToken() {
        String token = SecurityUtils.getSubject().getPrincipal().toString();
        //从jwt中获取token
        if (JWTUtil.getUsername(token) == null) {

            return ResultGenerator.genNeutralResult(ResultCode.TOKEN_ERROR, "token失效或token为假！");
        }

        UserDetailInfoVO userDetailInfoVO = authService.getUserDetailInfo(token);

        return ResultGenerator.genSuccessResult(new TokenDTO(JWTUtil.sign(userDetailInfoVO.getUserPO().getUserName(), userDetailInfoVO.getUserPO().getUserPassword())));
    }
    /**
     * 获取用户信息及其角色权限信息
     *
     * @return
     */
    @PostMapping("/get_user_info")
    @RequiresAuthentication
    @ApiOperation(value = "获取用户信息及其角色权限信息", httpMethod = "POST")
    public Result getUserInfo() throws SuccessException {
        String token = SecurityUtils.getSubject().getPrincipal().toString();
        //从jwt中获取token
        String username = JWTUtil.getUsername(token);
        if (username == null) {
            return ResultGenerator.genNeutralResult(ResultCode.TOKEN_ERROR, "token失效或token为假！");
        }
        // 获取用户信息
        UserDetailInfoVO userDetailInfoVO = authService.getUserDetailInfo(token);
        return ResultGenerator.genSuccessResult(userDetailInfoVO);
    }
    /**
     * 获取角色
     *
     * @return
     */
    @PostMapping("/get_role")
    @RequiresAuthentication
    @ApiOperation(value = "获取角色", httpMethod = "POST")
    public Result getRole() throws SuccessException {
        String token = SecurityUtils.getSubject().getPrincipal().toString();
        //从jwt中获取token
        String username = JWTUtil.getUsername(token);
        if (username == null) {
            return ResultGenerator.genNeutralResult(ResultCode.TOKEN_ERROR, "token失效或token为假！");
        }
        // 获取用户信息
        UserDTO info = authService.checkUserInfo(username);
        String role = info.getRole();
        String permission = info.getPermission();
        return ResultGenerator.genSuccessResult(new RoleNameDTO(role));
    }



//    /**
//     * 退出登陆
//     *
//     * @return
//     */
//    @PostMapping("/logout")
//    public Result logoutToken(@RequestParam("token") String token) {
//        //从缓存中删除key
//        authService.addToken("del-" + token, token);
//        return ResultGenerator.genSuccessResult("success");
//    }


    @GetMapping("/article")
    @RequiresAuthentication
    @ApiOperation(value = "是否认证", httpMethod = "GET")
    public Result article() {
        Subject subject = SecurityUtils.getSubject();
        if (subject.isAuthenticated()) {
            //"已获得许可"
            return ResultGenerator.genSuccessResult(ResultCode.YE_VERY);
        } else {
            //"未获得许可!"
            return ResultGenerator.genNeutralResult(ResultCode.NOT_AUTH);
        }
    }

    /**
     * 登陆授权
     *
     * @return 结果集
     */
    @GetMapping("/require_auth")
    @RequiresAuthentication
    @ApiOperation(value = "登陆授权", httpMethod = "GET")
    public Result requireAuth() {
        return ResultGenerator.genNeutralResult(ResultCode.YE_VERY, "已获得许可");
    }


    /**
     * 必须具备admin角色才可以访问
     *
     * @return 结果集
     */
    @GetMapping("/require_role")
    @RequiresRoles("Admin")
    @ApiOperation(value = "必须具备Admin角色才可以访问", httpMethod = "GET")
    @RequiresAuthentication
    public Result requireRole() {
        return ResultGenerator.genNeutralResult(ResultCode.NOT_SMART_ENOUGH, "正在访问 require_role");
    }

    /**
     * 必须具备几个权限才可以访问
     *
     * @return 结果集
     */
    @GetMapping("/require_permission")
    @RequiresPermissions(logical = Logical.AND, value = {"type:check", "type:modify"})
    @ApiOperation(value = "必须具备几个权限才可以访问", httpMethod = "GET")
    @RequiresAuthentication
    public Result requirePermission() {
        return ResultGenerator.genNeutralResult(ResultCode.NOT_SMART_ENOUGH,
                "您正在访问权限需要编辑，查看");
    }

}
