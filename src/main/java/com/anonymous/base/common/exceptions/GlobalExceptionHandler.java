package com.anonymous.base.common.exceptions;

import com.anonymous.base.common.model.request.HttpResponse;
import com.anonymous.base.common.utils.ResultUtils;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.stream.Collectors;

/**
 * @author : Anonymous
 * @Description: GlobalExceptionHandler 全局异常
 * @date: 2024/12/6 14:56
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
     * 其他未知异常
     */
    @ExceptionHandler(Exception.class)
    public HttpResponse handleGenericException(Exception ex) {
        return ResultUtils.error(ex.getMessage());
    }
}
