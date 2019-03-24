package demik.springcloud.entity.domain.po;

/**
 * Function:
 *
 * @author liubing
 * Date: 2019/3/24 12:40 AM
 * @since JDK 1.8
 */
public class VisitSchoolPO {
    /**
     * id
     */
    private Integer id;
    /**
     * 教师id
     */
    private Integer teacherId;
    /**
     * 教师名字
     */
    private String teacherName;
    /**
     * 学校id
     */
    private Integer schoolId;
    /**
     * 学校名字
     */
    private String schoolName;

    /**
     * 访学时间
     */
    private String visitTime;
    public VisitSchoolPO() {
    }

    public VisitSchoolPO(Integer id, Integer teacherId, String teacherName, Integer schoolId, String schoolName, String visitTime) {
        this.id = id;
        this.teacherId = teacherId;
        this.teacherName = teacherName;
        this.schoolId = schoolId;
        this.schoolName = schoolName;
        this.visitTime = visitTime;
    }

    @Override
    public String toString() {
        return "VisitSchoolPO{" +
                "id=" + id +
                ", teacherId=" + teacherId +
                ", teacherName='" + teacherName + '\'' +
                ", schoolId=" + schoolId +
                ", schoolName='" + schoolName + '\'' +
                ", visitTime='" + visitTime + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Integer teacherId) {
        this.teacherId = teacherId;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
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

    public String getVisitTime() {
        return visitTime;
    }

    public void setVisitTime(String visitTime) {
        this.visitTime = visitTime;
    }
}
