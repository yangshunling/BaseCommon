package com.anonymous.base.common.exceptions;

/**
 * <p>
 * BaseCommonException 自定义异常类
 * </p>
 *
 * @author Anonymous
 * @since 2024/12/13 19:32
 */
public class CommonException extends RuntimeException {

    /**
     * 默认构造函数
     */
    public CommonException() {
    }

    /**
     * 带消息构造函数
     *
     * @param message 异常消息
     */
    public CommonException(String message) {
        super(message);
    }

    /**
     * 带消息和原因构造函数
     *
     * @param message 异常消息
     * @param cause   异常原因
     */
    public CommonException(String message, Throwable cause) {
        super(message, cause);
    }
}
