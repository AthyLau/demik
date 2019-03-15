package demik.springcloud.entity.domain.dto;

import demik.springcloud.entity.domain.po.StudentInfoPO;
import demik.springcloud.entity.domain.vo.StudentInfoVO;

/**
 * Function:
 *
 * @author liubing
 * Date: 2019/3/14 5:18 PM
 * @since JDK 1.8
 */
public class StudentInfoDTO {
    /**
     * 学生信息
     */
    private StudentInfoPO studentInfoPO;
    /**
     * 班级信息年级信息专业信息
     */
    private AClassInfoDTO aClassInfoDTO;

    public StudentInfoDTO() {
    }

    public StudentInfoDTO(StudentInfoPO studentInfoPO, AClassInfoDTO aClassInfoDTO) {
        this.studentInfoPO = studentInfoPO;
        this.aClassInfoDTO = aClassInfoDTO;
    }

    @Override
    public String toString() {
        return "StudentInfoDTO{" +
                "studentInfoPO=" + studentInfoPO +
                ", aClassInfoDTO=" + aClassInfoDTO +
                '}';
    }

    public StudentInfoPO getStudentInfoPO() {
        return studentInfoPO;
    }

    public void setStudentInfoPO(StudentInfoPO studentInfoPO) {
        this.studentInfoPO = studentInfoPO;
    }

    public AClassInfoDTO getaClassInfoDTO() {
        return aClassInfoDTO;
    }

    public void setaClassInfoDTO(AClassInfoDTO aClassInfoDTO) {
        this.aClassInfoDTO = aClassInfoDTO;
    }
}
