package cn.wyz.controller;

import cn.wyz.bean.request.RefreshTokenDTO;
import cn.wyz.insternalcommon.bean.ResponseResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wangnanxiang
 */
@RestController
public class TokenController {

    @PostMapping("/refresh-token")
    public ResponseResult<?> refreshToken(@RequestBody RefreshTokenDTO refreshTokenDTO) {
        return null;
    }
}
