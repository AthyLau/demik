package demik.springcloud.entity.domain.po;

/**
 * Function:
 *
 * @author liubing
 * Date: 2019/3/24 2:05 AM
 * @since JDK 1.8
 */
public class TeacherInfoPO {
    /**
     * 教师id
     */
    private Integer teacherId;
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
     * 办公室id
     */
    private String officeName;
    /**
     * 学历id
     */
    private Integer educationBackgroudId;
    /**
     * 学历id
     */
    private String educationBackgroudName;
    /**
     * 毕业学校id
     */
    private Integer schoolId;
    /**
     * 毕业学校id
     */
    private String schoolName;
    /**
     * 职位id
     */
    private Integer deptId;
    /**
     * 职位id
     */
    private String deptName;
    /**
     * 教材id
     */
    private Integer bookId;
    /**
     * 教材id
     */
    private String bookName;

    public TeacherInfoPO() {
    }

    public TeacherInfoPO(Integer teacherId, String teacherName, String teacherIdCard, String teacherNumber, String teacherPhone, String teacherEntranceTime, Integer officeId, String officeName, Integer educationBackgroudId, String educationBackgroudName, Integer schoolId, String schoolName, Integer deptId, String deptName, Integer bookId, String bookName) {
        this.teacherId = teacherId;
        this.teacherName = teacherName;
        this.teacherIdCard = teacherIdCard;
        this.teacherNumber = teacherNumber;
        this.teacherPhone = teacherPhone;
        this.teacherEntranceTime = teacherEntranceTime;
        this.officeId = officeId;
        this.officeName = officeName;
        this.educationBackgroudId = educationBackgroudId;
        this.educationBackgroudName = educationBackgroudName;
        this.schoolId = schoolId;
        this.schoolName = schoolName;
        this.deptId = deptId;
        this.deptName = deptName;
        this.bookId = bookId;
        this.bookName = bookName;
    }

    @Override
    public String toString() {
        return "TeacherInfoPO{" +
                "teacherId=" + teacherId +
                ", teacherName='" + teacherName + '\'' +
                ", teacherIdCard='" + teacherIdCard + '\'' +
                ", teacherNumber='" + teacherNumber + '\'' +
                ", teacherPhone='" + teacherPhone + '\'' +
                ", teacherEntranceTime='" + teacherEntranceTime + '\'' +
                ", officeId=" + officeId +
                ", officeName=" + officeName +
                ", educationBackgroudId=" + educationBackgroudId +
                ", educationBackgroudName=" + educationBackgroudName +
                ", schoolId=" + schoolId +
                ", schoolName=" + schoolName +
                ", deptId=" + deptId +
                ", deptName=" + deptName +
                ", bookId=" + bookId +
                ", bookName=" + bookName +
                '}';
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

    public String getOfficeName() {
        return officeName;
    }

    public void setOfficeName(String officeName) {
        this.officeName = officeName;
    }

    public Integer getEducationBackgroudId() {
        return educationBackgroudId;
    }

    public void setEducationBackgroudId(Integer educationBackgroudId) {
        this.educationBackgroudId = educationBackgroudId;
    }

    public String getEducationBackgroudName() {
        return educationBackgroudName;
    }

    public void setEducationBackgroudName(String educationBackgroudName) {
        this.educationBackgroudName = educationBackgroudName;
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

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }
}
