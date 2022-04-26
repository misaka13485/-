package com.zengxuan.auth.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zengxuan.auth.entity.UserInfo;
import com.zengxuan.auth.mapper.UserInfoMapper;
import com.zengxuan.auth.service.IUserInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.zengxuan.auth.utils.TokenUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author ZengXuan
 * @since 2022-04-15
 */
@Service
public class UserInfoServiceImpl extends ServiceImpl<UserInfoMapper, UserInfo> implements IUserInfoService {

    @Autowired
    UserInfoMapper userInfoMapper;

    @Override
    public UserInfo getUserByID(String id) {
        return userInfoMapper.selectById(id);
    }

    @Override
    public String register(UserInfo userInfo) {
         userInfoMapper.insert(userInfo);
         return "成功";
    }

    @Override
    public String login(UserInfo userInfo) {
        QueryWrapper<UserInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username",userInfo.getUsername());
        queryWrapper.eq("password",userInfo.getUserPassword());
        UserInfo login= userInfoMapper.selectList(queryWrapper).get(0);
        if(login==null){
            return "用户名或密码错误";
        }
        TokenUtils tokenUtils = new TokenUtils();
        return tokenUtils.token(login.getId());
    }

    @Override
    public String logout(UserInfo userInfo) {
        userInfo.setToken("");
        try {
            userInfoMapper.updateById(userInfo);
        } catch (Exception e) {
            return "退出失败，请重试";
        }

        return "成功";
    }
}
