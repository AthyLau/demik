package demik.springcloud.studentmanagementsystem9002.controller;

import com.google.common.collect.Lists;
import demik.springcloud.entity.commonbox.Result;
import demik.springcloud.entity.commonbox.ResultCode;
import demik.springcloud.entity.commonbox.ResultGenerator;
import demik.springcloud.entity.domain.dto.GradeInfoDTO;
import demik.springcloud.entity.domain.vo.GradeIdVO;
import demik.springcloud.entity.domain.vo.GradeInfoVO;
import demik.springcloud.studentmanagementsystem9002.service.GradeInfoService;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
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
@RequestMapping("grade-info")
@ApiModel(description = "年级管理模块")
public class GradeInfoController {
    @Autowired
    private GradeInfoService gradeInfoService;
    /**
     * 添加一个
     * @param gradeInfoVO
     * @return
     */
    @ApiOperation(value = "添加", httpMethod = "POST")
    @PostMapping("/addGrade")
    public Result addGrade(@RequestBody GradeInfoVO gradeInfoVO){
        GradeInfoDTO gradeInfoDTO = new GradeInfoDTO();
        BeanUtils.copyProperties(gradeInfoVO,gradeInfoDTO);
        if(gradeInfoService.addGrade(gradeInfoDTO)){
            return ResultGenerator.genSuccessResult();
        }
        return ResultGenerator.genFailResult("添加班级失败");
    }

    /**
     * 删除一个
     * @param gradeIdVO
     * @return
     */
    @ApiOperation(value = "删除", httpMethod = "POST")
    @PostMapping("/deleteGrade")
    public Result deleteGrade(@RequestBody GradeIdVO gradeIdVO){
        if(gradeInfoService.deleteGrade(gradeIdVO.getGradeId())){
            return ResultGenerator.genSuccessResult();
        }
        return ResultGenerator.genFailResult("删除班级失败");
    }

    /**
     * 更新一个信息
     * @return
     */
    @ApiOperation(value = "更新", httpMethod = "POST")
    @PostMapping("/updateGrade")
    public Result updateGrade(@RequestBody GradeInfoVO gradeInfoVO){
        GradeInfoDTO gradeInfoDTO = new GradeInfoDTO();
        BeanUtils.copyProperties(gradeInfoVO,gradeInfoDTO);
        if(gradeInfoService.findGradeById(gradeInfoDTO.getGradeId())==null){
            return ResultGenerator.genSuccessResult(ResultCode.NONE_DATA);
        }
        if(gradeInfoService.updateGrade(gradeInfoDTO)){
            return ResultGenerator.genSuccessResult();
        }
        return ResultGenerator.genFailResult("更新班级信息失败");
    }

    /**
     * 查询所有的信息
     * @return
     */
    @ApiOperation(value = "查找所有", httpMethod = "GET")
    @GetMapping("/findAllGrade")
    public Result<List<GradeInfoVO>> findAllGrade(){
        List<GradeInfoVO> vos = Lists.newArrayList();
        List<GradeInfoDTO> dtos = gradeInfoService.findAllGrade();
        dtos.forEach(x->{
            GradeInfoVO gradeInfoVO = new GradeInfoVO();
            BeanUtils.copyProperties(x,gradeInfoVO);
            vos.add(gradeInfoVO);
        });
        if(vos!=null&&vos.size()>0){
            return ResultGenerator.genSuccessResult(vos);
        }
        return ResultGenerator.genSuccessResult(ResultCode.NONE_DATA);
    }

    /**
     * 根据id查询信息
     * @param gradeIdVO
     * @return
     */
    @ApiOperation(value = "查找一个", httpMethod = "POST")
    @PostMapping("/findGradeById")
    public Result<GradeInfoVO> findGradeById(@RequestBody GradeIdVO gradeIdVO){
        GradeInfoDTO gradeInfoDTO = gradeInfoService.findGradeById(gradeIdVO.getGradeId());
        if(gradeInfoDTO==null){
            return ResultGenerator.genSuccessResult(ResultCode.NONE_DATA);
        }
        GradeInfoVO gradeInfoVO = new GradeInfoVO();
        BeanUtils.copyProperties(gradeInfoDTO,gradeInfoVO);
        if(gradeInfoVO!=null){
            return ResultGenerator.genSuccessResult(gradeInfoVO);
        }
        return ResultGenerator.genSuccessResult(ResultCode.NONE_DATA);
    }


}
