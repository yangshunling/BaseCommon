package com.anonymous.base.common.plugin;


import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.config.builder.CustomFile;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.io.File;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * EnhanceFreemarkerTemplateEngine 自定义模板解析引擎
 * </p>
 *
 * @author Anonymous
 * @since 2025/1/9 18:38
 */
public class EnhanceFreemarkerTemplateEngine extends FreemarkerTemplateEngine {
    @Override
    protected void outputCustomFile(List<CustomFile> customFiles, TableInfo tableInfo, Map<String, Object> objectMap) {
        // objectMap 里的key可以在ftl文件中直接引用
        String entityName = tableInfo.getEntityName();
        String otherPath = this.getPathInfo(OutputFile.entity);
        customFiles.forEach(customFile -> {
            // 拼接路径
            String fileName = String.format(otherPath + File.separator + entityName + "%s", customFile.getFileName());
            this.outputFile(new File(fileName), objectMap, customFile.getTemplatePath(),true);
        });
    }
}
