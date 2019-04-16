package demik.springcloud.studentmanagementsystem9001.controller;

import com.google.common.collect.Lists;
import demik.springcloud.entity.commonbox.Result;
import demik.springcloud.entity.commonbox.ResultCode;
import demik.springcloud.entity.commonbox.ResultGenerator;
import demik.springcloud.entity.domain.dto.*;
import demik.springcloud.entity.domain.po.StudentCasePO;
import demik.springcloud.entity.domain.po.UserPO;
import demik.springcloud.entity.domain.vo.AClassIdVO;
import demik.springcloud.entity.domain.vo.StudentIdVO;
import demik.springcloud.entity.domain.vo.StudentInfoVO;
import demik.springcloud.entity.feignservice.FeignService;
import demik.springcloud.entity.utils.excelutils.ExcelUtils;
import demik.springcloud.studentmanagementsystem9001.service.AClassInfoService;
import demik.springcloud.studentmanagementsystem9001.service.StudentInfoService;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.List;
import java.util.Map;

/**
 * Function:
 *
 * @author liubing
 * Date: 2019/3/14 2:32 PM
 * @since JDK 1.8
 */
@RestController
@RequestMapping("/student-info")
@ApiModel(description = "学生管理模块")
public class StudentInfoController {

    @Autowired
    private StudentInfoService studentInfoService;
    @Autowired
    private AClassInfoService aClassInfoService;
    @Autowired
    private FeignService feignService;
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
        StudentInfoDTO studentInfoDTO = studentInfoService.findStudentById(studentInfoVO.getStudentId());
        if(studentInfoDTO.getStudentInfoPO().getStudentIdCard()!=studentInfoVO.getStudentIdCard()){
            return ResultGenerator.genFailResult("不允许修改身份证号码");
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
    /**
     * 根据学生的身份证号查询学生
     * @param studentIdCardNumberDTO
     * @return
     */
    @ApiOperation(value = "根据学生的身份证号查询学生", httpMethod = "POST")
    @PostMapping("/findStudentByIdCardNumber")
    public Result<StudentInfoDTO> findStudentByIdCardNumber(@RequestBody StudentIdCardNumberDTO studentIdCardNumberDTO){
        StudentInfoDTO studentInfoDTO = studentInfoService.findStudentByIdCardNumber(studentIdCardNumberDTO.getIdCardNum());
        if(studentInfoDTO != null){
            return ResultGenerator.genSuccessResult(studentInfoDTO);
        }
        return ResultGenerator.genSuccessResult(ResultCode.NONE_DATA);
    }
    /**
     * 根据学生的名字查询多个学生
     * @param studentNameDTO
     * @return
     */
    @ApiOperation(value = "根据学生的名字查询多个学生", httpMethod = "POST")
    @PostMapping("/findStudentByStudentName")
    public Result<List<StudentInfoDTO>> findStudentByStudentName(@RequestBody StudentNameDTO studentNameDTO){
        List<StudentInfoDTO> dtos = studentInfoService.findStudentByStudentName(studentNameDTO.getStudentName());
        if(dtos != null&&dtos.size()>0){
            return ResultGenerator.genSuccessResult(dtos);
        }
        return ResultGenerator.genSuccessResult(ResultCode.NONE_DATA);
    }
    /**
     * 根据班级的id查询学生
     * @return
     */
    @ApiOperation(value = "根据班级的id查询学生", httpMethod = "POST")
    @PostMapping("/findStudentByClassId")
    public Result<List<StudentInfoDTO>> findStudentByClassId(@RequestBody AClassIdVO aClassIdVO){
        List<StudentInfoDTO> dtos = studentInfoService.findStudentByClassId(aClassIdVO.getAclassId());
        if(dtos != null&&dtos.size()>0){
            return ResultGenerator.genSuccessResult(dtos);
        }
        return ResultGenerator.genSuccessResult(ResultCode.NONE_DATA);
    }
    /**
     * 上传文件
     * @param file
     * @param request
     * @return
     */
    @ApiOperation(value = "上传学生excel表格并添加学生以及用户", httpMethod = "POST", response = ResponseEntity.class)
    @PostMapping("/uploadstudentDataExcel")
    public Result uploadExcel(@RequestParam(value = "studentDataExcel") MultipartFile file, HttpServletRequest request){
        List<StudentExcelDTO> studentInfos;
        try {
            InputStream in = file.getInputStream();
            Workbook wb = ExcelUtils.chooseWorkbook(file.getName(), in);
            StudentExcelDTO studentInfo = new StudentExcelDTO();
            //学生excel转为对象
            studentInfos = ExcelUtils.readDateListT(wb, studentInfo, 11, 0);
            System.out.println(studentInfos);
        }catch (Exception e){
            return ResultGenerator.genFailResult("上传文件失败");
        }
        //添加学生到数据库
        Map<Integer,String>  map = studentInfoService.addBatchStudent(studentInfos);
        if(map.size()>0){
            return ResultGenerator.genSuccessResult(map);
        }
        //添加用户到数据库feign
        Result result = feignService.addStudentUser(studentInfos);
        if(result.getData()==null||result.getData().equals("")){
            return ResultGenerator.genSuccessResult();
        }
        return result;
    }
    /**
     * 这是下载模板的方法
     * @param response
     * @param request
     * @throws Exception
     */
    @ApiOperation(value = "下载学生excel数据模版", httpMethod = "GET")
    @RequestMapping(value = "/downloadStudentExcel",method = RequestMethod.GET)
    public void downloadAttachment(HttpServletResponse response, HttpServletRequest request) throws Exception {
        OutputStream os = null;
        InputStream is = null;
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        String fileName = "大学生信息导入模版.xlsx";
        String filePath = "/Users/liubing/Desktop/code/IdeaProjects/lcxy_demo/demik-file/student/template/" + fileName;
        try {
            response.reset();
            response.setContentType("application/x-download");
            response.setHeader("Access-Control-Allow-Origin", "*");
            response.setCharacterEncoding("UTF-8");
            response.addHeader("Content-Disposition", "attachment;filename=" + fileName);
            is = new FileInputStream(filePath);
            os = response.getOutputStream();
            bis = new BufferedInputStream(is);
            bos = new BufferedOutputStream(os);
            byte[] buffer = new byte[1024];
            int i = 0;
            while ((i = is.read(buffer)) != -1) {
                os.write(buffer, 0, i);
            }
            bos.flush();
        } catch (NullPointerException e) {
            e.printStackTrace();
            System.out.println("文件不存在");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("文件下载错误");
        } finally {
            if (bos != null) {
                bos.close();
                bos = null;
            }
            if (os != null) {
                os.close();
                os = null;
            }
            if (bis != null) {
                bis.close();
                bis = null;
            }
            if (is != null) {
                is.close();
                is = null;
            }
        }
    }
}
