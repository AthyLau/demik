package demik.springcloud.teachermanagementsystem8001.service;

import com.google.common.collect.Maps;
import demik.springcloud.entity.domain.dto.AClassInfoDTO;
import demik.springcloud.entity.domain.dto.TeacherExcelDTO;
import demik.springcloud.entity.domain.dto.TeacherInfoDTO;
import demik.springcloud.entity.domain.po.BookPO;
import demik.springcloud.entity.domain.po.SchoolPO;
import demik.springcloud.entity.domain.po.StudentCasePO;
import demik.springcloud.entity.domain.po.TeacherInfoPO;
import demik.springcloud.entity.domain.vo.*;
import demik.springcloud.teachermanagementsystem8001.manager.TeacherInfoManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

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
    @Autowired
    private OtherInfoService otherInfoService;
    @Autowired
    private OfficeInfoService officeInfoService;
    @Autowired
    private VisitSchoolInfoService visitSchoolInfoService;
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
    public TeacherInfoPO findTeacherInfoById(Integer teacherId) {
        return teacherInfoManager.findTeacherInfoById(teacherId);
    }

    /**
     * 根据教师的名字查询教师
     * @param teacherName
     * @return
     */
    public List<TeacherInfoPO> findTeacherInfoByTeacherName(String teacherName) {
        return teacherInfoManager.findTeacherInfoByTeacherName(teacherName);
    }

    /**
     * 根据教师的身份证查询教师
     * @param idCard
     * @return
     */
    public TeacherInfoPO findTeacherInfoByTeacherIdCard(String idCard) {
        return teacherInfoManager.findTeacherInfoByTeacherIdCard(idCard);
    }

    /**
     * 根据教研室id查找教师
     * @param officeId
     * @return
     */
    public List<TeacherInfoPO> findTeacherInfoByOfficeId(Integer officeId) {
        return teacherInfoManager.findTeacherInfoByOfficeId(officeId);
    }

    /**
     * 添加从 excel来的教师信息到数据库
     * @param dtos
     * @return
     */
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, timeout = 3600)
    public Map<Integer,String> addBatchTeacherInfo(List<TeacherExcelDTO> dtos) {
        Map<Integer,String> results = Maps.newHashMap();
        dtos.forEach(x->{
            int xh = x.getId()+10;
            EducationBackgroudVO educationBackgroudVO = otherInfoService.findEducationBackgroudById(x.getEducationBackgroudId());
            OfficeInfoVO officeInfoVO = officeInfoService.findOfficeInfoById(x.getOfficeId());
            DeptVO deptVO = otherInfoService.findDeptById(x.getDeptId());
            BookPO bookPO = otherInfoService.findBookByName(x.getBookName());
            SchoolPO schoolPO = visitSchoolInfoService.findSchoolInfoByName(x.getSchoolName());
            if(bookPO==null){
                bookPO = new BookPO();
                bookPO.setBookName(x.getBookName());
                if(!otherInfoService.addBook(bookPO)){
                    bookPO = null;
                    results.put(xh,xh+"行教材数据不存在且无法添加到数据库");
                }
            }
            if(deptVO==null){
                results.put(xh,xh+"行职位不存在");
            }
            if(officeInfoVO==null){
                results.put(xh,xh+"行教研室不存在");
            }
            if(educationBackgroudVO==null){
                results.put(xh,xh+"行学历不存在");
            }
            if(schoolPO==null){
                results.put(xh,xh+"行学校不存在");
            }
            if(schoolPO!=null&&educationBackgroudVO!=null&&officeInfoVO!=null&&deptVO!=null&&bookPO!=null){
                TeacherInfoDTO teacherInfoDTO = new TeacherInfoDTO();
                teacherInfoDTO.setBookId(bookPO.getBookId());
                teacherInfoDTO.setDeptId(deptVO.getDeptId());
                teacherInfoDTO.setEducationBackgroudId(educationBackgroudVO.getEducationBackgroudId());
                teacherInfoDTO.setOfficeId(officeInfoVO.getOfficeId());
                teacherInfoDTO.setSchoolId(schoolPO.getSchoolId());
                teacherInfoDTO.setTeacherIdCard(x.getTeacherIdCard());
                teacherInfoDTO.setTeacherName(x.getTeacherName());
                teacherInfoDTO.setTeacherNumber(x.getTeacherNumber());
                teacherInfoDTO.setTeacherPhone(x.getTeacherPhone());
                try{
                    if(!teacherInfoManager.addTeacherInfo(teacherInfoDTO)){
                        throw new RuntimeException();
                    }
                }catch (Exception e){
                    results.put(x.getId()+10,xh+"行教师数据有错误");
                }
            }
        });
        return results;
    }
}
