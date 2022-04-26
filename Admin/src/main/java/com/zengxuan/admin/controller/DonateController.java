package com.zengxuan.admin.controller;


import com.zengxuan.admin.service.IDonateService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 捐赠记录 前端控制器
 * </p>
 *
 * @author ZengXuan
 * @since 2022-04-25
 */
@Api(tags = "捐赠控制")
@RestController
@RequestMapping("/donate")
public class DonateController {
    @Autowired
    private IDonateService donateService;

    @ApiOperation("查询捐赠记录")
    @GetMapping("/getDonateList")
    public String getDonateList(){
        return donateService.getDonateList();
    }

    @ApiOperation("添加捐赠记录")
    @PostMapping("/addDonate")
    public String addDonate(@RequestParam int donater, @RequestParam int amount, @RequestParam int goodsId){
        return donateService.addDonate(donater, amount, goodsId);
    }

    @ApiOperation("删除捐赠记录")
    @DeleteMapping("/deleteDonate")
    public String deleteDonate(@RequestParam int id){
        return donateService.deleteDonate(id);
    }

    @ApiOperation("更新捐赠记录")
    @PutMapping("/updateDonate")
    public String updateDonate(@RequestParam int id,
                               @RequestParam int donater,
                               @RequestParam int amount,
                               @RequestParam int goodsId){
        return donateService.updateDonate(id, donater, amount, goodsId);
    }
}


