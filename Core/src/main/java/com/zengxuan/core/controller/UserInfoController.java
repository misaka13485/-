package com.zengxuan.core.controller;


import com.zengxuan.core.entity.UserInfo;
import com.zengxuan.core.service.IUserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author ZengXuan
 * @since 2022-04-15
 */
@RestController
@RequestMapping("/Auth")
public class UserInfoController {
    @Autowired
    private IUserInfoService userInfoService;


}
