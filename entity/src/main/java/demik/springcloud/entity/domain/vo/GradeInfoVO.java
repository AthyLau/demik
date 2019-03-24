package demik.springcloud.entity.domain.vo;

/**
 * Function:
 *
 * @author liubing
 * Date: 2019/3/14 3:22 PM
 * @since JDK 1.8
 */
public class GradeInfoVO {
    /**
     * 年级id
     */
    private Integer gradeId;
    /**
     * 年级姓名
     */
    private String gradeName;
    /**
     * 年级描述
     */
    private String gradeDescription;
    /**
     * 年级标语
     */
    private String gradeSlogan;

    public GradeInfoVO() {
    }

    public GradeInfoVO(Integer gradeId, String gradeName, String gradeDescription, String gradeSlogan) {
        this.gradeId = gradeId;
        this.gradeName = gradeName;
        this.gradeDescription = gradeDescription;
        this.gradeSlogan = gradeSlogan;
    }

    @Override
    public String toString() {
        return "GradeInfoVO{" +
                "gradeId=" + gradeId +
                ", gradeName='" + gradeName + '\'' +
                ", gradeDescription='" + gradeDescription + '\'' +
                ", gradeSlogan='" + gradeSlogan + '\'' +
                '}';
    }

    public Integer getGradeId() {
        return gradeId;
    }

    public void setGradeId(Integer gradeId) {
        this.gradeId = gradeId;
    }

    public String getGradeName() {
        return gradeName;
    }

    public void setGradeName(String gradeName) {
        this.gradeName = gradeName;
    }

    public String getGradeDescription() {
        return gradeDescription;
    }

    public void setGradeDescription(String gradeDescription) {
        this.gradeDescription = gradeDescription;
    }

    public String getGradeSlogan() {
        return gradeSlogan;
    }

    public void setGradeSlogan(String gradeSlogan) {
        this.gradeSlogan = gradeSlogan;
    }
}
