package demik.springcloud.teachermanagementsystem8001.service;

import demik.springcloud.entity.domain.vo.OfficeInfoVO;
import demik.springcloud.teachermanagementsystem8001.manager.OfficeInfoManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Function:
 *
 * @author liubing
 * Date: 2019/3/15 11:16 PM
 * @since JDK 1.8
 */
@Service
public class OfficeInfoService {

    @Autowired
    private OfficeInfoManager officeInfoManager;

    /**
     * 添加一个教研室
     * @param
     * @return
     */
    public boolean addOfficeInfo(OfficeInfoVO officeInfoVO) {
        return officeInfoManager.addOfficeInfo(officeInfoVO);
    }

    /**
     * 删除一个教研室
     * @param officeId
     * @return
     */
    public boolean deleteOfficeInfo(Integer officeId) {
        return officeInfoManager.deleteOfficeInfo(officeId);
    }
    /**
     * 更新一个教研室
     * @param
     * @return
     */
    public boolean updateOfficeInfo(OfficeInfoVO officeInfoVO) {
        return officeInfoManager.updateOfficeInfo(officeInfoVO);
    }

    /**
     * 查询所有的教研室
     * @return
     */
    public List<OfficeInfoVO> findAllOfficeInfo() {
        return officeInfoManager.findAllOfficeInfo();
    }

    /**
     * 查询单个教研室
     * @param officeId
     * @return
     */
    public OfficeInfoVO findOfficeInfoById(Integer officeId) {
        return officeInfoManager.findOfficeInfoById(officeId);
    }
}
