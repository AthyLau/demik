package demik.springcloud.entity.domain.dto;

/**
 * Function:
 *
 * @author liubing
 * Date: 2019/3/20 2:35 PM
 * @since JDK 1.8
 */

public class PublishedPaperInfoDTO {
    /**
     * id
     */
    private Integer id;
    /**
     * 论文名字
     */
    private String paperName;
    /**
     * 论文类型名
     */
    private String paperTypeName;
    /**
     * 发布时间
     */
    private String publishedTime;

    /**
     * 教师姓名
     */
    private String teacherName;
    public PublishedPaperInfoDTO() {
    }

    public PublishedPaperInfoDTO(Integer id, String paperName, String paperTypeName, String publishedTime, String teacherName) {
        this.id = id;
        this.paperName = paperName;
        this.paperTypeName = paperTypeName;
        this.publishedTime = publishedTime;
        this.teacherName = teacherName;
    }

    @Override
    public String toString() {
        return "PublishedPaperInfoDTO{" +
                "id=" + id +
                ", paperName='" + paperName + '\'' +
                ", paperTypeName='" + paperTypeName + '\'' +
                ", publishedTime='" + publishedTime + '\'' +
                ", teacherName=" + teacherName +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getPublishedTime() {
        return publishedTime;
    }

    public void setPublishedTime(String publishedTime) {
        this.publishedTime = publishedTime;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }
}
