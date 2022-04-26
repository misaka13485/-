package com.zengxuan.auth.service;

import com.zengxuan.auth.entity.UserInfo;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author ZengXuan
 * @since 2022-04-15
 */
@Service
public interface IUserInfoService extends IService<UserInfo> {

    public UserInfo getUserByID(String id);

    String register(UserInfo userInfo);

    String login(UserInfo userInfo);

    String logout(UserInfo userInfo);
}
