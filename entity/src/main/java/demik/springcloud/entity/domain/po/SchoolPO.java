package demik.springcloud.entity.domain.po;

/**
 * Function:
 *
 * @author liubing
 * Date: 2019/3/23 7:22 PM
 * @since JDK 1.8
 */
public class SchoolPO {
    /**
     * 学校id
     */
    private Integer schoolId;
    /**
     * 学校姓名
     */
    private String schoolName;

    public SchoolPO() {
    }

    public SchoolPO(Integer schoolId, String schoolName) {
        this.schoolId = schoolId;
        this.schoolName = schoolName;
    }

    @Override
    public String toString() {
        return "SchoolPO{" +
                "schoolId=" + schoolId +
                ", schoolName='" + schoolName + '\'' +
                '}';
    }

    public Integer getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(Integer schoolId) {
        this.schoolId = schoolId;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }
}
