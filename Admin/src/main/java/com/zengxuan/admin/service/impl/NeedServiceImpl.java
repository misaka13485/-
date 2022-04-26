package com.zengxuan.admin.service.impl;

import com.zengxuan.admin.entity.Need;
import com.zengxuan.admin.mapper.NeedMapper;
import com.zengxuan.admin.service.INeedService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

/**
 * <p>
 * 需求表 服务实现类
 * </p>
 *
 * @author ZengXuan
 * @since 2022-04-25
 */
@Service
public class NeedServiceImpl extends ServiceImpl<NeedMapper, Need> implements INeedService {
    @Autowired
    private NeedMapper needMapper;

    @Override
    public String updateNeed(int id, int needer, int amount, int goodsId, String status) {
        Need need = new Need();
        need.setId(BigDecimal.valueOf(id));
        need.setNeeder(BigDecimal.valueOf(needer));
        need.setAmount(BigDecimal.valueOf(amount));
        need.setGoodId(BigDecimal.valueOf(goodsId));
        need.setStatus(status);
        try {
            needMapper.updateById(need);
        } catch (Exception e) {
            return "更新失败";
        }
        return "更新成功";
    }

    @Override
    public String deleteNeed(int id) {
        try {
            needMapper.deleteById(BigDecimal.valueOf(id));
        } catch (Exception e) {
            return "删除失败";
        }
        return "删除成功";
    }

    @Override
    public String addNeed(int needer, int amount, int goodsId) {
        Need need = new Need();
        need.setNeeder(BigDecimal.valueOf(needer));
        need.setAmount(BigDecimal.valueOf(amount));
        need.setGoodId(BigDecimal.valueOf(goodsId));
        need.setStatus("待处理");
        try {
            needMapper.insert(need);
        } catch (Exception e) {
            return "添加失败";
        }
        return "添加成功";
    }

    @Override
    public String getNeedList() {
        List<Need> needList = needMapper.selectList(null);
        StringBuilder result = new StringBuilder("{\"data\":[");
        for (Need need : needList) {
            result.append("{\"id\":").append(need.getId()).append(",\"needer\":").append(need.getNeeder()).append(",\"amount\":").append(need.getAmount()).append(",\"goodId\":").append(need.getGoodId()).append(",\"status\":\"").append(need.getStatus()).append("\"},");
        }
        result = new StringBuilder(result.substring(0, result.length() - 1));
        result.append("]}");
        return result.toString();
    }
}
