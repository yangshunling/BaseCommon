package com.anonymous.base.common.exceptions;

import com.anonymous.base.common.web.model.request.HttpResponse;
import com.anonymous.base.common.utils.ResultUtils;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.stream.Collectors;

/**
 * <p>
 * GlobalExceptionHandler 全局异常
 * </p>
 *
 * @author Anonymous
 * @since 2024/12/13 19:35
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 字段校验异常
     *
     * @param ex
     * @return
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public HttpResponse handleValidationExceptions(MethodArgumentNotValidException ex) {
        // 获取所有的错误信息
        String errorMessages = ex.getBindingResult().getAllErrors().stream()
                .map(DefaultMessageSourceResolvable::getDefaultMessage)
                .collect(Collectors.joining(", "));
        // 返回合适的响应
        return ResultUtils.error(errorMessages);
    }

    /**
     * BaseCommonException 异常
     */
    @ExceptionHandler(CommonException.class)
    public HttpResponse handleBaseCommonException(CommonException ex) {
        return ResultUtils.error(ex.getMessage());
    }

    /**
     * 其他未知异常
     */
    @ExceptionHandler(Exception.class)
    public HttpResponse handleGenericException(Exception ex) {
        return ResultUtils.error(ex.getMessage());
    }
}
