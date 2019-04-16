package demik.springcloud.studentmanagementsystem9001.service;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import demik.springcloud.entity.domain.dto.AClassInfoDTO;
import demik.springcloud.entity.domain.dto.StudentExcelDTO;
import demik.springcloud.entity.domain.dto.StudentInfoDTO;
import demik.springcloud.entity.domain.dto.UserDTO;
import demik.springcloud.entity.domain.po.StudentCasePO;
import demik.springcloud.entity.domain.po.StudentInfoPO;
import demik.springcloud.entity.domain.po.UserPO;
import demik.springcloud.entity.domain.vo.AClassInfoVO;
import demik.springcloud.entity.domain.vo.StudentInfoVO;
import demik.springcloud.studentmanagementsystem9001.manager.StudentInfoManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * Function:
 *
 * @author liubing
 * Date: 2019/3/14 2:33 PM
 * @since JDK 1.8
 */
@Service
public class StudentInfoService {
    @Autowired
    private StudentInfoManager studentInfoManager;
    @Autowired
    private AClassInfoService aClassInfoService;
    /**
     * 添加一个学生
     * @param studentInfoVO
     * @return
     */
    public boolean addStudent(StudentInfoVO studentInfoVO) {
        return studentInfoManager.addStudent(studentInfoVO);
    }
    /**
     * 批量添加学生
     * @param dtos
     * @return
     */
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, timeout = 3600)
    public Map<Integer,String> addBatchStudent(List<StudentExcelDTO> dtos) {
        Map<Integer,String> results = Maps.newHashMap();
        dtos.forEach(x->{
            int xh = x.getId()+10;
            AClassInfoDTO aClassInfoDTO = aClassInfoService.findAClassByClassName(x.getAclassId());
            StudentCasePO studentCasePO = studentInfoManager.findStudentCaseById(x.getStudentCaseId());
            if(studentCasePO==null){
                results.put(xh,xh+"行学生近况不存在");
            }
            if(aClassInfoDTO==null){
                results.put(xh,xh+"行班级不存在");
            }
            if(aClassInfoDTO!=null&&studentCasePO!=null){
                StudentInfoVO studentInfoVO = new StudentInfoVO();
                studentInfoVO.setAclassId(aClassInfoDTO.getaClassInfoVO().getAclassId());
                studentInfoVO.setStudentAddress(x.getStudentAddress());
                studentInfoVO.setStudentCaseId(studentCasePO.getStudentCaseId());
                studentInfoVO.setStudentIdCard(x.getStudentIdCard());
                studentInfoVO.setStudentMail(x.getStudentMail());
                studentInfoVO.setStudentName(x.getStudentName());
                studentInfoVO.setStudentNational(x.getStudentNational());
                studentInfoVO.setStudentNumber(x.getStudentNumber());
                studentInfoVO.setStudentPhone(x.getStudentPhone());
                studentInfoVO.setStudentSex(x.getStudentSex());
                try{
                    if(!studentInfoManager.addStudent(studentInfoVO)){
                        throw new RuntimeException();
                    }
                }catch (Exception e){
                    results.put(x.getId()+10,xh+"行学生数据有错误");
                }
            }
        });
        return results;
    }
    /**
     * 删除一个学生
     * @param studentId
     * @return
     */
    public boolean deleteStudent(Integer studentId) {
        return studentInfoManager.deleteStudent(studentId);
    }

    /**
     * 更新学生信息
     * @param studentInfoVO
     * @return
     */
    public boolean updateStudent(StudentInfoVO studentInfoVO) {
        return studentInfoManager.updateStudent(studentInfoVO);
    }

    /**
     * 查询所有学生的信息
     * @return
     */
    public List<StudentInfoDTO> findAllStudent() {
        List<StudentInfoPO> pos = studentInfoManager.findAllStudent();
        List<StudentInfoDTO> dtos = Lists.newArrayList();
        pos.forEach(x->{
            StudentInfoDTO dto = new StudentInfoDTO();
            AClassInfoDTO aClassInfoDTO = aClassInfoService.findAClassById(x.getAclassId());
            dto.setaClassInfoDTO(aClassInfoDTO);
            dto.setStudentInfoPO(x);
            dtos.add(dto);
        });
        return dtos;
    }
    /**
     * 根据学生id查询学生信息
     * @param studentId
     * @return
     */
    public StudentInfoDTO findStudentById(Integer studentId) {
        StudentInfoPO studentInfoPO = studentInfoManager.findStudentById(studentId);
        if(studentInfoPO==null){
            return null;
        }
        StudentInfoDTO dto = new StudentInfoDTO();
        AClassInfoDTO aClassInfoDTO = aClassInfoService.findAClassById(studentInfoPO.getAclassId());
        dto.setaClassInfoDTO(aClassInfoDTO);
        dto.setStudentInfoPO(studentInfoPO);
        return dto;
    }

    /**
     * 根绝近况id查询近况
     * @param studentCaseId
     * @return
     */
    public StudentCasePO findStudentCaseById(Integer studentCaseId){
        return studentInfoManager.findStudentCaseById(studentCaseId);
    }
    /**
     * 查询所有的近况
     * @return
     */
    public List<StudentCasePO> findAllStudentCase(){
        return studentInfoManager.findAllStudentCase();
    }

    /**
     * 根据学生的身份证号查询学生
     * @param idCardNum
     * @return
     */
    public StudentInfoDTO findStudentByIdCardNumber(String idCardNum) {
        StudentInfoPO studentInfoPO = studentInfoManager.findStudentByIdCardNumber(idCardNum);
        if(studentInfoPO==null){
            return null;
        }
        StudentInfoDTO dto = new StudentInfoDTO();
        AClassInfoDTO aClassInfoDTO = aClassInfoService.findAClassById(studentInfoPO.getAclassId());
        dto.setaClassInfoDTO(aClassInfoDTO);
        dto.setStudentInfoPO(studentInfoPO);
        return dto;
    }

    /**
     * 根据学生的名字查询多个学生
     * @param studentName
     * @return
     */
    public List<StudentInfoDTO> findStudentByStudentName(String studentName) {
        List<StudentInfoPO> pos = studentInfoManager.findStudentByStudentName(studentName);
        List<StudentInfoDTO> dtos = Lists.newArrayList();
        pos.forEach(x->{
            StudentInfoDTO dto = new StudentInfoDTO();
            AClassInfoDTO aClassInfoDTO = aClassInfoService.findAClassById(x.getAclassId());
            dto.setaClassInfoDTO(aClassInfoDTO);
            dto.setStudentInfoPO(x);
            dtos.add(dto);
        });
        return dtos;
    }

    /**
     * 根据班级的id查询学生
     * @param aclassId
     * @return
     */
    public List<StudentInfoDTO> findStudentByClassId(Integer aclassId) {
        List<StudentInfoPO> pos = studentInfoManager.findStudentByClassId(aclassId);
        List<StudentInfoDTO> dtos = Lists.newArrayList();
        pos.forEach(x->{
            StudentInfoDTO dto = new StudentInfoDTO();
            AClassInfoDTO aClassInfoDTO = aClassInfoService.findAClassById(x.getAclassId());
            dto.setaClassInfoDTO(aClassInfoDTO);
            dto.setStudentInfoPO(x);
            dtos.add(dto);
        });
        return dtos;
    }

}
