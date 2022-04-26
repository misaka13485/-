package com.zengxuan.core.service.impl;

import com.zengxuan.core.entity.GoodInfo;
import com.zengxuan.core.mapper.GoodInfoMapper;
import com.zengxuan.core.service.IGoodInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author ZengXuan
 * @since 2022-04-24
 */
@Service
public class GoodInfoServiceImpl extends ServiceImpl<GoodInfoMapper, GoodInfo> implements IGoodInfoService {

    @Autowired
    private GoodInfoMapper goodInfoMapper;

    @Override
    public String addGoods(String id, String goodsId, String goodsName, int size) {
        GoodInfo goodInfo = new GoodInfo();
        goodInfo.setGoodSize(BigDecimal.valueOf(size));
        goodInfo.setName(goodsName);
        try {
            goodInfoMapper.insert(goodInfo);
        } catch (Exception e) {
            log.error("添加商品失败，商品信息"+goodInfo.toString());
            return "添加失败";
        }
        return "添加成功";
    }

    @Override
    public String getGoodInfo() {
        List<GoodInfo> goodInfoList = goodInfoMapper.selectList(null);
        String result = "{\"data\":[ [";
        for (GoodInfo goodInfo : goodInfoList) {
            result += goodInfo.toString() + ",";
        }
        result = result.substring(0, result.length() - 1);
        result += "]}";
        return result;
    }
}
