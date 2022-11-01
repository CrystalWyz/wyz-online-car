package cn.wyz.service;

import cn.wyz.bean.dto.UserInfoDTO;

/**
 * @author wangnanxiang
 */
public interface UserService {

    /**
     * 根据token获取用户信息
     * @param accessToken accessToken
     * @return 用户信息
     */
    UserInfoDTO getUserInfo(String accessToken);
}
