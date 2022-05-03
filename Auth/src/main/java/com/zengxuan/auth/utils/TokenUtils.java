package com.zengxuan.auth.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.zengxuan.auth.entity.UserInfo;
import com.zengxuan.auth.service.IUserInfoService;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 使用token验证用户是否登录
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
    IUserInfoService _UserInfoService;
    private static IUserInfoService UserInfoService;

    @PostConstruct
    void init() {
        UserInfoService = _UserInfoService;
    }

    public static void setMapper(IUserInfoService newMapper) {
        UserInfoService = newMapper;
    }



    /**
    * 验证token
    *
     * **/
    public String token (String id){
 
        String token = "";
        UserInfo userInfo = UserInfoService.getUserByID(id);
        try {

            if(userInfo == null){
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
            //携带UserInfoname，password信息，生成签名
            token = JWT.create()
                    .withHeader(header)
                    .withClaim("UserInfoname",userInfo.getUsername())
                    .withClaim("password",userInfo.getUserPassword())
                    .withClaim("id",id)
                    .withExpiresAt(date)
                    .sign(algorithm);

        }catch (Exception e){
            e.printStackTrace();
            return  null;
        }
        userInfo.setToken(token);
        UserInfoService.updateById(userInfo);
        return token;
    }

}