package demik.springcloud.teachermanagementsystem8001.controller;

import demik.springcloud.entity.commonbox.Result;
import demik.springcloud.entity.commonbox.ResultCode;
import demik.springcloud.entity.commonbox.ResultGenerator;
import demik.springcloud.entity.domain.po.BookPO;
import demik.springcloud.entity.domain.vo.DeptVO;
import demik.springcloud.entity.domain.vo.EducationBackgroudVO;
import demik.springcloud.teachermanagementsystem8001.service.OtherInfoService;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Function:
 *
 * @author liubing
 * Date: 2019/3/20 1:27 AM
 * @since JDK 1.8
 */
@RestController
@RequestMapping("/other-info")
@ApiModel(description = "其他信息管理模块")
public class OtherInfoController {

    @Autowired
    private OtherInfoService otherInfoService;

    /**
     * 查询所有的教育背景
     * @return
     */
    @ApiOperation(value = "查询所有的教育背景", httpMethod = "POST")
    @PostMapping("/findAllEducationBackgroud")
    public Result findAllEducationBackgroud(){
        List<EducationBackgroudVO> vos = otherInfoService.findAllEducationBackgroud();
        if(vos!=null&&vos.size()>0){
            return ResultGenerator.genSuccessResult(vos);
        }
        return ResultGenerator.genSuccessResult(ResultCode.NONE_DATA);
    }
    /**
     * 查询所有的职称
     * @return
     */
    @ApiOperation(value = "查询所有的职称", httpMethod = "POST")
    @PostMapping("/findAllDept")
    public Result findAllDept(){
        List<DeptVO> vos = otherInfoService.findAllDept();
        if(vos!=null&&vos.size()>0){
            return ResultGenerator.genSuccessResult(vos);
        }
        return ResultGenerator.genSuccessResult(ResultCode.NONE_DATA);
    }
    /**
     * 查询所有的教材
     * @return
     */
    @ApiOperation(value = "查询所有的教材", httpMethod = "POST")
    @PostMapping("/findAllBook")
    public Result findAllBook(){
        List<BookPO> vos = otherInfoService.findAllBook();
        if(vos!=null&&vos.size()>0){
            return ResultGenerator.genSuccessResult(vos);
        }
        return ResultGenerator.genSuccessResult(ResultCode.NONE_DATA);
    }
}
