package com.anonymous.base.common.service;

import com.anonymous.base.common.model.dto.SysMenuDTO;
import com.anonymous.base.common.model.entity.SysMenuEntity;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 系统菜单表 服务类
 * </p>
 *
 * @author Anonymous
 * @since 2024-12-20 18:52:26
 */
public interface ISysMenuService extends IService<SysMenuEntity> {
    /**
     * 创建新菜单
     *
     * @param menuDTO 菜单DTO，包含菜单的详细信息
     */
    void createMenu(SysMenuDTO menuDTO);

    /**
     * 更新菜单信息
     *
     * @param menuDTO 菜单DTO，包含更新后的菜单信息
     */
    void updateMenu(SysMenuDTO menuDTO);

    /**
     * 删除指定菜单
     *
     * @param menuId 菜单ID
     */
    void deleteMenu(Integer menuId);

    /**
     * 获取菜单列表（支持递归获取子菜单）
     *
     * @param parentId 菜单的父级ID，若为null则查询所有菜单
     * @return 菜单DTO列表
     */
    Page<SysMenuEntity> getMenus(Integer parentId);
}
