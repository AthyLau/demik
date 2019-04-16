package demik.springcloud.entity.domain.dto;

/**
 * Function:
 *
 * @author liubing
 * Date: 2019/4/12 1:58 PM
 * @since JDK 1.8
 */
public class PerfessionalNameDTO {
    private String perfessionalName;

    public PerfessionalNameDTO() {
    }

    public PerfessionalNameDTO(String perfessionalName) {
        this.perfessionalName = perfessionalName;
    }

    @Override
    public String toString() {
        return "PerfessionalNameDTO{" +
                "perfessionalName='" + perfessionalName + '\'' +
                '}';
    }

    public String getPerfessionalName() {
        return perfessionalName;
    }

    public void setPerfessionalName(String perfessionalName) {
        this.perfessionalName = perfessionalName;
    }
}
