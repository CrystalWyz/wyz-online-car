package cn.wyz.passengeruser.service;

import cn.wyz.insternalcommon.bean.PassengerUser;

/**
 * @author wangnanxiang
 */
public interface UserService {
    /**
     * 用户登录
     * @param passengerPhone 用户手机号
     */
    void login(String passengerPhone);

    /**
     * 查询用户信息
     * @param passengerPhone 手机号
     * @return 用户信息
     */
    PassengerUser getUserInfo(String passengerPhone);
}
