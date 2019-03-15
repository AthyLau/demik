package demik.springcloud.entity.domain.vo;

/**
 * Function:
 *
 * @author liubing
 * Date: 2019/3/14 5:22 PM
 * @since JDK 1.8
 */
public class AClassInfoVO {
    /**
     * 班级id
     */
    private Integer aclassId;
    /**
     * 班级名字
     */
    private String aclassName;
    /**
     * 班级描述
     */
    private String aclassDescription;
    /**
     * 班级标语
     */
    private String aclassSlogan;
    /**
     * 年级id
     */
    private Integer gradeId;
    /**
     * 专业id
     */
    private Integer perfessionalId;

    public AClassInfoVO() {
    }

    @Override
    public String toString() {
        return "AClassInfoVO{" +
                "aclassId=" + aclassId +
                ", aclassName='" + aclassName + '\'' +
                ", aclassDescription='" + aclassDescription + '\'' +
                ", aclassSlogan='" + aclassSlogan + '\'' +
                ", gradeId=" + gradeId +
                ", perfessionalId=" + perfessionalId +
                '}';
    }

    public AClassInfoVO(Integer aclassId, String aclassName, String aclassDescription, String aclassSlogan, Integer gradeId, Integer perfessionalId) {
        this.aclassId = aclassId;
        this.aclassName = aclassName;
        this.aclassDescription = aclassDescription;
        this.aclassSlogan = aclassSlogan;
        this.gradeId = gradeId;
        this.perfessionalId = perfessionalId;
    }

    public Integer getAclassId() {
        return aclassId;
    }

    public void setAclassId(Integer aclassId) {
        this.aclassId = aclassId;
    }

    public String getAclassName() {
        return aclassName;
    }

    public void setAclassName(String aclassName) {
        this.aclassName = aclassName;
    }

    public String getAclassDescription() {
        return aclassDescription;
    }

    public void setAclassDescription(String aclassDescription) {
        this.aclassDescription = aclassDescription;
    }

    public String getAclassSlogan() {
        return aclassSlogan;
    }

    public void setAclassSlogan(String aclassSlogan) {
        this.aclassSlogan = aclassSlogan;
    }

    public Integer getGradeId() {
        return gradeId;
    }

    public void setGradeId(Integer gradeId) {
        this.gradeId = gradeId;
    }

    public Integer getPerfessionalId() {
        return perfessionalId;
    }

    public void setPerfessionalId(Integer perfessionalId) {
        this.perfessionalId = perfessionalId;
    }
}
