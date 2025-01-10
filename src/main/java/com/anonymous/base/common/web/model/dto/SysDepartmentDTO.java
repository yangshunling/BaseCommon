package com.anonymous.base.common.web.model.dto;

import java.util.Date;

import com.anonymous.base.common.base.BasePageParam;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * DTO
 * </p>
 *
 * @author Anonymous
 * @since 2025-01-10 13:56:13
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class SysDepartmentDTO extends BasePageParam {

    /**
     * 部门ID
     */
    @JsonProperty("department_id")
    private Integer departmentId;
    /**
     * 部门名称
     */
    @JsonProperty("department_name")
    private String departmentName;
    /**
     * 父部门ID，0表示根部门
     */
    @JsonProperty("parent_id")
    private Integer parentId;
    /**
     * 角色描述
     */
    @JsonProperty("description")
    private String description;
    /**
     * 创建时间
     */
    @JsonProperty("create_time")
    private Date createTime;
    /**
     * 更新时间
     */
    @JsonProperty("update_time")
    private Date updateTime;
}
