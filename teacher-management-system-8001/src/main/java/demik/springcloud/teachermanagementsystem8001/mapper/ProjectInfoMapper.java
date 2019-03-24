package demik.springcloud.teachermanagementsystem8001.mapper;

import demik.springcloud.entity.domain.po.ProjectInfoPO;
import demik.springcloud.entity.domain.po.TeacherProjectPO;
import demik.springcloud.entity.domain.vo.TeacherProjectVO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Function:
 *
 * @author liubing
 * Date: 2019/3/20 3:40 PM
 * @since JDK 1.8
 */
@Mapper
public interface ProjectInfoMapper {

    /**
     * 查询所有的项目信息
     * @return
     */
    @Select("select project_id,project_name,project_value from project_info")
    List<ProjectInfoPO> findAllProjectinfo();

    /**
     * 查询所有的教师项目信息
     * @return
     */
    @Select("select p.project_id,p.project_name,p.project_value,t.teacher_name from teacher_info as t,project_info as p,teacher_project as tp where tp.project_id = p.project_id and tp.teacher_id = t.teacher_id")
    List<TeacherProjectPO> findAllProjectTeacherinfo();

    /**
     * 根据id查询项目
     * @param id
     * @return
     */
    @Select("select project_id,project_name,project_value from project_info where project_id = #{id}")
    ProjectInfoPO findProjectInfoById(Integer id);

    /**
     *  添加一条项目信息
     * @param po
     * @return
     */
    @Options(useGeneratedKeys=true, keyProperty="projectId", keyColumn="project_id")
    @Insert("insert into project_info(project_name,project_value) values(#{projectName},#{projectValue})")
    boolean addProjectInfo(ProjectInfoPO po);

    /**
     * 添加一条教师项目信息
     * @param teacherProjectVO
     * @return
     */
    @Insert("insert into teacher_project(project_id,teacher_id) values(#{projectId},#{teacherId})")
    boolean addTeacherProjectInfo(TeacherProjectVO teacherProjectVO);

    /**
     * 根据名字获取项目
     * @param name
     * @return
     */
    @Select("select project_id,project_name,project_value from project_info where project_name = #{name}")
    List<ProjectInfoPO> findProjectByName(String name);
}
