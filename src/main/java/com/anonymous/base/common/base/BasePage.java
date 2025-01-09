package com.anonymous.base.common.base;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * <p>
 * BasePage 分页实体
 * </p>
 *
 * @author Anonymous
 * @since 2025/1/9 17:15
 */
@Data
public class BasePage {
    /**
     * 页码
     */
    @JsonProperty("page_num")
    private int pageNum = 1;

    /**
     * 页数
     */
    @JsonProperty("page_size")
    private int pageSize = 10;
}
