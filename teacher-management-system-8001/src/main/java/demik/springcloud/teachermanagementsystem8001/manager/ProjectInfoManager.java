package demik.springcloud.teachermanagementsystem8001.manager;

import demik.springcloud.entity.domain.po.ProjectInfoPO;
import demik.springcloud.entity.domain.po.TeacherProjectPO;
import demik.springcloud.entity.domain.vo.TeacherProjectVO;
import demik.springcloud.teachermanagementsystem8001.mapper.ProjectInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Function:
 *
 * @author liubing
 * Date: 2019/3/20 3:40 PM
 * @since JDK 1.8
 */
@Repository
public class ProjectInfoManager {
    @Autowired
    private ProjectInfoMapper projectInfoMapper;

    /**
     * 查询所有的项目信息
     * @return
     */
    public List<ProjectInfoPO> findAllProjectinfo(){
        return projectInfoMapper.findAllProjectinfo();
    }

    /**
     *查询所有的教师项目信息
     * @return
     */
    public List<TeacherProjectPO> findAllProjectTeacherinfo() {
        return projectInfoMapper.findAllProjectTeacherinfo();
    }

    /**
     * 根据id查询项目
     * @param id
     * @return
     */
    public ProjectInfoPO findProjectInfoById(Integer id) {
        return projectInfoMapper.findProjectInfoById(id);
    }

    /**
     *  添加一条项目信息
     * @param po
     * @return
     */
    public boolean addProjectInfo(ProjectInfoPO po) {
        return projectInfoMapper.addProjectInfo(po);
    }

    /**
     * 添加一条教师项目信息
     * @param teacherProjectVO
     * @return
     */
    public boolean addTeacherProjectInfo(TeacherProjectVO teacherProjectVO) {
        return projectInfoMapper.addTeacherProjectInfo(teacherProjectVO);
    }

    /**
     * 根据名字获取项目
     * @param name
     * @return
     */
    public List<ProjectInfoPO> findProjectByName(String name) {
        return projectInfoMapper.findProjectByName(name);
    }
}
