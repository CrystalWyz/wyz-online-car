package cn.wyz.serviceprice.service.impl;

import cn.wyz.insternalcommon.bean.PriceRule;
import cn.wyz.insternalcommon.bean.ResponseResult;
import cn.wyz.insternalcommon.bean.dto.ForecastPriceDTO;
import cn.wyz.insternalcommon.bean.response.DirectionResponse;
import cn.wyz.insternalcommon.bean.response.ForecastPriceResponse;
import cn.wyz.insternalcommon.constant.CommonStatusEnum;
import cn.wyz.insternalcommon.exception.AppException;
import cn.wyz.serviceprice.mapper.PriceRuleMapper;
import cn.wyz.serviceprice.remote.ServiceMapClient;
import cn.wyz.serviceprice.service.ForecastPriceService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * @author wangnanxiang
 */
@Service
public class ForecastPriceServiceImpl implements ForecastPriceService {

    private static final BigDecimal PER_MILE = new BigDecimal(1000);
    private static final BigDecimal PER_MINUTE = new BigDecimal(60);

    private final ServiceMapClient serviceMapClient;

    private final PriceRuleMapper priceRuleMapper;

    public ForecastPriceServiceImpl(ServiceMapClient serviceMapClient, PriceRuleMapper priceRuleMapper) {
        this.serviceMapClient = serviceMapClient;
        this.priceRuleMapper = priceRuleMapper;
    }

    @Override
    public ForecastPriceResponse forecastPrice(ForecastPriceDTO forecastPriceDTO) {
        ResponseResult<DirectionResponse> directionResponse = serviceMapClient.driving(forecastPriceDTO);
        if (CommonStatusEnum.SUCCESS.getCode() != directionResponse.getCode()) {
            throw new AppException(CommonStatusEnum.FAIL.getCode(), "service-map 异常");
        }
        DirectionResponse direction = directionResponse.getData();

//        priceRuleMapper.selectOne();

        return null;
    }

    private BigDecimal countPrice(Integer distance, Integer duration, PriceRule priceRule) {
        // 价格
        BigDecimal price = priceRule.getStartFare();

        // 里程价
        BigDecimal distanceDecimal = new BigDecimal(distance);
        BigDecimal distanceMileDecimal = distanceDecimal.divide(PER_MILE, 2, RoundingMode.HALF_UP);
        BigDecimal startMileDecimal = new BigDecimal(priceRule.getStartMile());
        double distanceSubtract = distanceMileDecimal.subtract(startMileDecimal).doubleValue();
        BigDecimal mileDecimal = BigDecimal.valueOf(distanceSubtract < 0 ? 0 : distanceSubtract);

        BigDecimal mileFare = mileDecimal.multiply(priceRule.getUnitPricePerMile()).setScale(2, RoundingMode.HALF_UP);

        price = price.add(mileFare).setScale(2, RoundingMode.HALF_UP);

        // 时长价
        BigDecimal durationDecimal = new BigDecimal(duration);
        BigDecimal minutes = durationDecimal.divide(PER_MINUTE, 2, RoundingMode.HALF_UP);
        price = price.add(minutes.multiply(priceRule.getUnitPricePerMinute())).setScale(2, RoundingMode.HALF_UP);

        return price;
    }
}
