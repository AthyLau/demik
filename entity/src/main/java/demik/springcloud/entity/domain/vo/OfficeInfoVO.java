package demik.springcloud.entity.domain.vo;

/**
 * Function:
 *
 * @author liubing
 * Date: 2019/3/15 11:20 PM
 * @since JDK 1.8
 */
public class OfficeInfoVO {
    /**
     * 教研室id
     */
    private Integer officeId;
    /**
     * 教研室名字
     */
    private String officeName;
    /**
     * 教研室地址
     */
    private String officeAddress;
    /**
     * 教研室电话
     */
    private String officePhone;

    public OfficeInfoVO() {
    }

    public OfficeInfoVO(Integer officeId, String officeName, String officeAddress, String officePhone) {
        this.officeId = officeId;
        this.officeName = officeName;
        this.officeAddress = officeAddress;
        this.officePhone = officePhone;
    }

    @Override
    public String toString() {
        return "OfficeInfoVO{" +
                "officeId=" + officeId +
                ", officeName='" + officeName + '\'' +
                ", officeAddress='" + officeAddress + '\'' +
                ", officePhone='" + officePhone + '\'' +
                '}';
    }

    public Integer getOfficeId() {
        return officeId;
    }

    public void setOfficeId(Integer officeId) {
        this.officeId = officeId;
    }

    public String getOfficeName() {
        return officeName;
    }

    public void setOfficeName(String officeName) {
        this.officeName = officeName;
    }

    public String getOfficeAddress() {
        return officeAddress;
    }

    public void setOfficeAddress(String officeAddress) {
        this.officeAddress = officeAddress;
    }

    public String getOfficePhone() {
        return officePhone;
    }

    public void setOfficePhone(String officePhone) {
        this.officePhone = officePhone;
    }
}
