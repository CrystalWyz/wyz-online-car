package cn.wyz.controller;

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
    public String verificationCode(@RequestParam String passengerPhone) {

        return verificationCodeService.generatorVerificationCode(passengerPhone);
    }
}
