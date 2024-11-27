package com.anonymous.base.common.model.request;

import lombok.Data;

/**
 * @author : yangsl25774
 * @Description: HttpResponse
 * @date: 2024/6/21 13:09
 */
@Data
public class HttpResponse {
    /**
     * 错误码
     */
    private int errorNo;
    /**
     * 错误描述
     */
    private String errorInfo;
    /**
     * 返回数据
     */
    private Object data;
}