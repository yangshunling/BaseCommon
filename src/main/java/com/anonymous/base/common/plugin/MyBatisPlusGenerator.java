package com.anonymous.base.common.plugin;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.rules.DateType;

import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * MyBatisPlusGenerator MybatisPlus代码生成器
 * </p>
 *
 * @author Anonymous
 * @since 2024/12/13 19:35
 */
public class MyBatisPlusGenerator {

    public static void main(String[] args) {
        FastAutoGenerator.create("jdbc:mysql://10.20.26.60:33063/common-hspbs?autoReconnect=true&useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone=Asia/Shanghai&allowMultiQueries=true", "root", "admin@123")
                .globalConfig(builder -> builder
                        .author("Anonymous") // 设置作者
                        .disableOpenDir() // 禁止打开输出目录
                        .outputDir(Paths.get(System.getProperty("user.dir")) + "/src/main/java")
                        .dateType(DateType.ONLY_DATE) // 设置时间类型策略
                        .commentDate("yyyy-MM-dd HH:mm:ss")
                )
                .packageConfig(builder -> builder
                        .parent("com.anonymous.base.common")
                        .controller("plugin.generator")
                        .entity("plugin.generator")
                        .mapper("plugin.generator")
                        .service("plugin.generator")
                        .serviceImpl("plugin.generator")
                )
                .strategyConfig(builder -> builder
                        .addInclude("sys_department")
                        .entityBuilder()
                        .enableLombok()
                        .enableTableFieldAnnotation()
                        .controllerBuilder()
                        .enableRestStyle()
                )
                .injectionConfig(consumer -> {
                    Map<String, String> customFile = new HashMap<>();
                    customFile.put("Entity.java", "templates/entity.java.ftl");
                    customFile.put("DTO.java", "templates/dto.java.ftl");
                    customFile.put("VO.java", "templates/vo.java.ftl");
                    customFile.put("Convertor.java", "templates/convertor.java.ftl");
                    consumer.customFile(customFile);
                })
                .templateEngine(new EnhanceFreemarkerTemplateEngine())
                .execute();
    }
}
