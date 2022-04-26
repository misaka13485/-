package com.zengxuan.gateway.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zengxuan.gateway.entity.User;
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
public interface IUserService extends IService<User> {
    public User getUserByID(String id);
    public User getUserByToken(String token);


}
