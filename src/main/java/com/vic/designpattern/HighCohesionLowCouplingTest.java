package com.vic.designpattern;

import java.util.ArrayList;
import java.util.List;

/**
 * 高内聚低耦合（High Cohesion Low Coupling）
 * blog
 *  http://blog.csdn.net/nengyu/article/details/42141635
 *  http://blog.csdn.net/csh624366188/article/details/7183726
 *  http://blog.csdn.net/lijia503102319/article/details/50259835
 * 
 * @author victor
 */
public class HighCohesionLowCouplingTest {

    public static void main(String[] args) {
        TeacherManager tm = new TeacherManager();
        tm.printAllTeacher();
        
        StudentManager sm = new StudentManager();
        sm.printAllStudent();
    }

}

class Teacher {
    
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
}

class TeacherManager {
    
    public List<Teacher> getAllTeacher() {
        List<Teacher> list = new ArrayList<Teacher>();
        Teacher s = null;
        for(int i = 0; i < 10; i++) {
            s = new Teacher();
            s.setId("编号: "+i);
            list.add(s);
        }
        return list;
    }
    
    public void printAllTeacher() {
        List<Teacher> list = getAllTeacher();
        for(Teacher s : list) {
            System.out.println(s.getId());
        }
    }
    
}

class Student {
    
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
}

class StudentManager {
    
    public List<Student> getAllStudent() {
        List<Student> list = new ArrayList<Student>();
        Student s = null;
        for(int i = 0; i < 10; i++) {
            s = new Student();
            s.setId("学号: "+i);
            list.add(s);
        }
        return list;
    }
    
    public void printAllStudent() {
        List<Student> list = getAllStudent();
        for(Student s : list) {
            System.out.println(s.getId());
        }
    }
    
}