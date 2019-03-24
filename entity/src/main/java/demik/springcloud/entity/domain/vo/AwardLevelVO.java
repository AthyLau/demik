package demik.springcloud.entity.domain.vo;

/**
 * Function:
 *
 * @author liubing
 * Date: 2019/3/18 8:00 PM
 * @since JDK 1.8
 */
public class AwardLevelVO {
    /**
     * 奖级别id
     */
    private Integer awardLevelId;
    /**
     * 奖级别名称
     */
    private String awardLevelName;

    public AwardLevelVO() {
    }

    public AwardLevelVO(Integer awardLevelId, String awardLevelName) {
        this.awardLevelId = awardLevelId;
        this.awardLevelName = awardLevelName;
    }

    @Override
    public String toString() {
        return "AwardLevelVO{" +
                "awardLevelId=" + awardLevelId +
                ", awardLevelName='" + awardLevelName + '\'' +
                '}';
    }

    public Integer getAwardLevelId() {
        return awardLevelId;
    }

    public void setAwardLevelId(Integer awardLevelId) {
        this.awardLevelId = awardLevelId;
    }

    public String getAwardLevelName() {
        return awardLevelName;
    }

    public void setAwardLevelName(String awardLevelName) {
        this.awardLevelName = awardLevelName;
    }
}
