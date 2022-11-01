package cn.wyz.service.impl;

import cn.wyz.bean.dto.UserInfoDTO;
import cn.wyz.insternalcommon.bean.PassengerUser;
import cn.wyz.insternalcommon.bean.ResponseResult;
import cn.wyz.insternalcommon.bean.dto.TokenDTO;
import cn.wyz.insternalcommon.exception.AppException;
import cn.wyz.insternalcommon.util.JwtUtils;
import cn.wyz.remote.ServicePassengerUserClient;
import cn.wyz.service.UserService;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.stereotype.Service;

/**
 * @author wangnanxiang
 */
@Service
public class UserServiceImpl implements UserService {

    private final ServicePassengerUserClient passengerUserClient;

    public UserServiceImpl(ServicePassengerUserClient servicePassengerUserClient) {
        this.passengerUserClient = servicePassengerUserClient;
    }

    @Override
    public UserInfoDTO getUserInfo(String accessToken) {
        // 解析token
        TokenDTO tokenDTO = JwtUtils.checkToken(accessToken);

        // 获取用户信息
        PassengerUser passengerUser = passengerUserClient.getUserInfo(tokenDTO.getPhone()).getData();
        return UserInfoDTO.builder()
                .passengerName(passengerUser.getPassengerName())
                .profilePhoto(passengerUser.getProfilePhoto())
                .build();
    }
}
