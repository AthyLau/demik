package demik.springcloud.entity.domain.po;

/**
 * Function:
 *
 * @author liubing
 * Date: 2019/3/20 2:01 AM
 * @since JDK 1.8
 */
public class PaperTypePO {
    /**
     * 论文类型id
     */
    private Integer paperTypeId;
    /**
     * 论文类型名字
     */
    private String paperTypeName;

    public PaperTypePO() {
    }

    public PaperTypePO(Integer paperTypeId, String paperTypeName) {
        this.paperTypeId = paperTypeId;
        this.paperTypeName = paperTypeName;
    }

    public Integer getPaperTypeId() {
        return paperTypeId;
    }

    public void setPaperTypeId(Integer paperTypeId) {
        this.paperTypeId = paperTypeId;
    }

    public String getPaperTypeName() {
        return paperTypeName;
    }

    public void setPaperTypeName(String paperTypeName) {
        this.paperTypeName = paperTypeName;
    }

    @Override
    public String toString() {
        return "PaperTypePO{" +
                "paperTypeId=" + paperTypeId +
                ", paperTypeName='" + paperTypeName + '\'' +
                '}';
    }
}
