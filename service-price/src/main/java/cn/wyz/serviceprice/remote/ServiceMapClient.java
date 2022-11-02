package cn.wyz.serviceprice.remote;

import cn.wyz.insternalcommon.bean.ResponseResult;
import cn.wyz.insternalcommon.bean.dto.ForecastPriceDTO;
import cn.wyz.insternalcommon.bean.response.DirectionResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author wangnanxiang
 */
@FeignClient("service-map")
public interface ServiceMapClient {

    /**
     * 获取时间和距离
     * @param forecastPriceDTO 经纬度信息
     * @return 时间和距离
     */
    @GetMapping("/direction/driving")
    ResponseResult<DirectionResponse> driving(@RequestBody ForecastPriceDTO forecastPriceDTO);
}
