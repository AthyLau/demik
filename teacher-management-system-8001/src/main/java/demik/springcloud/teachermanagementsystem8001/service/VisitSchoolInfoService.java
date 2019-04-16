package demik.springcloud.teachermanagementsystem8001.service;

import demik.springcloud.entity.domain.dto.VisitSchoolDTO;
import demik.springcloud.entity.domain.po.SchoolPO;
import demik.springcloud.entity.domain.po.VisitSchoolPO;
import demik.springcloud.teachermanagementsystem8001.manager.VisitSchoolInfoManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Function:
 *
 * @author liubing
 * Date: 2019/3/20 3:45 PM
 * @since JDK 1.8
 */
@Service
public class VisitSchoolInfoService {
    @Autowired
    private VisitSchoolInfoManager visitSchoolInfoManager;
    /**
     * 根据名字查询学校信息
     */
    public SchoolPO findSchoolInfoByName(String name) {
        return visitSchoolInfoManager.findSchoolInfoByName(name);
    }
    /**
     * 查询所有的学校信息
     * @return
     */
    public List<SchoolPO> findAllSchoolInfo() {
        return visitSchoolInfoManager.findAllSchoolInfo();
    }

    /**
     * 查询所有的访学信息
     * @return
     */
    public List<VisitSchoolPO> findAllVisitSchoolInfo() {
        return visitSchoolInfoManager.findAllVisitSchoolInfo();
    }

    /**
     * 根据id查询学校
     * @param schoolId
     * @return
     */
    public SchoolPO findAllSchoolInfoById(Integer schoolId) {
        return visitSchoolInfoManager.findAllSchoolInfoById(schoolId);
    }

    /**
     * 添加一条教师访学信息
     * @param visitSchoolDTO
     * @return
     */
    public boolean addVisitSchoolInfo(VisitSchoolDTO visitSchoolDTO) {
        return visitSchoolInfoManager.addVisitSchoolInfo(visitSchoolDTO);
    }

    /**
     * 添加学校信息
     * @param po
     * @return
     */
    public boolean addSchoolInfo(SchoolPO po) {
        return visitSchoolInfoManager.addSchoolInfo(po);
    }

    /**
     * 根据id查询访学信息
     * @param id
     * @return
     */
    public VisitSchoolPO findVisitSchoolInfoById(Integer id) {
        return visitSchoolInfoManager.findVisitSchoolInfoById(id);
    }

    /**
     * 根据id删除访学信息
     * @param id
     * @return
     */
    public boolean deleteVisitSchoolInfoById(Integer id) {
        return visitSchoolInfoManager.deleteVisitSchoolInfoById(id);
    }

    /**
     * 根据教师姓名查询访学信息
     * @param teacherName
     * @return
     */
    public List<VisitSchoolPO> findVisitSchoolInfoByTeacherName(String teacherName) {
        return visitSchoolInfoManager.findVisitSchoolInfoByTeacherName(teacherName);
    }

    public List<VisitSchoolPO> findVisitSchoolInfoBySchoolName(String schoolName) {
        return visitSchoolInfoManager.findVisitSchoolInfoBySchoolName(schoolName);
    }
}
