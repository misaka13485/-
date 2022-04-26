package com.zengxuan.gateway.utils;
 
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.zengxuan.gateway.entity.User;
import com.zengxuan.gateway.mapper.UserMapper;
import com.zengxuan.gateway.service.IUserService;
import com.zengxuan.gateway.service.impl.UserServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * @desc   使用token验证用户是否登录
 * @author zm
 **/
@Component
@RefreshScope
@Slf4j

public  class TokenUtils {
    //设置过期时间

    private static final long EXPIRE_DATE = 30*60*100000;
    //token秘钥

    private static final String TOKEN_SECRET = "ZCfasfhuaUUHufguGuwu2020BQWE";

    @Autowired
    IUserService _userService;
    private static IUserService userService;

    @PostConstruct
    void init() {
        userService = _userService;
    }

    public static void setMapper(IUserService newMapper) {
        userService = newMapper;
    }



    /**
    * 验证token
    *
     * **/
    public String token (String id){
 
        String token = "";
        User user = userService.getUserByID(id);
        try {

            if(user == null){
                log.warn("用户ID"+id+"不存在");
                throw new RuntimeException("用户ID"+id+"不存在");
            }
            //过期时间
            Date date = new Date(System.currentTimeMillis()+EXPIRE_DATE);
            //秘钥及加密算法
            Algorithm algorithm = Algorithm.HMAC256(TOKEN_SECRET);
            //设置头部信息
            Map<String,Object> header = new HashMap<>();
            header.put("typ","JWT");
            header.put("alg","HS256");
            //携带username，password信息，生成签名
            token = JWT.create()
                    .withHeader(header)
                    .withClaim("username",user.getUsername())
                    .withClaim("password",user.getPassword())
                    .withClaim("id",id)
                    .withExpiresAt(date)
                    .sign(algorithm);

        }catch (Exception e){
            e.printStackTrace();
            return  null;
        }
        user.setToken(token);
        userService.updateById(user);
        return token;
    }
 
    public User verify(String token){
        /**
         * @desc   验证token，通过返回用户名称，失败返回null
         * @params [token]需要校验的串
         **/
        User user = userService.getUserByToken(token);
        //获取当前时间
        long nowTime = System.currentTimeMillis();
        if(user == null){
            log.warn("找不到对应token或者返回token过多，传入token为："+token);
            return null;
        }else if(JWT.decode(token).getExpiresAt().getTime() < nowTime){
            log.warn("token已过期，传入token为："+token);
            return null;
        }
        else{
            log.info("验证通过，返回用户名称："+user.getUsername());
            return user;
        }




    }





}