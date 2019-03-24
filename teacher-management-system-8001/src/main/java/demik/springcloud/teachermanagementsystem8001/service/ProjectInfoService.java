package demik.springcloud.teachermanagementsystem8001.service;

import demik.springcloud.entity.domain.po.ProjectInfoPO;
import demik.springcloud.entity.domain.po.TeacherProjectPO;
import demik.springcloud.entity.domain.vo.TeacherProjectVO;
import demik.springcloud.teachermanagementsystem8001.manager.PaperInfoManager;
import demik.springcloud.teachermanagementsystem8001.manager.ProjectInfoManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Function:
 *
 * @author liubing
 * Date: 2019/3/20 3:41 PM
 * @since JDK 1.8
 */
@Service
public class ProjectInfoService {
    @Autowired
    private ProjectInfoManager projectInfoManager;

    /**
     * 查询所有的项目信息
     * @return
     */
    public List<ProjectInfoPO> findAllProjectinfo() {
        return projectInfoManager.findAllProjectinfo();
    }

    /**
     * 查询所有的教师项目信息
     * @return
     */
    public List<TeacherProjectPO> findAllProjectTeacherinfo() {
        return projectInfoManager.findAllProjectTeacherinfo();
    }

    /**
     * 添加一条教师项目信息
     * @param teacherProjectVO
     * @return
     */
    public boolean addTeacherProjectInfo(TeacherProjectVO teacherProjectVO) {
        return projectInfoManager.addTeacherProjectInfo(teacherProjectVO);
    }

    /**
     * 根据id查询项目
     * @param id
     * @return
     */
    public ProjectInfoPO findProjectInfoById(Integer id) {
        return projectInfoManager.findProjectInfoById(id);
    }

    /**
     * 添加一条项目信息
     * @param po
     * @return
     */
    public boolean addProjectInfo(ProjectInfoPO po) {
        return projectInfoManager.addProjectInfo(po);
    }

    /**
     * 根据名字获取项目ID
     * @return
     */
    public Integer findProjectByName(String name) {
        List<ProjectInfoPO> pos = projectInfoManager.findProjectByName(name);
        if(pos.size()>0){
            return pos.get(0).getProjectId();
        }
        return null;
    }
}
