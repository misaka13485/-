package com.zengxuan.admin.controller;


import com.zengxuan.admin.service.IGoodInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author ZengXuan
 * @since 2022-04-25
 */
@Api(tags = "物资信息")
@RestController
@RequestMapping("/good-info")
public class GoodInfoController {
    @Autowired
    private IGoodInfoService goodInfoService;

    @ApiOperation(value = "查询商品信息")
    @GetMapping("/getGoodInfo")
    public String getGoodInfo(){
        return goodInfoService.getGoodInfo();
    }

    @ApiOperation(value = "添加商品信息")
    @PostMapping("/addGoodInfo")
    public String addGoodInfo(@RequestParam("goodName") String goodName,
                              @RequestParam("size") int size){
        return goodInfoService.addGoodInfo(goodName,size);
    }

    @ApiOperation(value = "删除商品信息")
    @DeleteMapping("/deleteGoodInfo")
    public String deleteGoodInfo(@RequestParam("goodId") int goodId){
        return goodInfoService.deleteGoodInfo(goodId);
    }

    @ApiOperation(value = "修改商品信息")
    @PutMapping("/updateGoodInfo")
    public String updateGoodInfo(@RequestParam("goodId") int goodId,
                                 @RequestParam("goodName") String goodName,
                                 @RequestParam("size") int size){
        return goodInfoService.updateGoodInfo(goodId,goodName,size);
    }
}


