package demik.springcloud.entity.domain.po;

/**
 * Function:
 *
 * @author liubing
 * Date: 2019/3/20 4:09 PM
 * @since JDK 1.8
 */
public class WorkPO {
    /**
     * 作品id
     */
    private Integer workId;
    /**
     * 作品名字
     */
    private String workName;

    public WorkPO() {
    }

    public WorkPO(Integer workId, String workName) {
        this.workId = workId;
        this.workName = workName;
    }

    @Override
    public String toString() {
        return "WorkPO{" +
                "workId=" + workId +
                ", workName='" + workName + '\'' +
                '}';
    }

    public Integer getWorkId() {
        return workId;
    }

    public void setWorkId(Integer workId) {
        this.workId = workId;
    }

    public String getWorkName() {
        return workName;
    }

    public void setWorkName(String workName) {
        this.workName = workName;
    }
}
