package demik.springcloud.teachermanagementsystem8001.controller;

import com.google.common.collect.Lists;
import demik.springcloud.entity.commonbox.Result;
import demik.springcloud.entity.commonbox.ResultCode;
import demik.springcloud.entity.commonbox.ResultGenerator;
import demik.springcloud.entity.domain.dto.TeacherWorkDTO;
import demik.springcloud.entity.domain.po.WorkInfoPO;
import demik.springcloud.entity.domain.po.WorkPO;
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
    /**
     * 查询所有的教师作品信息
     * @return
     */
    @ApiOperation(value = "查询所有的教师作品信息", httpMethod = "POST")
    @PostMapping("/findAllWorkInfo")
    public Result findAllWorkInfo(){
        List<WorkInfoPO> vos = workInfoService.findAllWorkInfo();
        if(vos!=null&&vos.size()>0){
            return ResultGenerator.genSuccessResult(vos);
        }
        return ResultGenerator.genSuccessResult(ResultCode.NONE_DATA);
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
     * 添加一个作品
     * @param teacherWorkDTO
     * @return
     */
    @ApiOperation(value = "添加一个作品", httpMethod = "POST")
    @PostMapping("/addTeacherWork")
    public Result addTeacherWork(@RequestBody TeacherWorkDTO teacherWorkDTO){
        if(teacherWorkDTO.getType()==null){
            return ResultGenerator.genSuccessResult(ResultCode.HTTP_MESSAGE_NOT_READABLE);
        }else if(teacherWorkDTO.getType()==1){
            if(workInfoService.findWorkById(teacherWorkDTO.getWorkId())==null){
                return ResultGenerator.genFailResult("该作品不存在");
            }
        }else if (teacherWorkDTO.getType()==2){
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
        }
        if(workInfoService.addTeacherWork(teacherWorkDTO)){
            return ResultGenerator.genSuccessResult();
        }
        return ResultGenerator.genSuccessResult();
    }

}
