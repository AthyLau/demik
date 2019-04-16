package demik.springcloud.entity.domain.vo;

/**
 * Function:
 *
 * @author liubing
 * Date: 2019/4/1 4:31 PM
 * @since JDK 1.8
 */
public class VisitSchoolIdVO {
    private Integer id;

    public VisitSchoolIdVO() {
    }

    public VisitSchoolIdVO(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "VisitSchoolIdVO{" +
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
