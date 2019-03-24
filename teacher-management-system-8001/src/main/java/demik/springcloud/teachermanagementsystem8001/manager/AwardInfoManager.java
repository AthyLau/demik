package demik.springcloud.teachermanagementsystem8001.manager;

import demik.springcloud.entity.domain.po.AwardInfoPO;
import demik.springcloud.entity.domain.vo.AwardGameVO;
import demik.springcloud.entity.domain.vo.AwardInfoVO;
import demik.springcloud.entity.domain.vo.AwardLevelVO;
import demik.springcloud.teachermanagementsystem8001.mapper.AwardInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Function:
 *
 * @author liubing
 * Date: 2019/3/18 7:47 PM
 * @since JDK 1.8
 */
@Repository
public class AwardInfoManager {

    @Autowired
    private AwardInfoMapper awardInfoMapper;

    /**
     * 查询所有的比赛
     * @return
     */
    public List<AwardGameVO> findAllAwardGame() {
        return awardInfoMapper.findAllAwardGame();
    }

    /**
     * 查询所有的奖级别
     * @return
     */
    public List<AwardLevelVO> findAllAwardLevel() {
        return awardInfoMapper.findAllAwardLevel();
    }

    /**
     * 查询所有的教师获奖记录
     * @return
     */
    public List<AwardInfoVO> findAllAwardInfo() {
        return awardInfoMapper.findAllAwardInfo();
    }

    /**
     * 删除一条教师获奖信息
     * @param id
     * @return
     */
    public boolean deleteAwardInfoById(Integer id) {
        return awardInfoMapper.deleteAwardInfoById(id);
    }

    /**
     * 添加一条教师获奖信息
     * @param awardInfoPO
     * @return
     */
    public boolean addAwardInfo(AwardInfoPO awardInfoPO) {
        return awardInfoMapper.addAwardInfo(awardInfoPO);
    }

    /**
     * 添加一条比赛信息
     * @param awardGameVO
     * @return
     */
    public boolean addAwardGame(AwardGameVO awardGameVO) {
        return awardInfoMapper.addAwardGame(awardGameVO);
    }

    /**
     * 根据比赛的名字查询比赛
     * @param name
     * @return
     */
    public List<AwardGameVO> findAwardGameByName(String name) {
        return awardInfoMapper.findAwardGameByName(name);
    }
}
