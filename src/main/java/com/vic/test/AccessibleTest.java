package com.vic.test;

import java.lang.reflect.Field;

public class AccessibleTest {  
      
        private int id;  
        private String name;  
      
        public AccessibleTest() {  
      
        }  
      
        public int getId() {  
            return id;  
        }  
      
        public void setId(int id) {  
            this.id = id;  
        }  
      
        public String getName() {  
            return name;  
        }  
      
        public void setName(String name) {  
            this.name = name;  
        }  
      
            
        public static void main(String[] args) throws Exception {  
            Class clazz = Class.forName("cn.vic.test.AccessibleTest");  
            AccessibleTest at = new AccessibleTest();  
            at.setId(1);  
            at.setName("AT");  
            for (Field f : clazz.getDeclaredFields()) {  
                //f.setAccessible(true);//AccessibleTest类中的成员变量为private,故必须进行此操作  
                System.out.println(f.get(at));//获取当前对象中当前Field的value  
            }  
      
        }  
          
    }