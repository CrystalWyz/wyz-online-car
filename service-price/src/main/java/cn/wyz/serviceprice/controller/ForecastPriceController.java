package cn.wyz.serviceprice.controller;

import cn.wyz.insternalcommon.bean.ResponseResult;
import cn.wyz.insternalcommon.bean.dto.ForecastPriceDTO;
import cn.wyz.insternalcommon.bean.response.ForecastPriceResponse;
import cn.wyz.serviceprice.service.ForecastPriceService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wangnanxiang
 */
@RestController
public class ForecastPriceController {

    private final ForecastPriceService forecastPriceService;

    public ForecastPriceController(ForecastPriceService forecastPriceService) {
        this.forecastPriceService = forecastPriceService;
    }

    @PostMapping("/forecast-price")
    public ResponseResult<ForecastPriceResponse> forecastPrice(@RequestBody ForecastPriceDTO forecastPriceDTO) {
        ForecastPriceResponse forecastPriceResponse = forecastPriceService.forecastPrice(forecastPriceDTO);
        return ResponseResult.success(forecastPriceResponse);
    }
}
