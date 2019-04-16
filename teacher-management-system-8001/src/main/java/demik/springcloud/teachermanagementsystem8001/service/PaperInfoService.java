package demik.springcloud.teachermanagementsystem8001.service;

import demik.springcloud.entity.domain.dto.PublishedPaperInfoDTO;
import demik.springcloud.entity.domain.po.PaperPublishedPO;
import demik.springcloud.entity.domain.po.PaperTypePO;
import demik.springcloud.entity.domain.vo.PaperInfoVO;
import demik.springcloud.entity.domain.vo.PaperOriginInfoVO;
import demik.springcloud.teachermanagementsystem8001.manager.PaperInfoManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Function:
 *
 * @author liubing
 * Date: 2019/3/20 1:45 AM
 * @since JDK 1.8
 */
@Service
public class PaperInfoService {

    @Autowired
    private PaperInfoManager paperInfoManager;

    /**
     * 查询所有的论文信息
     * @return
     */
    public List<PaperInfoVO> findAllPaperInfo() {
        return paperInfoManager.findAllPaperInfo();
    }

    /**
     * 添加论文
     * @param paperOriginInfoVO
     * @return
     */
    public boolean addPaperOriginInfo(PaperOriginInfoVO paperOriginInfoVO) {
        return paperInfoManager.addPaperOriginInfo(paperOriginInfoVO);
    }

    /**
     * 查询所有的论文类型
     * @return
     */
    public List<PaperTypePO> findAllPaperType() {
        return paperInfoManager.findAllPaperType();
    }

    /**
     * 删除一条教师发布论文信息
     * @param id
     * @return
     */
    public boolean deletePaperOriginInfo(Integer id) {
        return paperInfoManager.deletePaperOriginInfo(id);
    }

    /**
     * 查询所有的教师发布论文信息
     * @return
     */
    public List<PublishedPaperInfoDTO> findAllPublishedPaperInfo() {
        return paperInfoManager.PublishedPaperInfoDTO();
    }

    /**
     * 添加一条教师发布论文信息
     * @param paperPublishedPO
     * @return
     */
    public boolean addPublishedPaperInfo(PaperPublishedPO paperPublishedPO) {
        return paperInfoManager.addPublishedPaperInfo(paperPublishedPO);
    }

    /**
     * 根据名字查询论文发布信息
     * @param paperName
     * @return
     */
    public Integer findPaperInfoByName(String paperName) {
        return paperInfoManager.findPaperInfoByName(paperName);
    }

    /**
     * 根据id查询论文信息
     * @param id
     * @return
     */
    public PaperInfoVO findPaperInfoById(Integer id) {
        return paperInfoManager.findPaperInfoById(id);
    }

    /**
     *
     * @param id
     * @return
     */
    public PaperTypePO findPaperTypeById(Integer id) {
        return paperInfoManager.findPaperTypeById(id);
    }

    /**
     * 根据id查询教师发布论文信息
     * @param id
     * @return
     */
    public PublishedPaperInfoDTO findPublishedPaperInfoById(Integer id) {
        return paperInfoManager.findPublishedPaperInfoById(id);
    }

    /**
     * 根据教师名称查询教师发布论文信息
     * @param teacherName
     * @return
     */
    public List<PublishedPaperInfoDTO> findPublishedPaperInfoByTeacherName(String teacherName) {
        return paperInfoManager.findPublishedPaperInfoByTeacherName(teacherName);
    }

    /**
     * 根据论文名称查询教师发布论文信息
     * @param paperName
     * @return
     */
    public List<PublishedPaperInfoDTO> findPublishedPaperInfoByPaperName(String paperName) {
        return paperInfoManager.findPublishedPaperInfoByPaperName(paperName);
    }
}
