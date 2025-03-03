package com.anonymous.base.common.web.model.convertor;

import com.anonymous.base.common.base.BaseConvertor;
import com.anonymous.base.common.web.model.entity.SysUserEntity;
import com.anonymous.base.common.web.model.dto.SysUserDTO;
import com.anonymous.base.common.web.model.vo.SysUserVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * <p>
 * Convertor
 * </p>
 *
 * @author Anonymous
 * @since 2025-01-09 19:53:47
 */
@Mapper
public interface SysUserConvertor extends BaseConvertor<SysUserVO, SysUserDTO, SysUserEntity> {
    SysUserConvertor INSTANCE = Mappers.getMapper(SysUserConvertor.class);
}