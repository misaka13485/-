package com.zengxuan.admin.controller;


import com.zengxuan.admin.service.IDepositoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 仓库 前端控制器
 * </p>
 *
 * @author ZengXuan
 * @since 2022-04-25
 */
@Api(tags = "库存")
@RestController
@RequestMapping("/depository")
public class DepositoryController {
    @Autowired
    private IDepositoryService depositoryService;


    @ApiOperation("库存查询")
    @GetMapping("/getDepository")
    public String getDepository() {
        return depositoryService.getDepository();
    }

    @ApiOperation("添加库存")
    @GetMapping("/addDepository")
    public String addDepository(@RequestParam("goodsId") int goodsId, @RequestParam("num") int num) {
        return depositoryService.addDepository(goodsId, num);
    }

    @ApiOperation("减少库存")
    @GetMapping("/reduceDepository")
    public String reduceDepository(@RequestParam("goodsId") int goodsId, @RequestParam("num") int num) {
        return depositoryService.reduceDepository(goodsId, num);
    }

    @ApiOperation("根据货物号查询库存")
    @GetMapping("/getDepositoryByGoodsId")
    public String getDepositoryByGoodsId(@RequestParam("goodsId") int goodsId) {
        return depositoryService.getDepositoryByGoodsId(goodsId);
    }





}
