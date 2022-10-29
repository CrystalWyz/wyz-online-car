package cn.wyz.service.impl;

import cn.wyz.insternalcommon.bean.ResponseResult;
import cn.wyz.insternalcommon.bean.response.NumberCodeResponse;
import cn.wyz.remote.ServiceVerificationcodeClient;
import cn.wyz.service.VerificationCodeService;
import com.alibaba.fastjson2.JSONObject;
import org.springframework.stereotype.Service;

/**
 * @author wangnanxiang
 */
@Service
public class VerificationCodeServiceImpl implements VerificationCodeService {

    private final ServiceVerificationcodeClient serviceVerificationcodeClient;

    public VerificationCodeServiceImpl(ServiceVerificationcodeClient serviceVerificationcodeClient) {
        this.serviceVerificationcodeClient = serviceVerificationcodeClient;
    }

    @Override
    public String generatorVerificationCode(String passengerPhone) {

        //TODO 生成验证码
        ResponseResult<NumberCodeResponse> numberCodeResponse = serviceVerificationcodeClient.getNumberCode(6);
        Integer verificationCode = numberCodeResponse.getData().getNumberCode();

        // TODO 存入redis


        JSONObject result = new JSONObject();
        result.put("code", 200);
        result.put("message", "success");
        JSONObject data = new JSONObject();
        data.put("numberCode", verificationCode);
        result.put("data", data);
        return result.toString();
    }
}
