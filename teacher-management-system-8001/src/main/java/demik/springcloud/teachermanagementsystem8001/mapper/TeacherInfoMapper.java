package demik.springcloud.teachermanagementsystem8001.mapper;

import demik.springcloud.entity.domain.dto.TeacherInfoDTO;
import demik.springcloud.entity.domain.po.TeacherInfoPO;
import demik.springcloud.entity.domain.vo.TeacherIdVO;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Function:
 *
 * @author liubing
 * Date: 2019/3/24 2:02 AM
 * @since JDK 1.8
 */
@Mapper
public interface TeacherInfoMapper {
    /**
     * 查询所有的教师信息
     * @return
     */
    @Select("SELECT t.teacher_id,t.teacher_name,t.teacher_entrance_time,t.teacher_id_card," +
            " t.teacher_number,t.teacher_phone,t.office_id,o.office_name,t.education_backgroud_id," +
            " e.education_backgroud_name,t.school_id,s.school_name,t.dept_id,d.dept_name," +
            " t.book_id,b.book_name from teacher_info as t,book_info as b," +
            " dept_info as d,school_info as s,education_backgroud as e,office_info as o " +
            " where t.office_id = o.office_id and t.education_backgroud_id = e.education_backgroud_id and " +
            " t.school_id = s.school_id and t.dept_id = d.dept_id and t.book_id = b.book_id;")
    List<TeacherInfoPO> findAllTeacherInfo();

    /**
     *
     * @param teacherInfoDTO
     * @return
     */
    @Insert("insert into teacher_info(teacher_name, teacher_id_card, teacher_number, teacher_phone, teacher_entrance_time, office_id, education_backgroud_id, school_id, dept_id, book_id) " +
            "values(#{teacherName},#{teacherIdCard},#{teacherNumber},#{teacherPhone},#{teacherEntranceTime},#{officeId},#{educationBackgroudId},#{schoolId},#{deptId},#{bookId}) ")
    boolean addTeacherInfo(TeacherInfoDTO teacherInfoDTO);

    /**
     * 删除教师信息
     * @param teacherId
     * @return
     */
    @Delete("delete from teacher_info where teacher_id = #{teacherId}")
    boolean deleteTeacherInfo(Integer teacherId);

    /**
     * 根绝id查询教师信息
     * @param teacherId
     * @return
     */
    @Select("select teacher_id from teacher_info where teacher_id = #{teacherId}")
    TeacherIdVO findTeacherInfoById(Integer teacherId);
}
