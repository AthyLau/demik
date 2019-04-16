package demik.springcloud.entity.domain.dto;

/**
 * Function:
 *
 * @author liubing
 * Date: 2019/4/12 1:25 PM
 * @since JDK 1.8
 */
public class TeacherNameDTO {
    private String teacherName;

    public TeacherNameDTO() {
    }

    public TeacherNameDTO(String teacherName) {
        this.teacherName = teacherName;
    }

    @Override
    public String toString() {
        return "TeacherNameDTO{" +
                "teacherName='" + teacherName + '\'' +
                '}';
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }
}
