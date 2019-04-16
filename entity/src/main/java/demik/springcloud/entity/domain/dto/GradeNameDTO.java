package demik.springcloud.entity.domain.dto;

/**
 * Function:
 *
 * @author liubing
 * Date: 2019/4/12 1:55 PM
 * @since JDK 1.8
 */
public class GradeNameDTO {
    private String gradeName;

    public GradeNameDTO() {
    }

    public GradeNameDTO(String gradeName) {
        this.gradeName = gradeName;
    }

    @Override
    public String toString() {
        return "GradeNameDTO{" +
                "gradeName='" + gradeName + '\'' +
                '}';
    }

    public String getGradeName() {
        return gradeName;
    }

    public void setGradeName(String gradeName) {
        this.gradeName = gradeName;
    }
}
