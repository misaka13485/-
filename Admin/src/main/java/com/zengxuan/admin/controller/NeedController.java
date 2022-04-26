package com.zengxuan.admin.controller;


import com.zengxuan.admin.service.INeedService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 需求表 前端控制器
 * </p>
 *
 * @author ZengXuan
 * @since 2022-04-25
 */
@Api(tags = "需求表")
@RestController
@RequestMapping("/need")
public class NeedController {
    @Autowired
    private INeedService needService;

    @ApiOperation(value = "查询需求列表", notes = "查询需求列表")
    @GetMapping("/getNeedList")
    public String getNeedList() {
        return needService.getNeedList();
    }

    @ApiOperation(value = "增加需求", notes = "增加需求")
    @PostMapping("/addNeed")
    public String addNeed(@RequestParam int needer,
                          @RequestParam int amount,
                          @RequestParam int goodsId) {
        return needService.addNeed(needer,amount,goodsId);
    }

    @ApiOperation(value = "删除需求", notes = "删除需求")
    @PostMapping("/deleteNeed")
    public String deleteNeed(@RequestParam int id) {
        return needService.deleteNeed(id);
    }

    @ApiOperation(value = "更新需求", notes = "更新需求")
    @PostMapping("/updateNeed")
    public String updateNeed(@RequestParam int id,
                             @RequestParam int needer,
                             @RequestParam int amount,
                             @RequestParam int goodsId,
                             @RequestParam String status) {
        return needService.updateNeed(id,needer,amount,goodsId,status);
    }


}
