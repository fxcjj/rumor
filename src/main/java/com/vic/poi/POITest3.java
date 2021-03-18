package com.vic.poi;

import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.VerticalAlignment;

import javax.swing.filechooser.FileSystemView;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * 导出数据
 * @author victor
 */
public class POITest3 {

    public static void main(String[] args) throws Exception {

        // 导出
        exportExcel();
    }


    /**
     * 导出
     * @throws Exception
     */
    private static void exportExcel() throws Exception {

        String[] header = {"ID", "姓名"};


        // 获取桌面
        FileSystemView fsv = FileSystemView.getFileSystemView();
        //C:\Users\Victor\Desktop
        String desktop = fsv.getHomeDirectory().getPath();
        String filePath = desktop + "/user.xls";

        File file = new File(filePath);
        FileOutputStream fos = new FileOutputStream(file);

        // 创建工作簿
        HSSFWorkbook workbook = new HSSFWorkbook();
        // 创建工作表
        HSSFSheet sheet = workbook.createSheet("用户列表");


        // 表头格式
        HSSFCellStyle cellStyle = workbook.createCellStyle();
//        cellStyle.setAlignment(CellStyle.ALIGN_CENTER);
//        cellStyle.setVerticalAlignment(CellStyle.VERTICAL_CENTER);

        HSSFFont font = workbook.createFont();
        font.setColor(HSSFColor.HSSFColorPredefined.BLACK.getIndex());
        font.setBold(true);
        cellStyle.setFont(font);

        // 表头
        HSSFRow row1 = sheet.createRow(0);

        for(int i = 0; i < header.length; i++) {
            HSSFCell cell = row1.createCell(i);
            cell.setCellValue(header[i]);
            cell.setCellStyle(cellStyle);
        }

        List<User> data = new ArrayList<>();
        data.add(new User("1", "victor"));
        data.add(new User("2", "beverly"));
        data.add(new User("3", "justin"));

        for(int j = 0; j < data.size(); j++) {
            HSSFRow row = sheet.createRow(j + 1);
            // 对象属性个数，这里只有两个id和name
            row.createCell(0).setCellValue(data.get(j).getId());
            row.createCell(1).setCellValue(data.get(j).getName());
        }

        workbook.write(fos);
        fos.close();
    }


}
