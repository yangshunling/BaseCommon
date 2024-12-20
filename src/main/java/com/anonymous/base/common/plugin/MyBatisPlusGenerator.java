package com.anonymous.base.common.plugin;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.DbColumnType;

import java.nio.file.Paths;
import java.sql.Types;

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
                .dataSourceConfig(builder ->
                        builder.typeConvertHandler((globalConfig, typeRegistry, metaInfo) -> {
                            int typeCode = metaInfo.getJdbcType().TYPE_CODE;
                            if (typeCode == Types.SMALLINT) {
                                // 自定义类型转换
                                return DbColumnType.INTEGER;
                            }
                            return typeRegistry.getColumnType(metaInfo);
                        })
                )
                .packageConfig(builder -> builder
                        .parent("com.anonymous.base.common")
                        .controller("controller")
                        .entity("model.entity")
                        .mapper("mapper")
                        .service("service")
                        .serviceImpl("service.impl")
                )
                .strategyConfig(builder -> builder
                        .addInclude("")
                        .entityBuilder()
                        .enableLombok()
                        .enableTableFieldAnnotation()
                        .controllerBuilder()
                        .enableRestStyle()
                )
                .execute();
    }
}
