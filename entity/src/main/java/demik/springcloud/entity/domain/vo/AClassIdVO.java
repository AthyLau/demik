package demik.springcloud.entity.domain.vo;

/**
 * Function:
 *
 * @author liubing
 * Date: 2019/3/14 3:15 PM
 * @since JDK 1.8
 */
public class AClassIdVO {
    /**
     * 班级id
     */
    private Integer aclassId;

    public AClassIdVO() {
    }

    public AClassIdVO(Integer aclassId) {
        this.aclassId = aclassId;
    }

    @Override
    public String toString() {
        return "AClassIdVO{" +
                "aclassId=" + aclassId +
                '}';
    }

    public Integer getAclassId() {
        return aclassId;
    }

    public void setAclassId(Integer aclassId) {
        this.aclassId = aclassId;
    }
}
