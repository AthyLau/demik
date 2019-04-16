package demik.springcloud.entity.domain.dto;

/**
 * Function:
 *
 * @author liubing
 * Date: 2019/4/12 2:39 PM
 * @since JDK 1.8
 */
public class PaperNameDTO {
    private String paperName;

    public PaperNameDTO() {
    }

    public PaperNameDTO(String paperName) {
        this.paperName = paperName;
    }

    @Override
    public String toString() {
        return "PaperNameDTO{" +
                "paperName='" + paperName + '\'' +
                '}';
    }

    public String getPaperName() {
        return paperName;
    }

    public void setPaperName(String paperName) {
        this.paperName = paperName;
    }
}
