package com.zengxuan.admin.service;

import com.zengxuan.admin.entity.Donate;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 捐赠记录 服务类
 * </p>
 *
 * @author ZengXuan
 * @since 2022-04-25
 */
public interface IDonateService extends IService<Donate> {

    String getDonateList();

    String addDonate(int donater, int amount, int goodsId);

    String deleteDonate(int id);

    String updateDonate(int id, int donater, int amount, int goodsId);
}
