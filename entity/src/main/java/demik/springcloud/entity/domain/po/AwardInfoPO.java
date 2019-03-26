package demik.springcloud.entity.domain.po;

import java.util.Date;

/**
 * Function:
 *
 * @author liubing
 * Date: 2019/3/18 9:16 PM
 * @since JDK 1.8
 */
public class AwardInfoPO {
//    /**
//     * 获奖信息的id
//     */
//    private Integer awardId;
    /**
     * 获奖老师的id
     */
    private Integer teacherId;
    /**
     * 获奖比赛的id 可以是null
     */
    private Integer awardGameId;
    /**
     * 获奖比赛的name
     */
    private String awardGameName;
    /**
     * 获奖等级的id
     */
    private Integer awardLevelId;
    /**
     * 获奖时间
     */
    private Date awardTime;
    /**
     * 类型 类型只能是1 已经存在的 2 其他
     */
    private Integer type;

    public AwardInfoPO() {
    }

    public AwardInfoPO(Integer teacherId, Integer awardGameId, String awardGameName, Integer awardLevelId, Date awardTime, Integer type) {
        this.teacherId = teacherId;
        this.awardGameId = awardGameId;
        this.awardGameName = awardGameName;
        this.awardLevelId = awardLevelId;
        this.awardTime = awardTime;
        this.type = type;
    }

    public Integer getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Integer teacherId) {
        this.teacherId = teacherId;
    }

    public Integer getAwardGameId() {
        return awardGameId;
    }

    public void setAwardGameId(Integer awardGameId) {
        this.awardGameId = awardGameId;
    }

    public String getAwardGameName() {
        return awardGameName;
    }

    public void setAwardGameName(String awardGameName) {
        this.awardGameName = awardGameName;
    }

    public Integer getAwardLevelId() {
        return awardLevelId;
    }

    public void setAwardLevelId(Integer awardLevelId) {
        this.awardLevelId = awardLevelId;
    }

    public Date getAwardTime() {
        return awardTime;
    }

    public void setAwardTime(Date awardTime) {
        this.awardTime = awardTime;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}
