package com.zengxuan.admin.service;

import com.zengxuan.admin.entity.GoodInfo;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author ZengXuan
 * @since 2022-04-25
 */
public interface IGoodInfoService extends IService<GoodInfo> {

    String addGoodInfo(String goodName, int size);

    String getGoodInfo();

    String deleteGoodInfo(int goodId);

    String updateGoodInfo(int goodId, String goodName, int size);
}
