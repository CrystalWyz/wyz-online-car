package cn.wyz.controller;

import cn.wyz.insternalcommon.bean.ResponseResult;
import cn.wyz.insternalcommon.bean.dto.ForecastPriceDTO;
import cn.wyz.insternalcommon.bean.response.ForecastPriceResponse;
import cn.wyz.remote.ServicePriceClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wangnanxiang
 */
@RestController
public class ForecastPriceController {

    private final ServicePriceClient servicePriceClient;

    public ForecastPriceController(ServicePriceClient servicePriceClient) {
        this.servicePriceClient = servicePriceClient;
    }


    @PostMapping("/forecast-price")
    public ResponseResult<ForecastPriceResponse> forecastPrice(@RequestBody ForecastPriceDTO forecastPriceDTO) {
        return servicePriceClient.forecastPrice(forecastPriceDTO);
    }
}
