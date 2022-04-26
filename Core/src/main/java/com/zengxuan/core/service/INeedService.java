package com.zengxuan.core.service;

import com.zengxuan.core.dto.NeedForm;
import com.zengxuan.core.entity.Need;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.stereotype.Service;

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

    String getNeedsById(String id);

}
