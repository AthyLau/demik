package demik.springcloud.entity.domain.dto;

/**
 * Function:
 *
 * @author liubing
 * Date: 2019/3/24 2:19 AM
 * @since JDK 1.8
 */
public class TeacherInfoDTO {
    /**
     * 教师姓名
     */
    private String teacherName;
    /**
     * 教师身份证号
     */
    private String teacherIdCard;
    /**
     * 教师编号
     */
    private String teacherNumber;
    /**
     * 教师手机号
     */
    private String teacherPhone;
    /**
     * 教师入学时间
     */
    private String teacherEntranceTime;
    /**
     * 办公室id
     */
    private Integer officeId;
    /**
     * 学历id
     */
    private Integer educationBackgroudId;
    /**
     * 毕业学校id
     */
    private Integer schoolId;
    /**
     * 职位id
     */
    private Integer deptId;
    /**
     * 教材id
     */
    private Integer bookId;

    public TeacherInfoDTO() {
    }

    public TeacherInfoDTO(String teacherName, String teacherIdCard, String teacherNumber, String teacherPhone, String teacherEntranceTime, Integer officeId, Integer educationBackgroudId, Integer schoolId, Integer deptId, Integer bookId) {
        this.teacherName = teacherName;
        this.teacherIdCard = teacherIdCard;
        this.teacherNumber = teacherNumber;
        this.teacherPhone = teacherPhone;
        this.teacherEntranceTime = teacherEntranceTime;
        this.officeId = officeId;
        this.educationBackgroudId = educationBackgroudId;
        this.schoolId = schoolId;
        this.deptId = deptId;
        this.bookId = bookId;
    }

    @Override
    public String toString() {
        return "TeacherInfoDTO{" +
                "teacherName='" + teacherName + '\'' +
                ", teacherIdCard='" + teacherIdCard + '\'' +
                ", teacherNumber='" + teacherNumber + '\'' +
                ", teacherPhone='" + teacherPhone + '\'' +
                ", teacherEntranceTime='" + teacherEntranceTime + '\'' +
                ", officeId=" + officeId +
                ", educationBackgroudId=" + educationBackgroudId +
                ", schoolId=" + schoolId +
                ", deptId=" + deptId +
                ", bookId=" + bookId +
                '}';
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getTeacherIdCard() {
        return teacherIdCard;
    }

    public void setTeacherIdCard(String teacherIdCard) {
        this.teacherIdCard = teacherIdCard;
    }

    public String getTeacherNumber() {
        return teacherNumber;
    }

    public void setTeacherNumber(String teacherNumber) {
        this.teacherNumber = teacherNumber;
    }

    public String getTeacherPhone() {
        return teacherPhone;
    }

    public void setTeacherPhone(String teacherPhone) {
        this.teacherPhone = teacherPhone;
    }

    public String getTeacherEntranceTime() {
        return teacherEntranceTime;
    }

    public void setTeacherEntranceTime(String teacherEntranceTime) {
        this.teacherEntranceTime = teacherEntranceTime;
    }

    public Integer getOfficeId() {
        return officeId;
    }

    public void setOfficeId(Integer officeId) {
        this.officeId = officeId;
    }

    public Integer getEducationBackgroudId() {
        return educationBackgroudId;
    }

    public void setEducationBackgroudId(Integer educationBackgroudId) {
        this.educationBackgroudId = educationBackgroudId;
    }

    public Integer getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(Integer schoolId) {
        this.schoolId = schoolId;
    }

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }
}
