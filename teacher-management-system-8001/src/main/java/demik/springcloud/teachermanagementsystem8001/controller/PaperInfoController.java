package demik.springcloud.teachermanagementsystem8001.controller;

import demik.springcloud.entity.commonbox.Result;
import demik.springcloud.entity.commonbox.ResultCode;
import demik.springcloud.entity.commonbox.ResultGenerator;
import demik.springcloud.entity.domain.dto.PaperNameDTO;
import demik.springcloud.entity.domain.dto.PublishedPaperInfoDTO;
import demik.springcloud.entity.domain.dto.TeacherNameDTO;
import demik.springcloud.entity.domain.po.PaperPublishedPO;
import demik.springcloud.entity.domain.po.PaperTypePO;
import demik.springcloud.entity.domain.vo.*;
import demik.springcloud.teachermanagementsystem8001.service.PaperInfoService;
import demik.springcloud.teachermanagementsystem8001.service.TeacherInfoService;
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
 * Date: 2019/3/20 1:43 AM
 * @since JDK 1.8
 */
@RestController
@RequestMapping("/paper-info")
@ApiModel(description = "论文管理模块")
public class PaperInfoController {

    @Autowired
    private PaperInfoService paperInfoService;
    @Autowired
    private TeacherInfoService teacherInfoService;
    /**
     * 查询所有的论文
     * @return
     */
    @ApiOperation(value = "查询所有的论文信息", httpMethod = "POST")
    @PostMapping("/findAllPaperInfo")
    public Result findAllPaperInfo(){
        List<PaperInfoVO> vos = paperInfoService.findAllPaperInfo();
        if(vos!=null&&vos.size()>0){
            return ResultGenerator.genSuccessResult(vos);
        }
        return ResultGenerator.genSuccessResult(ResultCode.NONE_DATA);
    }
    /**
     * 根据id查询论文信息
     * @return
     */
    @ApiOperation(value = "根据id查询论文信息", httpMethod = "POST")
    @PostMapping("/findPaperInfoById")
    public Result findPaperInfoById(@RequestBody PaperIdVO paperIdVO){
        PaperInfoVO vos = paperInfoService.findPaperInfoById(paperIdVO.getId());
        if(vos!=null){
            return ResultGenerator.genSuccessResult(vos);
        }
        return ResultGenerator.genSuccessResult(ResultCode.NONE_DATA);
    }
    /**
     * 查询所有的论文类型
     * @return
     */
    @ApiOperation(value = "查询所有的论文类型", httpMethod = "POST")
    @PostMapping("/findAllPaperType")
    public Result findAllPaperType(){
        List<PaperTypePO> pos = paperInfoService.findAllPaperType();
        if(pos!=null&&pos.size()>0){
            return ResultGenerator.genSuccessResult(pos);
        }
        return ResultGenerator.genSuccessResult(ResultCode.NONE_DATA);
    }
    /**
     * 根据id查询论文类型信息
     * @return
     */
    @ApiOperation(value = "根据id查询论文类型信息", httpMethod = "POST")
    @PostMapping("/findPaperTypeById")
    public Result findPaperTypeById(@RequestBody PaperIdVO paperIdVO){
        PaperTypePO vos = paperInfoService.findPaperTypeById(paperIdVO.getId());
        if(vos!=null){
            return ResultGenerator.genSuccessResult(vos);
        }
        return ResultGenerator.genSuccessResult(ResultCode.NONE_DATA);
    }
    /**
     * 添加论文
     * @return
     */
    @ApiOperation(value = "添加论文", httpMethod = "POST")
    @PostMapping("/addPaperOriginInfo")
    public Result addPaperOriginInfo(@RequestBody PaperOriginInfoVO paperOriginInfoVO){
        if(paperInfoService.findPaperTypeById(paperOriginInfoVO.getPaperTypeId())==null){
            return ResultGenerator.genSuccessResult(ResultCode.NONE_DATA);
        }
        if(paperInfoService.findPaperInfoByName(paperOriginInfoVO.getPaperName())!=null){
            return ResultGenerator.genFailResult("论文已经存在");
        }
        if(paperInfoService.addPaperOriginInfo(paperOriginInfoVO)){
            return ResultGenerator.genSuccessResult();
        }
        return ResultGenerator.genFailResult("添加论文失败");
    }

