package com.anonymous.base.common.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

/**
 * <p>
 * 用户信息表
 * </p>
 *
 * @author Anonymous
 * @since 2024-12-06 13:41:30
 */
@Data
public class SysUserInfoDTO {

    /**
     * 用户名
     */
    @NotEmpty(message = "用户名不能为空")
    @JsonProperty("user_name")
    private String userName;

    /**
     * 用户密码
     */
    @NotEmpty(message = "密码不能为空")
    @JsonProperty("password")
    private String password;

    /**
     * 手机号码
     */
    @JsonProperty("mobile")
    private String mobile;

    /**
     * 邮箱
     */
    @JsonProperty("email")
    private String email;

    /**
     * 部门ID
     */
    @JsonProperty("department_id")
    private Integer departmentId;

    /**
     * 账户状态
     */
    @JsonProperty("user_status")
    private Integer userStatus;
}
