package cn.wyz.insternalcommon.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author wangnanxiang
 */
@Getter
@AllArgsConstructor
public enum CommonStatusEnum {

    /**
     * 成功
     */
    SUCCESS(200,"success"),
    /**
     * 失败
     */
    FAIL(500,"fail");

    private final int code;
    private final String message;
}
