package demik.springcloud.entity.domain.vo;

/**
 * Function:
 *
 * @author liubing
 * Date: 2019/3/20 1:33 AM
 * @since JDK 1.8
 */
public class EducationBackgroudVO {
    /**
     * 教育背景的id
     */
    private Integer educationBackgroudId;
    /**
     * 教育背景的名称
     */
    private String educationBackgroudName;

    public EducationBackgroudVO(Integer educationBackgroudId, String educationBackgroudName) {
        this.educationBackgroudId = educationBackgroudId;
        this.educationBackgroudName = educationBackgroudName;
    }

    @Override
    public String toString() {
        return "EducationBackgroudVO{" +
                "educationBackgroudId=" + educationBackgroudId +
                ", educationBackgroudName='" + educationBackgroudName + '\'' +
                '}';
    }

    public Integer getEducationBackgroudId() {
        return educationBackgroudId;
    }

    public void setEducationBackgroudId(Integer educationBackgroudId) {
        this.educationBackgroudId = educationBackgroudId;
    }

    public String getEducationBackgroudName() {
        return educationBackgroudName;
    }

    public void setEducationBackgroudName(String educationBackgroudName) {
        this.educationBackgroudName = educationBackgroudName;
    }
}
