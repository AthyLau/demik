package demik.springcloud.studentmanagementsystem9001.manager;

import demik.springcloud.entity.domain.vo.PerfessionalInfoVO;
import demik.springcloud.studentmanagementsystem9001.mapper.PerfessionalInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Function:
 *
 * @author liubing
 * Date: 2019/3/14 2:36 PM
 * @since JDK 1.8
 */
@Repository
public class PerfessionalInfoManager {
    @Autowired
    private PerfessionalInfoMapper perfessionalInfoMapper;

    /**
     * 添加一个专业
     * @param perfessionalInfoVO
     * @return
     */
    public boolean addPerfessionalInfo(PerfessionalInfoVO perfessionalInfoVO) {
        return perfessionalInfoMapper.addPerfessionalInfo(perfessionalInfoVO);
    }

    /**
     * 更新一个专业
     * @param perfessionalInfoVO
     * @return
     */
    public boolean updatePerfessionalInfo(PerfessionalInfoVO perfessionalInfoVO) {
        return perfessionalInfoMapper.updatePerfessionalInfo(perfessionalInfoVO);
    }

    /**
     * 删除一个专业
     * @param perrfessionalId
     * @return
     */
    public boolean deletePerfessionalInfo(Integer perrfessionalId) {
        return perfessionalInfoMapper.deletePerfessionalInfo(perrfessionalId);
    }

    /**
     * 查询所有专业
     * @return
     */
    public List<PerfessionalInfoVO> findAllPerfessionalInfo() {
        return perfessionalInfoMapper.findAllPerfessionalInfo();
    }

    /**
     * 查找单个专业
     * @return
     */
    public PerfessionalInfoVO findPerfessionalInfoById(Integer perfessionalId) {
        return perfessionalInfoMapper.findPerfessionalInfoById(perfessionalId);
    }
}
