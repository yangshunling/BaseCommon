package com.anonymous.base.common.helper;

import com.anonymous.base.common.model.dto.SysUserInfoDTO;
import com.anonymous.base.common.model.entity.SysUserInfoEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * <p>
 * BaseConvertHelper 对象映射通用转换类
 * </p>
 *
 * @author Anonymous
 * @since 2024/12/13 19:33
 */
@Mapper
public interface BaseConvertHelper {

    /**
     * 单例模式获取 CommonMapper 对象
     */
    BaseConvertHelper INSTANCE = Mappers.getMapper(BaseConvertHelper.class);

    /**
     * SysUserInfoDTO 对象转换为 SysUserInfoEntity 对象
     *
     * @param sysUserInfoDTO SysUserInfoDTO 对象
     * @return SysUserInfoEntity 对象
     */
    SysUserInfoEntity sysUserDtoToEntity(SysUserInfoDTO sysUserInfoDTO);
}
