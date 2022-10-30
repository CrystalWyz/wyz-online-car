package cn.wyz.remote;

import cn.wyz.insternalcommon.bean.ResponseResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author wangnanxiang
 */
@FeignClient("service-passenger-user")
public interface ServicePassengerUserClient {

    /**
     * 用户登录远程调用
     * @param passengerPhone 用户手机号
     * @return
     */
    @PostMapping("/user")
    ResponseResult<?> login(@RequestParam String passengerPhone);
}
