package com.anonymous.base.common.web.model.dto;

import java.util.Date;

import com.anonymous.base.common.base.BasePageParam;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * <p>
 * DTO
 * </p>
 *
 * @author Anonymous
 * @since 2025-01-09 19:53:47
 */
@Data
public class SysUserDTO extends BasePageParam {

    /**
     * 用户ID
     */
    @JsonProperty("user_id")
    private Integer userId;
    /**
     * 用户名
     */
    @JsonProperty("user_name")
    private String userName;
    /**
     * 用户密码
     */
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
    /**
     * 账户创建时间
     */
    @JsonProperty("created_time")
    private Date createdTime;
    /**
     * 账户更新时间
     */
    @JsonProperty("updated_time")
    private Date updatedTime;
}
