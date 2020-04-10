package com.vic.poi;

import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

import javax.swing.filechooser.FileSystemView;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Date;

/**
 * poi测试
 * Poor Obfuscation Implementation
 *
 * https://blog.csdn.net/vbirdbest/article/details/72870714
 * @author victor
 */
public class POITest1 {

    public static void main(String[] args) throws Exception {

        createExcel1();
        // 创建excel
//        createExcel();

        // 读取excel
//        readExcel();

    }

    /**
     * 读取excel
     */
    private static void readExcel() throws Exception {

        // 获取桌面
        FileSystemView fsv = FileSystemView.getFileSystemView();
        //C:\Users\Victor\Desktop
        String desktop = fsv.getHomeDirectory().getPath();
        String filePath = desktop + "/famine.xls";
        File file = new File(filePath);
        FileInputStream fis = new FileInputStream(file);

        BufferedInputStream bufferedInputStream = new BufferedInputStream(fis);
        POIFSFileSystem fileSystem = new POIFSFileSystem(bufferedInputStream);
        HSSFWorkbook workbook = new HSSFWorkbook(fileSystem);
        HSSFSheet sheet = workbook.getSheet("sheet1");

        // 最后一行的索引，从0开始
        int lastRowIndex = sheet.getLastRowNum();
//        System.out.println(lastRowIndex);
        for (int i = 0; i <= lastRowIndex; i++) {
            HSSFRow row = sheet.getRow(i);
            if (row == null)
                break;

            short lastCellNum = row.getLastCellNum();
            for (int j = 0; j < lastCellNum; j++) {
                String cellValue = row.getCell(j).getStringCellValue();
                System.out.println(cellValue);
            }
        }


        bufferedInputStream.close();
    }

    /**
     * 创建excel
     */
    private static void createExcel() throws Exception {

        // 获取桌面
        FileSystemView fsv = FileSystemView.getFileSystemView();
        //C:\Users\Victor\Desktop
        String desktop = fsv.getHomeDirectory().getPath();
        String filePath = desktop + "/famine.xls";

        File file = new File(filePath);
        FileOutputStream fos = new FileOutputStream(file);

        // 创建工作簿
        HSSFWorkbook workbook = new HSSFWorkbook();
        // 创建工作表
        HSSFSheet beverly1 = workbook.createSheet("sheet1");

        // 创建第一行
        HSSFRow header = beverly1.createRow(0);

        // 创建单元格并设值
        header.createCell(0).setCellValue("id");
        header.createCell(1).setCellValue("订单号");
        header.createCell(2).setCellValue("下单时间");
        header.createCell(3).setCellValue("个数");
        header.createCell(4).setCellValue("单价");
        header.createCell(5).setCellValue("订单金额");


        // 创建第二行
        HSSFRow row1 = beverly1.createRow(1);
        // id
        row1.createCell(0).setCellValue("1");
        // 订单号
        row1.createCell(1).setCellValue("N001");

        // 下单时间，日期格式化
        HSSFCellStyle cellStyle2 = workbook.createCellStyle();
        HSSFCreationHelper creationHelper = workbook.getCreationHelper();
        cellStyle2.setDataFormat(creationHelper.createDataFormat().getFormat("yyyy-MM-dd HH:mm:ss"));


        HSSFCell cell2 = row1.createCell(2);
        cell2.setCellStyle(cellStyle2);
        cell2.setCellValue(new Date());

        // 设置第N列的宽度
        beverly1.setColumnWidth(2, 20 * 256);

        // 个数
        row1.createCell(3).setCellValue(2);

        // 单价，保留两位小数
        HSSFCellStyle cellStyle3 = workbook.createCellStyle();
        cellStyle3.setDataFormat(HSSFDataFormat.getBuiltinFormat("0.00"));
        HSSFCell cell4 = row1.createCell(4);
        cell4.setCellStyle(cellStyle3);
        cell4.setCellValue(29.5);

        // 货币格式化
        HSSFCellStyle cellStyle4 = workbook.createCellStyle();
        HSSFFont font = workbook.createFont();
        font.setFontName("华文行楷");
        font.setFontHeightInPoints((short)15);
        font.setColor(HSSFColor.RED.index);
        cellStyle4.setFont(font);

        // 订单金额=个数*单价
        HSSFCell cell5 = row1.createCell(5);
        cell5.setCellFormula("D2*E2");  // 设置计算公式

        // 获取计算公式的值
        HSSFFormulaEvaluator e = new HSSFFormulaEvaluator(workbook);
        cell5 = e.evaluateInCell(cell5);
        System.out.println(cell5.getNumericCellValue());


        workbook.setActiveSheet(0);
        workbook.write(fos);
        fos.close();

    }


    /**
     * 创建excel
     */
    private static void createExcel1() throws Exception {

        // 获取桌面
        FileSystemView fsv = FileSystemView.getFileSystemView();
        //C:\Users\Victor\Desktop
        String desktop = fsv.getHomeDirectory().getPath();
        String filePath = desktop + "/hello.xls";

        File file = new File(filePath);
        FileOutputStream fos = new FileOutputStream(file);

        // 创建工作簿
        HSSFWorkbook workbook = new HSSFWorkbook();
        // 创建工作表
        HSSFSheet beverly1 = workbook.createSheet("sheet1");

        // 创建第一行
        for(int i = 0; i < 3; i++) {
            beverly1.createRow(i).createCell(0).setCellValue("你好" + (i + 1));
        }

        workbook.write(fos);
        fos.close();

    }

}
