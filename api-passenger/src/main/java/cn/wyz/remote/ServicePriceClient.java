package cn.wyz.remote;

import cn.wyz.insternalcommon.bean.ResponseResult;
import cn.wyz.insternalcommon.bean.dto.ForecastPriceDTO;
import cn.wyz.insternalcommon.bean.response.ForecastPriceResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author wangnanxiang
 */
@FeignClient("service-price")
public interface ServicePriceClient {

    /**
     * 预估价格
     * @param forecastPriceDTO forecastPriceDTO
     * @return 预估价格
     */
    @PostMapping("/forecast-price")
    ResponseResult<ForecastPriceResponse> forecastPrice(@RequestBody ForecastPriceDTO forecastPriceDTO);
}
