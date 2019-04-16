package demik.springcloud.entity.domain.dto;

import demik.springcloud.entity.utils.excelutils.IsNeed;

import java.util.Date;

/**
 * Function:
 *
 * @author liubing
 * Date: 2019/4/15 1:57 PM
 * @since JDK 1.8
 */
public class TeacherExcelDTO {
    /**
     * 序号
     */
    @IsNeed
    private Integer id;
    /**
     * 教师姓名
     */
    @IsNeed
    private String teacherName;
    /**
     * 教师性别
     */
    @IsNeed
    private String teacherSex;
    /**
     * 教师邮箱
     */
    @IsNeed
    private String teacherMail;
    /**
     * 教师身份证号
     */
    @IsNeed
    private String teacherIdCard;
    /**
     * 教师编号
     */
    @IsNeed
    private String teacherNumber;
    /**
     * 教师手机号
     */
    @IsNeed
    private String teacherPhone;
    /**
     * 办公室id
     */
    @IsNeed
    private Integer officeId;
    /**
     * 学历id
     */
    @IsNeed
    private Integer educationBackgroudId;
    /**
     * 毕业学校id
     */
    @IsNeed
    private String schoolName;
    /**
     * 职位id
     */
    @IsNeed
    private Integer deptId;
    /**
     * 教材id
     */
    @IsNeed
    private String bookName;
    /**
     * 用户名
     */
    @IsNeed
    private String userName;
    /**
     * 密码
     */
    @IsNeed
    private String password;
    /**
     * 是否上锁
     */
    @IsNeed
    private Boolean locked;

    public TeacherExcelDTO() {
    }

    public TeacherExcelDTO(Integer id, String teacherName, String teacherSex, String teacherMail, String teacherIdCard, String teacherNumber, String teacherPhone, Integer officeId, Integer educationBackgroudId, String schoolName, Integer deptId, String bookName, String userName, String password, Boolean locked) {
        this.id = id;
        this.teacherName = teacherName;
        this.teacherSex = teacherSex;
        this.teacherMail = teacherMail;
        this.teacherIdCard = teacherIdCard;
        this.teacherNumber = teacherNumber;
        this.teacherPhone = teacherPhone;
        this.officeId = officeId;
        this.educationBackgroudId = educationBackgroudId;
        this.schoolName = schoolName;
        this.deptId = deptId;
        this.bookName = bookName;
        this.userName = userName;
        this.password = password;
        this.locked = locked;
    }

    @Override
    public String toString() {
        return "TeacherExcelDTO{" +
                "id=" + id +
                ", teacherName='" + teacherName + '\'' +
                ", teacherSex='" + teacherSex + '\'' +
                ", teacherMail='" + teacherMail + '\'' +
                ", teacherIdCard='" + teacherIdCard + '\'' +
                ", teacherNumber='" + teacherNumber + '\'' +
                ", teacherPhone='" + teacherPhone + '\'' +
                ", officeId=" + officeId +
                ", educationBackgroudId=" + educationBackgroudId +
                ", schoolName='" + schoolName + '\'' +
                ", deptId=" + deptId +
                ", bookName=" + bookName +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", locked=" + locked +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getTeacherSex() {
        return teacherSex;
    }

    public void setTeacherSex(String teacherSex) {
        this.teacherSex = teacherSex;
    }

    public String getTeacherMail() {
        return teacherMail;
    }

    public void setTeacherMail(String teacherMail) {
        this.teacherMail = teacherMail;
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

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getLocked() {
        return locked;
    }

    public void setLocked(Boolean locked) {
        this.locked = locked;
    }
}
