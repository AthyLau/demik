package demik.springcloud.entity.domain.vo;

/**
 * Function:
 *
 * @author liubing
 * Date: 2019/3/18 7:50 PM
 * @since JDK 1.8
 */
public class AwardGameVO {
    /**
     * 比赛id
     */
    private Integer awardGameId;
    /**
     * 比赛名字
     */
    private String awardGameName;

    public AwardGameVO() {
    }

    public AwardGameVO(Integer awardGameId, String awardGameName) {
        this.awardGameId = awardGameId;
        this.awardGameName = awardGameName;
    }

    @Override
    public String toString() {
        return "AwardGameVO{" +
                "awardGameId=" + awardGameId +
                ", awardGameName='" + awardGameName + '\'' +
                '}';
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
}
