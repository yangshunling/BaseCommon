package com.anonymous.base.common.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 系统操作日志表
 * </p>
 *
 * @author Anonymous
 * @since 2024-12-13 19:36:24
 */
@Getter
@Setter
@TableName("sys_log_operate")
public class SysLogOperateEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 序号
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 请求模块
     */
    @TableField("module_name")
    private String moduleName;

    /**
     * 请求地址
     */
    @TableField("request_url")
    private String requestUrl;

    /**
     * 请求参数
     */
    @TableField("request_params")
    private String requestParams;

    /**
     * 请求方法 (GET, POST, etc.)
     */
    @TableField("request_method")
    private String requestMethod;

    /**
     * 操作说明
     */
    @TableField("operation_description")
    private String operationDescription;

    /**
     * IP地址
     */
    @TableField("ip_address")
    private String ipAddress;

    /**
     * 请求浏览器
     */
    @TableField("user_agent")
    private String userAgent;

    /**
     * 响应码
     */
    @TableField("response_code")
    private Integer responseCode;

    /**
     * 操作系统
     */
    @TableField("os")
    private String os;

    /**
     * 返回信息
     */
    @TableField("response_message")
    private String responseMessage;

    /**
     * 操作人
     */
    @TableField("operator")
    private String operator;

    /**
     * 创建时间
     */
    @TableField("created_at")
    private Date createdAt;
}
