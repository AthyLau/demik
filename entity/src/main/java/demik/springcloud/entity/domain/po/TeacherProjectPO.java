package demik.springcloud.entity.domain.po;

/**
 * Function:
 *
 * @author liubing
 * Date: 2019/3/22 8:42 PM
 * @since JDK 1.8
 */
public class TeacherProjectPO {
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
     * 教师名字
     */
    private String teacherName;

    public TeacherProjectPO() {
    }

    public TeacherProjectPO(Integer projectId, String projectName, Integer projectValue, String teacherName) {
        this.projectId = projectId;
        this.projectName = projectName;
        this.projectValue = projectValue;
        this.teacherName = teacherName;
    }

    @Override
    public String toString() {
        return "TeacherProjectPO{" +
                "projectId=" + projectId +
                ", projectName='" + projectName + '\'' +
                ", projectValue=" + projectValue +
                ", teacherName='" + teacherName + '\'' +
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

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }
}
