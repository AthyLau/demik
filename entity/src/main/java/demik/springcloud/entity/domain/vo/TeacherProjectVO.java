package demik.springcloud.entity.domain.vo;

/**
 * Function:
 *
 * @author liubing
 * Date: 2019/3/23 1:33 PM
 * @since JDK 1.8
 */
public class TeacherProjectVO {
    /**
     * 项目id
     */
    private Integer projectId;
    /**
     * 项目名字
     */
    private String projectName;
    /**
     * 项目价值
     */
    private Integer projectValue;
    /**
     * 教师id
     */
    private Integer teacherId;
    /**
     * 类型
     */
    private Integer type;

    public TeacherProjectVO() {
    }

    public TeacherProjectVO(Integer projectId, String projectName, Integer projectValue, Integer teacherId, Integer type) {
        this.projectId = projectId;
        this.projectName = projectName;
        this.projectValue = projectValue;
        this.teacherId = teacherId;
        this.type = type;
    }

    @Override
    public String toString() {
        return "TeacherProjectVO{" +
                "projectId=" + projectId +
                ", projectName='" + projectName + '\'' +
                ", projectValue=" + projectValue +
                ", teacherId=" + teacherId +
                ", type=" + type +
                '}';
    }

    public Integer getProjectId() {
        return projectId;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public Integer getProjectValue() {
        return projectValue;
    }

    public void setProjectValue(Integer projectValue) {
        this.projectValue = projectValue;
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
