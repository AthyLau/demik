package demik.springcloud.entity.domain.po;

/**
 * Function:
 *
 * @author liubing
 * Date: 2019/3/22 8:33 PM
 * @since JDK 1.8
 */
public class ProjectInfoPO {
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

    public ProjectInfoPO() {
    }

    public ProjectInfoPO(Integer projectId, String projectName, Integer projectValue) {
        this.projectId = projectId;
        this.projectName = projectName;
        this.projectValue = projectValue;
    }

    @Override
    public String toString() {
        return "ProjectInfoPO{" +
                "projectId=" + projectId +
                ", projectName='" + projectName + '\'' +
                ", projectValue=" + projectValue +
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
}
