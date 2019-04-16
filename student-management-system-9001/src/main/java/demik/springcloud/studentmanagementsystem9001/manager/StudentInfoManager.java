package demik.springcloud.studentmanagementsystem9001.manager;

import demik.springcloud.entity.domain.dto.StudentExcelDTO;
import demik.springcloud.entity.domain.dto.StudentInfoDTO;
import demik.springcloud.entity.domain.po.StudentCasePO;
import demik.springcloud.entity.domain.po.StudentInfoPO;
import demik.springcloud.entity.domain.vo.StudentInfoVO;
import demik.springcloud.studentmanagementsystem9001.mapper.StudentInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
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
@Repository
public class StudentInfoManager {

    @Autowired
    private StudentInfoMapper studentInfoMapper;
    /**
     * 添加一个学生
     * @param studentInfoVO
     * @return
     */
    public boolean addStudent(StudentInfoVO studentInfoVO) {
        return studentInfoMapper.addStudent(studentInfoVO);
    }
    /**
     * 删除一个学生
     * @param studentId
     * @return
     */
    public boolean deleteStudent(Integer studentId) {
        return studentInfoMapper.deleteStudent(studentId);
    }
    /**
     * 更新学生信息
     * @param studentInfoVO
     * @return
     */
    public boolean updateStudent(StudentInfoVO studentInfoVO) {
        return studentInfoMapper.updateStudent(studentInfoVO);
    }
    /**
     * 查询所有学生的原始信息
     * @return
     */
    public List<StudentInfoPO> findAllStudent() {
        return studentInfoMapper.findAllStudent();
    }
    /**
     * 查询单个学生的原始信息
     * @return
     */
    public StudentInfoPO findStudentById(Integer studentId) {
        return studentInfoMapper.findStudentById(studentId);
    }

    /**
     * 根据学生近况id查询近况
     * @param studentCaseId
     * @return
     */
    public StudentCasePO findStudentCaseById(Integer studentCaseId) {
        return studentInfoMapper.findStudentCaseById(studentCaseId);
    }

    /**
     * 查询所有的近况
     * @return
     */
    public List<StudentCasePO> findAllStudentCase() {
        return studentInfoMapper.findAllStudentCase();
    }

    /**
     * 删除班级下的所有学生
     * @param id
     * @return
     */
    public boolean deleteStudentByAClassId(Integer id) {
        return studentInfoMapper.deleteStudentByAClassId(id);
    }

    /**
     * 根据学生的身份证号查询学生
     * @param idCardNum
     * @return
     */
    public StudentInfoPO findStudentByIdCardNumber(String idCardNum) {
        return studentInfoMapper.findStudentByIdCardNumber(idCardNum);
    }

    /**
     * 根据学生的名字查询多个学生
     * @param studentName
     * @return
     */
    public List<StudentInfoPO> findStudentByStudentName(String studentName) {
        return studentInfoMapper.findStudentByStudentName(studentName);
    }

    /**
     * 根据班级的id查询学生
     * @param aclassId
     * @return
     */
    public List<StudentInfoPO> findStudentByClassId(Integer aclassId) {
        return studentInfoMapper.findStudentByClassId(aclassId);
    }


}
