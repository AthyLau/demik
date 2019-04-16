package demik.springcloud.entity.domain.vo;

/**
 * Function:
 *
 * @author liubing
 * Date: 2019/4/1 4:37 PM
 * @since JDK 1.8
 */
public class TeacherWorkIdVO {
    private Integer id;

    public TeacherWorkIdVO() {
    }

    public TeacherWorkIdVO(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "TeacherWorkIdVO{" +
                "id=" + id +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
