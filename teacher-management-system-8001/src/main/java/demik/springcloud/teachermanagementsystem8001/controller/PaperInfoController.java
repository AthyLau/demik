package demik.springcloud.teachermanagementsystem8001.controller;

import demik.springcloud.entity.commonbox.Result;
import demik.springcloud.entity.commonbox.ResultCode;
import demik.springcloud.entity.commonbox.ResultGenerator;
import demik.springcloud.entity.domain.dto.PublishedPaperInfoDTO;
import demik.springcloud.entity.domain.po.PaperPublishedPO;
import demik.springcloud.entity.domain.po.PaperTypePO;
import demik.springcloud.entity.domain.vo.PaperIdVO;
import demik.springcloud.entity.domain.vo.PaperInfoVO;
import demik.springcloud.entity.domain.vo.PaperPublishedIdVO;
import demik.springcloud.entity.domain.vo.PaperOriginInfoVO;
import demik.springcloud.teachermanagementsystem8001.service.PaperInfoService;
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
        if(paperPublishedPO.getType()==null){
            return ResultGenerator.genSuccessResult(ResultCode.HTTP_MESSAGE_NOT_READABLE);
        }else if(paperPublishedPO.getType()==1){
            List<PaperInfoVO> vos = paperInfoService.findAllPaperInfo();
            Integer len = vos.size();
            vos.forEach(x->{
                if(x.getPaperId()==paperPublishedPO.getPaperId()){
                    vos.remove(x);
                }
            });
            if(vos.size()==len){
                return ResultGenerator.genSuccessResult(ResultCode.NONE_DATA);
            }
        }else if(paperPublishedPO.getType()==2){
            //判断传过来的name是不是空
            if(paperPublishedPO.getPaperName()==null){
                return ResultGenerator.genSuccessResult(ResultCode.HTTP_MESSAGE_NOT_READABLE);
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

}
