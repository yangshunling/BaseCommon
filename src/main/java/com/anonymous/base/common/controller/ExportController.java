package com.anonymous.base.common.controller;

import com.alibaba.excel.EasyExcel;
import com.anonymous.base.common.handler.BaseCellStyleHandler;
import com.anonymous.base.common.model.data.ExportData;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * ExportController
 * </p>
 *
 * @author Anonymous
 * @since 2024/12/17 9:37
 */
@RestController
public class ExportController {

    @GetMapping("/export")
    public void exportExcel(HttpServletResponse response) throws IOException {
        // 设置响应头
        response.setContentType("application/vnd.ms-excel");
        response.setCharacterEncoding("utf-8");
        String fileName = URLEncoder.encode("用户数据表", "UTF-8");
        response.setHeader("Content-disposition", "attachment;filename=" + fileName + ".xlsx");

        // 模拟数据
        List<ExportData> dataList = new ArrayList<>();
        dataList.add(new ExportData(1L, "张三", 25, "销售部"));
        dataList.add(new ExportData(2L, "李四", 30, "技术部"));
        dataList.add(new ExportData(3L, "王五", 28, "市场部"));
        dataList.add(new ExportData(4L, "赵六", 35, "管理部"));

        // 导出 Excel
        EasyExcel.write(response.getOutputStream(), ExportData.class)
                .registerWriteHandler(new BaseCellStyleHandler())
                .sheet("用户数据")
                .doWrite(dataList);
    }
}
