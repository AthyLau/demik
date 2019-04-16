package demik.springcloud.entity.domain.dto;

/**
 * Function:
 *
 * @author liubing
 * Date: 2019/4/12 1:47 PM
 * @since JDK 1.8
 */
public class AClassNameDTO {
    private String AClassName;

    public AClassNameDTO() {
    }

    public AClassNameDTO(String AClassName) {
        this.AClassName = AClassName;
    }

    @Override
    public String toString() {
        return "AClassNameDTO{" +
                "AClassName='" + AClassName + '\'' +
                '}';
    }

    public String getAClassName() {
        return AClassName;
    }

    public void setAClassName(String AClassName) {
        this.AClassName = AClassName;
    }
}
