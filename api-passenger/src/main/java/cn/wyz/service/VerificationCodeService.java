package cn.wyz.service;

/**
 * @author wangnanxiang
 */
public interface VerificationCodeService {

    /**
     * 获取验证码
     * @param passengerPhone 乘客手机号
     * @return 验证码
     */
    String generatorVerificationCode(String passengerPhone);
}
