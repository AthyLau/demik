package demik.springcloud.teachermanagementsystem8001.controller;

import demik.springcloud.entity.commonbox.Result;
import demik.springcloud.entity.commonbox.ResultCode;
import demik.springcloud.entity.commonbox.ResultGenerator;
import demik.springcloud.entity.domain.dto.SchoolNameDTO;
import demik.springcloud.entity.domain.dto.TeacherNameDTO;
import demik.springcloud.entity.domain.dto.VisitSchoolDTO;
import demik.springcloud.entity.domain.po.ProjectInfoPO;
import demik.springcloud.entity.domain.po.SchoolPO;
import demik.springcloud.entity.domain.po.VisitSchoolPO;
import demik.springcloud.entity.domain.vo.SchoolIdVO;
import demik.springcloud.entity.domain.vo.VisitSchoolIdVO;
import demik.springcloud.teachermanagementsystem8001.service.TeacherInfoService;
import demik.springcloud.teachermanagementsystem8001.service.VisitSchoolInfoService;
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
 * Date: 2019/3/20 3:45 PM
 * @since JDK 1.8
 */
@RestController
@RequestMapping("/visit-info")
@ApiModel(description = "访学信息管理模块")
public class VisitSchoolInfoController {
    @Autowired
    private VisitSchoolInfoService visitSchoolInfoService;
    @Autowired
    private TeacherInfoService teacherInfoService;
    /**
     * 查询所有的学校信息
     * @return
     */
    @ApiOperation(value = "查询所有的学校信息", httpMethod = "POST")
    @PostMapping("/findAllSchoolInfo")
    public Result findAllSchoolInfo(){
        List<SchoolPO> vos = visitSchoolInfoService.findAllSchoolInfo();
        if(vos!=null&&vos.size()>0){
            return ResultGenerator.genSuccessResult(vos);
        }
        return ResultGenerator.genSuccessResult(ResultCode.NONE_DATA);
    }
    /**
     * 查询所有的访学信息
     * @return
     */
    @ApiOperation(value = "查询所有的访学信息", httpMethod = "POST")
    @PostMapping("/findAllVisitSchoolInfo")
    public Result findAllVisitSchoolInfo(){
        List<VisitSchoolPO> vos = visitSchoolInfoService.findAllVisitSchoolInfo();
        if(vos!=null&&vos.size()>0){
            return ResultGenerator.genSuccessResult(vos);
        }
        return ResultGenerator.genSuccessResult(ResultCode.NONE_DATA);
    }
    /**
     * 根据id查询访学信息
     * @return
     */
    @ApiOperation(value = "根据id查询访学信息", httpMethod = "POST")
    @PostMapping("/findVisitSchoolInfoById")
    public Result findVisitSchoolInfoById(@RequestBody VisitSchoolIdVO visitSchoolIdVO){
        VisitSchoolPO vos = visitSchoolInfoService.findVisitSchoolInfoById(visitSchoolIdVO.getId());
        if(vos!=null){
            return ResultGenerator.genSuccessResult(vos);
        }
        return ResultGenerator.genSuccessResult(ResultCode.NONE_DATA);
    }
    /**
     * 根据教师姓名查询访学信息
     * @return
     */
    @ApiOperation(value = "根据教师姓名查询访学信息", httpMethod = "POST")
    @PostMapping("/findVisitSchoolInfoByTeacherName")
    public Result findVisitSchoolInfoByTeacherName(@RequestBody TeacherNameDTO teacherNameDTO){
        List<VisitSchoolPO> vos = visitSchoolInfoService.findVisitSchoolInfoByTeacherName(teacherNameDTO.getTeacherName());
        if(vos!=null&&vos.size()>0){
            return ResultGenerator.genSuccessResult(vos);
        }
        return ResultGenerator.genSuccessResult(ResultCode.NONE_DATA);
    }
    /**
     * 根据学校名查询访学信息
     * @return
     */
    @ApiOperation(value = "根据学校名查询访学信息", httpMethod = "POST")
    @PostMapping("/findVisitSchoolInfoBySchoolName")
    public Result findVisitSchoolInfoBySchoolName(@RequestBody SchoolNameDTO schoolNameDTO){
        List<VisitSchoolPO> vos = visitSchoolInfoService.findVisitSchoolInfoBySchoolName(schoolNameDTO.getSchoolName());
        if(vos!=null&&vos.size()>0){
            return ResultGenerator.genSuccessResult(vos);
        }
        return ResultGenerator.genSuccessResult(ResultCode.NONE_DATA);
    }
    /**
     * 根据id删除访学信息
     * @return
     */
    @ApiOperation(value = "根据id删除访学信息", httpMethod = "POST")
    @PostMapping("/deleteVisitSchoolInfoById")
    public Result deleteVisitSchoolInfoById(@RequestBody VisitSchoolIdVO visitSchoolIdVO){
        if(visitSchoolInfoService.deleteVisitSchoolInfoById(visitSchoolIdVO.getId())){
            return ResultGenerator.genSuccessResult();
        }
        return ResultGenerator.genSuccessResult("删除访学信息失败");
    }
    /**
     * 根据id查询学校
     * @return
     */
    @ApiOperation(value = "根据id查询学校", httpMethod = "POST")
    @PostMapping("/findSchoolInfoById")
    public Result findAllSchoolInfoById(@RequestBody SchoolIdVO schoolIdVO){
        SchoolPO po = visitSchoolInfoService.findAllSchoolInfoById(schoolIdVO.getSchoolId());
        if(po!=null){
            return ResultGenerator.genSuccessResult(po);
        }
        return ResultGenerator.genSuccessResult(ResultCode.NONE_DATA);
    }
    /**
     * 添加一条教师访学信息
     * @return
     */
    @ApiOperation(value = "添加一条教师访学信息", httpMethod = "POST")
    @PostMapping("/addVisitSchoolInfo")
    public Result addVisitSchoolInfo(@RequestBody VisitSchoolDTO visitSchoolDTO){
        if(teacherInfoService.findTeacherInfoById(visitSchoolDTO.getTeacherId())==null){
            return ResultGenerator.genFailResult("教师不存在");
        }
        if(visitSchoolDTO.getType()==null){
            ResultGenerator.genSuccessResult(ResultCode.HTTP_MESSAGE_NOT_READABLE);
        }else if(visitSchoolDTO.getType()==1){
            SchoolPO schoolPO = visitSchoolInfoService.findAllSchoolInfoById(visitSchoolDTO.getSchoolId());
            if(null==schoolPO){
               return ResultGenerator.genFailResult("学校不存在");
            }
        }else if(visitSchoolDTO.getType()==2){
            if(visitSchoolDTO.getSchoolName()==null||visitSchoolDTO.getSchoolName().trim().equals("")){
                return ResultGenerator.genFailResult("学校名字不能为空");
            }
            List<SchoolPO> schoolPOS = visitSchoolInfoService.findAllSchoolInfo();
            Integer len = schoolPOS.size();
            schoolPOS.forEach(x->{
                if(x.getSchoolName().equals(visitSchoolDTO.getSchoolName())){
                    schoolPOS.remove(x);
                }
            });
            if(!(len==schoolPOS.size())){
                SchoolPO po = new SchoolPO();
                po.setSchoolName(visitSchoolDTO.getSchoolName());
                if(!visitSchoolInfoService.addSchoolInfo(po)){
                    return ResultGenerator.genFailResult("添加学校信息失败");
                }
                if(po.getSchoolId()==null){
                    return ResultGenerator.genFailResult("获取学校id失败");
                }
                visitSchoolDTO.setSchoolId(po.getSchoolId());
            }else{
                return ResultGenerator.genFailResult("想要添加的学校已经存在");
            }
        }else {
            return ResultGenerator.genSuccessResult("Type传入数据错误");
        }
        if(!visitSchoolInfoService.addVisitSchoolInfo(visitSchoolDTO)){
            return ResultGenerator.genFailResult("添加一条教师访学信息失败");
        }
        return ResultGenerator.genSuccessResult();
    }
}
