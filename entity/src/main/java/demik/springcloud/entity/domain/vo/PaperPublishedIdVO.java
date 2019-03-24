package demik.springcloud.entity.domain.vo;

/**
 * Function:
 *
 * @author liubing
 * Date: 2019/3/20 2:27 PM
 * @since JDK 1.8
 */
public class PaperPublishedIdVO {
    /**
     * id
     */
    private Integer id;

    public PaperPublishedIdVO() {
    }

    public PaperPublishedIdVO(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "PaperPublishedIdVO{" +
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
