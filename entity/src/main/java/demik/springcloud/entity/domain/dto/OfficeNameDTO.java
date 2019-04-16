package demik.springcloud.entity.domain.dto;

/**
 * Function:
 *
 * @author liubing
 * Date: 2019/4/12 2:22 PM
 * @since JDK 1.8
 */
public class OfficeNameDTO {
    private String officeName;

    public OfficeNameDTO() {
    }

    public OfficeNameDTO(String officeName) {
        this.officeName = officeName;
    }

    @Override
    public String toString() {
        return "OfficeNameDTO{" +
                "officeName='" + officeName + '\'' +
                '}';
    }

    public String getOfficeName() {
        return officeName;
    }

    public void setOfficeName(String officeName) {
        this.officeName = officeName;
    }
}
