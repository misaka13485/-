package com.zengxuan.admin.controller;


import com.zengxuan.admin.service.IUserInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author ZengXuan
 * @since 2022-04-25
 */
@Api(tags="用户信息")
@RestController
@RequestMapping("/user-info")
public class UserInfoController {
    @Autowired
    private IUserInfoService userInfoService;

    @ApiOperation("查询用户信息")
    @GetMapping("/getUserInfo")
    public String getUserInfo(){
        return userInfoService.getUserInfo();
    }

    @ApiOperation("增加用户信息")
    @PostMapping("/addUserInfo")
    public String addUserInfo(@RequestParam String name,
                              @RequestParam String password){
        return userInfoService.addUserInfo(name,password);
    }

    @ApiOperation("删除用户信息")
    @DeleteMapping("/deleteUserInfo")
    public String deleteUserInfo(@RequestParam int id){
        return userInfoService.deleteUserInfo(id);
    }

    @ApiOperation("修改用户信息")
    @PutMapping("/updateUserInfo")
    public String updateUserInfo(@RequestParam int id,
                                 @RequestParam String name,
                                 @RequestParam String password,
                                 @RequestParam String token){
        return userInfoService.updateUserInfo(id,name,password,token);
    }

}
