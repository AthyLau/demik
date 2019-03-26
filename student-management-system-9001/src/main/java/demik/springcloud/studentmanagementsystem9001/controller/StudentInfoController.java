package demik.springcloud.studentmanagementsystem9001.controller;

import demik.springcloud.entity.commonbox.Result;
import demik.springcloud.entity.commonbox.ResultCode;
import demik.springcloud.entity.commonbox.ResultGenerator;
import demik.springcloud.entity.domain.dto.StudentInfoDTO;
import demik.springcloud.entity.domain.po.StudentCasePO;
import demik.springcloud.entity.domain.vo.StudentIdVO;
import demik.springcloud.entity.domain.vo.StudentInfoVO;
import demik.springcloud.studentmanagementsystem9001.service.AClassInfoService;
import demik.springcloud.studentmanagementsystem9001.service.StudentInfoService;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Function:
 *
 * @author liubing
 * Date: 2019/3/14 2:32 PM
 * @since JDK 1.8
 */
@RestController
@RequestMapping("student-info")
@ApiModel(description = "学生管理模块")
public class StudentInfoController {

    @Autowired
    private StudentInfoService studentInfoService;
    @Autowired
    private AClassInfoService aClassInfoService;
    /**
     * 添加一个学生       16
     * @param studentInfoVO
     * @return
     */
    @ApiOperation(value = "添加一个学生16", httpMethod = "POST")
    @PostMapping("/addStudent")
    public Result addStudent(@RequestBody StudentInfoVO studentInfoVO){
        //todo 每添加一个学生都要把这个学生添加到user表里 学号作为账号身份证后六位作为密码
        if(studentInfoService.findStudentCaseById(studentInfoVO.getStudentCaseId())==null){
            return ResultGenerator.genFailResult("学生的近况不存在");
        }
        if(aClassInfoService.findAClassById(studentInfoVO.getAclassId())==null){
            return ResultGenerator.genFailResult("班级信息不存在");
        }
        if(studentInfoService.addStudent(studentInfoVO)){
            return ResultGenerator.genSuccessResult();
        }
        return ResultGenerator.genFailResult("添加学生失败");
    }

    /**
     * 删除一个学生       17
     * @param studentIdVO
     * @return
     */
    @ApiOperation(value = "删除一个学生17", httpMethod = "POST")
    @PostMapping("/deleteStudent")
    public Result deleteStudent(@RequestBody StudentIdVO studentIdVO){
        if(studentInfoService.deleteStudent(studentIdVO.getStudentId())){
            return ResultGenerator.genSuccessResult();
        }
        return ResultGenerator.genFailResult("删除学生失败");
    }

    /**
     * 更新一个学生信息     18
     * @return
     */
    @ApiOperation(value = "更新一个学生18", httpMethod = "POST")
    @PostMapping("/updateStudent")
    public Result updateStudent(@RequestBody StudentInfoVO studentInfoVO){
        if(studentInfoService.findStudentCaseById(studentInfoVO.getStudentCaseId())==null){
            return ResultGenerator.genFailResult("学生的近况不存在");
        }
        if(aClassInfoService.findAClassById(studentInfoVO.getAclassId())==null){
            return ResultGenerator.genFailResult("班级信息不存在");
        }
        if(studentInfoService.updateStudent(studentInfoVO)){
            return ResultGenerator.genSuccessResult();
        }
        return ResultGenerator.genFailResult("更新学生失败");
    }

    /**
     * 查询所有学生的信息        19
     * @return
     */
    @ApiOperation(value = "查询所有学生的信息19", httpMethod = "GET")
    @GetMapping("/findAllStudent")
    public Result<List<StudentInfoDTO>> findAllStudent(){
        List<StudentInfoDTO> dtos = studentInfoService.findAllStudent();
        if(dtos!=null&&dtos.size()>0){
            return ResultGenerator.genSuccessResult(dtos);
        }
        return ResultGenerator.genSuccessResult(ResultCode.NONE_DATA);
    }

    /**
     * 根据学生id查询学生信息     20
     * @param studentIdVO
     * @return
     */
    @ApiOperation(value = "根据学生id查询学生信息20", httpMethod = "POST")
    @PostMapping("/findStudentById")
    public Result<StudentInfoDTO> findStudentById(@RequestBody StudentIdVO studentIdVO){
        StudentInfoDTO studentInfoDTO = studentInfoService.findStudentById(studentIdVO.getStudentId());
        if(studentInfoDTO != null){
            return ResultGenerator.genSuccessResult(studentInfoDTO);
        }
        return ResultGenerator.genSuccessResult(ResultCode.NONE_DATA);
    }

    /**
     * 查询学生近况       21
     * @return
     */
    @ApiOperation(value = "查询学生近况21", httpMethod = "POST")
    @PostMapping("/findAllStudentCase")
    public Result<List<StudentCasePO>> findAllStudentCase(){
        List<StudentCasePO> studentCasePOS = studentInfoService.findAllStudentCase();
        if(studentCasePOS!=null&&studentCasePOS.size()>0){
            return ResultGenerator.genSuccessResult(studentCasePOS);
        }
        return ResultGenerator.genSuccessResult(ResultCode.NONE_DATA);
    }
}
