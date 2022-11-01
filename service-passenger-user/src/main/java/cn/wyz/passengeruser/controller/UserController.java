package cn.wyz.passengeruser.controller;


import cn.wyz.insternalcommon.bean.PassengerUser;
import cn.wyz.insternalcommon.bean.ResponseResult;
import cn.wyz.passengeruser.service.UserService;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/userInfo/{phone}")
    public ResponseResult<PassengerUser> getUserInfo(@PathVariable("phone") String passengerPhone) {
        PassengerUser userInfo = userService.getUserInfo(passengerPhone);
        return ResponseResult.success(userInfo);
    }
}
