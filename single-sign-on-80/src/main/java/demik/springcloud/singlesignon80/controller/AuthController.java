package demik.springcloud.singlesignon80.controller;

import demik.springcloud.entity.commonbox.Result;
import demik.springcloud.entity.commonbox.ResultCode;
import demik.springcloud.entity.commonbox.ResultGenerator;
import demik.springcloud.entity.domain.dto.LoginDTO;
import demik.springcloud.entity.domain.dto.RoleNameDTO;
import demik.springcloud.entity.domain.dto.TokenDTO;
import demik.springcloud.entity.domain.dto.UserDTO;
import demik.springcloud.entity.domain.vo.UserDetailInfoVO;
import demik.springcloud.entity.exception.SuccessException;
import demik.springcloud.singlesignon80.service.AuthService;
import demik.springcloud.singlesignon80.shiro.JWTUtil;
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
     * 登陆校验
     *
     * @return
     */
    @ApiOperation(value = "登录校验", httpMethod = "POST")
    @PostMapping("/login")
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
     * 获取角色和地址
     *
     * @return
     */
    @PostMapping("/get_role")
    @RequiresAuthentication
    @ApiOperation(value = "获取角色和地址", httpMethod = "POST")
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
    @RequiresRoles("超级管理员")
    @ApiOperation(value = "必须具备admin角色才可以访问", httpMethod = "GET")
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
    @RequiresPermissions(logical = Logical.AND, value = {"permission:view", "permission:edit"})
    @ApiOperation(value = "必须具备几个权限才可以访问", httpMethod = "GET")
    @RequiresAuthentication
    public Result requirePermission() {
        return ResultGenerator.genNeutralResult(ResultCode.NOT_SMART_ENOUGH,
                "您正在访问权限需要编辑，查看");
    }
}
