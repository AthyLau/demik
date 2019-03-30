package demik.springcloud.singlesignon80.controller;

import demik.springcloud.entity.commonbox.Result;
import demik.springcloud.entity.commonbox.ResultCode;
import demik.springcloud.entity.commonbox.ResultGenerator;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

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
        return ResultGenerator.genFailResult("error");
    }
    @ApiOperation(value = "某post请求发生错误", httpMethod = "POST")
    @PostMapping("/error_post")
    public Result errorPost(){
        return ResultGenerator.genFailResult("error");
    }
}
