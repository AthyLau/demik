package demik.springcloud.teachermanagementsystem8001.service;

import demik.springcloud.entity.domain.dto.TeacherInfoDTO;
import demik.springcloud.entity.domain.po.TeacherInfoPO;
import demik.springcloud.entity.domain.vo.TeacherIdVO;
import demik.springcloud.teachermanagementsystem8001.manager.TeacherInfoManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Function:
 *
 * @author liubing
 * Date: 2019/3/24 2:02 AM
 * @since JDK 1.8
 */
@Service
public class TeacherInfoService {
    @Autowired
    private TeacherInfoManager teacherInfoManager;

    /**
     * 查询所有的教师信息
     * @return
     */
    public List<TeacherInfoPO> findAllTeacherInfo() {
        return teacherInfoManager.findAllTeacherInfo();
    }

    /**
     * 添加教师
     * @param teacherInfoDTO
     * @return
     */
    public boolean addTeacherInfo(TeacherInfoDTO teacherInfoDTO) {
        return teacherInfoManager.addTeacherInfo(teacherInfoDTO);
    }

    /**
     * 删除教师信息
     * @param teacherId
     * @return
     */
    public boolean deleteTeacherInfo(Integer teacherId) {
        return teacherInfoManager.deleteTeacherInfo(teacherId);
    }

    /**
     * 根绝id查询教师信息
     * @param teacherId
     * @return
     */
    public TeacherIdVO findTeacherInfoById(Integer teacherId) {
        return teacherInfoManager.findTeacherInfoById(teacherId);
    }
}
