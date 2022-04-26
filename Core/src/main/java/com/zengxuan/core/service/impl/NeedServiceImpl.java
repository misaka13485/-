package com.zengxuan.core.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zengxuan.core.entity.GoodInfo;
import com.zengxuan.core.entity.Need;
import com.zengxuan.core.mapper.GoodInfoMapper;
import com.zengxuan.core.mapper.NeedMapper;
import com.zengxuan.core.service.INeedService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
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
 * @since 2022-04-20
 */
@Service
@Slf4j
public class NeedServiceImpl extends ServiceImpl<NeedMapper, Need> implements INeedService {
    @Autowired
    private NeedMapper needMapper;

    @Autowired
    private GoodInfoMapper goodInfoMapper;


    @Override
    public String addNewNeed(int needer, int goodsId, int amount) {
        Need need = new Need();
        need.setNeeder(BigDecimal.valueOf(needer));
        need.setGoodId(BigDecimal.valueOf(goodsId));
        need.setAmount(BigDecimal.valueOf(amount));
        need.setStatus("待处理");
        QueryWrapper<GoodInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("goodsId", goodsId);
        GoodInfo goodInfo = goodInfoMapper.selectOne(queryWrapper);
        if (goodInfo == null){
            return "没有找到该商品,请检查商品id";
        }
        try{
            needMapper.insert(need);
        } catch (Exception e){
            log.error("添加需求失败，需求人：{}，商品id：{}，数量：{}", needer, goodsId, amount);
            log.error("错误信息："+e.getMessage());
            return "添加失败,请检查输入";
        }
        return "添加成功";
    }






    @Override
    public String getNeedsById(String id) {
        QueryWrapper<Need> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("needer", id);
        List<Need> need = needMapper.selectList(queryWrapper);
        if (need == null){
            return "没有找到该需求";
        }else {
            StringBuilder result = new StringBuilder("{\"data\":[");
            for (Need need1:need) {
                result.append(need1.toString()).append(",");
             }
            result = new StringBuilder(result.substring(0, result.length() - 1));
            result.append("]}");
            return result.toString();

            }
        }

}
