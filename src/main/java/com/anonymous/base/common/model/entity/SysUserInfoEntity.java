package com.anonymous.base.common.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;

import lombok.Data;

/**
 * <p>
 * 用户信息表
 * </p>
 *
 * @author Anonymous
 * @since 2024-12-06 13:41:30
 */
@Data
@TableName("sys_user_info")
public class SysUserInfoEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 用户ID
     */
    @TableId(value = "user_id", type = IdType.INPUT)
    private String userId;

    /**
     * 用户名
     */
    @TableField("user_name")
    private String userName;

    /**
     * 密码
     */
    @TableField("password")
    private String password;

    /**
     * 邮箱
     */
    @TableField("email")
    private String email;

    /**
     * 账户状态
     */
    @TableField("status")
    private String status;

    /**
     * 账户创建时间
     */
    @TableField("created_time")
    private Date createdTime;

    /**
     * 账户更新时间
     */
    @TableField("updated_time")
    private Date updatedTime;
}
