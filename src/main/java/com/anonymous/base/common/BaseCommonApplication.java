package com.anonymous.base.common;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching // 开启SpringBoot的缓存支持
public class BaseCommonApplication {

    public static void main(String[] args) {
        SpringApplication.run(BaseCommonApplication.class, args);
    }

}
