package demik.springcloud.studentmanagementsystem9001.controller;

import com.google.common.collect.Lists;
import demik.springcloud.entity.commonbox.Result;
import demik.springcloud.entity.commonbox.ResultCode;
import demik.springcloud.entity.commonbox.ResultGenerator;
import demik.springcloud.entity.domain.dto.AClassInfoDTO;
import demik.springcloud.entity.domain.vo.AClassIdVO;
import demik.springcloud.entity.domain.vo.AClassInfoVO;
import demik.springcloud.studentmanagementsystem9001.service.AClassInfoService;
import demik.springcloud.studentmanagementsystem9001.service.GradeInfoService;
import demik.springcloud.studentmanagementsystem9001.service.PerfessionalInfoService;
import io.swagger.annotations.Api;
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
@RequestMapping("aclass-info")
@ApiModel(description = "班级管理模块")
public class AClassInfoController {
    @Autowired
    private AClassInfoService aClassInfoService;
    @Autowired
    private GradeInfoService gradeInfoService;
    @Autowired
    private PerfessionalInfoService perfessionalInfoService;

    /**
     * 添加一个班级
     * @param aClassInfoVO
     * @return
     */
    @ApiOperation(value = "添加一个班级", httpMethod = "POST")
    @PostMapping("/addAClass")
    public Result addAClass(@RequestBody AClassInfoVO aClassInfoVO){
        if(!(gradeInfoService.findGradeById(aClassInfoVO.getAclassId())!=null||perfessionalInfoService.findPerfessionalInfoById(aClassInfoVO.getPerfessionalId())!=null)){
            return ResultGenerator.genFailResult("年级或者专业不存在");
        }
        if(aClassInfoService.addAClass(aClassInfoVO)){
            return ResultGenerator.genSuccessResult();
        }
        return ResultGenerator.genFailResult("添加班级失败");
    }

    /**
     * 删除一个班级
     * @param aClassIdVO
     * @return
     */
    @ApiOperation(value = "删除一个班级", httpMethod = "POST")
    @PostMapping("/deleteAClass")
    public Result deleteAClass(@RequestBody AClassIdVO aClassIdVO){
        if(aClassInfoService.deleteAClass(aClassIdVO.getAclassId())){
            return ResultGenerator.genSuccessResult();
        }
        return ResultGenerator.genFailResult("删除班级失败");
    }

    /**
     * 更新一个班级
     * @param aClassInfoVO
     * @return
     */
    @ApiOperation(value = "更新一个班级", httpMethod = "POST")
    @PostMapping("/updateAClass")
    public Result updateAClass(@RequestBody AClassInfoVO aClassInfoVO){
        if(!(gradeInfoService.findGradeById(aClassInfoVO.getAclassId())!=null||perfessionalInfoService.findPerfessionalInfoById(aClassInfoVO.getPerfessionalId())!=null)){
            return ResultGenerator.genFailResult("年级或者专业不存在");
        }
        if(aClassInfoService.updateAClass(aClassInfoVO)){
            return ResultGenerator.genSuccessResult();
        }
        return ResultGenerator.genFailResult("更新班级失败");
    }
    /**
     * 查询所有班级
     * @return
     */
    @ApiOperation(value = "查询所有班级", httpMethod = "GET")
    @GetMapping("/findAllAClass")
    public Result findAllAClass(){
        List<AClassInfoDTO> dtos = aClassInfoService.findAllAClass();
        if(dtos!=null&&dtos.size()>0){
            return ResultGenerator.genSuccessResult(dtos);
        }
        return ResultGenerator.genSuccessResult(ResultCode.NONE_DATA);
    }
    /**
     * 查询单个班级
     * @return
     */
    @ApiOperation(value = "查询单个班级", httpMethod = "POST")
    @PostMapping("/findAClassById")
    public Result findAClassById(@RequestBody AClassIdVO aClassIdVO){
        AClassInfoDTO dto = aClassInfoService.findAClassById(aClassIdVO.getAclassId());
        if(dto!=null){
            return ResultGenerator.genSuccessResult(dto);
        }
        return ResultGenerator.genSuccessResult(ResultCode.NONE_DATA);
    }
}
