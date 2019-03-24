package demik.springcloud.entity.domain.vo;

/**
 * Function:
 *
 * @author liubing
 * Date: 2019/3/20 1:55 AM
 * @since JDK 1.8
 */
public class PaperOriginInfoVO {
    /**
     * 论文id
     */
    private Integer paperId;
    /**
     * 论文名子
     */
    private String paperName;
    /**
     * 论文类型id
     */
    private Integer paperTypeId;

    public PaperOriginInfoVO() {
    }

    public PaperOriginInfoVO(Integer paperId, String paperName, Integer paperTypeId) {
        this.paperId = paperId;
        this.paperName = paperName;
        this.paperTypeId = paperTypeId;
    }

    @Override
    public String toString() {
        return "PaperOriginInfoVO{" +
                "paperId=" + paperId +
                ", paperName='" + paperName + '\'' +
                ", paperTypeId=" + paperTypeId +
                '}';
    }

    public Integer getPaperId() {
        return paperId;
    }

    public void setPaperId(Integer paperId) {
        this.paperId = paperId;
    }

    public String getPaperName() {
        return paperName;
    }

    public void setPaperName(String paperName) {
        this.paperName = paperName;
    }

    public Integer getPaperTypeId() {
        return paperTypeId;
    }

    public void setPaperTypeId(Integer paperTypeId) {
        this.paperTypeId = paperTypeId;
    }
}
