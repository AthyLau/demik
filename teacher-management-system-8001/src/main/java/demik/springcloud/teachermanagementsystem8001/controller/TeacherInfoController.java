package demik.springcloud.teachermanagementsystem8001.controller;

import com.google.common.collect.Lists;
import demik.springcloud.entity.commonbox.Result;
import demik.springcloud.entity.commonbox.ResultCode;
import demik.springcloud.entity.commonbox.ResultGenerator;
import demik.springcloud.entity.domain.dto.*;
import demik.springcloud.entity.domain.po.BookPO;
import demik.springcloud.entity.domain.po.TeacherInfoPO;
import demik.springcloud.entity.domain.vo.DeptVO;
import demik.springcloud.entity.domain.vo.EducationBackgroudVO;
import demik.springcloud.entity.domain.vo.OfficeIdVO;
import demik.springcloud.entity.domain.vo.TeacherIdVO;
import demik.springcloud.entity.feignservice.FeignService;
import demik.springcloud.entity.utils.excelutils.ExcelUtils;
import demik.springcloud.teachermanagementsystem8001.service.OfficeInfoService;
import demik.springcloud.teachermanagementsystem8001.service.OtherInfoService;
import demik.springcloud.teachermanagementsystem8001.service.TeacherInfoService;
import demik.springcloud.teachermanagementsystem8001.service.VisitSchoolInfoService;
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
    @Autowired
    private VisitSchoolInfoService visitSchoolInfoService;
    @Autowired
    private FeignService feignService;
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

        if(otherInfoService.findBookById(teacherInfoDTO.getBookId())==null){
            return ResultGenerator.genFailResult("教材不存在");
        }
        if(otherInfoService.findDeptById(teacherInfoDTO.getDeptId())==null){
            return ResultGenerator.genFailResult("职位不存在");
        }
        if(otherInfoService.findEducationBackgroudById(teacherInfoDTO.getEducationBackgroudId())==null){
            return ResultGenerator.genFailResult("教育背景不存在");
        }
        if(null==officeInfoService.findOfficeInfoById(teacherInfoDTO.getOfficeId())){
            return ResultGenerator.genFailResult("教研室不存在");
        }
        if(null==visitSchoolInfoService.findAllSchoolInfoById(teacherInfoDTO.getSchoolId())){
            return ResultGenerator.genFailResult("学校不存在");
        }
        if(teacherInfoService.findTeacherInfoByTeacherIdCard(teacherInfoDTO.getTeacherIdCard())!=null){
            return ResultGenerator.genFailResult("教师已经存在");
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
    /**
     * 根据教师id查找教师
     * @param teacherIdVO
     * @return
     */
    @ApiOperation(value = "根据教师id查找教师", httpMethod = "POST")
    @PostMapping("/findTeacherInfoById")
    public Result findTeacherInfoById(@RequestBody TeacherIdVO teacherIdVO){
        TeacherInfoPO teacherInfoPO = teacherInfoService.findTeacherInfoById(teacherIdVO.getTeacherId());
        if(null!=teacherInfoPO){
            return ResultGenerator.genSuccessResult(teacherInfoPO);
        }
        return ResultGenerator.genSuccessResult(ResultCode.NONE_DATA);
    }
    /**
     * 根据教师的名字查询教师
     * @return
     */
    @ApiOperation(value = "根据教师的名字查询教师", httpMethod = "POST")
    @PostMapping("/findTeacherInfoByTeacherName")
    public Result<List<TeacherInfoPO>> findTeacherInfoByTeacherName(@RequestBody TeacherNameDTO teacherNameDTO){
        List<TeacherInfoPO> pos = teacherInfoService.findTeacherInfoByTeacherName(teacherNameDTO.getTeacherName());
        if(pos!=null||pos.size()>0){
            return ResultGenerator.genSuccessResult(pos);
        }
        return ResultGenerator.genSuccessResult(ResultCode.NONE_DATA);
    }
    /**
     * 根据教师的身份证查询教师
     * @return
     */
    @ApiOperation(value = "根据教师的身份证查询教师", httpMethod = "POST")
    @PostMapping("/findTeacherInfoByTeacherIdCard")
    public Result<TeacherInfoPO> findTeacherInfoByTeacherIdCard(@RequestBody TeacherIdCardDTO teacherIdCardDTO){
        TeacherInfoPO pos = teacherInfoService.findTeacherInfoByTeacherIdCard(teacherIdCardDTO.getIdCard());
        if(pos!=null){
            return ResultGenerator.genSuccessResult(pos);
        }
        return ResultGenerator.genSuccessResult(ResultCode.NONE_DATA);
    }
    /**
     * 根据教研室id查找教师
     * @param officeIdVO
     * @return
     */
    @ApiOperation(value = "根据教研室id查找教师", httpMethod = "POST")
    @PostMapping("/findTeacherInfoByOfficeId")
    public Result findTeacherInfoByOfficeId(@RequestBody OfficeIdVO officeIdVO){
        List<TeacherInfoPO> teacherInfoPO = teacherInfoService.findTeacherInfoByOfficeId(officeIdVO.getOfficeId());
        if(null!=teacherInfoPO){
            return ResultGenerator.genSuccessResult(teacherInfoPO);
        }
        return ResultGenerator.genSuccessResult(ResultCode.NONE_DATA);
    }
    /**
     * 上传文件
     * @param file
     * @param request
     * @return
     */
    @ApiOperation(value = "上传教师excel表格并添加教师以及用户", httpMethod = "POST", response = ResponseEntity.class)
    @PostMapping("/uploadTeacherDataExcel")
    public Result uploadExcel(@RequestParam(value = "teacherDataExcel") MultipartFile file, HttpServletRequest request){
        List<TeacherExcelDTO> teacherExcelDTOS;
        try {
            InputStream in = file.getInputStream();
            Workbook wb = ExcelUtils.chooseWorkbook(file.getName(), in);
            TeacherExcelDTO teacherExcelDTO = new TeacherExcelDTO();
            //教师excel转为对象
            teacherExcelDTOS = ExcelUtils.readDateListT(wb, teacherExcelDTO, 11, 0);
            System.out.println(teacherExcelDTOS);
        }catch (Exception e){
            return ResultGenerator.genFailResult("上传文件失败");
        }
        //添加教师到数据库
        Map<Integer,String> map = teacherInfoService.addBatchTeacherInfo(teacherExcelDTOS);
        if(map.size()>0){
            return ResultGenerator.genSuccessResult(map);
        }
        //添加用户到数据库feign
        Result result = feignService.addTeacherUser(teacherExcelDTOS);
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
    @RequestMapping(value = "/downloadTeacherExcel",method = RequestMethod.GET)
    public void downloadAttachment(HttpServletResponse response, HttpServletRequest request) throws Exception {
        OutputStream os = null;
        InputStream is = null;
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        String fileName = "教师信息导入模版.xlsx";
        String filePath = "/Users/liubing/Desktop/code/IdeaProjects/lcxy_demo/demik-file/teacher/template/" + fileName;
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
