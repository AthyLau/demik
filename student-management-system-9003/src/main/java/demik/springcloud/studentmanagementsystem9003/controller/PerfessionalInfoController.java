package demik.springcloud.studentmanagementsystem9003.controller;

import demik.springcloud.entity.commonbox.Result;
import demik.springcloud.entity.commonbox.ResultCode;
import demik.springcloud.entity.commonbox.ResultGenerator;
import demik.springcloud.entity.domain.vo.PerfessionalIdVO;
import demik.springcloud.entity.domain.vo.PerfessionalInfoVO;
import demik.springcloud.studentmanagementsystem9003.service.PerfessionalInfoService;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Function:
 *
 * @author liubing
 * Date: 2019/3/14 2:35 PM
 * @since JDK 1.8
 */
@RestController
@RequestMapping("perfessional-info")
@ApiModel(description = "专业管理模块")
public class PerfessionalInfoController {

    @Autowired
    private PerfessionalInfoService perfessionalInfoService;

    /**
     * 添加一个专业
     * @param perfessionalInfoVO
     * @return
     */
    @ApiOperation(value = "添加一个专业", httpMethod = "POST")
    @PostMapping("/addPerfessionalInfo")
    public Result addPerfessionalInfo(@RequestBody PerfessionalInfoVO perfessionalInfoVO){
        if(perfessionalInfoService.addPerfessionalInfo(perfessionalInfoVO)){
            return ResultGenerator.genSuccessResult();
        }
        return ResultGenerator.genFailResult("添加专业失败");
    }
    /**
     * 删除一个专业
     * @param perfessionalInfoVO
     * @return
     */
    @ApiOperation(value = "删除一个专业", httpMethod = "POST")
    @PostMapping("/deletePerfessionalInfo")
    public Result deletePerfessionalInfo(@RequestBody PerfessionalIdVO perfessionalInfoVO){
        if(perfessionalInfoService.deletePerfessionalInfo(perfessionalInfoVO.getPerfessionalId())){
            return ResultGenerator.genSuccessResult();
        }
        return ResultGenerator.genFailResult("删除专业失败");
    }
    /**
     * 更新一个专业
     * @param perfessionalInfoVO
     * @return
     */
    @ApiOperation(value = "更新一个专业", httpMethod = "POST")
    @PostMapping("/updatePerfessionalInfo")
    public Result updatePerfessionalInfo(@RequestBody PerfessionalInfoVO perfessionalInfoVO){
        if(perfessionalInfoService.updatePerfessionalInfo(perfessionalInfoVO)){
            return ResultGenerator.genSuccessResult();
        }
        return ResultGenerator.genFailResult("更新专业失败");
    }
    /**
     * 查询所有专业
     * @return
     */
    @ApiOperation(value = "查询所有专业", httpMethod = "GET")
    @GetMapping("/findAllPerfessionalInfo")
    public Result findAllPerfessionalInfo(){
        List<PerfessionalInfoVO> list = perfessionalInfoService.findAllPerfessionalInfo();
        if(list!=null&&list.size()>0){
            return ResultGenerator.genSuccessResult(list);
        }
        return ResultGenerator.genSuccessResult(ResultCode.NONE_DATA);
    }
    /**
     * 查询单个专业
     * @return
     */
    @ApiOperation(value = "查询单个专业", httpMethod = "POST")
    @PostMapping("/findPerfessionalInfoById")
    public Result findPerfessionalInfoById(@RequestBody PerfessionalIdVO perfessionalIdVO){
        PerfessionalInfoVO perfessionalInfoVO = perfessionalInfoService.findPerfessionalInfoById(perfessionalIdVO.getPerfessionalId());
        if(perfessionalInfoVO!=null){
            return ResultGenerator.genSuccessResult(perfessionalInfoVO);
        }
        return ResultGenerator.genSuccessResult(ResultCode.NONE_DATA);
    }
}
