package com.zengxuan.core.service;

import com.zengxuan.core.entity.UserInfo;
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

public interface IUserInfoService extends IService<UserInfo> {

    UserInfo getUserByID(String id);

    String register(UserInfo userInfo);

    String login(UserInfo userInfo);

    String logout(UserInfo userInfo);
}
