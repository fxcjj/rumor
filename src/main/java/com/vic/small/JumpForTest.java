package com.vic.small;

/**
 * 跳出两层for循环
 *
 */
public class JumpForTest {
	public static void main(String[] args) {
        boolean flag = true;
        for(int i = 0; i < 10; i++) {
            if(!flag) break;
            for(int j = 0; j < 10; j++) {
                if(j == 5) {
                    System.out.println(j);
                    flag = false;
                    break;
                }
            }
        }
        System.out.println("xxxxxxxxxxxx");
    }
    
}
