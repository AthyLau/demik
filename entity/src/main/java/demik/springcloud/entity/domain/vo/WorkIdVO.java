package demik.springcloud.entity.domain.vo;

/**
 * Function:
 *
 * @author liubing
 * Date: 2019/3/26 3:05 PM
 * @since JDK 1.8
 */
public class WorkIdVO {
    private Integer workid;

    public WorkIdVO() {
    }

    public WorkIdVO(Integer workid) {
        this.workid = workid;
    }

    @Override
    public String toString() {
        return "WorkIdVO{" +
                "workid=" + workid +
                '}';
    }

    public Integer getWorkid() {
        return workid;
    }

    public void setWorkid(Integer workid) {
        this.workid = workid;
    }
}
