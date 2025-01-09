package com.anonymous.base.common.plugin.generator;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * <p>
 * 用户表
 * </p>
 *
 * @author Anonymous
 * @since 2025-01-09 19:27:32
 */
@Data
@TableName("sys_user")
public class SysUserEntity {

    /**
     * 用户ID
     */
    @TableId(value = "user_id", type = IdType.AUTO)
    private Integer userId;

    /**
     * 用户名
     */
    @TableField("user_name")
    private String userName;

    /**
     * 用户密码
     */
    @TableField("password")
    private String password;

    /**
     * 手机号码
     */
    @TableField("mobile")
    private String mobile;

    /**
     * 邮箱
     */
    @TableField("email")
    private String email;

    /**
     * 部门ID
     */
    @TableField("department_id")
    private Integer departmentId;

    /**
     * 账户状态
     */
    @TableField("user_status")
    private Integer userStatus;

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
