package com.anonymous.base.common.exceptions;

/**
 * @author : Anonymous
 * @Description: BaseCommonException 自定义异常类
 * @date: 2024/6/24 16:52
 */
public class BaseCommonException extends RuntimeException {

    public BaseCommonException() {
    }

    public BaseCommonException(String message) {
        super(message);
    }

    public BaseCommonException(String message, Throwable cause) {
        super(message, cause);
    }
}
