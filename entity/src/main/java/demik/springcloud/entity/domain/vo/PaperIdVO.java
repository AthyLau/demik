package demik.springcloud.entity.domain.vo;

/**
 * Function:
 *
 * @author liubing
 * Date: 2019/3/26 2:56 PM
 * @since JDK 1.8
 */
public class PaperIdVO {
    private Integer id;

    public PaperIdVO() {
    }

    public PaperIdVO(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "PaperIdVO{" +
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
