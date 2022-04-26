package com.zengxuan.admin.service;

import com.zengxuan.admin.entity.Depository;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 仓库 服务类
 * </p>
 *
 * @author ZengXuan
 * @since 2022-04-25
 */
public interface IDepositoryService extends IService<Depository> {

    String getDepository();


    String addDepository(int goodsId, int num);

    String reduceDepository(int goodsId, int num);

    String getDepositoryByGoodsId(int goodsId);
}
