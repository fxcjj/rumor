package com.vic.easypoi;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import com.vic.easypoi.entity.CourseEntity;
import com.vic.easypoi.entity.StudentEntity;
import com.vic.easypoi.entity.TeacherEntity;
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
public class Test2 {


    public static void main(String[] args) throws Exception {

        List<StudentEntity> stuList1 = getStuList1();
        List<StudentEntity> stuList2 = getStuList2();


        TeacherEntity t1 = new TeacherEntity();
        t1.setId("1");
        t1.setName("老王1");

        TeacherEntity t2 = new TeacherEntity();
        t2.setId("2");
        t2.setName("老王2");


        List<CourseEntity> coureList = new ArrayList<>();
        CourseEntity c1 = new CourseEntity();
        c1.setId("1");
        c1.setName("java课程");
        c1.setMathTeacher(t1);
        c1.setStudents(stuList1);

        CourseEntity c2 = new CourseEntity();
        c2.setId("2");
        c2.setName("c课程");
        c2.setMathTeacher(t2);
        c2.setStudents(stuList2);

        coureList.add(c1);
        coureList.add(c2);

        Workbook workbook = ExcelExportUtil.exportExcel(new ExportParams("title-2412312", "secondTitle-测试", "测试"),
                CourseEntity.class, coureList);

        // 获取桌面
        FileSystemView fsv = FileSystemView.getFileSystemView();
        //C:\Users\Victor\Desktop
        String desktop = fsv.getHomeDirectory().getPath();
        String filePath = desktop + "/d.xls";

        File file = new File(filePath);
        FileOutputStream fos = new FileOutputStream(file);

        workbook.write(fos);
        workbook.close();;
    }

    private static List<StudentEntity> getStuList1() {
        List<StudentEntity> stuList1 = new ArrayList<>();
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

        stuList1.add(s1);
        stuList1.add(s2);
        return stuList1;
    }
    private static List<StudentEntity> getStuList2() {
        List<StudentEntity> stuList1 = new ArrayList<>();
        StudentEntity s1 = new StudentEntity();
        s1.setId("3");
        s1.setName("carl");
        s1.setSex(2);
        s1.setBirthday(new Date());
        s1.setRegistrationDate(new Date());

        StudentEntity s2 = new StudentEntity();
        s2.setId("4");
        s2.setName("王二");
        s2.setSex(1);
        s2.setBirthday(new Date());
        s2.setRegistrationDate(new Date());

        stuList1.add(s1);
        stuList1.add(s2);
        return stuList1;
    }

}
