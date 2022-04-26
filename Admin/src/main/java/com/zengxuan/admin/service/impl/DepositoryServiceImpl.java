package com.zengxuan.admin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zengxuan.admin.entity.Depository;
import com.zengxuan.admin.mapper.DepositoryMapper;
import com.zengxuan.admin.service.IDepositoryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

/**
 * <p>
 * 仓库 服务实现类
 * </p>
 *
 * @author ZengXuan
 * @since 2022-04-25
 */
@Service
@Slf4j
public class DepositoryServiceImpl extends ServiceImpl<DepositoryMapper, Depository> implements IDepositoryService {
    @Autowired
    private DepositoryMapper depositoryMapper;

    @Override
    public String getDepository() {
        List<Depository> depositoryList = depositoryMapper.selectList(null);
        StringBuilder result = new StringBuilder("data: [");
        for (Depository depository : depositoryList) {
            result.append(depository.toString()).append(",");
        }
        result = new StringBuilder(result.substring(0, result.length() - 1));
        result.append("]");
        return result.toString();

    }

    @Override
    public String addDepository(int goodsId, int num) {
        QueryWrapper<Depository> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("goods_id", goodsId);
        Depository depository = depositoryMapper.selectOne(queryWrapper);
        if (depository == null) {
            depository = new Depository();
            depository.setGoodId(BigDecimal.valueOf(goodsId));
            depository.setAmount(BigDecimal.valueOf(num));
            try {
                depositoryMapper.insert(depository);
            } catch (Exception e) {
                log.error("添加仓库失败！"+e.getMessage());
                return "添加仓库失败！";

            }

        }else {
            BigDecimal amount = depository.getAmount();
            depository.setAmount(amount.add(BigDecimal.valueOf(num)));
            try {
                depositoryMapper.update(depository, queryWrapper);
            } catch (Exception e) {
                log.error("添加仓库失败！"+e.getMessage());
            }

        }
        return "添加仓库成功！";
    }

    @Override
    public String reduceDepository(int goodsId, int num) {
        QueryWrapper<Depository> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("goods_id", goodsId);
        Depository depository = depositoryMapper.selectOne(queryWrapper);
        if (depository == null) {
            return "仓库中没有该商品！";
        }else {
            BigDecimal amount = depository.getAmount();
            if (amount.compareTo(BigDecimal.valueOf(num)) < 0) {
                return "数量不足！";
            }else {
                depository.setAmount(amount.subtract(BigDecimal.valueOf(num)));
                try {
                    depositoryMapper.update(depository, queryWrapper);
                } catch (Exception e) {
                    log.error("减少仓库失败！"+e.getMessage());
                }
            }
        }
        return "减少仓库成功！";
    }

    @Override
    public String getDepositoryByGoodsId(int goodsId) {
        QueryWrapper<Depository> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("goods_id", goodsId);
        Depository depository = depositoryMapper.selectOne(queryWrapper);
        if (depository == null) {
            return "仓库中没有该商品！";
        }else {
            return depository.toString();
        }
    }
}
