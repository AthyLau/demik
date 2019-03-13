package demik.springcloud.entity.domain.pojo;

/**
 * Function: 自定义错误信息
 *
 * @author miluo
 * Date: 2018/11/13 5:58 PM
 * @since JDK 1.8
 */
public class FailException extends Exception {

    /**
     * 错误编码
     */
    private String errCode;


    /**
     * 错误消息
     */
    private String errMsg;


    public FailException() {
        super();
    }

    public FailException(String message) {
        super(message);
        this.errMsg = errMsg;
    }

    public FailException(String errCode, String errMsg) {
        super();
        this.errCode = errCode;
        this.errMsg = errMsg;
    }

    public String getErrCode() {
        return errCode;
    }

    public void setErrCode(String errCode) {
        this.errCode = errCode;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }
}
