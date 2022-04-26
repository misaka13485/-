package com.zengxuan.gateway.utils;

import com.zengxuan.gateway.service.IUserService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class TokenUtilsTest {



    @Autowired
    private IUserService userService;

    @Test
    void userServiceTest() {
        System.out.println(userService.getUserByID("1"));
    }


    @Test
    void verify() {
        TokenUtils tokenUtils = new TokenUtils();
        String id ="2";
        String token = tokenUtils.token(id);
        System.out.println(token);
        System.out.println(tokenUtils.verify(token));
    }
}