    /**
     * 删除一条教师发布论文信息
     * @return
     */
    @ApiOperation(value = "删除一条教师发布论文信息", httpMethod = "POST")
    @PostMapping("/deletePaperOriginInfo")
    public Result deletePaperOriginInfo(@RequestBody PaperPublishedIdVO paperPublishedIdVO){
        if(paperInfoService.deletePaperOriginInfo(paperPublishedIdVO.getId())){
            return ResultGenerator.genSuccessResult();
        }
        return ResultGenerator.genFailResult("删除一条教师发布论文信息失败");
    }
    /**
     * 添加一条教师发布论文信息
     * @return
     */
    @ApiOperation(value = "添加一条教师发布论文信息", httpMethod = "POST")
    @PostMapping("/addPublishedPaperInfo")
    public Result addPublishedPaperInfo(@RequestBody PaperPublishedPO paperPublishedPO){

        if(teacherInfoService.findTeacherInfoById(paperPublishedPO.getTeacherId())==null){
            return ResultGenerator.genSuccessResult("没有该教师");
        }
        if(paperPublishedPO.getType()==null){
            return ResultGenerator.genSuccessResult(ResultCode.HTTP_MESSAGE_NOT_READABLE);
        }else if(paperPublishedPO.getType()==1){
            if(paperInfoService.findPaperInfoById(paperPublishedPO.getPaperId())==null){
                return ResultGenerator.genSuccessResult("该论文不存在");
            }
        }else if(paperPublishedPO.getType()==2){
            //判断论文类型是否为空
            if(paperInfoService.findPaperTypeById(paperPublishedPO.getPaperTypeId())==null){
                return ResultGenerator.genSuccessResult("没有该论文类型");
            }
            //判断传过来的name是不是空
            if(paperPublishedPO.getPaperName()==null||paperPublishedPO.getPaperName().trim().equals("")){
                return ResultGenerator.genSuccessResult("传过来的论文名字为空");
            }
            Integer i = paperInfoService.findPaperInfoByName(paperPublishedPO.getPaperName());
            if(i==null){
                PaperOriginInfoVO paperOriginInfoVO = new PaperOriginInfoVO();
                paperOriginInfoVO.setPaperName(paperPublishedPO.getPaperName());
                paperOriginInfoVO.setPaperTypeId(paperPublishedPO.getPaperTypeId());
                if(!paperInfoService.addPaperOriginInfo(paperOriginInfoVO)){
                    return ResultGenerator.genFailResult("添加一条教师发布论文信息失败");
                }
                if(paperOriginInfoVO.getPaperId()==null){
                    return ResultGenerator.genFailResult("返回论文id失败");
                }
                paperPublishedPO.setPaperId(paperOriginInfoVO.getPaperId());
            }else {
                return ResultGenerator.genFailResult("想添加的论文已经存在");
            }
        }else {
            return ResultGenerator.genSuccessResult("Type传入数据错误");
        }
        if(paperInfoService.addPublishedPaperInfo(paperPublishedPO)){
            return ResultGenerator.genSuccessResult();
        }
        return ResultGenerator.genFailResult("添加一条教师发布论文信息失败");
    }
    /**
     * 查询所有的教师发布论文信息
     * @return
     */
    @ApiOperation(value = "查询所有的教师发布论文信息", httpMethod = "POST")
    @PostMapping("/findAllPublishedPaperInfo")
    public Result findAllPublishedPaperInfo(){
        List<PublishedPaperInfoDTO> pos = paperInfoService.findAllPublishedPaperInfo();
        if(pos!=null&&pos.size()>0){
            return ResultGenerator.genSuccessResult(pos);
        }
        return ResultGenerator.genSuccessResult(ResultCode.NONE_DATA);
    }
    /**
     * 根据id查询教师发布论文信息
     * @return
     */
    @ApiOperation(value = "根据id查询教师发布论文信息", httpMethod = "POST")
    @PostMapping("/findPublishedPaperInfoById")
    public Result findPublishedPaperInfoById(@RequestBody PublishedPaperIdVO publishedPaperIdVO){
        PublishedPaperInfoDTO pos = paperInfoService.findPublishedPaperInfoById(publishedPaperIdVO.getId());
        if(pos!=null){
            return ResultGenerator.genSuccessResult(pos);
        }
        return ResultGenerator.genSuccessResult(ResultCode.NONE_DATA);
    }
    /**
     * 根据id查询教师发布论文信息
     * @return
     */
    @ApiOperation(value = "根据教师名称查询教师发布论文信息", httpMethod = "POST")
    @PostMapping("/findPublishedPaperInfoByTeacherName")
    public Result findPublishedPaperInfoByTeacherName(@RequestBody TeacherNameDTO teacherNameDTO){
        List<PublishedPaperInfoDTO> pos = paperInfoService.findPublishedPaperInfoByTeacherName(teacherNameDTO.getTeacherName());
        if(pos!=null&&pos.size()>0){
            return ResultGenerator.genSuccessResult(pos);
        }
        return ResultGenerator.genSuccessResult(ResultCode.NONE_DATA);
    }
    /**
     * 根据论文名称查询教师发布论文信息
     * @return
     */
    @ApiOperation(value = "根据论文名称查询教师发布论文信息", httpMethod = "POST")
    @PostMapping("/findPublishedPaperInfoByPaperName")
    public Result findPublishedPaperInfoByPaperName(@RequestBody PaperNameDTO paperNameDTO){
        List<PublishedPaperInfoDTO> pos = paperInfoService.findPublishedPaperInfoByPaperName(paperNameDTO.getPaperName());
        if(pos!=null&&pos.size()>0){
            return ResultGenerator.genSuccessResult(pos);
        }
        return ResultGenerator.genSuccessResult(ResultCode.NONE_DATA);
    }
}
