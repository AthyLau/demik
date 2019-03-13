package demik.springcloud.entity.commonbox;


/**
 * Function: 响应结果生成工具
 *
 * @author miluo
 * Date: 2018/9/5 上午10:41
 * @since JDK 1.8
 */
public class ResultGenerator {
    private static final String DEFAULT_SUCCESS_MESSAGE = "Success";

    /**
     * 成功时返回的数据结构
     *
     * @return 结果
     */
    public static Result genSuccessResult() {
        return new Result()
                .setCode(ResultCode.SUCCESS)
                .setMessage(DEFAULT_SUCCESS_MESSAGE);
    }

    /**
     * 成功时返回的数据结构
     *
     * @param data 可传入时间作为消息值
     * @return 结果
     */
    public static<T> Result<T> genSuccessResult(T data) {
        return new Result<T>()
                .setCode(ResultCode.SUCCESS)
                .setMessage(DEFAULT_SUCCESS_MESSAGE)
                .setData(data);
    }

    /**
     * 成功时返回的数据结构
     *
     * @return 结果
     */
    public static Result genSuccessResult(ResultCode resultCode) {
        if (resultCode == null) {
            resultCode = ResultCode.NONE_DATA;
        }
        return new Result()
                .setCode(resultCode.getCode())
                .setMessage(resultCode.getMessage());
    }

    /**
     * 失败时返回的数据结构
     *
     * @param message 失败的原因
     * @return 结果
     */
    public static Result genFailResult(String message) {
        return new Result()
                .setCode(ResultCode.FAIL)
                .setMessage(message);
    }

    /**
     * 失败时返回的数据结构
     *
     * @param message 失败的原因
     * @return 结果
     */
    public static Result genFailResult(ResultCode resultCode, String message) {
        return new Result()
                .setCode(resultCode)
                .setMessage(message);
    }


    /**
     * 中立参数，有些值介于对和错之间
     *
     * @param resultCode 状态码 需要指定枚举值
     * @param message    要发送的消息
     * @return 结果集
     */
    public static Result genNeutralResult(ResultCode resultCode, String message) {
        return new Result()
                .setCode(resultCode)
                .setMessage(message);
    }

    /**
     * 中立参数，有些值介于对和错之间
     *
     * @param resultCode 状态码 要发送的消息参数
     * @return 结果集
     */
    public static Result genNeutralResult(ResultCode resultCode) {
        return new Result()
                .setCode(resultCode.getCode())
                .setMessage(resultCode.getMessage());
    }


    /**
     * 中立参数，有些值介于对和错之间
     *
     * @param resultCode 状态码
     * @param message    要发送的消息
     * @return 结果集
     */
    public static Result genNeutralResult(int resultCode, String message) {
        return new Result()
                .setCode(resultCode)
                .setMessage(message);
    }

    /**
     * 中立参数，有些值介于对和错之间
     *
     * @param resultCode 状态码
     * @param message    要发送的消息
     * @return 结果集
     */
    public static<T> Result<T> genNeutralResult(int resultCode, String message, T data) {
        return new Result<T>()
                .setCode(resultCode)
                .setMessage(message)
                .setData(data);
    }

    /**
     * 中立参数，有些值介于对和错之间
     *
     * @param resultCode
     * @param data
     * @return
     */
    public static<T> Result<T> genNeutralResult(ResultCode resultCode, T data) {
        return new Result<T>()
                .setCode(resultCode.getCode())
                .setMessage(resultCode.getMessage())
                .setData(data);
    }

}
