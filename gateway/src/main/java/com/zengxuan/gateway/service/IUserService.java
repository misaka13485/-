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
    User getUserByID(String id);
    User getUserByToken(String token);


}
