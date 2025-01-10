package com.anonymous.base.common.web.model.convertor;

import com.anonymous.base.common.base.BaseConvertor;
import com.anonymous.base.common.web.model.dto.SysDepartmentDTO;
import com.anonymous.base.common.web.model.entity.SysDepartmentEntity;
import com.anonymous.base.common.web.model.vo.SysDepartmentVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * <p>
 * Convertor
 * </p>
 *
 * @author Anonymous
 * @since 2025-01-10 13:56:13
 */
@Mapper
public interface SysDepartmentConvertor extends BaseConvertor<SysDepartmentVO, SysDepartmentDTO, SysDepartmentEntity> {
    SysDepartmentConvertor INSTANCE = Mappers.getMapper(SysDepartmentConvertor.class);
}