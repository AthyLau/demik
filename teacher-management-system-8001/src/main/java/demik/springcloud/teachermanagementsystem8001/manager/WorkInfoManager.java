package demik.springcloud.teachermanagementsystem8001.manager;

import demik.springcloud.entity.domain.dto.TeacherWorkDTO;
import demik.springcloud.entity.domain.po.WorkInfoPO;
import demik.springcloud.entity.domain.po.WorkPO;
import demik.springcloud.teachermanagementsystem8001.mapper.WorkInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Function:
 *
 * @author liubing
 * Date: 2019/3/20 3:44 PM
 * @since JDK 1.8
 */
@Repository
public class WorkInfoManager {
    @Autowired
    private WorkInfoMapper workInfoMapper;

    /**
     * 查询所有的教师作品信息
     * @return
     */
    public List<WorkInfoPO> findAllWorkInfo() {
        return workInfoMapper.findAllWorkInfo();
    }

    /**
     * 查询所有的作品
     * @return
     */
    public List<WorkPO> findAllWork() {
        return workInfoMapper.findAllWork();
    }

    /**
     * 添加一个作品
     * @param teacherWorkDTO
     * @return
     */
    public boolean addTeacherWork(TeacherWorkDTO teacherWorkDTO) {
        return workInfoMapper.addTeacherWork(teacherWorkDTO);
    }

    /**
     * 根据名字获取作品
     * @return
     */
    public WorkPO findWorkByName(String name) {
        return workInfoMapper.findWorkByName(name);
    }

    /**
     * 根据id查找作品
     * @param workId
     * @return
     */
    public WorkPO findWorkById(Integer workId) {
        return workInfoMapper.findWorkById(workId);
    }

    /**
     * 添加作品
     * @param workPO
     * @return
     */
    public boolean addWork(WorkPO workPO) {
        return workInfoMapper.addWork(workPO);
    }

    /**
     * 根据id查询教师作品信息
     * @param id
     * @return
     */
    public WorkInfoPO findTeacherWorkInfoById(Integer id) {
        return workInfoMapper.findTeacherWorkInfoById(id);
    }

    /**
     * 根据id删除教师作品信息
     * @param id
     * @return
     */
    public boolean deleteTeacherWorkInfoById(Integer id) {
        return workInfoMapper.deleteTeacherWorkInfoById(id);
    }

    /**
     * 根据教师名字查询教师作品信息
     * @param teacherName
     * @return
     */
    public List<WorkInfoPO> findTeacherWorkInfoByTeacherName(String teacherName) {
        return workInfoMapper.findTeacherWorkInfoByTeacherName(teacherName);
    }

    /**
     * 根据作品名字查询教师作品信息
     * @param workName
     * @return
     */
    public List<WorkInfoPO> findTeacherWorkInfoByWorkName(String workName) {
        return workInfoMapper.findTeacherWorkInfoByWorkName(workName);
    }
}
