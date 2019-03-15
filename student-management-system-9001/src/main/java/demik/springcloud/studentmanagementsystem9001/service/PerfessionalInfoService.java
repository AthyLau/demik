package demik.springcloud.studentmanagementsystem9001.service;

import demik.springcloud.entity.domain.vo.PerfessionalInfoVO;
import demik.springcloud.studentmanagementsystem9001.manager.PerfessionalInfoManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Function:
 *
 * @author liubing
 * Date: 2019/3/14 2:36 PM
 * @since JDK 1.8
 */
@Service
public class PerfessionalInfoService {

    @Autowired
    private PerfessionalInfoManager perfessionalInfoManager;

    /**
     * 添加一个专业
     * @param perfessionalInfoVO
     * @return
     */
    public boolean addPerfessionalInfo(PerfessionalInfoVO perfessionalInfoVO) {
        return perfessionalInfoManager.addPerfessionalInfo(perfessionalInfoVO);
    }

    /**
     * 更新一个专业
     * @param perfessionalInfoVO
     * @return
     */
    public boolean updatePerfessionalInfo(PerfessionalInfoVO perfessionalInfoVO) {
        return perfessionalInfoManager.updatePerfessionalInfo(perfessionalInfoVO);
    }

    /**
     * 删除一个专业
     * @param perrfessionalId
     * @return
     */
    public boolean deletePerfessionalInfo(Integer perrfessionalId) {
        return perfessionalInfoManager.deletePerfessionalInfo(perrfessionalId);
    }

    /**
     * 查询所有专业
     * @return
     */
    public List<PerfessionalInfoVO> findAllPerfessionalInfo() {
        return perfessionalInfoManager.findAllPerfessionalInfo();
    }

    /**
     * 查找单个专业
     * @param perfessionalId
     * @return
     */
    public PerfessionalInfoVO findPerfessionalInfoById(Integer perfessionalId) {
        return perfessionalInfoManager.findPerfessionalInfoById(perfessionalId);
    }
}
