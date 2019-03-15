package demik.springcloud.studentmanagementsystem9002.service;

import com.google.common.collect.Lists;
import demik.springcloud.entity.domain.doo.GradeInfoDO;
import demik.springcloud.entity.domain.dto.GradeInfoDTO;
import demik.springcloud.studentmanagementsystem9002.manager.GradeInfoManager;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Function:
 *
 * @author liubing
 * Date: 2019/3/14 2:37 PM
 * @since JDK 1.8
 */
@Service
public class GradeInfoService {
    @Autowired
    private GradeInfoManager gradeInfoManager;
    /**
     * 添加一个
     * @param gradeInfoDTO
     * @return
     */
    public boolean addGrade(GradeInfoDTO gradeInfoDTO){
        GradeInfoDO gradeInfoDO = new GradeInfoDO();
        BeanUtils.copyProperties(gradeInfoDTO,gradeInfoDO);
        return gradeInfoManager.addGrade(gradeInfoDO);
    }

    /**
     * 删除一个
     * @param id
     * @return
     */
    public boolean deleteGrade(Integer id){
        return gradeInfoManager.deleteGrade(id);
    }

    /**
     * 更新一个信息
     * @param gradeInfoDTO
     * @return
     */
    public boolean updateGrade(GradeInfoDTO gradeInfoDTO){
        GradeInfoDO gradeInfoDO = new GradeInfoDO();
        BeanUtils.copyProperties(gradeInfoDTO,gradeInfoDO);
        return gradeInfoManager.updateGrade(gradeInfoDO);
    }

    /**
     * 查询所有的信息
     * @return
     */
    public List<GradeInfoDTO> findAllGrade(){
        List<GradeInfoDO> dos = gradeInfoManager.findAllGrade();
        List<GradeInfoDTO> dtos = Lists.newArrayList();
        dos.forEach(x->{
            GradeInfoDTO gradeInfoDTO = new GradeInfoDTO();
            BeanUtils.copyProperties(x,gradeInfoDTO);
            dtos.add(gradeInfoDTO);
        });
        return dtos;
    }

    /**
     * 根据id查询信息
     * @param id
     * @return
     */
    public GradeInfoDTO findGradeById(Integer id){
        GradeInfoDO gradeInfoDO = gradeInfoManager.findGradeById(id);
        if(gradeInfoDO==null){
            return null;
        }
        GradeInfoDTO gradeInfoDTO = new GradeInfoDTO();
        BeanUtils.copyProperties(gradeInfoDO,gradeInfoDTO);
        return gradeInfoDTO;
    }
}
