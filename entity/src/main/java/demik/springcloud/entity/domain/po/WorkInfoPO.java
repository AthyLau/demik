package demik.springcloud.entity.domain.po;

/**
 * Function:
 *
 * @author liubing
 * Date: 2019/3/20 3:54 PM
 * @since JDK 1.8
 */
public class WorkInfoPO {
    /**
     * id
     */
    private Integer id;
    /**
     * 作品名字
     */
    private Integer workName;
    /**
     * 教师名字
     */
    private Integer teacherName;

    public WorkInfoPO() {
    }

    public WorkInfoPO(Integer id, Integer workName, Integer teacherName) {
        this.id = id;
        this.workName = workName;
        this.teacherName = teacherName;
    }

    @Override
    public String toString() {
        return "WorkInfoPO{" +
                "id=" + id +
                ", workName=" + workName +
                ", teacherName=" + teacherName +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getWorkName() {
        return workName;
    }

    public void setWorkName(Integer workName) {
        this.workName = workName;
    }

    public Integer getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(Integer teacherName) {
        this.teacherName = teacherName;
    }
}
