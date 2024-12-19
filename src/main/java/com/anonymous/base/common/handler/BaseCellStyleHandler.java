package com.anonymous.base.common.handler;

import com.alibaba.excel.metadata.Head;
import com.alibaba.excel.metadata.data.WriteCellData;
import com.alibaba.excel.write.handler.CellWriteHandler;
import com.alibaba.excel.write.metadata.holder.WriteSheetHolder;
import com.alibaba.excel.write.metadata.holder.WriteTableHolder;
import org.apache.poi.ss.usermodel.*;

import java.util.List;

/**
 * <p>
 * BaseCellStyleHelper 表格样式设置类
 * </p>
 *
 * @author Anonymous
 * @since 2024/12/17 9:36
 */
public class BaseCellStyleHandler implements CellWriteHandler {

    /**
     * 定义表头样式
     */
    private CellStyle headStyle;
    /**
     * 定义内容样式
     */
    private CellStyle contentStyle;

    /**
     * 问题：然而在我们自定义的拦截器中，操作当前单元格样式时会无法生效，这是因为在3.1.x版本后有一个FillStyleCellWriteHandler拦截器，他会把OriginCellStyle和WriteCellStyle合并，会已WriteCellStyle样式为主，他的order是50000，而我们自定义的拦截器默认是0，因此我们修改的样式会被覆盖。
     * 解决：我们可以在我们的自定义拦截器重写order方法，将其值设置大于50000即可
     *
     * @return 拦截器的顺序
     */
    @Override
    public int order() {
        return 50001;
    }

    /**
     * 在单元格写入完成后设置样式
     *
     * @param writeSheetHolder 表示当前工作表的信息
     * @param writeTableHolder 表示当前表格的信息，可能为空
     * @param cellDataList     当前单元格的数据列表
     * @param cell             当前单元格
     * @param head             表头信息，若为表头单元格则非空
     * @param relativeRowIndex 当前行的相对索引，从 0 开始
     * @param isHead           是否是表头单元格
     */
    @Override
    public void afterCellDispose(WriteSheetHolder writeSheetHolder, WriteTableHolder writeTableHolder, List<WriteCellData<?>> cellDataList, Cell cell, Head head, Integer relativeRowIndex, Boolean isHead) {
        Workbook workbook = writeSheetHolder.getSheet().getWorkbook();
        if (Boolean.TRUE.equals(isHead)) {
            // 如果是表头单元格
            if (headStyle == null) {
                headStyle = createHeadStyle(workbook);
            }
            cell.setCellStyle(headStyle);
        } else {
            // 如果是内容单元格
            if (contentStyle == null) {
                contentStyle = createContentStyle(workbook);
            }
            cell.setCellStyle(contentStyle);
        }
    }

    /**
     * 创建表头样式
     *
     * @param workbook 当前工作簿对象
     * @return 配置好的表头样式
     */
    private CellStyle createHeadStyle(Workbook workbook) {
        CellStyle headStyle = workbook.createCellStyle();
        Font headFont = workbook.createFont();

        // 设置表头字体样式：加粗、白色字体
        headFont.setBold(true);
        headFont.setColor(IndexedColors.WHITE.getIndex());
        headFont.setBold(true);
        headFont.setFontHeightInPoints((short) 12);
        headStyle.setFont(headFont);

        // 设置表头背景色为天蓝色
        headStyle.setFillForegroundColor(IndexedColors.ROYAL_BLUE.getIndex());
        headStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);

        // 设置表头文字居中对齐
        headStyle.setAlignment(HorizontalAlignment.CENTER);
        headStyle.setVerticalAlignment(VerticalAlignment.CENTER);

        // 设置表头边框
        headStyle.setBorderTop(BorderStyle.THIN);
        headStyle.setBorderBottom(BorderStyle.THIN);
        headStyle.setBorderLeft(BorderStyle.THIN);
        headStyle.setBorderRight(BorderStyle.THIN);

        return headStyle;
    }

    /**
     * 创建内容样式
     *
     * @param workbook 当前工作簿对象
     * @return 配置好的内容样式
     */
    private CellStyle createContentStyle(Workbook workbook) {
        CellStyle contentStyle = workbook.createCellStyle();
        Font contentFont = workbook.createFont();

        // 设置内容字体样式：黑色字体
        contentFont.setColor(IndexedColors.BLACK.getIndex());
        contentStyle.setFont(contentFont);

        // 设置内容文字左对齐
        contentStyle.setAlignment(HorizontalAlignment.LEFT);
        contentStyle.setVerticalAlignment(VerticalAlignment.CENTER);

        // 设置内容单元格边框
        contentStyle.setBorderTop(BorderStyle.THIN);
        contentStyle.setBorderBottom(BorderStyle.THIN);
        contentStyle.setBorderLeft(BorderStyle.THIN);
        contentStyle.setBorderRight(BorderStyle.THIN);

        return contentStyle;
    }
}
