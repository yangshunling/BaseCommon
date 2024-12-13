package com.anonymous.base.common.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 系统登录日志表
 * </p>
 *
 * @author Anonymous
 * @since 2024-12-13 19:27:16
 */
@Getter
@Setter
@TableName("sys_log_login")
public class SysLogLoginEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 序号
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 登录用户名
     */
    @TableField("username")
    private String username;

    /**
     * 登录IP
     */
    @TableField("login_ip")
    private String loginIp;

    /**
     * 运营商
     */
    @TableField("operator")
    private String operator;

    /**
     * 大洲
     */
    @TableField("continent")
    private String continent;

    /**
     * 国家
     */
    @TableField("country")
    private String country;

    /**
     * 省份
     */
    @TableField("province")
    private String province;

    /**
     * 城市
     */
    @TableField("city")
    private String city;

    /**
     * 县区
     */
    @TableField("district")
    private String district;

    /**
     * 经度
     */
    @TableField("longitude")
    private BigDecimal longitude;

    /**
     * 纬度
     */
    @TableField("latitude")
    private BigDecimal latitude;

    /**
     * 登录类型
     */
    @TableField("login_type")
    private String loginType;

    /**
     * 操作系统
     */
    @TableField("os")
    private String os;

    /**
     * 浏览器名
     */
    @TableField("browser")
    private String browser;

    /**
     * Agent信息
     */
    @TableField("user_agent")
    private String userAgent;

    /**
     * 所属部门
     */
    @TableField("department")
    private String department;

    /**
     * 备注
     */
    @TableField("remark")
    private String remark;

    /**
     * 创建时间
     */
    @TableField("created_at")
    private Date createdAt;
}
