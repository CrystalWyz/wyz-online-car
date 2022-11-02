package cn.wyz.serviceprice.service.impl;

import cn.wyz.insternalcommon.bean.ResponseResult;
import cn.wyz.insternalcommon.bean.dto.ForecastPriceDTO;
import cn.wyz.insternalcommon.bean.response.DirectionResponse;
import cn.wyz.insternalcommon.bean.response.ForecastPriceResponse;
import cn.wyz.insternalcommon.constant.CommonStatusEnum;
import cn.wyz.insternalcommon.exception.AppException;
import cn.wyz.serviceprice.remote.ServiceMapClient;
import cn.wyz.serviceprice.service.ForecastPriceService;
import org.springframework.stereotype.Service;

/**
 * @author wangnanxiang
 */
@Service
public class ForecastPriceServiceImpl implements ForecastPriceService {

    private final ServiceMapClient serviceMapClient;

    public ForecastPriceServiceImpl(ServiceMapClient serviceMapClient) {
        this.serviceMapClient = serviceMapClient;
    }

    @Override
    public ForecastPriceResponse forecastPrice(ForecastPriceDTO forecastPriceDTO) {
        ResponseResult<DirectionResponse> directionResponse = serviceMapClient.driving(forecastPriceDTO);
        if (CommonStatusEnum.SUCCESS.getCode() != directionResponse.getCode()) {
            throw new AppException(CommonStatusEnum.FAIL.getCode(), "service-map 异常");
        }
        DirectionResponse direction = directionResponse.getData();

        return null;
    }
}
