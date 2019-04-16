package demik.springcloud.studentmanagementsystem9001.service;

import demik.springcloud.entity.domain.vo.AClassInfoVO;
import demik.springcloud.entity.domain.vo.PerfessionalInfoVO;
import demik.springcloud.studentmanagementsystem9001.manager.AClassInfoManager;
import demik.springcloud.studentmanagementsystem9001.manager.PerfessionalInfoManager;
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
 * Date: 2019/3/14 2:36 PM
 * @since JDK 1.8
 */
@Service
public class PerfessionalInfoService {

    @Autowired
    private PerfessionalInfoManager perfessionalInfoManager;
    @Autowired
    private AClassInfoService aClassInfoService;

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
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, timeout = 3600)
    public boolean deletePerfessionalInfo(Integer perrfessionalId) {
        List<AClassInfoVO> vos = aClassInfoService.findAClassInfoByPId(perrfessionalId);
        if(vos!=null&&vos.size()>0){
            vos.forEach(x->{
                if(!aClassInfoService.deleteAClass(x.getAclassId())){
                    throw new RuntimeException();
                }
            });
        }
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

    /**
     * 根据名称查询专业
     * @param perfessionalName
     * @return
     */
    public PerfessionalInfoVO findPerfessionalInfoByName(String perfessionalName) {
        return perfessionalInfoManager.findPerfessionalInfoByName(perfessionalName);
    }
}
