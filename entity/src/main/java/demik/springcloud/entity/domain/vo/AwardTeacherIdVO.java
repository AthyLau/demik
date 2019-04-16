package demik.springcloud.entity.domain.vo;

/**
 * Function:
 *
 * @author liubing
 * Date: 2019/4/1 4:22 PM
 * @since JDK 1.8
 */
public class AwardTeacherIdVO {
    private Integer id;

    public AwardTeacherIdVO() {
    }

    public AwardTeacherIdVO(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "AwardTeacherIdVO{" +
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
