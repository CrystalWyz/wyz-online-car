package cn.wyz.servicemap.remote;

import cn.wyz.insternalcommon.bean.response.DirectionResponse;
import cn.wyz.insternalcommon.constant.AmapConfigConstant;
import cn.wyz.insternalcommon.constant.CommonStatusEnum;
import cn.wyz.insternalcommon.exception.AppException;
import com.alibaba.fastjson2.JSONArray;
import com.alibaba.fastjson2.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author wangnanxiang
 */
@Service
public class MapDirectionClient {

    @Value("${amap.key}")
    private String amapKey;

    private final RestTemplate restTemplate;

    public MapDirectionClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public DirectionResponse direction(String depLongitude, String depLatitude, String destLongitude, String destLatitude) {
        // 组装调用url
        //https://restapi.amap.com/v3/direction/driving?origin=116.481028,39.989643&destination=116.465302,40.004717&extensions=all&output=xml&key=<用户的key>
        String url = AmapConfigConstant.DIRECTION_URL + "?" +
                "origin=" + depLongitude + "," + depLatitude + "&" +
                "destination=" + destLongitude + "," + destLatitude + "&" +
                "extensions=base" + "&" + "output=json" + "&" +
                "strategy=0" + "&" +
                "key=" + amapKey;

        // 调用高德接口
        ResponseEntity<String> directionResponse = restTemplate.getForEntity(url, String.class);
        String directionString = directionResponse.getBody();
        
        // 解析结果
        return parseDirectionResponse(directionString);
    }

    private DirectionResponse parseDirectionResponse(String directionString) {
        JSONObject directionJSON = JSONObject.parseObject(directionString);
        int status = directionJSON.getIntValue(AmapConfigConstant.STATUS, 0);
        if (status == 0) {
            throw new AppException(CommonStatusEnum.FAIL.getCode(), "地点解析失败");
        }

        if (!directionJSON.containsKey(AmapConfigConstant.ROUTE)) {
            throw new AppException(CommonStatusEnum.FAIL.getCode(), "地点解析失败");
        }
        JSONObject routeJSON = directionJSON.getJSONObject(AmapConfigConstant.ROUTE);

        if (!routeJSON.containsKey(AmapConfigConstant.PATHS)) {
            throw new AppException(CommonStatusEnum.FAIL.getCode(), "地点解析失败");
        }
        JSONArray jsonArray = routeJSON.getJSONArray(AmapConfigConstant.PATHS);
        JSONObject pathJSON = jsonArray.getJSONObject(0);
        if (!pathJSON.containsKey(AmapConfigConstant.DISTANCE) || !pathJSON.containsKey(AmapConfigConstant.DURATION)) {
            throw new AppException(CommonStatusEnum.FAIL.getCode(), "地点解析失败");
        }
        
        return new DirectionResponse(pathJSON.getIntValue(AmapConfigConstant.DISTANCE), pathJSON.getIntValue(AmapConfigConstant.DURATION));
    }
}
