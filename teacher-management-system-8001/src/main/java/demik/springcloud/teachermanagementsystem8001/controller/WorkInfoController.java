package demik.springcloud.teachermanagementsystem8001.controller;

import com.google.common.collect.Lists;
import demik.springcloud.entity.commonbox.Result;
import demik.springcloud.entity.commonbox.ResultCode;
import demik.springcloud.entity.commonbox.ResultGenerator;
import demik.springcloud.entity.domain.dto.TeacherNameDTO;
import demik.springcloud.entity.domain.dto.TeacherWorkDTO;
import demik.springcloud.entity.domain.dto.WorkNameDTO;
import demik.springcloud.entity.domain.po.WorkInfoPO;
import demik.springcloud.entity.domain.po.WorkPO;
import demik.springcloud.entity.domain.vo.TeacherWorkIdVO;
import demik.springcloud.entity.domain.vo.WorkIdVO;
import demik.springcloud.teachermanagementsystem8001.service.TeacherInfoService;
import demik.springcloud.teachermanagementsystem8001.service.WorkInfoService;
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
 * Date: 2019/3/20 3:44 PM
 * @since JDK 1.8
 */
@RestController
@RequestMapping("/work-info")
@ApiModel(description = "作品管理模块")
public class WorkInfoController {
    @Autowired
    private WorkInfoService workInfoService;
    @Autowired
    private TeacherInfoService teacherInfoService;
    /**
     * 查询所有的教师作品信息
     * @return
     */
    @ApiOperation(value = "查询所有的教师作品信息", httpMethod = "POST")
    @PostMapping("/findAllTeacherWorkInfo")
    public Result findAllWorkInfo(){
        List<WorkInfoPO> vos = workInfoService.findAllWorkInfo();
        if(vos!=null&&vos.size()>0){
            return ResultGenerator.genSuccessResult(vos);
        }
        return ResultGenerator.genSuccessResult(ResultCode.NONE_DATA);
    }
    /**
     * 根据id查询教师作品信息
     * @return
     */
    @ApiOperation(value = "根据id查询教师作品信息", httpMethod = "POST")
    @PostMapping("/findTeacherWorkInfoById")
    public Result findTeacherWorkInfoById(@RequestBody TeacherWorkIdVO teacherWorkIdVO){
        WorkInfoPO vos = workInfoService.findTeacherWorkInfoById(teacherWorkIdVO.getId());
        if(vos!=null){
            return ResultGenerator.genSuccessResult(vos);
        }
        return ResultGenerator.genSuccessResult(ResultCode.NONE_DATA);
    }
    /**
     * 根据教师名字查询教师作品信息
     * @return
     */
    @ApiOperation(value = "根据教师名字查询教师作品信息", httpMethod = "POST")
    @PostMapping("/findTeacherWorkInfoByTeacherName")
    public Result findTeacherWorkInfoByTeacherName(@RequestBody TeacherNameDTO teacherNameDTO){
        List<WorkInfoPO> vos = workInfoService.findTeacherWorkInfoByTeacherName(teacherNameDTO.getTeacherName());
        if(vos!=null){
            return ResultGenerator.genSuccessResult(vos);
        }
        return ResultGenerator.genSuccessResult(ResultCode.NONE_DATA);
    }
    /**
     * 根据作品名字查询教师作品信息
     * @return
     */
    @ApiOperation(value = "根据作品名字查询教师作品信息", httpMethod = "POST")
    @PostMapping("/findTeacherWorkInfoByWorkName")
    public Result findTeacherWorkInfoByWorkName(@RequestBody WorkNameDTO workNameDTO){
        List<WorkInfoPO> vos = workInfoService.findTeacherWorkInfoByWorkName(workNameDTO.getWorkName());
        if(vos!=null){
            return ResultGenerator.genSuccessResult(vos);
        }
        return ResultGenerator.genSuccessResult(ResultCode.NONE_DATA);
    }
    /**
     * 根据id删除教师作品信息
     * @return
     */
    @ApiOperation(value = "根据id删除教师作品信息", httpMethod = "POST")
    @PostMapping("/deleteTeacherWorkInfoById")
    public Result deleteTeacherWorkInfoById(@RequestBody TeacherWorkIdVO teacherWorkIdVO){
        if(workInfoService.deleteTeacherWorkInfoById(teacherWorkIdVO.getId())){
            return ResultGenerator.genSuccessResult();
        }
        return ResultGenerator.genSuccessResult("删除教师作品信息失败");
    }
    /**
     * 查询所有的作品
     * @return
     */
    @ApiOperation(value = "查询所有的作品", httpMethod = "POST")
    @PostMapping("/findAllWorkInfo")
    public Result findAllWork(){
        List<WorkPO> vos = workInfoService.findAllWork();
        if(vos!=null&&vos.size()>0){
            return ResultGenerator.genSuccessResult(vos);
        }
        return ResultGenerator.genSuccessResult(ResultCode.NONE_DATA);
    }
    /**
     * 根据id查询作品
     * @return
     */
    @ApiOperation(value = "根据id查询作品", httpMethod = "POST")
    @PostMapping("/findWorkById")
    public Result findWorkById(@RequestBody WorkIdVO workIdVO){
        WorkPO vos = workInfoService.findWorkById(workIdVO.getWorkid());
        if(vos!=null){
            return ResultGenerator.genSuccessResult(vos);
        }
        return ResultGenerator.genSuccessResult(ResultCode.NONE_DATA);
    }
    /**
     * 添加一个作品
     * @param teacherWorkDTO
     * @return
     */
    @ApiOperation(value = "添加一个作品", httpMethod = "POST")
    @PostMapping("/addTeacherWork")
    public Result addTeacherWork(@RequestBody TeacherWorkDTO teacherWorkDTO){
        if(teacherInfoService.findTeacherInfoById(teacherWorkDTO.getTeacherId())==null){
            return ResultGenerator.genSuccessResult("教师信息不存在");
        }
        if(teacherWorkDTO.getType()==null){
            return ResultGenerator.genSuccessResult("type不能为空");
        }else if(teacherWorkDTO.getType()==1){
            if(workInfoService.findWorkById(teacherWorkDTO.getWorkId())==null){
                return ResultGenerator.genFailResult("该作品不存在");
            }
        }else if (teacherWorkDTO.getType()==2){
            if(teacherWorkDTO.getWorkName()==null||teacherWorkDTO.getWorkName().trim().equals("")){
                return ResultGenerator.genFailResult("作品名字不能为空");
            }
            List<WorkPO> vos = workInfoService.findAllWork();
            Integer len = vos.size();
            vos.forEach(x->{
                if(x.getWorkName().equals(teacherWorkDTO.getWorkName())){
                    vos.remove(x);
                }
            });
            if(!(len==vos.size())){
                WorkPO workPO = new WorkPO();
                workPO.setWorkName(teacherWorkDTO.getWorkName());
                if(!workInfoService.addWork(workPO)){
                    return ResultGenerator.genFailResult("添加作品失败");
                }
                if(workPO.getWorkId()==null){
                    return ResultGenerator.genFailResult("返回的作品id为空");
                }
                teacherWorkDTO.setWorkId(workPO.getWorkId());
            }else {
                return ResultGenerator.genFailResult("想要添加的作品已经存在");
            }
        }else {
            return ResultGenerator.genSuccessResult("Type传入数据错误");
        }
        if(workInfoService.addTeacherWork(teacherWorkDTO)){
            return ResultGenerator.genSuccessResult();
        }
        return ResultGenerator.genSuccessResult();
    }

}
