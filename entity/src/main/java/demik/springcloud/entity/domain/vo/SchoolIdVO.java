package demik.springcloud.entity.domain.vo;

/**
 * Function:
 *
 * @author liubing
 * Date: 2019/3/24 12:50 AM
 * @since JDK 1.8
 */
public class SchoolIdVO {
    /**
     * 学校id
     */
    private Integer schoolId;

    public SchoolIdVO() {
    }

    public SchoolIdVO(Integer schoolId) {
        this.schoolId = schoolId;
    }

    @Override
    public String toString() {
        return "SchoolIdVO{" +
                "schoolId=" + schoolId +
                '}';
    }

    public Integer getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(Integer schoolId) {
        this.schoolId = schoolId;
    }
}
