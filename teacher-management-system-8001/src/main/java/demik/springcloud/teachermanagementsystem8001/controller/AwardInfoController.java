package demik.springcloud.teachermanagementsystem8001.controller;

import demik.springcloud.entity.commonbox.Result;
import demik.springcloud.entity.commonbox.ResultCode;
import demik.springcloud.entity.commonbox.ResultGenerator;
import demik.springcloud.entity.domain.dto.GameNameDTO;
import demik.springcloud.entity.domain.dto.TeacherNameDTO;
import demik.springcloud.entity.domain.po.AwardInfoPO;
import demik.springcloud.entity.domain.vo.*;
import demik.springcloud.teachermanagementsystem8001.service.AwardInfoService;
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
 * Date: 2019/3/18 7:47 PM
 * @since JDK 1.8
 */
@RestController
@RequestMapping("/award-info")
@ApiModel(description = "获奖管理模块")
public class AwardInfoController {

    @Autowired
    private AwardInfoService awardInfoService;
    @Autowired
    private TeacherInfoService teacherInfoService;

    /**
     * 查询所有的比赛
     * @return
     */
    @ApiOperation(value = "查询所有的比赛", httpMethod = "POST")
    @PostMapping("/findAllAwardGame")
    public Result<List<AwardGameVO>> findAllAwardGame(){
        List<AwardGameVO> vos = awardInfoService.findAllAwardGame();
        if(vos!=null&&vos.size()>0){
            return ResultGenerator.genSuccessResult(vos);
        }
        return ResultGenerator.genSuccessResult(ResultCode.NONE_DATA);
    }
    /**
     * 根据id查询比赛
     * @return
     */
    @ApiOperation(value = "根据id查询比赛", httpMethod = "POST")
    @PostMapping("/findAwardGameById")
    public Result<AwardGameVO> findAwardGameById(@RequestBody AwardIdVO awardIdVO){
        AwardGameVO vos = awardInfoService.findAwardGameById(awardIdVO.getId());
        if(vos!=null){
            return ResultGenerator.genSuccessResult(vos);
        }
        return ResultGenerator.genSuccessResult(ResultCode.NONE_DATA);
    }
    /**
     * 根据id查询比赛
     * @return
     */
    @ApiOperation(value = "根据id查询比赛等级", httpMethod = "POST")
    @PostMapping("/findAwardLevelById")
    public Result<AwardLevelVO> findAwardLevelById(@RequestBody AwardIdVO awardIdVO){
        AwardLevelVO vos = awardInfoService.getAwardLevelById(awardIdVO.getId());
        if(vos!=null){
            return ResultGenerator.genSuccessResult(vos);
        }
        return ResultGenerator.genSuccessResult(ResultCode.NONE_DATA);
    }
    /**
     * 查询所有的奖项级别
     * @return
     */
    @ApiOperation(value = "查询所有的奖项级别", httpMethod = "POST")
    @PostMapping("/findAllAwardLevel")
    public Result<List<AwardLevelVO>> findAllAwardLevel(){
        List<AwardLevelVO> vos = awardInfoService.findAllAwardLevel();
        if(vos!=null&&vos.size()>0){
            return ResultGenerator.genSuccessResult(vos);
        }
        return ResultGenerator.genSuccessResult(ResultCode.NONE_DATA);
    }

