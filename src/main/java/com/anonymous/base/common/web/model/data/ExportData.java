package com.anonymous.base.common.web.model.data;

import cn.idev.excel.annotation.ExcelProperty;
import cn.idev.excel.annotation.write.style.HeadRowHeight;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@HeadRowHeight(25)
public class ExportData {
    @ExcelProperty("ID")
    private Long id;

    @ExcelProperty("姓名")
    private String name;

    @ExcelProperty("年龄")
    private Integer age;

    @ExcelProperty("部门")
    private String department;
}
