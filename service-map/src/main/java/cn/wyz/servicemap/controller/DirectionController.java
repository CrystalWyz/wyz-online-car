package cn.wyz.servicemap.controller;

import cn.wyz.insternalcommon.bean.ResponseResult;
import cn.wyz.insternalcommon.bean.dto.ForecastPriceDTO;
import cn.wyz.insternalcommon.bean.response.DirectionResponse;
import cn.wyz.servicemap.service.DirectionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wangnanxiang
 */
@RestController
public class DirectionController {

    private final DirectionService directionService;

    public DirectionController(DirectionService directionService) {
        this.directionService = directionService;
    }

    @GetMapping("/direction/driving")
    public ResponseResult<DirectionResponse> driving(@RequestBody ForecastPriceDTO forecastPriceDTO) {
        DirectionResponse directionResponse = directionService.driving(forecastPriceDTO.getDepLongitude(), forecastPriceDTO.getDepLatitude(),
                forecastPriceDTO.getDestLongitude(), forecastPriceDTO.getDestLatitude());

        return ResponseResult.success(directionResponse);
    }
}
