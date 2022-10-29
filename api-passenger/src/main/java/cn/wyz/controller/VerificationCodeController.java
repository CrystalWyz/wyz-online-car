package cn.wyz.controller;

import cn.wyz.insternalcommon.bean.ResponseResult;
import cn.wyz.service.VerificationCodeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wangnanxiang
 */
@RestController
public class VerificationCodeController {

    private final VerificationCodeService verificationCodeService;

    public VerificationCodeController(VerificationCodeService verificationCodeService) {
        this.verificationCodeService = verificationCodeService;
    }

    @GetMapping("/verification-code")
    public ResponseResult<?> verificationCode(@RequestParam String passengerPhone) {
        verificationCodeService.generatorVerificationCode(passengerPhone);
        return ResponseResult.success();
    }
}
