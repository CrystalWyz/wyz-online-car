package cn.wyz.servicemap.service.impl;

import cn.wyz.insternalcommon.bean.response.DirectionResponse;
import cn.wyz.servicemap.remote.MapDirectionClient;
import cn.wyz.servicemap.service.DirectionService;
import org.springframework.stereotype.Service;

/**
 * @author wangnanxiang
 */
@Service
public class DirectionServiceImpl implements DirectionService {

    private final MapDirectionClient mapDirectionClient;

    public DirectionServiceImpl(MapDirectionClient mapDirectionClient) {
        this.mapDirectionClient = mapDirectionClient;
    }

    @Override
    public DirectionResponse driving(String depLongitude, String depLatitude, String destLongitude, String destLatitude) {
        return mapDirectionClient.direction(depLongitude, depLatitude, destLongitude, destLatitude);
    }
}
