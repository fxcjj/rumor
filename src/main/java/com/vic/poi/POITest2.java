package com.vic.poi;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;

import javax.swing.filechooser.FileSystemView;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Calendar;
import java.util.Date;

/**
 * 各种单元格类型
 * @author victor
 */
public class POITest2 {

    public static void main(String[] args) throws Exception {

        // 读取
        readExcel();

        // 创建
//        createExcel();
    }

    /**
     * 读取
     */
    private static void readExcel() throws Exception {
        // 获取桌面
        FileSystemView fsv = FileSystemView.getFileSystemView();
        //C:\Users\Victor\Desktop
        String desktop = fsv.getHomeDirectory().getPath();
        String filePath = desktop + "/cell.xls";
        File file = new File(filePath);
        FileInputStream fis = new FileInputStream(file);

        BufferedInputStream bufferedInputStream = new BufferedInputStream(fis);
        POIFSFileSystem fileSystem = new POIFSFileSystem(bufferedInputStream);
        HSSFWorkbook workbook = new HSSFWorkbook(fileSystem);
        HSSFSheet sheet = workbook.getSheet("cellType");

        // 最后一行的索引，从0开始
        int lastRowIndex = sheet.getLastRowNum();
        for (int i = 0; i <= lastRowIndex; i++) {
            HSSFRow row = sheet.getRow(i);
            if (row == null)
                break;

            short lastCellNum = row.getLastCellNum();
            for (int j = 0; j < lastCellNum; j++) {
                System.out.println(CellUtils.getCellValue(row.getCell(j)));
            }
        }


        bufferedInputStream.close();

    }

    /**
     * 创建各种单元格类型
     * @throws Exception
     */
    private static void createExcel() throws Exception {
        // 获取桌面
        FileSystemView fsv = FileSystemView.getFileSystemView();
        //C:\Users\Victor\Desktop
        String desktop = fsv.getHomeDirectory().getPath();
        String filePath = desktop + "/cell.xls";

        File file = new File(filePath);
        FileOutputStream fos = new FileOutputStream(file);

        // 创建工作簿
        HSSFWorkbook workbook = new HSSFWorkbook();
        // 创建工作表
        HSSFSheet sheet = workbook.createSheet("cellType");

        // 创建第一行

        sheet.createRow(0).createCell(0).setCellValue(1.1);
        // 在excel中为43659.4766，解析？
        sheet.createRow(1).createCell(0).setCellValue(new Date());
        // 在excel中为43659.4766，解析？
        sheet.createRow(2).createCell(0).setCellValue(Calendar.getInstance());
        sheet.createRow(3).createCell(0).setCellValue("字符串");
        sheet.createRow(4).createCell(0).setCellValue(true);
        sheet.createRow(5).createCell(0).setCellType(Cell.CELL_TYPE_ERROR);

        workbook.write(fos);
        fos.close();
    }


}
