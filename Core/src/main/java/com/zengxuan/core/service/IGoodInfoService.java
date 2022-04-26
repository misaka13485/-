package com.zengxuan.core.service;

import com.zengxuan.core.entity.GoodInfo;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author ZengXuan
 * @since 2022-04-24
 */
public interface IGoodInfoService extends IService<GoodInfo> {

    String addGoods(String id, String goodsId, String goodsName, int size);

    String getGoodInfo();
}
