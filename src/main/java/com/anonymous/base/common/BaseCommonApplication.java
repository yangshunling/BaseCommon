package com.anonymous.base.common;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@MapperScan("com.anonymous.base.common.mapper")
public class BaseCommonApplication {

    public static void main(String[] args) {
        SpringApplication.run(BaseCommonApplication.class, args);
    }

}
