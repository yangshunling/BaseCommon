package com.anonymous.base.common.model.dto;

import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

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
public class SysUserInfoDTO {

    /**
     * 用户名
     */
    @NotEmpty(message = "用户名不能为空")
    @JsonProperty("user_name")
    private String userName;

    /**
     * 密码
     */
    @NotEmpty(message = "密码不能为空")
    @JsonProperty("password")
    private String password;

    /**
     * 邮箱
     */
    @JsonProperty("email")
    private String email;
}
