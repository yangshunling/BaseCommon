package com.anonymous.base.common.base;

import java.util.List;

/**
 * <p>
 * BaseConvertor 对象映射通用转换基类
 * </p>
 *
 * @author Anonymous
 * @since 2025/1/9 16:50
 */
public interface BaseConvertor<VO, DTO, ENTITY> {

    /**
     * 将 ENTITY 类型转换为 VO 类型。
     *
     * @param entity ENTITY 类型的对象
     * @return 转换后的 VO 类型对象
     */
    VO toVO(ENTITY entity);

    /**
     * 将 DTO 类型转换为 ENTITY 类型。
     *
     * @param dto DTO 类型的对象
     * @return 转换后的 ENTITY 类型对象
     */
    ENTITY toEntity(DTO dto);

    /**
     * 批量将 ENTITY 类型对象转换为 VO 类型对象。
     *
     * @param entities ENTITY 类型的对象列表
     * @return 转换后的 VO 类型对象列表
     */
    List<VO> toVOList(List<ENTITY> entities);

    /**
     * 批量将 DTO 类型对象转换为 ENTITY 类型对象。
     *
     * @param dtos DTO 类型的对象列表
     * @return 转换后的 ENTITY 类型对象列表
     */
    List<ENTITY> toEntityList(List<DTO> dtos);
}
