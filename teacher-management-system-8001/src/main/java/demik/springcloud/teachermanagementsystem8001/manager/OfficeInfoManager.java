package demik.springcloud.teachermanagementsystem8001.manager;

import demik.springcloud.entity.domain.vo.OfficeInfoVO;
import demik.springcloud.teachermanagementsystem8001.mapper.OfficeInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Function:
 *
 * @author liubing
 * Date: 2019/3/15 11:16 PM
 * @since JDK 1.8
 */
@Repository
public class OfficeInfoManager {

    @Autowired
    private OfficeInfoMapper officeInfoMapper;

    /**
     * 添加一个教研室
     * @param
     * @return
     */
    public boolean addOfficeInfo(OfficeInfoVO officeInfoVO) {
        return officeInfoMapper.addOfficeInfo(officeInfoVO);
    }

    /**
     * 删除一个教研室
     * @param officeId
     * @return
     */
    public boolean deleteOfficeInfo(Integer officeId) {
        return officeInfoMapper.deleteOfficeInfo(officeId);
    }
    /**
     * 更新一个教研室
     * @param
     * @return
     */
    public boolean updateOfficeInfo(OfficeInfoVO officeInfoVO) {
        return officeInfoMapper.updateOfficeInfo(officeInfoVO);
    }

    /**
     * 查询所有的教研室
     * @return
     */
    public List<OfficeInfoVO> findAllOfficeInfo() {
        return officeInfoMapper.findAllOfficeInfo();
    }

    /**
     * 查询单个教研室
     * @param officeId
     * @return
     */
    public OfficeInfoVO findOfficeInfoById(Integer officeId) {
        return officeInfoMapper.findOfficeInfoById(officeId);
    }
}
