package demik.springcloud.zuulgateway8080.controller;

import demik.springcloud.entity.commonbox.Result;
import demik.springcloud.entity.commonbox.ResultGenerator;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Function:
 *
 * @author liubing
 * Date: 2019/3/29 7:43 PM
 * @since JDK 1.8
 */
@RestController
@RequestMapping("/error")
@Api(description = " 错误controller")
public class ErrorController {


    @ApiOperation(value = "某get请求发生错误", httpMethod = "GET")
    @GetMapping("/error_get")
    public Result errorGet(){
        return ResultGenerator.genFailResult("ERROR!（某get请求发生错误）");
    }
    @ApiOperation(value = "某post请求发生错误", httpMethod = "POST")
    @PostMapping("/error_post")
    public Result errorPost(){
        return ResultGenerator.genFailResult("ERROR!（某post请求发生错误）");
    }
    @ApiOperation(value = "token为空", httpMethod = "GET")
    @GetMapping("/error_token_null")
    public Result errorTokenNull(){
        return ResultGenerator.genFailResult("ERROR!TOKEN IS NULL!（token为空）");
    }
    @ApiOperation(value = "用户不存在", httpMethod = "GET")
    @GetMapping("/error_user_not_existed")
    public Result errorUserNotExisted(){
        return ResultGenerator.genFailResult("ERROR!USER NOT EXISITED!（用户不存在）");
    }
    @ApiOperation(value = "用户名或者密码错误", httpMethod = "GET")
    @GetMapping("/error_user_or_password")
    public Result errorUserOrPassword(){
        return ResultGenerator.genFailResult("ERROR!USER OR PASSWORD ERROR!（用户名或者密码错误）");
    }
    @ApiOperation(value = "token不为空（应该为空）", httpMethod = "GET")
    @GetMapping("/error_token_not_null")
    public Result errorTokenNotNull(){
        return ResultGenerator.genFailResult("ERROR!TOKEN IS NOT NULL!(token不为空（应该为空）)");
    }
    @ApiOperation(value = "ip不存在", httpMethod = "GET")
    @GetMapping("/error_ip_not_existed")
    public Result errorIpNotExisted(){
        return ResultGenerator.genFailResult("ERROR!IP IS NOT EXISITED!(ip不存在)");
    }
    @ApiOperation(value = "访问的url为非法路径", httpMethod = "GET")
    @GetMapping("/error_url")
    public Result errorUrl(){
        return ResultGenerator.genFailResult("ERROR!URL IS ILLEGALITY!(访问的url为非法路径)");
    }
    @ApiOperation(value = "权限不合法", httpMethod = "GET")
    @GetMapping("/error_permission")
    public Result errorPermission(){
        return ResultGenerator.genFailResult("ERROR!PERMISSION IS ILLEGALITY!(权限不合法)");
    }
}
