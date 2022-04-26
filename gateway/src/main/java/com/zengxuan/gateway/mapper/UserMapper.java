package com.zengxuan.gateway.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zengxuan.gateway.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author ZengXuan
 * @since 2022-04-15
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

}
