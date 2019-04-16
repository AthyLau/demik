package demik.springcloud.entity.domain.dto;

/**
 * Function:
 *
 * @author liubing
 * Date: 2019/4/11 8:31 PM
 * @since JDK 1.8
 */
public class StudentNameDTO {
    private String studentName;

    public StudentNameDTO() {
    }

    public StudentNameDTO(String studentName) {
        this.studentName = studentName;
    }

    @Override
    public String toString() {
        return "StudentNameDTO{" +
                "studentName='" + studentName + '\'' +
                '}';
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }
}
