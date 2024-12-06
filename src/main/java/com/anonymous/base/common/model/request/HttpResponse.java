package com.anonymous.base.common.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @author : Anonymous
 * @Description: HttpResponse
 * @date: 2024/6/21 13:09
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