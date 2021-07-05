package com.vic.temp;

import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.ConcurrentHashMap;

public class TestA {

	public static void main(String[] args) {
//		Calendar cal = Calendar.getInstance();
//		cal.setTime(new Date());
//		cal.set(2021, 2-1, 10);
//		System.out.println(cal.getActualMaximum(Calendar.DAY_OF_MONTH));


		ConcurrentHashMap<String, String> m = new ConcurrentHashMap<>();
		m.put(null, "a");
		m.put("a", null); // NullPointerException
		System.out.println(m);


	}
	
	
}
