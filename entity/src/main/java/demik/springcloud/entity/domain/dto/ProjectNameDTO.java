package demik.springcloud.entity.domain.dto;

/**
 * Function:
 *
 * @author liubing
 * Date: 2019/4/12 2:46 PM
 * @since JDK 1.8
 */
public class ProjectNameDTO {
    private String projectName;

    public ProjectNameDTO() {
    }

    public ProjectNameDTO(String projectName) {
        this.projectName = projectName;
    }

    @Override
    public String toString() {
        return "ProjectNameDTO{" +
                "projectName='" + projectName + '\'' +
                '}';
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }
}
