package demik.springcloud.studentmanagementsystem9003.service;

import com.google.common.collect.Lists;
import demik.springcloud.entity.domain.doo.GradeInfoDO;
import demik.springcloud.entity.domain.dto.AClassInfoDTO;
import demik.springcloud.entity.domain.vo.AClassInfoVO;
import demik.springcloud.entity.domain.vo.GradeInfoVO;
import demik.springcloud.entity.domain.vo.PerfessionalInfoVO;
import demik.springcloud.studentmanagementsystem9003.manager.AClassInfoManager;
import demik.springcloud.studentmanagementsystem9003.manager.GradeInfoManager;
import demik.springcloud.studentmanagementsystem9003.manager.PerfessionalInfoManager;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Function:
 *
 * @author liubing
 * Date: 2019/3/14 2:38 PM
 * @since JDK 1.8
 */
@Service
public class AClassInfoService {

    @Autowired
    private AClassInfoManager aClassInfoManager;
    @Autowired
    private PerfessionalInfoManager perfessionalInfoManager;
    @Autowired
    private GradeInfoManager gradeInfoManager;
    /**
     * 添加一个班级
     * @param aClassInfoVO
     * @return
     */
    public boolean addAClass(AClassInfoVO aClassInfoVO) {
        return aClassInfoManager.addAClass(aClassInfoVO);
    }
    /**
     * 删除一个班级
     * @param id
     * @return
     */
    public boolean deleteAClass(Integer id) {
        return aClassInfoManager.deleteAClass(id);
    }

    /**
     * 更新一个班级
     * @param aClassInfoVO
     * @return
     */
    public boolean updateAClass(AClassInfoVO aClassInfoVO) {
        return aClassInfoManager.updateAClass(aClassInfoVO);
    }

    /**
     * 查询所有的班级信息及其所属的年级专业信息
     * @return
     */
    public List<AClassInfoDTO> findAllAClass() {
        List<AClassInfoDTO> dtos = Lists.newArrayList();
        List<AClassInfoVO> origonVos = aClassInfoManager.findAllAClass();
        origonVos.forEach(x->{
            AClassInfoDTO dto = new AClassInfoDTO();
            PerfessionalInfoVO pvo = perfessionalInfoManager.findPerfessionalInfoById(x.getPerfessionalId());
            GradeInfoDO gdo = gradeInfoManager.findGradeById(x.getGradeId());
            GradeInfoVO gvo = new GradeInfoVO();
            BeanUtils.copyProperties(gdo,gvo);
            dto.setaClassInfoVO(x);
            dto.setGradeInfoVO(gvo);
            dto.setPerfessionalInfoVO(pvo);
            dtos.add(dto);
        });
        return dtos;
    }
    /**
     * 查询单个班级
     * @return
     */
    public AClassInfoDTO findAClassById(Integer id) {
        AClassInfoDTO dto = new AClassInfoDTO();
        AClassInfoVO avo = aClassInfoManager.findAClassById(id);
        if(avo==null){
            return null;
        }
        PerfessionalInfoVO pvo = perfessionalInfoManager.findPerfessionalInfoById(avo.getPerfessionalId());
        GradeInfoDO gdo = gradeInfoManager.findGradeById(avo.getGradeId());
        GradeInfoVO gvo = new GradeInfoVO();
        BeanUtils.copyProperties(gdo,gvo);
        dto.setaClassInfoVO(avo);
        dto.setGradeInfoVO(gvo);
        dto.setPerfessionalInfoVO(pvo);
        return dto;
    }
}
