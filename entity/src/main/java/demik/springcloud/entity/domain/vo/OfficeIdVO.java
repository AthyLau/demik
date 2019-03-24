package demik.springcloud.entity.domain.vo;

/**
 * Function:
 *
 * @author liubing
 * Date: 2019/3/15 11:27 PM
 * @since JDK 1.8
 */
public class OfficeIdVO {
    /**
     * 教研室id
     */
    private Integer officeId;

    public OfficeIdVO() {
    }

    public OfficeIdVO(Integer officeId) {
        this.officeId = officeId;
    }

    @Override
    public String toString() {
        return "OfficeIdVO{" +
                "officeId=" + officeId +
                '}';
    }

    public Integer getOfficeId() {
        return officeId;
    }

    public void setOfficeId(Integer officeId) {
        this.officeId = officeId;
    }
}
