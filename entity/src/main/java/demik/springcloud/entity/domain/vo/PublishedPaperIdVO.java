package demik.springcloud.entity.domain.vo;

/**
 * Function:
 *
 * @author liubing
 * Date: 2019/4/1 4:26 PM
 * @since JDK 1.8
 */
public class PublishedPaperIdVO {
    private Integer id;

    public PublishedPaperIdVO() {
    }

    public PublishedPaperIdVO(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "PublishedPaperIdVO{" +
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
