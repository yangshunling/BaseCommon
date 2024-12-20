package com.anonymous.base.common.service.impl;

import com.anonymous.base.common.helper.BaseConvertHelper;
import com.anonymous.base.common.model.dto.SysMenuDTO;
import com.anonymous.base.common.model.entity.SysMenuEntity;
import com.anonymous.base.common.mapper.SysMenuMapper;
import com.anonymous.base.common.service.ISysMenuService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 系统菜单表 服务实现类
 * </p>
 *
 * @author Anonymous
 * @since 2024-12-20 18:52:26
 */
@Service
public class SysMenuServiceImpl extends ServiceImpl<SysMenuMapper, SysMenuEntity> implements ISysMenuService {

    @Autowired
    SysMenuMapper sysMenuMapper;

    /**
     * 创建菜单
     *
     * @param sysMenuDTO 菜单DTO，包含菜单的详细信息
     * @throws IllegalArgumentException 父菜单不存在时抛出异常
     */
    @Override
    public void createMenu(SysMenuDTO sysMenuDTO) {
        SysMenuEntity sysMenuEntity = BaseConvertHelper.INSTANCE.sysMenuDtoToEntity(sysMenuDTO);
        sysMenuMapper.insert(sysMenuEntity);
    }

    /**
     * 更新菜单信息
     *
     * @param sysMenuDTO 菜单DTO，包含更新后的菜单信息
     * @throws IllegalArgumentException 菜单不存在时抛出异常
     */
    @Override
    public void updateMenu(SysMenuDTO sysMenuDTO) {
        SysMenuEntity sysMenuEntity = BaseConvertHelper.INSTANCE.sysMenuDtoToEntity(sysMenuDTO);
        sysMenuMapper.updateById(sysMenuEntity);
    }

    /**
     * 删除菜单
     *
     * @param menuId 菜单ID
     * @throws IllegalArgumentException 菜单下存在子菜单时抛出异常
     */
    @Override
    public void deleteMenu(Integer menuId) {
        sysMenuMapper.deleteById(menuId);
    }

    /**
     * 获取菜单列表（支持递归获取子菜单）
     *
     * @param parentId 菜单的父级ID，若为null则查询所有菜单
     * @return 菜单DTO列表
     */
    @Override
    public Page<SysMenuEntity> getMenus(Integer parentId) {
        // 创建分页对象，设置页码和每页大小
        Page<SysMenuEntity> page = new Page<>(1, Integer.MAX_VALUE); // 页码1，每页最大数据量
        // 创建查询条件，这里没有限制条件，查询所有数据
        QueryWrapper<SysMenuEntity> queryWrapper = new QueryWrapper<>();
        // 查询所有数据
        return sysMenuMapper.selectPage(page, queryWrapper);
    }
}
