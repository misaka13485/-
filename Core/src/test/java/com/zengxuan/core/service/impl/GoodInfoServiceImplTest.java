package com.zengxuan.core.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@Slf4j
class GoodInfoServiceImplTest {
    @Autowired
    GoodInfoServiceImpl goodInfoService;

    @Test
    void getGoodInfo() {
        log.info("查询物资类别表测试："+goodInfoService.getGoodInfo());
    }
}