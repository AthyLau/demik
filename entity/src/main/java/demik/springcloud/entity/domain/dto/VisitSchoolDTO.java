package demik.springcloud.entity.domain.dto;

import java.util.Date;

/**
 * Function:
 *
 * @author liubing
 * Date: 2019/3/24 12:59 AM
 * @since JDK 1.8
 */
public class VisitSchoolDTO {
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
    private Date visitTime;
    /**
     * 教师id
     */
    private Integer teacherId;
    /**
     * 类型 为1：下拉框选择已经存在的学校 2 手动输入学校
     */
    private Integer type;

    public VisitSchoolDTO() {
    }

    public VisitSchoolDTO(Integer schoolId, String schoolName, Date visitTime, Integer teacherId, Integer type) {
        this.schoolId = schoolId;
        this.schoolName = schoolName;
        this.visitTime = visitTime;
        this.teacherId = teacherId;
        this.type = type;
    }

    @Override
    public String toString() {
        return "VisitSchoolDTO{" +
                "schoolId=" + schoolId +
                ", schoolName=" + schoolName +
                ", visitTime=" + visitTime +
                ", teacherId=" + teacherId +
                ", type=" + type +
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

    public Date getVisitTime() {
        return visitTime;
    }

    public void setVisitTime(Date visitTime) {
        this.visitTime = visitTime;
    }

    public Integer getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Integer teacherId) {
        this.teacherId = teacherId;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}
