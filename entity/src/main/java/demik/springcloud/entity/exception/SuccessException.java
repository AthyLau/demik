package demik.springcloud.entity.exception;


import demik.springcloud.entity.commonbox.ResultCode;

/**
 * Function: 成功但没有数据返回异常
 *
 * @author miluo
 * Date: 2018/11/13 6:19 PM
 * @since JDK 1.8
 */
public class SuccessException extends Exception {

    /**
     * 错误编码
     */
    private String errCode;


    /**
     * 错误消息
     */
    private String errMsg;

    /**
     * 返回值对象
     */
    private ResultCode resultCode;


    public SuccessException() {
        super();
    }

    public SuccessException(String message) {
        super(message);
        this.errMsg = errMsg;
    }

    public SuccessException(ResultCode resultCode) {
        super();
        this.resultCode=resultCode;
    }

//    public SuccessException(String errCode, String errMsg) {
//        super();
//        this.errCode = errCode;
//        this.errMsg = errMsg;
//    }

    public ResultCode getResultCode() {
        return resultCode;
    }

    public void setResultCode(ResultCode resultCode) {
        this.resultCode = resultCode;
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
