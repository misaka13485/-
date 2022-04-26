package com.zengxuan.admin.service.impl;

import com.zengxuan.admin.entity.GoodInfo;
import com.zengxuan.admin.mapper.GoodInfoMapper;
import com.zengxuan.admin.service.IGoodInfoService;
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
 * @since 2022-04-25
 */
@Service
public class GoodInfoServiceImpl extends ServiceImpl<GoodInfoMapper, GoodInfo> implements IGoodInfoService {
    @Autowired
    private GoodInfoMapper goodInfoMapper;

    @Override
    public String addGoodInfo(String goodName, int size) {
        GoodInfo goodInfo = new GoodInfo();
        goodInfo.setName(goodName);
        goodInfo.setSize(BigDecimal.valueOf(size));
        try {
            goodInfoMapper.insert(goodInfo);
        } catch (Exception e) {
            return "添加失败";
        }
        return "添加成功";
    }

    @Override
    public String getGoodInfo() {
        List<GoodInfo> goodInfoList = goodInfoMapper.selectList(null);
        StringBuilder result = new StringBuilder("{\"data\":[");
        for (GoodInfo goodInfo : goodInfoList) {
            result.append(goodInfo.toString()).append(",");
        }
        result = new StringBuilder(result.substring(0, result.length() - 1));
        result.append("]}");
        return result.toString();
    }

    @Override
    public String deleteGoodInfo(int goodId) {
        try {
            goodInfoMapper.deleteById(goodId);
        } catch (Exception e) {
            return "删除失败";
        }
        return "删除成功";
    }

    @Override
    public String updateGoodInfo(int goodId, String goodName, int size) {
        GoodInfo goodInfo = new GoodInfo();
        goodInfo.setGoodsId(BigDecimal.valueOf(goodId));
        goodInfo.setName(goodName);
        goodInfo.setSize(BigDecimal.valueOf(size));
        try {
            goodInfoMapper.updateById(goodInfo);
        } catch (Exception e) {
            return "修改失败";
        }
        return "修改成功";
    }
}
