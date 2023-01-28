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
    FAIL(500,"fail"),
    /**
     * 验证码已过期
     */
    VERIFICATION_CODE_OVERDUE(1098, "验证码已过期"),
    /**
     * 验证码错误
     */
    VERIFICATION_CODE_ERROR(1099, "验证码不正确"),
    /**
     * 计价规则不存在
     */
    PRICE_RULE_EMPTY(1300, "计价规则不存在");

    private final int code;
    private final String message;
}
