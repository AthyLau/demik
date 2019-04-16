package demik.springcloud.entity.domain.dto;

/**
 * Function:
 *
 * @author liubing
 * Date: 2019/4/11 8:24 PM
 * @since JDK 1.8
 */
public class StudentIdCardNumberDTO {
    private String idCardNum;

    public StudentIdCardNumberDTO() {
    }

    public StudentIdCardNumberDTO(String idCardNum) {
        this.idCardNum = idCardNum;
    }

    @Override
    public String toString() {
        return "StudentIdCardNumberDTO{" +
                "idCardNum='" + idCardNum + '\'' +
                '}';
    }

    public String getIdCardNum() {
        return idCardNum;
    }

    public void setIdCardNum(String idCardNum) {
        this.idCardNum = idCardNum;
    }
}
