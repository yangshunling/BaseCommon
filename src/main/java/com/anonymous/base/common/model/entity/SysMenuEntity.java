package com.anonymous.base.common.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 系统菜单表
 * </p>
 *
 * @author Anonymous
 * @since 2024-12-20 18:52:26
 */
@Data
@TableName("sys_menu")
public class SysMenuEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键 ID
     */
    @TableId(value = "menu_id", type = IdType.AUTO)
    private Integer menuId;

    /**
     * 父菜单 ID，顶级菜单为 0
     */
    @TableField("menu_parent_id")
    private Integer menuParentId;

    /**
     * 菜单名称
     */
    @TableField("menu_name")
    private String menuName;

    /**
     * 菜单路径，前端路由用
     */
    @TableField("menu_path")
    private String menuPath;

    /**
     * 菜单图标，前端显示用
     */
    @TableField("menu_icon")
    private String menuIcon;

    /**
     * 排序，数字越小越靠前
     */
    @TableField("menu_order")
    private Integer menuOrder;

    /**
     * 是否可见：1-可见，0-不可见
     */
    @TableField("is_visible")
    private Boolean isVisible;

    /**
     * 是否启用：1-启用，0-禁用
     */
    @TableField("is_enabled")
    private Boolean isEnabled;

    /**
     * 创建时间
     */
    @TableField("create_time")
    private Date createTime;

    /**
     * 更新时间
     */
    @TableField("update_time")
    private Date updateTime;

    /**
     * 备注信息
     */
    @TableField("remark")
    private String remark;
}
