package com.zengxuan.admin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zengxuan.admin.entity.Donate;
import com.zengxuan.admin.mapper.DonateMapper;
import com.zengxuan.admin.service.IDonateService;
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
 * @since 2022-04-25
 */
@Service
@Slf4j
public class DonateServiceImpl extends ServiceImpl<DonateMapper, Donate> implements IDonateService {
    @Autowired
    private DonateMapper donateMapper;

    @Override
    public String getDonateList() {
        List<Donate> list = donateMapper.selectList(null);
        StringBuilder result = new StringBuilder("{\"data\":[");
        for (Donate donate : list) {
            result.append(donate.toString()).append(",");
        }
        result = new StringBuilder(result.substring(0, result.length() - 1));
        result.append("]}");
        return result.toString();
    }

    @Override
    public String addDonate(int donater, int amount, int goodsId) {
        Donate donate = new Donate();
        donate.setDonater(BigDecimal.valueOf(donater));
        donate.setAmount(BigDecimal.valueOf(amount));
        donate.setGoodsId(BigDecimal.valueOf(goodsId));
        try {
            donateMapper.insert(donate);
        } catch (Exception e) {
            log.error("添加捐赠记录失败：" + e.getMessage());
            return "添加捐赠记录失败";
        }
        return "添加捐赠记录成功";
    }

    @Override
    public String deleteDonate(int id) {
        try {
            donateMapper.deleteById(id);
        } catch (Exception e) {
            log.error("删除捐赠记录失败：" + e.getMessage());
            return "删除捐赠记录失败";
        }
        return "删除捐赠记录成功";
    }

    @Override
    public String updateDonate(int id, int donater, int amount, int goodsId) {
        Donate donate = new Donate();
        donate.setId(BigDecimal.valueOf(id));
        donate.setDonater(BigDecimal.valueOf(donater));
        donate.setAmount(BigDecimal.valueOf(amount));
        donate.setGoodsId(BigDecimal.valueOf(goodsId));
        try {
            donateMapper.updateById(donate);
        } catch (Exception e) {
            log.error("更新捐赠记录失败：" + e.getMessage());
            return "更新捐赠记录失败";
        }
        return "更新捐赠记录成功";
    }
}
