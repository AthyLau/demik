package demik.springcloud.entity.domain.vo;

/**
 * Function:
 *
 * @author liubing
 * Date: 2019/3/14 5:26 PM
 * @since JDK 1.8
 */
public class PerfessionalInfoVO {
    /**
     * 专业id
     */
    private Integer perfessionalId;
    /**
     * 专业名字
     */
    private String perfessionalName;
    /**
     * 专业描述
     */
    private String perfessionalDescription;
    /**
     * 专业标语
     */
    private String perfessionalSlogan;

    public PerfessionalInfoVO() {
    }

    public PerfessionalInfoVO(Integer perfessionalId, String perfessionalName, String perfessionalDescription, String perfessionalSlogan) {
        this.perfessionalId = perfessionalId;
        this.perfessionalName = perfessionalName;
        this.perfessionalDescription = perfessionalDescription;
        this.perfessionalSlogan = perfessionalSlogan;
    }

    @Override
    public String toString() {
        return "PerfessionalInfoVO{" +
                "perfessionalId=" + perfessionalId +
                ", perfessionalName='" + perfessionalName + '\'' +
                ", perfessionalDescription='" + perfessionalDescription + '\'' +
                ", perfessionalSlogan='" + perfessionalSlogan + '\'' +
                '}';
    }

    public Integer getPerfessionalId() {
        return perfessionalId;
    }

    public void setPerfessionalId(Integer perfessionalId) {
        this.perfessionalId = perfessionalId;
    }

    public String getPerfessionalName() {
        return perfessionalName;
    }

    public void setPerfessionalName(String perfessionalName) {
        this.perfessionalName = perfessionalName;
    }

    public String getPerfessionalDescription() {
        return perfessionalDescription;
    }

    public void setPerfessionalDescription(String perfessionalDescription) {
        this.perfessionalDescription = perfessionalDescription;
    }

    public String getPerfessionalSlogan() {
        return perfessionalSlogan;
    }

    public void setPerfessionalSlogan(String perfessionalSlogan) {
        this.perfessionalSlogan = perfessionalSlogan;
    }
}
