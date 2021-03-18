package com.vic.temp;

import java.util.Calendar;
import java.util.Date;

public class TestA {

	public static void main(String[] args) {
		Calendar cal = Calendar.getInstance();
//		cal.setTime(new Date());
		cal.set(2021, 2-1, 10);
		System.out.println(cal.getActualMaximum(Calendar.DAY_OF_MONTH));
	}
	
	
}
