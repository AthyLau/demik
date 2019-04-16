package demik.springcloud.teachermanagementsystem8001.mapper;

import demik.springcloud.entity.domain.dto.TeacherWorkDTO;
import demik.springcloud.entity.domain.po.WorkInfoPO;
import demik.springcloud.entity.domain.po.WorkPO;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Function:
 *
 * @author liubing
 * Date: 2019/3/20 3:44 PM
 * @since JDK 1.8
 */

@Mapper
public interface WorkInfoMapper {


    /**
     * 查询所有的教师作品信息
     * @return
     */
    @Select("SELECT tw.id,w.work_name,t.teacher_name from teacher_work as tw,work_info as w,teacher_info as t where tw.work_id = w.work_id and tw.teacher_id = t.teacher_id;")
    List<WorkInfoPO> findAllWorkInfo();

    /**
     * 查询所有的作品
     * @return
     */
    @Select("select work_id,work_name from work_info")
    List<WorkPO> findAllWork();

    /**
     * 添加一个作品
     * @param teacherWorkDTO
     * @return
     */
    @Insert("insert into teacher_work(work_id,teacher_id) values (#{workId},#{teacherId})")
    boolean addTeacherWork(TeacherWorkDTO teacherWorkDTO);

    /**
     * 根据id查找作品
     * @param workId
     * @return
     */
    @Select("select work_id,work_name from work_info where work_id = #{workId}")
    WorkPO findWorkById(Integer workId);

    /**
     * 根据名字获取作品
     * @param name
     * @return
     */
    @Select("select work_id,work_name from work_info where work_name = #{workName}")
    WorkPO findWorkByName(String name);

    /**
     * 添加作品
     * @param workPO
     * @return
     */
    @Options(useGeneratedKeys=true, keyProperty="workId", keyColumn="work_id")
    @Insert("insert into work_info(work_name) values(#{workName})")
    boolean addWork(WorkPO workPO);

    /**
     * 根据id查询教师作品信息
     * @param id
     * @return
     */
    @Select("SELECT tw.id,w.work_name,t.teacher_name from teacher_work as tw,work_info as w,teacher_info as t where tw.work_id = w.work_id and tw.teacher_id = t.teacher_id and tw.id = #{id};")
    WorkInfoPO findTeacherWorkInfoById(Integer id);

    /**
     * 根据id删除教师作品信息
     * @param id
     * @return
     */
    @Delete("delete from teacher_work where id = #{id}")
    boolean deleteTeacherWorkInfoById(Integer id);

    /**
     * 根据教师名字查询教师作品信息
     * @param teacherName
     * @return
     */
    @Select("SELECT tw.id,w.work_name,t.teacher_name from teacher_work as tw,work_info as w,teacher_info as t where tw.work_id = w.work_id and tw.teacher_id = t.teacher_id and t.teacher_name = #{teacherName};")
    List<WorkInfoPO> findTeacherWorkInfoByTeacherName(String teacherName);

    /**
     * 根据作品名字查询教师作品信息
     * @param workName
     * @return
     */
    @Select("SELECT tw.id,w.work_name,t.teacher_name from teacher_work as tw,work_info as w,teacher_info as t where tw.work_id = w.work_id and tw.teacher_id = t.teacher_id and w.work_name = #{workName};")
    List<WorkInfoPO> findTeacherWorkInfoByWorkName(String workName);
}
