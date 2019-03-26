package demik.springcloud.teachermanagementsystem8001.manager;

import demik.springcloud.entity.domain.dto.PublishedPaperInfoDTO;
import demik.springcloud.entity.domain.po.PaperPublishedPO;
import demik.springcloud.entity.domain.po.PaperTypePO;
import demik.springcloud.entity.domain.vo.PaperInfoVO;
import demik.springcloud.entity.domain.vo.PaperOriginInfoVO;
import demik.springcloud.teachermanagementsystem8001.mapper.PaperInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Function:
 *
 * @author liubing
 * Date: 2019/3/20 1:44 AM
 * @since JDK 1.8
 */
@Repository
public class PaperInfoManager {

    @Autowired
    private PaperInfoMapper paperInfoMapper;
    /**
     * 查询所有的论文信息
     * @return
     */
    public List<PaperInfoVO> findAllPaperInfo() {
        return paperInfoMapper.findAllPaperInfo();
    }

    /**
     * 添加论文
     * @param paperOriginInfoVO
     * @return
     */
    public boolean addPaperOriginInfo(PaperOriginInfoVO paperOriginInfoVO) {
        return paperInfoMapper.addPaperOriginInfo(paperOriginInfoVO);
    }

    /**
     * 查询所有的论文类型
     * @return
     */
    public List<PaperTypePO> findAllPaperType() {
        return paperInfoMapper.findAllPaperType();
    }

    /**
     * 删除一条教师发布论文信息
     * @return
     */
    public boolean deletePaperOriginInfo(Integer id) {
        return paperInfoMapper.deletePaperOriginInfo(id);
    }

    /**
     * 查询所有的教师发布论文信息
     * @return
     */
    public List<PublishedPaperInfoDTO> PublishedPaperInfoDTO() {
        return paperInfoMapper.PublishedPaperInfoDTO();
    }

    /**
     * 添加一条教师发布论文信息
     * @param paperPublishedPO
     * @return
     */
    public boolean addPublishedPaperInfo(PaperPublishedPO paperPublishedPO) {
        return paperInfoMapper.addPublishedPaperInfo(paperPublishedPO);
    }

    /**
     * 根据名字查询论文发布信息
     * @param paperName
     * @return
     */
    public Integer findPaperInfoByName(String paperName) {
        List<Integer> list = paperInfoMapper.findPaperInfoByName(paperName);
        if(list!=null&&list.size()>0){
            return list.get(0);
        }
        return null;
    }

    /**
     * 根据id查询论文信息
     * @param id
     * @return
     */
    public PaperInfoVO findPaperInfoById(Integer id) {
        return paperInfoMapper.findPaperInfoById(id);
    }

    /**
     *
     * @param id
     * @return
     */
    public PaperTypePO findPaperTypeById(Integer id) {
        return paperInfoMapper.findPaperTypeById(id);
    }
}
