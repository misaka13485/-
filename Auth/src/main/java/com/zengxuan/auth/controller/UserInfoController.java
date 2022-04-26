package com.zengxuan.auth.controller;


import com.zengxuan.auth.entity.UserInfo;
import com.zengxuan.auth.service.IUserInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author ZengXuan
 * @since 2022-04-15
 */
@Api(tags = "用户信息接口")
@RestController
@RequestMapping("/Auth")
public class UserInfoController {
    @Autowired
    private IUserInfoService userInfoService;



    //注册
    @ApiOperation(value = "注册",notes = "注册")
    @PostMapping("/register")
    public String register(@RequestParam(value = "username",required = true) String username,@RequestParam(value = "password", required = true) String password){
        UserInfo userInfo = new UserInfo();
        userInfo.setUsername(username);
        userInfo.setUserPassword(password);
        return userInfoService.register(userInfo);

    }

    //登录
    @ApiOperation(value = "登录",notes = "登录")
    @PostMapping("/login")
    public String login(@RequestParam(value = "username",required = true) String username,@RequestParam(value = "password", required = true) String password){
        UserInfo user = new UserInfo();
        user.setUsername(username);
        user.setUserPassword(password);
        return userInfoService.login(user);
    }

    //登出
    @ApiOperation(value = "登出",notes = "登出")
    @GetMapping("/logout")
    public String logout(@RequestHeader("username") String username,@RequestHeader("id") String id){
        UserInfo user = new UserInfo();
        user.setUsername(username);
        user.setId(id);
        return userInfoService.logout(user);
    }

}
