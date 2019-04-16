package demik.springcloud.entity.domain.vo;

/**
 * Function:
 *
 * @author liubing
 * Date: 2019/3/20 1:47 AM
 * @since JDK 1.8
 */
public class PaperInfoVO {
    /**
     * 论文id
     */
    private Integer paperId;
    /**
     * 论文名字
     */
    private String paperName;
    /**
     * 论文类型
     */
    private String paperTypeName;

    public PaperInfoVO() {
    }

    public PaperInfoVO(Integer paperId, String paperName, String paperTypeName) {
        this.paperId = paperId;
        this.paperName = paperName;
        this.paperTypeName = paperTypeName;
    }

    @Override
    public String toString() {
        return "PaperInfoVO{" +
                "paperId=" + paperId +
                ", paperName='" + paperName + '\'' +
                ", paperTypeName=" + paperTypeName +
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

    public String getPaperTypeName() {
        return paperTypeName;
    }

    public void setPaperTypeName(String paperTypeName) {
        this.paperTypeName = paperTypeName;
    }
}