    /**
     * 查询所有的教师获奖信息
     * @return
     */
    @ApiOperation(value = "查询所有的教师获奖信息", httpMethod = "POST")
    @PostMapping("/findAllAwardInfo")
    public Result<List<AwardInfoVO>> findAllAwardInfo(){
        List<AwardInfoVO> vos = awardInfoService.findAllAwardInfo();
        if(vos!=null&&vos.size()>0){
            return ResultGenerator.genSuccessResult(vos);
        }
        return ResultGenerator.genSuccessResult(ResultCode.NONE_DATA);
    }
    /**
     * 根据id查询教师获奖信息
     * @return
     */
    @ApiOperation(value = "根据id查询教师获奖信息", httpMethod = "POST")
    @PostMapping("/findAwardInfoById")
    public Result<AwardInfoVO> findAwardInfoById(@RequestBody AwardTeacherIdVO awardTeacherIdVO){
        AwardInfoVO vos = awardInfoService.findAwardInfoById(awardTeacherIdVO.getId());
        if(vos!=null){
            return ResultGenerator.genSuccessResult(vos);
        }
        return ResultGenerator.genSuccessResult(ResultCode.NONE_DATA);
    }
    /**
     * 根据教师名称查询教师获奖信息
     * @return
     */
    @ApiOperation(value = "根据教师名称查询教师获奖信息", httpMethod = "POST")
    @PostMapping("/findAwardInfoByTeacherName")
    public Result<List<AwardInfoVO>> findAwardInfoByTeacherName(@RequestBody TeacherNameDTO teacherNameDTO){
        List<AwardInfoVO> vos = awardInfoService.findAwardInfoByTeacherName(teacherNameDTO.getTeacherName());
        if(vos!=null){
            return ResultGenerator.genSuccessResult(vos);
        }
        return ResultGenerator.genSuccessResult(ResultCode.NONE_DATA);
    }
    /**
     * 根据比赛名称查询教师获奖信息
     * @return
     */
    @ApiOperation(value = "根据比赛名称查询教师获奖信息", httpMethod = "POST")
    @PostMapping("/findAwardInfoByGameName")
    public Result<List<AwardInfoVO>> findAwardInfoByGameName(@RequestBody GameNameDTO gameNameDTO){
        List<AwardInfoVO> vos = awardInfoService.findAwardInfoByGameName(gameNameDTO.getGameName());
        if(vos!=null){
            return ResultGenerator.genSuccessResult(vos);
        }
        return ResultGenerator.genSuccessResult(ResultCode.NONE_DATA);
    }
    /**
     * 删除一条教师获奖信息
     * @return
     */
    @ApiOperation(value = "删除一条教师获奖信息", httpMethod = "POST")
    @PostMapping("/deleteAwardInfoById")
    public Result deleteAwardInfoById(@RequestBody AwardInfoIdVO awardInfoIdVO){
        if(awardInfoService.deleteAwardInfoById(awardInfoIdVO.getAwardInfoId())){
            return ResultGenerator.genSuccessResult();
        }
        return ResultGenerator.genFailResult("删除一条教师获奖信息失败");
    }
    /**
     * 添加一条教师获奖信息
     * @return
     */
    @ApiOperation(value = "添加一条教师获奖信息", httpMethod = "POST")
    @PostMapping("/addAwardInfo")
    public Result addAwardInfo(@RequestBody AwardInfoPO awardInfoPO){

        //没有这个等级
        if(teacherInfoService.findTeacherInfoById(awardInfoPO.getTeacherId())==null){
            return ResultGenerator.genSuccessResult("没有这个教师");
        }
        if(awardInfoPO.getType()==null){
            return ResultGenerator.genSuccessResult("Type不能为空");
            //下拉框
        }else if(awardInfoPO.getType()==1){
            //没有这个比赛
            if(awardInfoService.findAwardGameById(awardInfoPO.getAwardGameId())==null){
                return ResultGenerator.genSuccessResult("没有这个比赛");
            }
            //手动输入
        }else if(awardInfoPO.getType()==2){
            //没有这个奖项等级
            if(awardInfoService.getAwardLevelById(awardInfoPO.getAwardLevelId())==null){
                return ResultGenerator.genSuccessResult("没有这个获奖等级");
            }
            //判断传过来的比赛名称是否是空
            if(awardInfoPO.getAwardGameName()==null||awardInfoPO.getAwardGameName().trim().equals("")){
                return ResultGenerator.genSuccessResult("比赛名称不能为空");
            }
            //判断比赛是不是已经存在
            Integer i = awardInfoService.findAwardGameByName(awardInfoPO.getAwardGameName());
            //比赛不存在
            if(i==null){
                //添加比赛并把返回的id插入到po类中
                AwardGameVO awardGameVO = new AwardGameVO();
                awardGameVO.setAwardGameName(awardInfoPO.getAwardGameName());
                if(!awardInfoService.addAwardGame(awardGameVO)){
                    return ResultGenerator.genFailResult("添加一条比赛信息失败");
                }
                if(awardGameVO.getAwardGameId()==null){
                    return ResultGenerator.genFailResult("返回比赛id失败");
                }
                awardInfoPO.setAwardGameId(awardGameVO.getAwardGameId());
            }else {
                return ResultGenerator.genFailResult("想添加的比赛已经存在");
            }
        }else{
            return ResultGenerator.genSuccessResult("Type传入的数据有问题");
        }
        //插入获奖信息
        if(awardInfoService.addAwardInfo(awardInfoPO)){
            return ResultGenerator.genSuccessResult();
        }
        return ResultGenerator.genFailResult("添加一条教师获奖信息失败");
    }
}
