package com.zengxuan.admin.service;

import com.zengxuan.admin.entity.Need;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 需求表 服务类
 * </p>
 *
 * @author ZengXuan
 * @since 2022-04-25
 */
public interface INeedService extends IService<Need> {

    String updateNeed(int id, int needer, int amount, int goodsId, String status);

    String deleteNeed(int id);

    String addNeed(int needer, int amount, int goodsId);

    String getNeedList();
}
