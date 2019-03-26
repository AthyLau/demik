package demik.springcloud.entity.domain.vo;

/**
 * Function:
 *
 * @author liubing
 * Date: 2019/3/26 2:48 PM
 * @since JDK 1.8
 */
public class OtherIdVO {
    /**
     * id
     */
    private Integer id;

    public OtherIdVO() {
    }

    public OtherIdVO(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "OtherIdVO{" +
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
