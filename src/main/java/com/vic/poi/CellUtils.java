package com.vic.poi;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.ss.usermodel.Cell;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 单元格工具类
 * @author victor
 */
public class CellUtils {

    public static String getCellValue(HSSFCell cell) {
        String value = "";
        switch (cell.getCellType()) {

            /**
             * 日期,数字的类型都是数值的,所有需要对每一个进行区分
             *  yyyy/MM/dd 格式的值是 14
             *  HH:mm:ss  格式的值是 21
             *  yyyy/MM/dd HH:mm:ss 格式的值是 22
             */
            case Cell.CELL_TYPE_NUMERIC: // 数字
                //short s = cell.getCellStyle().getDataFormat();
                if (HSSFDateUtil.isCellDateFormatted(cell)) {// 处理日期格式、时间格式
                    SimpleDateFormat sdf = null;
                    // 验证short值
                    if (cell.getCellStyle().getDataFormat() == 14) {
                        sdf = new SimpleDateFormat("yyyy/MM/dd");
                    } else if (cell.getCellStyle().getDataFormat() == 21) {
                        sdf = new SimpleDateFormat("HH:mm:ss");
                    } else if (cell.getCellStyle().getDataFormat() == 22) {
                        sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
                    } else {
                        throw new RuntimeException("日期格式错误!!!");
                    }
                    Date date = cell.getDateCellValue();
                    value = sdf.format(date);
                } else if (cell.getCellStyle().getDataFormat() == 0) {//处理数值格式

//                    cell.getDateCellValue()
//                    Date date = HSSFDateUtil.getJavaDate(new Double(cell.getNumericCellValue()));

                    cell.setCellType(Cell.CELL_TYPE_STRING);
                    value = cell.getRichStringCellValue().getString();
                }
                break;
            case Cell.CELL_TYPE_STRING:
                value = cell.getStringCellValue();
                break;
            case Cell.CELL_TYPE_BOOLEAN:
                value = String.valueOf(cell.getBooleanCellValue());
                break;
            case Cell.CELL_TYPE_FORMULA: // 公式
                value = String.valueOf(cell.getCellFormula());
                break;
            case Cell.CELL_TYPE_BLANK: // 空值
                value = null;
                break;
            case Cell.CELL_TYPE_ERROR: // 故障
                value = "非法字符";
                break;
            default:
                value = "未知类型";
                break;

        }
        return value;
    }
}
