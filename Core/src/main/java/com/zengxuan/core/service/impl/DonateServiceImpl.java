package com.zengxuan.core.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zengxuan.core.entity.Donate;
import com.zengxuan.core.entity.GoodInfo;
import com.zengxuan.core.mapper.DonateMapper;
import com.zengxuan.core.mapper.GoodInfoMapper;
import com.zengxuan.core.service.IDonateService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

/**
 * <p>
 * 捐赠记录 服务实现类
 * </p>
 *
 * @author ZengXuan
 * @since 2022-04-21
 */
@Service
@Slf4j
public class DonateServiceImpl extends ServiceImpl<DonateMapper, Donate> implements IDonateService {
    @Autowired
    private DonateMapper donateMapper;

    @Autowired
    private GoodInfoMapper goodInfoMapper;


    @Override
    public String addNewDonate(int id, int goodsId, int amount) {
        Donate donate = new Donate();
        donate.setId(BigDecimal.valueOf(id));
        donate.setGoodsId(BigDecimal.valueOf(goodsId));
        donate.setAmount(BigDecimal.valueOf(amount));
        donate.setStatus("待处理");
        QueryWrapper<GoodInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("goodsId", goodsId);
        GoodInfo goodInfo = goodInfoMapper.selectOne(queryWrapper);
        if (goodInfo == null) {
            return "捐赠失败，请检查物品ID是否正确";
        }
        try{
            donateMapper.insert(donate);
        } catch (Exception e) {
            log.error("捐赠失败，请检查参数是否正确: 捐赠人id={}, 货物id={}, 数量={}", id, goodsId, amount);
            log.error(e.getMessage());
            throw e;
        }
        return "捐赠信息添加成功";
    }

    @Override
    public String getDonatesById(String id) {
        QueryWrapper<Donate> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("donater", id);
        List<Donate> list = donateMapper.selectList(queryWrapper);
        if (list.size() == 0) {
            return "您还没有捐赠过任何物品";
        }else {
            StringBuilder result = new StringBuilder("{\"data\":[ [");
            for (Donate donate : list) {
                result.append(donate.toString()).append(",");
            }
            result = new StringBuilder(result.substring(0, result.length() - 1));
            result.append("]}");
            return result.toString();
        }
    }
}
