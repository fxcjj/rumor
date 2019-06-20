package com.vic.miscellaneous;


import com.vic.entity.User;

public class Test2 {
	
	public static void main(String[] args) {
		User[] us = new User[3];
		us[0] = new User("name0", "p0");
		us[1] = new User("name1", "p1");
		us[2] = new User("name2", "p2");
		
		User u;
		for(int j = 0; j < us.length; j++) {
			if((u = us[j]) != null) {
				us[j] = null;
				System.out.println(u); //yes
			}
		}
	}
	
}
