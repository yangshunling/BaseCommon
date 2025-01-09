package com.anonymous.base.common.plugin.generator;

import com.anonymous.base.common.base.BaseConvertor;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * <p>
 * Convertor
 * </p>
 *
 * @author Anonymous
 * @since 2025-01-09 19:30:42
 */
@Mapper
public interface SysUserConvertor extends BaseConvertor<SysUserVO, SysUserDTO, SysUserEntity> {
    SysUserConvertor INSTANCE = Mappers.getMapper(SysUserConvertor.class);
}