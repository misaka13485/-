package com.zengxuan.admin.service;

import com.zengxuan.admin.entity.UserInfo;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author ZengXuan
 * @since 2022-04-25
 */
public interface IUserInfoService extends IService<UserInfo> {

    String getUserInfo();

    String addUserInfo(String name, String password);

    String deleteUserInfo(int id);

    String updateUserInfo(int id, String name, String password, String token);
}
