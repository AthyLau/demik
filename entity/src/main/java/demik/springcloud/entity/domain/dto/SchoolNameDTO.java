package demik.springcloud.entity.domain.dto;

import demik.springcloud.entity.domain.vo.SchoolIdVO;

/**
 * Function:
 *
 * @author liubing
 * Date: 2019/4/12 3:04 PM
 * @since JDK 1.8
 */
public class SchoolNameDTO {
    private String schoolName;

    public SchoolNameDTO() {
    }

    public SchoolNameDTO(String schoolName) {
        this.schoolName = schoolName;
    }

    @Override
    public String toString() {
        return "SchoolNameDTO{" +
                "schoolName=" + schoolName +
                '}';
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }
}
