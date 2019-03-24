package demik.springcloud.teachermanagementsystem8001.service;

import demik.springcloud.entity.domain.po.AwardInfoPO;
import demik.springcloud.entity.domain.vo.AwardGameVO;
import demik.springcloud.entity.domain.vo.AwardInfoVO;
import demik.springcloud.entity.domain.vo.AwardLevelVO;
import demik.springcloud.teachermanagementsystem8001.manager.AwardInfoManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Function:
 *
 * @author liubing
 * Date: 2019/3/18 7:48 PM
 * @since JDK 1.8
 */
@Service
public class AwardInfoService {
    @Autowired
    private AwardInfoManager awardInfoManager;
    /**
     * 查询所有的比赛
     * @return
     */
    public List<AwardGameVO> findAllAwardGame() {
        return awardInfoManager.findAllAwardGame();
    }

    /**
     * 查询所有的奖级别
     * @return
     */
    public List<AwardLevelVO> findAllAwardLevel() {
        return awardInfoManager.findAllAwardLevel();
    }

    /**
     * 查询所有的教师获奖记录
     * @return
     */
    public List<AwardInfoVO> findAllAwardInfo() {
        return awardInfoManager.findAllAwardInfo();
    }

    /**
     * 删除一条教师获奖信息
     * @return
     */
    public boolean deleteAwardInfoById(Integer id) {
        return awardInfoManager.deleteAwardInfoById(id);
    }

    /**
     * 添加一条教师获奖信息
     * @param awardInfoPO
     * @return
     */
    public boolean addAwardInfo(AwardInfoPO awardInfoPO) {
        return awardInfoManager.addAwardInfo(awardInfoPO);
    }
    /**
     * 根据比赛的名字查询比赛的ID
     * @return
     */
    public Integer findAwardGameByName(String name){
        List<AwardGameVO> gameVOS = awardInfoManager.findAwardGameByName(name);
        if(gameVOS!=null&&gameVOS.size()>0){
            return gameVOS.get(0).getAwardGameId();
        }
        return null;
    }

    /**
     * 添加一条比赛信息
     * @param awardGameVO
     * @return
     */
    public boolean addAwardGame(AwardGameVO awardGameVO) {
        return awardInfoManager.addAwardGame(awardGameVO);
    }
}
