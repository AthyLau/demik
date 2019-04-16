package demik.springcloud.entity.domain.vo;

/**
 * Function:
 *
 * @author liubing
 * Date: 2019/3/18 8:47 PM
 * @since JDK 1.8
 */
public class AwardInfoVO {
    /**
     * 奖项id
     */
    private Integer awardId;
    /**
     * 教师
     */
    private Integer teacherName;
    /**
     * 获奖比赛
     */
    private String awardGameName;
    /**
     * 获奖比赛的等级
     */
    private String awardLevelName;
    /**
     * 获奖时间
     */
    private String awardTime;

    public AwardInfoVO() {
    }

    public AwardInfoVO(Integer awardId, Integer teacherName, String awardGameName, String awardLevelName, String awardTime) {
        this.awardId = awardId;
        this.teacherName = teacherName;
        this.awardGameName = awardGameName;
        this.awardLevelName = awardLevelName;
        this.awardTime = awardTime;
    }

    @Override
    public String toString() {
        return "AwardInfoVO{" +
                "awardId=" + awardId +
                ", teacherName=" + teacherName +
                ", awardGameName=" + awardGameName +
                ", awardLevelName=" + awardLevelName +
                ", awardTime='" + awardTime + '\'' +
                '}';
    }

    public Integer getAwardId() {
        return awardId;
    }

    public void setAwardId(Integer awardId) {
        this.awardId = awardId;
    }

    public Integer getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(Integer teacherName) {
        this.teacherName = teacherName;
    }

    public String getAwardGameName() {
        return awardGameName;
    }

    public void setAwardGameName(String awardGameName) {
        this.awardGameName = awardGameName;
    }

    public String getAwardLevelName() {
        return awardLevelName;
    }

    public void setAwardLevelName(String awardLevelName) {
        this.awardLevelName = awardLevelName;
    }

    public String getAwardTime() {
        return awardTime;
    }

    public void setAwardTime(String awardTime) {
        this.awardTime = awardTime;
    }
}
