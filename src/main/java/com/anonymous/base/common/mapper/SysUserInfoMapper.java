package com.anonymous.base.common.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.anonymous.base.common.model.entity.SysUserInfoEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 * 用户信息表 Mapper 接口
 * </p>
 *
 * @author Anonymous
 * @since 2024-12-06 13:41:30
 */
@Mapper
public interface SysUserInfoMapper extends BaseMapper<SysUserInfoEntity> {

}
