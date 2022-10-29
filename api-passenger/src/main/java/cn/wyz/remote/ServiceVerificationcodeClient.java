package cn.wyz.remote;

import cn.wyz.insternalcommon.bean.ResponseResult;
import cn.wyz.insternalcommon.bean.response.NumberCodeResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author wangnanxiang
 */
@FeignClient("service-verificationcode")
public interface ServiceVerificationcodeClient {

    /**
     * 获取六位数验证码
     * @return 验证码
     */
    @RequestMapping(value = "/numberCode/{size}", method = RequestMethod.GET)
    ResponseResult<NumberCodeResponse> getNumberCode(@PathVariable("size")int size);
}
