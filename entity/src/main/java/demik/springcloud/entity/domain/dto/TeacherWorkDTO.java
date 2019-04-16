package demik.springcloud.entity.domain.dto;

/**
 * Function:
 *
 * @author liubing
 * Date: 2019/3/22 7:25 PM
 * @since JDK 1.8
 */
public class TeacherWorkDTO {
    //如果前端要传入类型为1的话就是选择的已经存在的work如果是2的话就是手动输入work
    /**
     * 作品id（可以是null）work_id   _i = I
     */
    private Integer workId;
    /**
     * 作品名字（可以是null）
     */
    private String workName;
    /**
     * 教师id
     */
    private Integer teacherId;
    /**
     * 类型 为 下拉框选择已经存在的work还是手动输入work
     */
    private Integer type;//只能是1或者2

    public TeacherWorkDTO() {
    }

    public TeacherWorkDTO(Integer workId, String workName, Integer teacherId, Integer type) {
        this.workId = workId;
        this.workName = workName;
        this.teacherId = teacherId;
        this.type = type;
    }

    public Integer getWorkId() {
        return workId;
    }

    public void setWorkId(Integer workId) {
        this.workId = workId;
    }

    public String getWorkName() {
        return workName;
    }

    public void setWorkName(String workName) {
        this.workName = workName;
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
