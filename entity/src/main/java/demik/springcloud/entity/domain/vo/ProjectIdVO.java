package demik.springcloud.entity.domain.vo;

/**
 * Function:
 *
 * @author liubing
 * Date: 2019/3/23 6:57 PM
 * @since JDK 1.8
 */
public class ProjectIdVO {
    private Integer id;

    public ProjectIdVO() {
    }

    public ProjectIdVO(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "ProjectIdVO{" +
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
