package com.zengxuan.core.service;

import com.zengxuan.core.entity.Donate;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 捐赠记录 服务类
 * </p>
 *
 * @author ZengXuan
 * @since 2022-04-21
 */
public interface IDonateService extends IService<Donate> {

    String addNewDonate(int id, int goodsId, int amount);

    String getDonatesById(String id);
}
