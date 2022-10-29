package cn.wyz.insternalcommon.bean;

import cn.wyz.insternalcommon.constant.CommonStatusEnum;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author wangnanxiang
 */
@Data
public class ResponseResult<T> {

    private int code;

    private String message;

    private T data;

    public static <T> ResponseResult<T> success() {
        ResponseResult<T> result = new ResponseResult<>();
        result.setCode(CommonStatusEnum.SUCCESS.getCode());
        result.setMessage(CommonStatusEnum.SUCCESS.getMessage());

        return result;
    }

    public static <T> ResponseResult<T> success(T data) {
        ResponseResult<T> result = new ResponseResult<>();
        result.setCode(CommonStatusEnum.SUCCESS.getCode());
        result.setMessage(CommonStatusEnum.SUCCESS.getMessage());
        result.setData(data);

        return result;
    }

    public static ResponseResult<?> fail(int code, String message) {
        ResponseResult<?> result = new ResponseResult<>();
        result.setCode(CommonStatusEnum.FAIL.getCode());
        result.setMessage(CommonStatusEnum.FAIL.getMessage());

        return result;
    }

    public static <T> ResponseResult<T> fail(T data) {
        ResponseResult<T> result = new ResponseResult<>();
        result.setCode(CommonStatusEnum.FAIL.getCode());
        result.setMessage(CommonStatusEnum.FAIL.getMessage());
        result.setData(data);

        return result;
    }

    public static <T> ResponseResult<T> fail(int code, String message, T data) {
        ResponseResult<T> result = new ResponseResult<>();
        result.setCode(code);
        result.setMessage(message);
        result.setData(data);

        return result;
    }
}
