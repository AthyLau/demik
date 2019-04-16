package demik.springcloud.entity.utils.excelutils;

/**
 * Function:
 *
 * @author liubing
 * Date: 2019/4/14 3:25 AM
 * @since JDK 1.8
 */
public class StudentInfo {
    /**
     * 序号
     */
    @IsNeed
    private Integer id;
    /**
     *  学生姓名
     */
    @IsNeed
    private String studentName;
    /**
     * 学生学号
     */
    @IsNeed
    private String studentNumber;
    /**
     * 学生性别
     */
    @IsNeed
    private String studentSex;
    /**
     * 学生民族
     */
    @IsNeed
    private String studentNational;
    /**
     * 学生手机号
     */
    @IsNeed
    private String studentPhone;
    /**
     * 学生身份证号
     */
    @IsNeed
    private String studentIdCard;
    /**
     * 学生地址
     */
    @IsNeed
    private String studentAddress;
    /**
     * 学生邮箱
     */
    @IsNeed
    private String studentMail;
    /**
     * 班级名字
     */
    @IsNeed
    private String aclassId;
    /**
     * 学生近况
     */
    @IsNeed
    private String studentCaseDescription;
    @IsNeed
    private String userName;
    @IsNeed
    private String password;
    @IsNeed
    private String locked;
    public StudentInfo() {
    }

    public StudentInfo(Integer id, String studentName, String studentNumber, String studentSex, String studentNational, String studentPhone, String studentIdCard, String studentAddress, String studentMail, String aclassId, String studentCaseDescription, String userName, String password, String locked) {
        this.id = id;
        this.studentName = studentName;
        this.studentNumber = studentNumber;
        this.studentSex = studentSex;
        this.studentNational = studentNational;
        this.studentPhone = studentPhone;
        this.studentIdCard = studentIdCard;
        this.studentAddress = studentAddress;
        this.studentMail = studentMail;
        this.aclassId = aclassId;
        this.studentCaseDescription = studentCaseDescription;
        this.userName = userName;
        this.password = password;
        this.locked = locked;
    }

    @Override
    public String toString() {
        return "StudentInfo{" +
                "id=" + id +
                ", studentName='" + studentName + '\'' +
                ", studentNumber='" + studentNumber + '\'' +
                ", studentSex='" + studentSex + '\'' +
                ", studentNational='" + studentNational + '\'' +
                ", studentPhone='" + studentPhone + '\'' +
                ", studentIdCard='" + studentIdCard + '\'' +
                ", studentAddress='" + studentAddress + '\'' +
                ", studentMail='" + studentMail + '\'' +
                ", aclassId='" + aclassId + '\'' +
                ", studentCaseDescription='" + studentCaseDescription + '\'' +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", locked='" + locked + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(String studentNumber) {
        this.studentNumber = studentNumber;
    }

    public String getStudentSex() {
        return studentSex;
    }

    public void setStudentSex(String studentSex) {
        this.studentSex = studentSex;
    }

    public String getStudentNational() {
        return studentNational;
    }

    public void setStudentNational(String studentNational) {
        this.studentNational = studentNational;
    }

    public String getStudentPhone() {
        return studentPhone;
    }

    public void setStudentPhone(String studentPhone) {
        this.studentPhone = studentPhone;
    }

    public String getStudentIdCard() {
        return studentIdCard;
    }

    public void setStudentIdCard(String studentIdCard) {
        this.studentIdCard = studentIdCard;
    }

    public String getStudentAddress() {
        return studentAddress;
    }

    public void setStudentAddress(String studentAddress) {
        this.studentAddress = studentAddress;
    }

    public String getStudentMail() {
        return studentMail;
    }

    public void setStudentMail(String studentMail) {
        this.studentMail = studentMail;
    }

    public String getAclassId() {
        return aclassId;
    }

    public void setAclassId(String aclassId) {
        this.aclassId = aclassId;
    }

    public String getStudentCaseDescription() {
        return studentCaseDescription;
    }

    public void setStudentCaseDescription(String studentCaseDescription) {
        this.studentCaseDescription = studentCaseDescription;
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

    public String getLocked() {
        return locked;
    }

    public void setLocked(String locked) {
        this.locked = locked;
    }
}
