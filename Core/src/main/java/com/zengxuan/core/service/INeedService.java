package com.zengxuan.core.service;

import com.zengxuan.core.entity.Need;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 需求表 服务类
 * </p>
 *
 * @author ZengXuan
 * @since 2022-04-20
 */

public interface INeedService extends IService<Need> {

    String addNewNeed(int needer, int goodsId, int amount);

    List<Need> getNeedsById(int id);

}
