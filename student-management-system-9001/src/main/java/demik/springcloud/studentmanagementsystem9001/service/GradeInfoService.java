package demik.springcloud.studentmanagementsystem9001.service;

import com.google.common.collect.Lists;
import demik.springcloud.entity.domain.doo.GradeInfoDO;
import demik.springcloud.entity.domain.dto.GradeInfoDTO;
import demik.springcloud.entity.domain.po.GradeInfoPO;
import demik.springcloud.entity.domain.vo.AClassInfoVO;
import demik.springcloud.entity.domain.vo.GradeIdVO;
import demik.springcloud.entity.domain.vo.GradeInfoVO;
import demik.springcloud.studentmanagementsystem9001.manager.GradeInfoManager;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

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
    @Autowired
    private AClassInfoService aClassInfoService;
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
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, timeout = 3600)
    public boolean deleteGrade(Integer id){
        List<AClassInfoVO> vos = aClassInfoService.findAClassInfoByPId(id);
        if(vos!=null&&vos.size()>0){
            vos.forEach(x->{
                if(!aClassInfoService.deleteAClass(x.getAclassId())){
                    throw new RuntimeException();
                }
            });
        }
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

    /**
     * 根据年级名称查询信息
     * @param gradeName
     * @return
     */
    public GradeInfoDTO findGradeByGradeName(String gradeName) {
        GradeInfoDO gradeInfoDO = gradeInfoManager.findGradeByGradeName(gradeName);
        if(gradeInfoDO==null){
            return null;
        }
        GradeInfoDTO gradeInfoDTO = new GradeInfoDTO();
        BeanUtils.copyProperties(gradeInfoDO,gradeInfoDTO);
        return gradeInfoDTO;
    }
}
