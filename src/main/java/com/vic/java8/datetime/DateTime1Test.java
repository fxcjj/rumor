package com.vic.java8.datetime;

import java.time.LocalDate;
import java.time.MonthDay;

/**
 * Java 8 Date Time - 20 Examples of LocalDate, LocalTime, LocalDateTime
 * 
 * * Instant - It represents a timestamp
 * * LocalDate - a date without time e.g. 2018-02-12.
 * 		It can be used to store birthday, anniversary, date of joining etc.
 * * LocalTime - represents time without a date
 * * LocalDateTime - is used to combine date and time, but still without any offset or time-zone.
 * * ZonedDateTime - a complete date-time with time-zone and resolved offset from UTC/Greenwich
 * 
 * @author Victor
 * @date 2018年2月12日 下午2:58:22
 */
public class DateTime1Test {
	
	public static void main(String[] args) {
		
		
//		test5();
		
//		test4();
		
//		test3();
		
//		test2();
		
//		test1();

		System.out.println(LocalDate.now() + "/" + "aaa");
	}
	
	/**
	 * Example 5 - How to check for recurring events e.g. birthday in Java 8
	 * Another practical task related to date and time in Java is checking for recurring events e.g. monthly bills,  
	 * wedding anniversary, EMI date or yearly insurance premium dates. If you are working for an E-commerce site, 
	 * you would definitely have a module which sends birthday wishes to your customer and seasons greetings 
	 * on every major holiday e.g. Christmas, Thanksgiving date or Deepawali in India.
	 * How do you check for holidays or any other recurring event in Java? By using MonthDay class. 
	 * This class is a combination of month and date without a year, which means you can 
	 * use it for events which occur every year.
	 * There are similar classes exists for other combination as well e.g. YearMonth. 
	 * Like other classes in new date and time API, this is also immutable and thread-safe 
	 * and it is also a value class. Now let's see example of how to use MonthDay class 
	 * for checking recurring date time events :
	 */
	private static void test5() {
		LocalDate dateOfBirth = LocalDate.of(1990, 12, 25);
		MonthDay birthday = MonthDay.of(dateOfBirth.getMonth(), dateOfBirth.getDayOfMonth());
		LocalDate today = LocalDate.now();
		MonthDay currentMonthDay = MonthDay.from(today);
		if(currentMonthDay.equals(birthday)) {
			System.out.println("Many Many happy returns of the day !!");
		} else {
			System.out.println("Sorry, today is not your birthday");
		}
		/*
		 * Since today's date matches with the birthday, 
		 * irrespective of year you have seen the birthday greeting as output. 
		 * You can run this program by advancing your windows date and time clock 
		 * and see if it alerts you on your next birthday or not, 
		 * or you can write a JUnit test with the date of your next year birthday 
		 * and see if your code runs properly or not.
		 */
	}
	
	/**
	 * Example 4 - How to check if two dates are equal in Java 8
	 * Talking about real world date time task, one of them is to checking whether two dates 
	 * are same or not. Many times you would like to check whether today is that special day, 
	 * your birthday, anniversary or a trading holiday or not. Sometimes, you will get 
	 * an arbitrary date and you need to check against certain date e.g. holidays to confirm 
	 * whether given date is a holiday or not.
	 * This example will help you to accomplish those task in Java 8. 
	 * Just like you thought, LocalDate has overridden equal method to provide date equality, 
	 * as shown in the following example :
	 */
	private static void test4() {
		LocalDate date1 = LocalDate.of(2014, 01, 14); 
		LocalDate today = LocalDate.now();
		if(date1.equals(today)) {
			System.out.printf("Today %s and date1 %s are same date %n", today, date1); 
		}

	}
	
	/**
	 * Example 3 - How to get a particular date in java 8
	 * In the first example, we have seen that creating a today's date was very easy
	 * because of static factory method now(), but you can also create a date from
	 * any arbitrary date by using another useful factory method called LocalDate.of(),
	 * this takes a year, month and date and return an equivalent LocalDate instance.
	 * 
	 * The good thing about this method is that it has not repeated mistake done 
	 * in previous API e.g. year started from 1900, months starting from zero etc.
	 * Here dates are represented in the way you write it e.g. in the following example
	 * it will represent 14th January, nothing is hidden about it. 
	 */
	private static void test3() {
		LocalDate dateOfBirth = LocalDate.of(2010, 01, 14);
		System.out.println("Your Date of birth is : " + dateOfBirth);
		/*
		 * You can see that as expected the date created is exactly same as written 
		 * and represent 14th January 2014. 
		 */
	}
	
	/**
	 * Example 2 - How to get current day, month and year in Java 8
	 * 
	 * The LocalDate class has a convenient method to extract year, month, the day of the month
	 * and several other date attributes from an instance of LocalDate class.
	 * By using these method, you can get whatever property of date you want, no need to use
	 * a supporting class like java.util.Calendar
	 */
	private static void test2() {
		LocalDate now = LocalDate.now();
		System.out.println("Now: " + now);
		System.out.println("Year: " + now.getYear());
		System.out.println("Month: " + now.getMonth());
		System.out.println("Day: " + now.getDayOfMonth());
		
		/*
		 * You can see that how easy to get year or month from a date in java 8,
		 * just use corresponding getter method, nothing to remember, very intuitive.
		 * Compare this with older way of getting the current date, month, and year in java.
		 * old way:
		 * http://javarevisited.blogspot.sg/2012/12/how-to-get-current-date-month-year-dayoweek-dayofmonth-java-example.html#axzz56mdVNSLl
		 */
		
	}
	
	/**
	 * Example 1 - How to get today's date in java 8
	 * Java 8 has a class called LocalDate which can be used to represents today's date.
	 * This class is little different than java.util.Date because it only contains the date,
	 * no time part. So anytime if you just to represent date without time, use this class.
	 */
	private static void test1() {
		LocalDate now = LocalDate.now();
		System.out.println("Today's local date: " + now);
		
		/*
		 * You can see that is has created today's date without any time information.
		 * It also prints the date in the nicely formatted way, unlike previous Date class
		 * which print data non-formatted.
		 * You can also see Java SE 8 for Really impatient to learn about different ways to 
		 * create LocalDate in Java 8.
		 */
	}
	
}
