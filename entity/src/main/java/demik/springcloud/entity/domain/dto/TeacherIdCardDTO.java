package demik.springcloud.entity.domain.dto;

/**
 * Function:
 *
 * @author liubing
 * Date: 2019/4/12 1:38 PM
 * @since JDK 1.8
 */
public class TeacherIdCardDTO {
    private String idCard;

    public TeacherIdCardDTO() {
    }

    public TeacherIdCardDTO(String idCard) {
        this.idCard = idCard;
    }

    @Override
    public String toString() {
        return "TeacherIdCardDTO{" +
                "idCard='" + idCard + '\'' +
                '}';
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }
}
