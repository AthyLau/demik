package demik.springcloud.teachermanagementsystem8001.controller;

import demik.springcloud.entity.commonbox.Result;
import demik.springcloud.entity.commonbox.ResultCode;
import demik.springcloud.entity.commonbox.ResultGenerator;
import demik.springcloud.entity.domain.vo.OfficeIdVO;
import demik.springcloud.entity.domain.vo.OfficeInfoVO;
import demik.springcloud.teachermanagementsystem8001.service.OfficeInfoService;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Function:
 *
 * @author liubing
 * Date: 2019/3/15 11:16 PM
 * @since JDK 1.8
 */
@RestController
@RequestMapping("/office-info")
@ApiModel(description = "教研室管理模块")
public class OfficeInfoController {
    @Autowired
    private OfficeInfoService officeInfoService;

    /**
     * 添加一个教研室
     * @param
     * @return
     */
    @ApiOperation(value = "添加一个教研室", httpMethod = "POST")
    @PostMapping("/addOfficeInfo")
    public Result addOfficeInfo(@RequestBody OfficeInfoVO officeInfoVO){
        if(officeInfoService.addOfficeInfo(officeInfoVO)){
            return ResultGenerator.genSuccessResult();
        }
        return ResultGenerator.genFailResult("添加教研室失败");
    }

    /**
     * 删除一个教研室
     * @param
     * @return
     */
    @ApiOperation(value = "删除一个教研室", httpMethod = "POST")
    @PostMapping("/deleteOfficeInfo")
    public Result deleteOfficeInfo(@RequestBody OfficeIdVO officeIdVO){
        if(officeInfoService.deleteOfficeInfo(officeIdVO.getOfficeId())){
            return ResultGenerator.genSuccessResult();
        }
        return ResultGenerator.genFailResult("删除教研室失败");
    }

    /**
     * 更新一个教研室
     * @param
     * @return
     */
    @ApiOperation(value = "更新一个教研室", httpMethod = "POST")
    @PostMapping("/updateOfficeInfo")
    public Result updateOfficeInfo(@RequestBody OfficeInfoVO officeInfoVO){
        if(officeInfoService.updateOfficeInfo(officeInfoVO)){
            return ResultGenerator.genSuccessResult();
        }
        return ResultGenerator.genFailResult("更新教研室失败");
    }

    /**
     * 查询所有的教研室
     * @return
     */
    @ApiOperation(value = "查询所有的教研室", httpMethod = "POST")
    @PostMapping("/findAllOfficeInfo")
    public Result<List<OfficeInfoVO>> findAllOfficeInfo(){
        List<OfficeInfoVO> list = officeInfoService.findAllOfficeInfo();
        if(list!=null&&list.size()>0){
            return ResultGenerator.genSuccessResult(list);
        }
        return ResultGenerator.genSuccessResult(ResultCode.NONE_DATA);
    }
    /**
     * 查询单个教研室
     * @return
     */
    @ApiOperation(value = "查询单个教研室", httpMethod = "POST")
    @PostMapping("/findOfficeInfoById")
    public Result<OfficeInfoVO> findOfficeInfoById(@RequestBody OfficeIdVO officeIdVO){
        OfficeInfoVO vo = officeInfoService.findOfficeInfoById(officeIdVO.getOfficeId());
        if(vo!=null){
            return ResultGenerator.genSuccessResult(vo);
        }
        return ResultGenerator.genSuccessResult(ResultCode.NONE_DATA);
    }

}
