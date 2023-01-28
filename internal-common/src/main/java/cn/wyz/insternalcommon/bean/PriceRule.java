package cn.wyz.insternalcommon.bean;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author wangnanxiang
 */
@Data
public class PriceRule {

    private String cityCode;

    private String vehicleType;

    private BigDecimal startFare;

    private Integer startMile;

    private BigDecimal unitPricePerMile;

    private BigDecimal unitPricePerMinute;
}
