package cn.wyz.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wangnanxiang
 */
@RestController
public class TestController {

    @GetMapping("/test")
    public String test() {
        return "test success";
    }
}
