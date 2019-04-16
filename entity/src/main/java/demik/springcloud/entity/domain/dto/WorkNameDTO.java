package demik.springcloud.entity.domain.dto;

/**
 * Function:
 *
 * @author liubing
 * Date: 2019/4/12 3:18 PM
 * @since JDK 1.8
 */
public class WorkNameDTO {
    private String workName;

    public WorkNameDTO() {
    }

    public WorkNameDTO(String workName) {
        this.workName = workName;
    }

    @Override
    public String toString() {
        return "WorkNameDTO{" +
                "workName='" + workName + '\'' +
                '}';
    }

    public String getWorkName() {
        return workName;
    }

    public void setWorkName(String workName) {
        this.workName = workName;
    }
}
