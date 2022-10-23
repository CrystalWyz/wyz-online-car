package cn.wyz.service.impl;

import cn.wyz.service.VerificationCodeService;
import com.alibaba.fastjson2.JSONObject;
import org.springframework.stereotype.Service;

/**
 * @author wangnanxiang
 */
@Service
public class VerificationCodeServiceImpl implements VerificationCodeService {

    @Override
    public String generatorVerificationCode(String passengerPhone) {

        //TODO 生成验证码
        String verificationCode = "1";

        // TODO 存入redis


        JSONObject result = new JSONObject();
        result.put("code", 200);
        result.put("message", "success");
        result.put("data", verificationCode);
        return result.toString();
    }
}
