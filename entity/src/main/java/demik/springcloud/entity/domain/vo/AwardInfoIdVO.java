package demik.springcloud.entity.domain.vo;

/**
 * Function:
 *
 * @author liubing
 * Date: 2019/3/18 9:02 PM
 * @since JDK 1.8
 */
public class AwardInfoIdVO {
    /**
     * 获奖信息的id
     */
    private Integer awardInfoId;

    public AwardInfoIdVO() {
    }

    public AwardInfoIdVO(Integer awardInfoId) {
        this.awardInfoId = awardInfoId;
    }

    @Override
    public String toString() {
        return "AwardInfoIdVO{" +
                "awardInfoId=" + awardInfoId +
                '}';
    }

    public Integer getAwardInfoId() {
        return awardInfoId;
    }

    public void setAwardInfoId(Integer awardInfoId) {
        this.awardInfoId = awardInfoId;
    }
}
