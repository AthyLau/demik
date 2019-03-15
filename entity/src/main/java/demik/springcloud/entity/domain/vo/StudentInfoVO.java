package demik.springcloud.entity.domain.vo;

/**
 * Function:
 *
 * @author liubing
 * Date: 2019/3/14 5:09 PM
 * @since JDK 1.8
 */
public class StudentInfoVO {
    /**
     * id
     */
    private Integer studentId;
    /**
     *  学生姓名
     */
    private String studentName;
    /**
     * 学生学号
     */
    private String studentNumber;
    /**
     * 学生性别
     */
    private String studentSex;
    /**
     * 学生民族
     */
    private String studentNational;
    /**
     * 学生手机号
     */
    private String studentPhone;
    /**
     * 学生身份证号
     */
    private String studentIdCard;
    /**
     * 学生地址
     */
    private String studentAddress;
    /**
     * 学生邮箱
     */
    private String studentMail;
    /**
     * 班级id
     */
    private Integer aclassId;
    /**
     * 学生近况id
     */
    private Integer studentCaseId;

    public StudentInfoVO() {
    }

    public StudentInfoVO(Integer studentId, String studentName, String studentNumber, String studentSex, String studentNational, String studentPhone, String studentIdCard, String studentAddress, String studentMail, Integer aclassId, Integer studentCaseId) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.studentNumber = studentNumber;
        this.studentSex = studentSex;
        this.studentNational = studentNational;
        this.studentPhone = studentPhone;
        this.studentIdCard = studentIdCard;
        this.studentAddress = studentAddress;
        this.studentMail = studentMail;
        this.aclassId = aclassId;
        this.studentCaseId = studentCaseId;
    }

    @Override
    public String toString() {
        return "StudentInfoVO{" +
                "studentId=" + studentId +
                ", studentName='" + studentName + '\'' +
                ", studentNumber='" + studentNumber + '\'' +
                ", studentSex='" + studentSex + '\'' +
                ", studentNational='" + studentNational + '\'' +
                ", studentPhone='" + studentPhone + '\'' +
                ", studentIdCard='" + studentIdCard + '\'' +
                ", studentAddress='" + studentAddress + '\'' +
                ", studentMail='" + studentMail + '\'' +
                ", aclassId=" + aclassId +
                ", studentCaseId=" + studentCaseId +
                '}';
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
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

    public Integer getAclassId() {
        return aclassId;
    }

    public void setAclassId(Integer aclassId) {
        this.aclassId = aclassId;
    }

    public Integer getStudentCaseId() {
        return studentCaseId;
    }

    public void setStudentCaseId(Integer studentCaseId) {
        this.studentCaseId = studentCaseId;
    }
}
