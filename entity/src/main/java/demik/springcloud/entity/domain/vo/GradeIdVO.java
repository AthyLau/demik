package demik.springcloud.entity.domain.vo;

/**
 * Function:
 *
 * @author liubing
 * Date: 2019/3/14 3:18 PM
 * @since JDK 1.8
 */
public class GradeIdVO {
    /**
     * 专业id
     */
    private Integer gradeId;

    public GradeIdVO() {
    }

    public GradeIdVO(Integer gradeId) {
        this.gradeId = gradeId;
    }

    @Override
    public String toString() {
        return "GradeIdVO{" +
                "gradeId=" + gradeId +
                '}';
    }

    public Integer getGradeId() {
        return gradeId;
    }

    public void setGradeId(Integer gradeId) {
        this.gradeId = gradeId;
    }
}
