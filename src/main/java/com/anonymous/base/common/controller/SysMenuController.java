package com.anonymous.base.common.controller;

import com.anonymous.base.common.model.dto.SysMenuDTO;
import com.anonymous.base.common.model.entity.SysMenuEntity;
import com.anonymous.base.common.model.request.HttpResponse;
import com.anonymous.base.common.service.ISysMenuService;
import com.anonymous.base.common.utils.ResultUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 系统菜单表 前端控制器
 * </p>
 *
 * @author Anonymous
 * @since 2024-12-20 18:52:26
 */
@RestController
@RequestMapping("/sysMenu")
public class SysMenuController {

    @Autowired
    private ISysMenuService menuService;

    /**
     * 创建新菜单
     *
     * @param menuDTO 包含菜单的详细信息
     * @return 返回操作结果
     */
    @PostMapping("/create")
    public HttpResponse createMenu(@RequestBody SysMenuDTO menuDTO) {
        menuService.createMenu(menuDTO);
        return ResultUtils.success();
    }

    /**
     * 更新指定菜单信息
     *
     * @param menuDTO 包含更新后的菜单信息
     * @return 返回操作结果
     */
    @PutMapping("/update")
    public HttpResponse updateMenu(@RequestBody SysMenuDTO menuDTO) {
        menuService.updateMenu(menuDTO);
        return ResultUtils.success();
    }

    /**
     * 删除指定菜单
     *
     * @param menuId 菜单 ID
     * @return 返回操作结果
     */
    @GetMapping("/delete")
    public HttpResponse deleteMenu(@RequestParam(name = "menu_id") Integer menuId) {
        menuService.deleteMenu(menuId);
        return ResultUtils.success();
    }

    /**
     * 查询菜单列表
     *
     * @param parentId 可选参数，指定查询某个菜单及其子菜单
     * @return 返回菜单树或指定菜单及其子菜单
     */
    @GetMapping("/list")
    public HttpResponse listMenus(@RequestParam(name = "parent_id", required = false) Integer parentId) {
        Page<SysMenuEntity> results = menuService.getMenus(parentId);
        return ResultUtils.list(results.getRecords(), results.getTotal());
    }
}
