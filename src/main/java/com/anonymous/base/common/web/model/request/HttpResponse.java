package com.anonymous.base.common.web.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * <p>
 * HttpResponse 统一返回数据模型
 * </p>
 *
 * @author Anonymous
 * @since 2024/12/13 19:34
 */
@Data
public class HttpResponse {
    /**
     * 错误码
     */
    @JsonProperty("error_no")
    private int errorNo;
    /**
     * 错误描述
     */
    @JsonProperty("error_info")
    private String errorInfo;
    /**
     * 返回数据
     */
    @JsonProperty("data")
    private Object data;
}