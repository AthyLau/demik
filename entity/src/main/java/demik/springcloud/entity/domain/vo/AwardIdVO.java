package demik.springcloud.entity.domain.vo;

/**
 * Function:
 *
 * @author liubing
 * Date: 2019/3/26 2:44 PM
 * @since JDK 1.8
 */
public class AwardIdVO {
    /**
     * id
     */
    private Integer id;

    public AwardIdVO() {
    }

    public AwardIdVO(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "AwardIdVO{" +
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
