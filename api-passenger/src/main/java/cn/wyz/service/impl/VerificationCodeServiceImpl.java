package cn.wyz.service.impl;

import cn.wyz.insternalcommon.bean.ResponseResult;
import cn.wyz.insternalcommon.bean.response.NumberCodeResponse;
import cn.wyz.remote.ServiceVerificationCodeClient;
import cn.wyz.service.VerificationCodeService;
import com.alibaba.fastjson2.JSONObject;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @author wangnanxiang
 */
@Service
public class VerificationCodeServiceImpl implements VerificationCodeService {

    private static final String VERIFICATION_CODE_PREFIX = "passenger-verification-code-";

    private final ServiceVerificationCodeClient serviceVerificationCodeClient;

    private final StringRedisTemplate stringRedisTemplate;

    public VerificationCodeServiceImpl(ServiceVerificationCodeClient serviceVerificationCodeClient, StringRedisTemplate stringRedisTemplate) {
        this.serviceVerificationCodeClient = serviceVerificationCodeClient;
        this.stringRedisTemplate = stringRedisTemplate;
    }

    @Override
    public void generatorVerificationCode(String passengerPhone) {

        // 生成验证码
        ResponseResult<NumberCodeResponse> numberCodeResponse = serviceVerificationCodeClient.getNumberCode(6);
        Integer verificationCode = numberCodeResponse.getData().getNumberCode();

        // 存入redis
        String key = VERIFICATION_CODE_PREFIX + passengerPhone;
        stringRedisTemplate.opsForValue().set(key, String.valueOf(verificationCode), 5, TimeUnit.MINUTES);

        // 短信发送
    }
}
