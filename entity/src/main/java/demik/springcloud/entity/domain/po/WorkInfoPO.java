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
    private String workName;
    /**
     * 教师名字
     */
    private String teacherName;

    public WorkInfoPO() {
    }

    public WorkInfoPO(Integer id, String workName, String teacherName) {
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

    public String getWorkName() {
        return workName;
    }

    public void setWorkName(String workName) {
        this.workName = workName;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }
}
