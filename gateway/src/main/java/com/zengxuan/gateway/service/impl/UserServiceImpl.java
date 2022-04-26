package com.zengxuan.gateway.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zengxuan.gateway.entity.User;
import com.zengxuan.gateway.mapper.UserMapper;
import com.zengxuan.gateway.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author ZengXuan
 * @since 2022-04-15
 */

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User getUserByID(String id) {
        return userMapper.selectById(id);
    }

    @Override
    public User getUserByToken(String token) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("token",token);
        List<User> list = userMapper.selectList(queryWrapper);
        if(list.size()!=1){
            return null;
        }else{
            return list.get(0);
        }
    }
}
