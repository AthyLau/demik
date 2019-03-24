package demik.springcloud.teachermanagementsystem8001.controller;

import com.google.common.collect.Lists;
import demik.springcloud.entity.commonbox.Result;
import demik.springcloud.entity.commonbox.ResultCode;
import demik.springcloud.entity.commonbox.ResultGenerator;
import demik.springcloud.entity.domain.dto.TeacherInfoDTO;
import demik.springcloud.entity.domain.po.BookPO;
import demik.springcloud.entity.domain.po.TeacherInfoPO;
import demik.springcloud.entity.domain.vo.DeptVO;
import demik.springcloud.entity.domain.vo.EducationBackgroudVO;
import demik.springcloud.entity.domain.vo.TeacherIdVO;
import demik.springcloud.teachermanagementsystem8001.service.OfficeInfoService;
import demik.springcloud.teachermanagementsystem8001.service.OtherInfoService;
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
 * Date: 2019/3/24 2:01 AM
 * @since JDK 1.8
 */
@RestController
@RequestMapping("/teacher-info")
@ApiModel(description = "教师信息管理模块")
public class TeacherInfoController {
    @Autowired
    private TeacherInfoService teacherInfoService;
    @Autowired
    private OtherInfoService otherInfoService;
    @Autowired
    private OfficeInfoService officeInfoService;
    /**
     * 查询所有的教师信息
     * @return
     */
    @ApiOperation(value = "查询所有的教师信息", httpMethod = "POST")
    @PostMapping("/findAllTeacherInfo")
    public Result<List<TeacherInfoPO>> findAllTeacherInfo(){
        List<TeacherInfoPO> pos = teacherInfoService.findAllTeacherInfo();
        if(pos!=null||pos.size()>0){
            return ResultGenerator.genSuccessResult(pos);
        }
        return ResultGenerator.genSuccessResult(ResultCode.NONE_DATA);
    }

    /**
     * 添加教师信息
     * @param teacherInfoDTO
     * @return
     */
    @ApiOperation(value = "添加教师信息", httpMethod = "POST")
    @PostMapping("/addTeacherInfo")
    public Result addTeacherInfo(@RequestBody TeacherInfoDTO teacherInfoDTO){
        List<Object> list = Lists.newArrayList();
        List<BookPO> vos1 = otherInfoService.findAllBook();
        List<DeptVO> vos2 = otherInfoService.findAllDept();
        List<EducationBackgroudVO> vos3 = otherInfoService.findAllEducationBackgroud();
        vos1.forEach(x->{
            if(x.getBookId()==teacherInfoDTO.getBookId()){
                list.add(x);
            }
        });
        vos2.forEach(x->{
            if(x.getDeptId()==teacherInfoDTO.getDeptId()){
                list.add(x);
            }
        });
        vos3.forEach(x->{
            if(x.getEducationBackgroudId()==teacherInfoDTO.getEducationBackgroudId()){
                list.add(x);
            }
        });
        if(list.size()!=3){
            return ResultGenerator.genFailResult("教材、学历或者职位不存在");
        }
        if(null==officeInfoService.findOfficeInfoById(teacherInfoDTO.getOfficeId())){
            return ResultGenerator.genFailResult("教研室不存在");
        }
        if(teacherInfoService.addTeacherInfo(teacherInfoDTO)){
            return ResultGenerator.genSuccessResult();
        }
        return ResultGenerator.genFailResult("添加教师失败");
    }
    /**
     * 删除教师信息
     * @param teacherIdVO
     * @return
     */
    @ApiOperation(value = "删除教师信息", httpMethod = "POST")
    @PostMapping("/deleteTeacherInfo")
    public Result deleteTeacherInfo(@RequestBody TeacherIdVO teacherIdVO){
        if(teacherInfoService.deleteTeacherInfo(teacherIdVO.getTeacherId())){
            return ResultGenerator.genSuccessResult();
        }
        return ResultGenerator.genSuccessResult(ResultCode.NONE_DATA);
    }
}
