package demik.springcloud.entity.domain.vo;

/**
 * Function:
 *
 * @author liubing
 * Date: 2019/3/24 4:44 PM
 * @since JDK 1.8
 */
public class TeacherIdVO {
    /**
     * 教师id
     */
    private Integer teacherId;

    public TeacherIdVO() {
    }

    public TeacherIdVO(Integer teacherId) {
        this.teacherId = teacherId;
    }

    @Override
    public String toString() {
        return "TeacherIdVO{" +
                "teacherId=" + teacherId +
                '}';
    }

    public Integer getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Integer teacherId) {
        this.teacherId = teacherId;
    }
}
