package demik.springcloud.entity.domain.vo;

/**
 * Function:根据学生id查找
 *
 * @author liubing
 * Date: 2019/3/14 2:28 PM
 * @since JDK 1.8
 */
public class StudentIdVO {
    /**
     * 学生id
     */
    private Integer studentId;

    public StudentIdVO() {
    }

    public StudentIdVO(Integer studentId) {
        this.studentId = studentId;
    }

    @Override
    public String toString() {
        return "StudentIdVO{" +
                "studentId=" + studentId +
                '}';
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }
}
