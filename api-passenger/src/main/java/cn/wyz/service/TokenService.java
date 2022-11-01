package cn.wyz.service;

import cn.wyz.bean.request.RefreshTokenDTO;
import cn.wyz.bean.response.TokenResponseDTO;

/**
 * @author wangnanxiang
 */
public interface TokenService {

    /**
     * 刷新token
     * @param refreshToken refreshToken
     * @return new accessToken
     */
    TokenResponseDTO refreshToken(String refreshToken);
}
