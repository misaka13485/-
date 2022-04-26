package com.zengxuan.core.controller;


import com.zengxuan.core.service.IGoodInfoService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author ZengXuan
 * @since 2022-04-24
 */
@RestController
@RequestMapping("/good-info")
public class GoodInfoController {
    @Autowired
    private IGoodInfoService goodInfoService;

    @ApiOperation(value = "查询物资信息列表")
    @GetMapping("/getGoodInfo")
    public String getGoodInfo(){
        return goodInfoService.getGoodInfo();
    }

}
