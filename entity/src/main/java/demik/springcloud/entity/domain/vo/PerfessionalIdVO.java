package demik.springcloud.entity.domain.vo;

/**
 * Function:
 *
 * @author liubing
 * Date: 2019/3/14 3:17 PM
 * @since JDK 1.8
 */
public class PerfessionalIdVO {
    /**
     * 专业id
     */
    private Integer perfessionalId;

    public PerfessionalIdVO() {
    }

    public PerfessionalIdVO(Integer perfessionalId) {
        this.perfessionalId = perfessionalId;
    }

    @Override
    public String toString() {
        return "PerfessionalIdVO{" +
                "perfessionalId=" + perfessionalId +
                '}';
    }

    public Integer getPerfessionalId() {
        return perfessionalId;
    }

    public void setPerfessionalId(Integer perfessionalId) {
        this.perfessionalId = perfessionalId;
    }
}
