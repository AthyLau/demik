package demik.springcloud.entity.domain.dto;

import demik.springcloud.entity.domain.vo.AClassInfoVO;
import demik.springcloud.entity.domain.vo.GradeInfoVO;
import demik.springcloud.entity.domain.vo.PerfessionalInfoVO;

/**
 * Function:
 *
 * @author liubing
 * Date: 2019/3/15 12:11 AM
 * @since JDK 1.8
 */
public class AClassInfoDTO {
    /**
     * 班级信息
     */
    private AClassInfoVO aClassInfoVO;
    /**
     * 专业信息
     */
    private PerfessionalInfoVO perfessionalInfoVO;
    /**
     * 年级信息
     */
    private GradeInfoVO gradeInfoVO;

    public AClassInfoDTO() {
    }

    public AClassInfoDTO(AClassInfoVO aClassInfoVO, PerfessionalInfoVO perfessionalInfoVO, GradeInfoVO gradeInfoVO) {
        this.aClassInfoVO = aClassInfoVO;
        this.perfessionalInfoVO = perfessionalInfoVO;
        this.gradeInfoVO = gradeInfoVO;
    }

    @Override
    public String toString() {
        return "AClassInfoDTO{" +
                "aClassInfoVO=" + aClassInfoVO +
                ", perfessionalInfoVO=" + perfessionalInfoVO +
                ", gradeInfoVO=" + gradeInfoVO +
                '}';
    }

    public AClassInfoVO getaClassInfoVO() {
        return aClassInfoVO;
    }

    public void setaClassInfoVO(AClassInfoVO aClassInfoVO) {
        this.aClassInfoVO = aClassInfoVO;
    }

    public PerfessionalInfoVO getPerfessionalInfoVO() {
        return perfessionalInfoVO;
    }

    public void setPerfessionalInfoVO(PerfessionalInfoVO perfessionalInfoVO) {
        this.perfessionalInfoVO = perfessionalInfoVO;
    }

    public GradeInfoVO getGradeInfoVO() {
        return gradeInfoVO;
    }

    public void setGradeInfoVO(GradeInfoVO gradeInfoVO) {
        this.gradeInfoVO = gradeInfoVO;
    }
}
