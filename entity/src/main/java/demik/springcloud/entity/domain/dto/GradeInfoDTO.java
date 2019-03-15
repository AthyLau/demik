package demik.springcloud.entity.domain.dto;

/**
 * Function:
 *
 * @author liubing
 * Date: 2019/3/14 3:26 PM
 * @since JDK 1.8
 */
public class GradeInfoDTO {
    /**
     * 班级id
     */
    private Integer gradeId;
    /**
     * 班级姓名
     */
    private String gradeName;
    /**
     * 班级描述
     */
    private String gradeDescription;
    /**
     * 班级标语
     */
    private String gradeSlogan;

    public GradeInfoDTO() {
    }

    public GradeInfoDTO(Integer gradeId, String gradeName, String gradeDescription, String gradeSlogan) {
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
