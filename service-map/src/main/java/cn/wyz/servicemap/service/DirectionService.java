package cn.wyz.servicemap.service;

import cn.wyz.insternalcommon.bean.response.DirectionResponse;

/**
 * @author wangnanxiang
 */
public interface DirectionService {

    /**
     * 根据经纬度获取距离和时间
     * @param depLongitude 源经度
     * @param depLatitude 源纬度
     * @param destLongitude 目标经度
     * @param destLatitude 目标纬度
     * @return 距离和时间
     */
    DirectionResponse driving(String depLongitude, String depLatitude, String destLongitude, String destLatitude);
}
