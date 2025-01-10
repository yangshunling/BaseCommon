package com.anonymous.base.common.web.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.util.Date;
import lombok.Data;

/**
 * <p>
 * 部门表
 * </p>
 *
 * @author Anonymous
 * @since 2025-01-10 13:56:13
 */
@Data
@TableName("sys_department")
public class SysDepartmentEntity {

    /**
     * 部门ID
     */
    @TableId(value = "department_id", type = IdType.AUTO)
    private Integer departmentId;

    /**
     * 部门名称
     */
    @TableField("department_name")
    private String departmentName;

    /**
     * 父部门ID，0表示根部门
     */
    @TableField("parent_id")
    private Integer parentId;

    /**
     * 角色描述
     */
    @TableField("description")
    private String description;

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
}
