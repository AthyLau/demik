package demik.springcloud.entity.commonbox;

/**
 * Function: 响应码枚举，参考HTTP状态码的语义
 *
 * @author miluo
 * Date: 2018/9/5 上午10:39
 * @since JDK 1.8
 */
public enum ResultCode {
    //成功
    SUCCESS(2000, "Success"),
    //已获得许可
    YE_VERY(2001, "Ye Very"),
    //暂无数据
    NONE_DATA(2002, "None Data"),
    //Uploading
    UPLOADING(2003, "Uploading"),
    //失败
    FAIL(4000, "Fail"),
    //未认证（签名错误）
    UNAUTHORIZED(4001, "Unauthorized"),
    NOT_AUTH(4002, "Not Auth"),
    //接口不存在
    NOT_FOUND(4004, "Not Found"),
    //token失效
    TOKEN_TIMEOUT(4444, "Token TimeOut"),
    //未获得许可（没有权限）
    NO_AUTH(4445, "No Auth"),
    //认证造假（上传的假token） 或者token上传错误
    TOKEN_ERROR(4446, "Token Error"),
    //参数校验错误
    PARAM_VALID(4447, "Param Valid"),
    //HTTP消息不可读
    HTTP_MESSAGE_NOT_READABLE(4448, "HTTP Message Not Readable"),
    //文件上传出错
    FILE_UPLOAD_ERROR(4449, "File Upload Error"),
    //文件上传类型出错
    FILE_UPLOAD_TYPE_ERROR(4450, "File Type Error"),
    //暂无权限
    NO_PERMISSION(4451, "No Permission"),
    //用户信息异常
    USER_INFO_EXCEPTION(4552, "User Info Exception"),
    //读取地块信息错误
    GET_LAND_INFO_ERROR(4553, "Get Land Info Error"),
    // 文件不存在
    FILE_NOT_FOUND(4554, "File Not Found"),
    // 目录不为空
    DIRECTORY_NOT_EMPTY(4555, "Directory Not Empty"),
    // 不是文件
    NOT_FILE(4556, "Not a File"),
    // 不是目录
    NOT_DIRECTORY(4557, "Not a Directory"),
    // 文件已存在
    FILE_EXISTS(4558, "File Exists"),
    // 请求参数不完整
    PARAM_NOT_COMPLETE(4559, "Parameters Not Complete"),
    // 用户注册失败
    USER_REGISTER_FAIL(4560,"User Register Fail"),
    // 用户验证失败
    USER_VERIFY_FAIL(4561, "User Verify Fail"),
    // 登出失败
    LOGOUT_FAIL(4562,"Log Out Fail !") ,
    //事务异常
    TRANSCATION_EXCEPITON(4600,"Transaction exception"),
    //服务器内部错误
    INTERNAL_SERVER_ERROR(5000, "Internal Server Error"),

    //服务器响应异常错误
    RESPONSE_RESULT_ERROR(5005, "Response Result Error"),

    //没那么智能，分辨不出正相关还是负相关
    NOT_SMART_ENOUGH(6008, "Not Smart Enough");


    public int code;
    public String message;

    ResultCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
