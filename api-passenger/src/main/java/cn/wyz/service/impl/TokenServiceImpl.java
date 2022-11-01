package cn.wyz.service.impl;

import cn.wyz.bean.response.TokenResponseDTO;
import cn.wyz.insternalcommon.bean.dto.TokenDTO;
import cn.wyz.insternalcommon.constant.CommonStatusEnum;
import cn.wyz.insternalcommon.constant.IdentityEnum;
import cn.wyz.insternalcommon.constant.TokenTypeEnum;
import cn.wyz.insternalcommon.exception.AppException;
import cn.wyz.insternalcommon.util.JwtUtils;
import cn.wyz.insternalcommon.util.RedisKeyUtils;
import cn.wyz.service.TokenService;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @author wangnanxiang
 */
@Service
public class TokenServiceImpl implements TokenService {
    
    private final StringRedisTemplate stringRedisTemplate;

    public TokenServiceImpl(StringRedisTemplate stringRedisTemplate) {
        this.stringRedisTemplate = stringRedisTemplate;
    }

    @Override
    public TokenResponseDTO refreshToken(String refreshToken) {

        // token解析
        TokenDTO tokenDTO = JwtUtils.parseToken(refreshToken);

        // 获取缓存中的token
        String refreshTokenKey = RedisKeyUtils.generatorTokenKey(tokenDTO.getPhone(), tokenDTO.getIdentity(),
                TokenTypeEnum.REFRESH_TOKEN_TYPE.getCode());
        String refreshTokenRedis = stringRedisTemplate.opsForValue().get(refreshTokenKey);
        // token 对比
        if (ObjectUtils.isEmpty(refreshTokenRedis) || !refreshTokenRedis.trim().equals(refreshToken)) {
            throw new AppException(CommonStatusEnum.FAIL.getCode(), "error token");
        }

        // 新token
        String accessToken = JwtUtils.generatorToken(tokenDTO, TokenTypeEnum.ACCESS_TOKEN_TYPE.getCode());
        refreshToken = JwtUtils.generatorToken(tokenDTO, TokenTypeEnum.REFRESH_TOKEN_TYPE.getCode());

        String accessTokenKey = RedisKeyUtils.generatorTokenKey(tokenDTO.getPhone(), IdentityEnum.PASSENGER.getCode(),TokenTypeEnum.ACCESS_TOKEN_TYPE.getCode());
        stringRedisTemplate.opsForValue().set(accessTokenKey, accessToken, 7, TimeUnit.DAYS);
        stringRedisTemplate.opsForValue().set(refreshTokenKey, refreshToken, 30, TimeUnit.DAYS);

        return TokenResponseDTO.builder().accessToken(accessToken).refreshToken(refreshToken).build();
    }
}
