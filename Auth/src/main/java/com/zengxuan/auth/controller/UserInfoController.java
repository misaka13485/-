package com.zengxuan.auth.controller;


import com.zengxuan.auth.dto.ResultDto;
import com.zengxuan.auth.entity.UserInfo;
import com.zengxuan.auth.service.IUserInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author ZengXuan
 * @since 2022-04-15
 */
@Api(tags = "用户信息接口")
@RestController
@RequestMapping
public class UserInfoController {
    @Autowired
    private IUserInfoService userInfoService;

    @ApiOperation("测试接口")
    @GetMapping("/test")
    public UserInfo test() {
        UserInfo userInfo = new UserInfo();
        userInfo.setId("1");
        userInfo.setUsername("zengxuan");
        userInfo.setUserPassword("123456");
        userInfo.setCreatTime(LocalDateTime.now());
        userInfo.setToken("123456");
        return userInfo;


    }


    //注册
    @ApiOperation(value = "注册", notes = "注册")
    @PostMapping("/register")
    public String register(@RequestParam(value = "username", required = true) String username, @RequestParam(value = "password", required = true) String password) {
        UserInfo userInfo = new UserInfo();
        userInfo.setUsername(username);
        userInfo.setUserPassword(password);
        return userInfoService.register(userInfo);

    }

    //登录
    @ApiOperation(value = "登录", notes = "登录")
    @PostMapping("/login")
    public ResultDto login(@RequestParam(value = "username", required = true) String username, @RequestParam(value = "password", required = true) String password) {
        UserInfo user = new UserInfo();
        user.setUsername(username);
        user.setUserPassword(password);
        ResultDto resultDto = new ResultDto();
        try {
            resultDto.setCode(200);
            resultDto.setMsg("登录成功");
            resultDto.setData(userInfoService.login(user));
        } catch (RuntimeException e) {
            if ("用户名或密码错误".equals(e.getMessage())) {
                resultDto.setCode(400);
                resultDto.setMsg("用户名或密码错误");

            } else {
                resultDto.setCode(500);
                resultDto.setMsg("服务器错误");
            }
        }
        return resultDto;
    }

    //登出
    @ApiOperation(value = "登出", notes = "登出")
    @GetMapping("/logout")
    public String logout(@RequestHeader("username") String username, @RequestHeader("id") String id) {
        UserInfo user = new UserInfo();
        user.setUsername(username);
        user.setId(id);
        return userInfoService.logout(user);
    }

}
