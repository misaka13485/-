package com.zengxuan.core.controller;


import com.zengxuan.core.dto.DonateForm;
import com.zengxuan.core.dto.NeedForm;
import com.zengxuan.core.dto.ResultDto;
import com.zengxuan.core.service.IDepositoryService;
import com.zengxuan.core.service.IDonateService;
import com.zengxuan.core.service.IGoodInfoService;
import com.zengxuan.core.service.INeedService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

/**
 * Core控制器
 *
 * @author zengxuan
 */

@Api(tags = "核心业务控制器")
@RestController
@RequestMapping
public class CoreController {


    @Autowired
    private IDonateService donateService;

    @Autowired
    private INeedService needService;

    @Autowired
    private IDepositoryService repositoryService;

    @Autowired
    private IGoodInfoService goodInfoService;



    @ApiOperation("添加需求")
    @PostMapping("/addNewNeed")
    public String addNewNeed(@RequestHeader(value = "username", required = false) String username,
                             @RequestHeader(value = "id", required = false) int id,
                             @RequestParam NeedForm needForm) {
        if (!needForm.isValid()) {
            return "参数错误";
        }
        if (!Objects.equals(needForm.getNeederId(), id)) {
            return "非法操作";
        }
        return needService.addNewNeed(id, needForm.getGoodsId(), needForm.getAmount());
    }

    @ApiOperation("添加捐赠")
    @PostMapping("addNewDonate")
    public String addNewDonate(@RequestHeader(value = "username", required = false) String username,
                               @RequestHeader(value = "id", required = false) String id,
                               @RequestParam() DonateForm donateForm) {
        if (!donateForm.isValid()) {
            return "参数错误";
        }
        if (!Objects.equals(String.valueOf(donateForm.getDonater()), id)) {
            return "非法操作";
        }
        return donateService.addNewDonate(donateForm.getDonater(), donateForm.getGoodsId(), donateForm.getAmount());
    }

    @ApiOperation("查询用户需求")
    @GetMapping("/getNeedsById")
    public ResultDto getNeeds(@RequestHeader String username,
                              @RequestHeader int id) {

        ResultDto resultDto = new ResultDto();
        resultDto.setData(needService.getNeedsById(id));
        return resultDto;
    }

    @ApiOperation("查询用户捐赠")
    @GetMapping("/getDonatesById")
    public String getDonates(@RequestHeader(value = "username", required = false) String username,
                             @RequestHeader(value = "id", required = false) String id) {
        return donateService.getDonatesById(id);
    }

    @ApiOperation("添加物资信息")
    @PostMapping("/addGoods")
    public String addGoods(@RequestHeader(value = "username", required = false) String username,
                           @RequestHeader(value = "id", required = false) String id,
                           @RequestParam String goodsId,
                           @RequestParam String goodsName,
                           @RequestParam int size) {
        return goodInfoService.addGoods(id, goodsId, goodsName, size);
    }







}

