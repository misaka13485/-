package com.zengxuan.admin.service.impl;

import com.zengxuan.admin.entity.UserInfo;
import com.zengxuan.admin.mapper.UserInfoMapper;
import com.zengxuan.admin.service.IUserInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author ZengXuan
 * @since 2022-04-25
 */
@Service
public class UserInfoServiceImpl extends ServiceImpl<UserInfoMapper, UserInfo> implements IUserInfoService {
    @Autowired
    private UserInfoMapper userInfoMapper;

    @Override
    public String getUserInfo() {
        List<UserInfo> userInfoList = userInfoMapper.selectList(null);
        String result = "{\"data\":[";
        for (UserInfo userInfo : userInfoList) {
            result += userInfo.toString() + ",";
        }
        result = result.substring(0, result.length() - 1);
        result += "]}";
        return result;
    }

    @Override
    public String addUserInfo(String name, String password) {
        UserInfo userInfo = new UserInfo();
        userInfo.setUsername(name);
        userInfo.setUserPassword(password);
        try {
            userInfoMapper.insert(userInfo);
        } catch (Exception e) {
            return "添加失败";
        }
        return "添加成功";
    }

    @Override
    public String deleteUserInfo(int id) {
        try {
            userInfoMapper.deleteById(id);
        } catch (Exception e) {
            return "删除失败";
        }
        return "删除成功";
    }

    @Override
    public String updateUserInfo(int id, String name, String password, String token) {
        UserInfo userInfo = new UserInfo();
        userInfo.setId(BigDecimal.valueOf(id));
        userInfo.setUsername(name);
        userInfo.setUserPassword(password);
        userInfo.setToken(token);
        try {
            userInfoMapper.updateById(userInfo);
        } catch (Exception e) {
            return "修改失败";
        }
        return "修改成功";
    }
}
