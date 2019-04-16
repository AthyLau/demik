package demik.springcloud.entity.domain.po;

/**
 * Function:
 *
 * @author liubing
 * Date: 2019/3/20 2:46 PM
 * @since JDK 1.8
 */
public class PaperPublishedPO {
    /**
     * 论文id 可以为空
     */
    private Integer paperId;
    /**
     * 论文名字 可以为空
     */
    private String paperName;
    /**
     * 论文类型 可以为空
     */
    private Integer paperTypeId;
    /**
     * 教师id
     */
    private Integer teacherId;

    /**
     * 类型
     */
    private Integer type;
    public PaperPublishedPO() {
    }

    public PaperPublishedPO(Integer paperId, String paperName, Integer paperTypeId, Integer teacherId, Integer type) {
        this.paperId = paperId;
        this.paperName = paperName;
        this.paperTypeId = paperTypeId;
        this.teacherId = teacherId;
        this.type = type;
    }

    @Override
    public String toString() {
        return "PaperPublishedPO{" +
                "paperId=" + paperId +
                ", paperName='" + paperName + '\'' +
                ", paperTypeId=" + paperTypeId +
                ", teacherId='" + teacherId + '\'' +
                ", type=" + type +
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

    public Integer getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Integer teacherId) {
        this.teacherId = teacherId;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}
