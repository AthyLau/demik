package demik.springcloud.studentmanagementsystem9002.mapper;

import demik.springcloud.entity.domain.po.StudentCasePO;
import demik.springcloud.entity.domain.po.StudentInfoPO;
import demik.springcloud.entity.domain.vo.StudentInfoVO;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Function:
 *
 * @author liubing
 * Date: 2019/3/14 2:33 PM
 * @since JDK 1.8
 */
@Mapper
public interface StudentInfoMapper {
    /**
     * 添加一个学生
     * @param studentInfoVO
     * @return
     */
    @Insert("INSERT INTO student_info(student_name,student_number,student_sex,student_national,student_phone,student_id_card,student_address,student_mail,student_case_id,aclass_id) " +
            "values(#{studentName},#{studentNumber},#{studentSex},#{studentNational},#{studentPhone},#{studentIdCard},#{studentAddress},#{studentMail},#{studentCaseId},#{aclassId})")
    boolean addStudent(StudentInfoVO studentInfoVO);
    /**
     * 删除一个学生
     * @param studentId
     * @return
     */
    @Delete("DELETE FROM student_info where student_id = #{studentId}")
    boolean deleteStudent(Integer studentId);
    /**
     * 更新学生信息
     * @param studentInfoVO
     * @return
     */
    @Update("update student_info set student_name = #{studentName},student_number = #{studentNumber},student_sex = #{studentSex},student_national = #{studentNational},student_phone = #{studentPhone},student_id_card = #{studentIdCard},student_address = #{studentAddress},student_mail = #{studentMail},student_case_id = #{studentCaseId},aclass_id = #{aclassId}")
    boolean updateStudent(StudentInfoVO studentInfoVO);
    /**
     * 查询所有学生的原始信息
     * @return
     */
    @Select("SELECT i.student_name,i.student_number,i.student_sex,i.student_national,i.student_phone,i.student_id_card,i.student_address,i.student_mail,c.student_case_description,i.aclass_id from student_info as i left join student_case as c on i.student_case_id = c.student_case_id")
    List<StudentInfoPO> findAllStudent();
    /**
     * 查询单个学生的原始信息
     * @return
     */
    @Select("SELECT i.student_id,i.student_name,i.student_number,i.student_sex,i.student_national,i.student_phone,i.student_id_card,i.student_address,i.student_mail,c.student_case_description,i.aclass_id from student_info as i left join student_case as c on i.student_case_id = c.student_case_id where i.student_id = #{studentId}")
    StudentInfoPO findStudentById(Integer studentId);

    /**
     * 根据学生近况id查询近况
     * @param studentCaseId
     * @return
     */
    @Select("SELECT student_case_id,student_case_description from student_case where student_case_id = #{studentCaseId}")
    StudentCasePO findStudentCaseById(Integer studentCaseId);

    /**
     * 查询所有的近况
     * @return
     */
    @Select("SELECT student_case_id,student_case_description from student_case")
    List<StudentCasePO> findAllStudentCase();

}
