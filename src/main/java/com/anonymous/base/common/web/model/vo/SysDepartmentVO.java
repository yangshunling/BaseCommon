package com.anonymous.base.common.web.model.vo;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * <p>
 * VO
 * </p>
 *
 * @author Anonymous
 * @since 2025-01-10 13:56:13
 */
@Data
public class SysDepartmentVO {

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
