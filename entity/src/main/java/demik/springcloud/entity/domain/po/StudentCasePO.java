package demik.springcloud.entity.domain.po;

/**
 * Function:
 *
 * @author liubing
 * Date: 2019/3/15 2:12 PM
 * @since JDK 1.8
 */
public class StudentCasePO {
    /**
     * 学生近况id
     */
    private Integer studentCaseId;
    /**
     * 学生近况描述
     */
    private String studentCaseDescription;

    public StudentCasePO() {
    }

    public StudentCasePO(Integer studentCaseId, String studentCaseDescription) {
        this.studentCaseId = studentCaseId;
        this.studentCaseDescription = studentCaseDescription;
    }

    @Override
    public String toString() {
        return "StudentCasePO{" +
                "studentCaseId=" + studentCaseId +
                ", studentCaseDescription='" + studentCaseDescription + '\'' +
                '}';
    }

    public Integer getStudentCaseId() {
        return studentCaseId;
    }

    public void setStudentCaseId(Integer studentCaseId) {
        this.studentCaseId = studentCaseId;
    }

    public String getStudentCaseDescription() {
        return studentCaseDescription;
    }

    public void setStudentCaseDescription(String studentCaseDescription) {
        this.studentCaseDescription = studentCaseDescription;
    }
}
