package com.anonymous.base.common.aspect;


import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson.JSON;
import com.anonymous.base.common.constant.BaseCommonConstant;
import com.anonymous.base.common.exceptions.BaseCommonException;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 * BaseCommonAspect
 * </p>
 *
 * @author Anonymous
 * @since 2024/12/13 19:33
 */
@Aspect
@Slf4j
@Component
public class BaseCommonAspect {

    /**
     * 定义切入点
     */
    @Pointcut("execution(* com.anonymous.base.common.controller..*.*(..))")
    public void log() {
    }

    /**
     * 在切点之前
     *
     * @param joinPoint 切点
     */
    @Before("log()")
    public void doBefore(JoinPoint joinPoint) {
        // 开始打印请求日志
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        if (attributes == null) {
            throw new BaseCommonException(StrUtil.format("【{}】Attributes cannot be null", BaseCommonConstant.BASE_COMMON_ASPECT));
        }
        HttpServletRequest request = attributes.getRequest();
        // 打印请求相关参数
        log.info("");
        log.info("=========================== Start ===========================");
        // 打印请求 url
        log.info("URL            : {}", request.getRequestURL().toString());
        // 打印 Http method
        log.info("HTTP Method    : {}", request.getMethod());
        // 打印调用 controller 的全路径以及执行方法
        log.info("Class Method   : {}", joinPoint.getSignature().getName());
        // 打印请求的 IP
        log.info("IP             : {}", request.getRemoteAddr());
        // 打印请求入参
        log.info("Request Args   : {}", JSON.toJSONString(joinPoint.getArgs()));
        //请求头
        String token = request.getHeader("Authorization");
        log.info("token          : {}", token);
    }

    /**
     * 在切点之后
     */
    @After("log()")
    public void doAfter() {
        log.info("============================ End ===========================");
    }

    /**
     * 环绕切入
     *
     * @param object 切点返回值
     */
    @AfterReturning(returning = "object", pointcut = "log()")
    public void doAfterReturning(Object object) {
    }
}
