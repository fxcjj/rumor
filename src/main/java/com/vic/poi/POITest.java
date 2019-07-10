package com.vic.poi;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * poi测试
 * Poor Obfuscation Implementation
 */
public class POITest {

    public static void main(String[] args) throws Exception {

        // 创建excel
//        createExcel();

        // 读取excel
        List<User> users = readExcel();
        for(User u : users) {
            System.out.println(u.getId() + ", " + u.getName());
        }

    }

    /**
     * 读取excel
     */
    private static List<User> readExcel() throws Exception {
        String path = "d://aa.xlsx";
        XSSFWorkbook wb = new XSSFWorkbook(new FileInputStream(path));

        // 获取sheet1
        XSSFSheet sheet = wb.getSheet("sheet1");

//        int lastRowNum = sheet.getLastRowNum();
        // 获取sheet1的行数
        int rowNum = sheet.getPhysicalNumberOfRows();

//        System.out.println(lastRowNum);
//        System.out.println(rowNum);


        List<User> userList = new ArrayList<>();
        // 遍历行数
        for(int i = 0; i < rowNum; i++) {
            XSSFRow row = sheet.getRow(i);

            // 为空时，遍历下一行
            if(row == null)
                continue;

            // id列，数值
            // 获取第i行的第0列（即第1列）
            String id = Demo1Util.getCellValue(row.getCell(0));


            // name列，字符串
            // 获取第i行的第1列（即第2列）
            String name = Demo1Util.getCellValue(row.getCell(1));

            // 设置属性
            User user = new User();
            user.setId(id);
            user.setName(name);

            // 添加到集合
            userList.add(user);
        }

        return userList;

    }

    /**
     * 创建excel
     */
    private static void createExcel() throws Exception {
        // 创建工作簿，XSSF代表10版的Excel(HSSF是03版的Excel)
        XSSFWorkbook wb = new XSSFWorkbook();

        // 工作表
        XSSFSheet sheet = wb.createSheet("会员列表");

        // 第一行
        XSSFRow header = sheet.createRow(0);

        // 第一列第一行，0代表第一列第一行
        XSSFCell cell0 = header.createCell(0);
        // 设置第一列第一行的值
        cell0.setCellValue("会员级别");
        header.createCell(1).setCellValue("会员编号");
        header.createCell(2).setCellValue("会员姓名");

        // 设置列的宽度
        // getPhysicalNumberOfCells()方法表示这行有多少包含数据的列
        for(int i = 0;i < header.getPhysicalNumberOfCells(); i++){
            //POI设置列宽度时比较特殊，它的基本单位是1/255个字符大小，
            //因此我们要想让列能够盛的下20个字符的话，就需要用255*20
            sheet.setColumnWidth(i, 255 * 20);
        }

        //设置行高，行高的单位就是像素，因此30就是30像素的意思
        header.setHeightInPoints(30);
        //上面设置好了内容，我们当然是要输出到某个文件的，输出就需要有输出流
        FileOutputStream fos= new FileOutputStream("d:/2010.xlsx");

        //向指定文件写入内容
        wb.write(fos);
        fos.close();

    }

}
