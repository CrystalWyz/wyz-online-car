package cn.wyz.service;

import cn.wyz.insternalcommon.bean.dto.ForecastPriceDTO;
import cn.wyz.insternalcommon.bean.response.ForecastPriceResponse;

/**
 * @author wangnanxiang
 */
public interface ForecastPriceService {

    /**
     * 预估价格
     * @param forecastPriceDTO 预估信息
     * @return 预估价格
     */
    ForecastPriceResponse forecastPrice(ForecastPriceDTO forecastPriceDTO);
}
