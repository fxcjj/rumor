package com.vic.easypoi;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import com.vic.easypoi.entity.StudentEntity;
import org.apache.poi.ss.usermodel.Workbook;

import javax.swing.filechooser.FileSystemView;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Victor
 * date: 2021/3/10 17:23
 */
public class Test1 {


    public static void main(String[] args) throws Exception {

        List<StudentEntity> stuList = new ArrayList<>();
        StudentEntity s1 = new StudentEntity();
        s1.setId("1");
        s1.setName("张三");
        s1.setSex(1);
        s1.setBirthday(new Date());
        s1.setRegistrationDate(new Date());

        StudentEntity s2 = new StudentEntity();
        s2.setId("2");
        s2.setName("李四");
        s2.setSex(2);
        s2.setBirthday(new Date());
        s2.setRegistrationDate(new Date());

        stuList.add(s1);
        stuList.add(s2);


        Workbook workbook = ExcelExportUtil.exportExcel(new ExportParams("计算机一班学生","学生"),
                StudentEntity.class, stuList);


        // 获取桌面
        FileSystemView fsv = FileSystemView.getFileSystemView();
        //C:\Users\Victor\Desktop
        String desktop = fsv.getHomeDirectory().getPath();
        String filePath = desktop + "/a.xls";

        File file = new File(filePath);
        FileOutputStream fos = new FileOutputStream(file);

        workbook.write(fos);
        workbook.close();;
    }

}
