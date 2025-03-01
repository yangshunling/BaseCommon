package com.anonymous.base.common;

import cn.hutool.core.date.DateUtil;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * <p>
 * BaseCommonApplication 启动类
 * </p>
 *
 * @author Anonymous
 * @since 2024/12/13 19:36
 */
@SpringBootApplication
@MapperScan("com.anonymous.base.common.web.mapper")
public class BaseCommonApplication {

    public static void main(String[] args) throws ParseException {
        SpringApplication.run(BaseCommonApplication.class, args);
    }

}
