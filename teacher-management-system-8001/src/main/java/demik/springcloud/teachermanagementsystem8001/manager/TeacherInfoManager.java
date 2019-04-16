package demik.springcloud.teachermanagementsystem8001.manager;

import demik.springcloud.entity.domain.dto.TeacherInfoDTO;
import demik.springcloud.entity.domain.po.TeacherInfoPO;
import demik.springcloud.entity.domain.vo.TeacherIdVO;
import demik.springcloud.teachermanagementsystem8001.mapper.TeacherInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Function:
 *
 * @author liubing
 * Date: 2019/3/24 2:02 AM
 * @since JDK 1.8
 */
@Repository
public class TeacherInfoManager {
    @Autowired
    private TeacherInfoMapper teacherInfoMapper;

    /**
     * 查询所有的教师信息
     * @return
     */
    public List<TeacherInfoPO> findAllTeacherInfo() {
        return teacherInfoMapper.findAllTeacherInfo();
    }

    /**
     *
     * @param teacherInfoDTO
     * @return
     */
    public boolean addTeacherInfo(TeacherInfoDTO teacherInfoDTO) {
        return teacherInfoMapper.addTeacherInfo(teacherInfoDTO);
    }

    /**
     * 删除教师信息
     * @param teacherId
     * @return
     */
    public boolean deleteTeacherInfo(Integer teacherId) {
        return teacherInfoMapper.deleteTeacherInfo(teacherId);
    }

    /**
     * 根绝id查询教师信息
     * @param teacherId
     * @return
     */
    public TeacherInfoPO findTeacherInfoById(Integer teacherId) {
        return teacherInfoMapper.findTeacherInfoById(teacherId);
    }

    /**
     * 根据教师的名字查询教师
     * @param teacherName
     * @return
     */
    public List<TeacherInfoPO> findTeacherInfoByTeacherName(String teacherName) {
        return teacherInfoMapper.findTeacherInfoByTeacherName(teacherName);
    }
    /**
     * 根据教师的身份证查询教师
     * @param idCard
     * @return
     */
    public TeacherInfoPO findTeacherInfoByTeacherIdCard(String idCard) {
        return teacherInfoMapper.findTeacherInfoByTeacherIdCard(idCard);
    }

    /**
     * 根据教研室id查找教师
     * @param officeId
     * @return
     */
    public List<TeacherInfoPO> findTeacherInfoByOfficeId(Integer officeId) {
        return teacherInfoMapper.findTeacherInfoByOfficeId(officeId);
    }
}
