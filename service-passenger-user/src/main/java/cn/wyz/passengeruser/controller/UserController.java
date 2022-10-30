package cn.wyz.passengeruser.controller;


import cn.wyz.insternalcommon.bean.ResponseResult;
import cn.wyz.passengeruser.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wangnanxiang
 */
@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/user")
    public ResponseResult<?> login(@RequestParam String passengerPhone) {
        userService.login(passengerPhone);
        return ResponseResult.success();
    }
}
