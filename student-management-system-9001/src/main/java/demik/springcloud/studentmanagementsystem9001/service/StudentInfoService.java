package demik.springcloud.studentmanagementsystem9001.service;

import com.google.common.collect.Lists;
import demik.springcloud.entity.domain.dto.AClassInfoDTO;
import demik.springcloud.entity.domain.dto.StudentInfoDTO;
import demik.springcloud.entity.domain.po.StudentCasePO;
import demik.springcloud.entity.domain.po.StudentInfoPO;
import demik.springcloud.entity.domain.vo.StudentInfoVO;
import demik.springcloud.studentmanagementsystem9001.manager.StudentInfoManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
}
