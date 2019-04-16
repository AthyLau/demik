package demik.springcloud.teachermanagementsystem8001.mapper;

import demik.springcloud.entity.domain.dto.VisitSchoolDTO;
import demik.springcloud.entity.domain.po.SchoolPO;
import demik.springcloud.entity.domain.po.VisitSchoolPO;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Function:
 *
 * @author liubing
 * Date: 2019/3/20 3:45 PM
 * @since JDK 1.8
 */
@Mapper
public interface VisitSchoolInfoMapper {
    /**
     * 查询所有的学校信息
     * @return
     */
    @Select("SELECT school_id,school_name from school_info")
    List<SchoolPO> findAllSchoolInfo();

    /**
     * 查询所有的访学信息
     * @return
     */
    @Select("select s.school_id,vs.id,vs.visit_time,t.teacher_id,t.teacher_name,s.school_name from visit_school as vs,school_info as s, " +
            "teacher_info as t where t.teacher_id = vs.teacher_id and vs.school_id = s.school_id;")
    List<VisitSchoolPO> findAllVisitSchoolInfo();

    /**
     * 根据id查询学校
     * @param schoolId
     * @return
     */
    @Select("SELECT school_id,school_name from school_info where school_id = #{schoolId}")
    SchoolPO findAllSchoolInfoById(Integer schoolId);

    /**
     * 添加一个访学信息
     * @param visitSchoolDTO
     * @return
     */
    @Insert("insert into visit_school(teacher_id,school_id,visit_time) values(#{teacherId},#{schoolId},#{visitTime})")
    boolean addVisitSchoolInfo(VisitSchoolDTO visitSchoolDTO);

    /**
     * 添加学校信息
     * @param po
     * @return
     */
    @Options(useGeneratedKeys=true, keyProperty="schoolId", keyColumn="school_id")
    @Insert("insert into school_info(school_name) values(#{schoolName})")
    boolean addSchoolInfo(SchoolPO po);

    /**
     * 根据id查询访学信息
     * @param id
     * @return
     */
    @Select("select s.school_id,vs.id,vs.visit_time,t.teacher_id,t.teacher_name,s.school_name from visit_school as vs,school_info as s, " +
            "teacher_info as t where t.teacher_id = vs.teacher_id and vs.school_id = s.school_id and vs.id = #{id};")
    VisitSchoolPO findVisitSchoolInfoById(Integer id);

    /**
     * 根据id删除访学信息
     * @param id
     * @return
     */
    @Delete("delete from visit_school where id = #{id}")
    boolean deleteVisitSchoolInfoById(Integer id);

    /**
     * 根据教师姓名查询访学信息
     * @param teacherName
     * @return
     */
    @Select("select s.school_id,vs.id,vs.visit_time,t.teacher_id,t.teacher_name,s.school_name from visit_school as vs,school_info as s, " +
            "teacher_info as t where t.teacher_id = vs.teacher_id and vs.school_id = s.school_id and t.teacher_name = #{teacherName};")
    List<VisitSchoolPO> findVisitSchoolInfoByTeacherName(String teacherName);
    @Select("select s.school_id,vs.id,vs.visit_time,t.teacher_id,t.teacher_name,s.school_name from visit_school as vs,school_info as s, " +
            "teacher_info as t where t.teacher_id = vs.teacher_id and vs.school_id = s.school_id and s.school_name = #{schoolName};")
    List<VisitSchoolPO> findVisitSchoolInfoBySchoolName(String schoolName);

    /**
     *
     * @param name
     * @return
     */
    @Select("SELECT school_id,school_name from school_info where school_name = #{name} ")
    SchoolPO findSchoolInfoByName(String name);
}
