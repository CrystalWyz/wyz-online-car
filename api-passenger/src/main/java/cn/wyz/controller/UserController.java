package cn.wyz.controller;

import cn.wyz.bean.dto.UserInfoDTO;
import cn.wyz.insternalcommon.bean.ResponseResult;
import cn.wyz.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author wangnanxiang
 */
@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/userInfo")
    public ResponseResult<UserInfoDTO> getUserInfo(HttpServletRequest request) {
        String accessToken = request.getHeader("Authorization");
        UserInfoDTO userInfo = userService.getUserInfo(accessToken);

        return ResponseResult.success(userInfo);
    }
}
