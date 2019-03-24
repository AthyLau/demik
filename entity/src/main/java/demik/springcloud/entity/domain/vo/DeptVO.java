package demik.springcloud.entity.domain.vo;

/**
 * Function:
 *
 * @author liubing
 * Date: 2019/3/20 1:41 AM
 * @since JDK 1.8
 */
public class DeptVO {
    /**
     * 职称id
     */
    private Integer deptId;
    /**
     * 职称名字
     */
    private String deptName;

    public DeptVO() {
    }

    public DeptVO(Integer deptId, String deptName) {
        this.deptId = deptId;
        this.deptName = deptName;
    }

    @Override
    public String toString() {
        return "DeptVO{" +
                "deptId=" + deptId +
                ", deptName='" + deptName + '\'' +
                '}';
    }

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }
}
