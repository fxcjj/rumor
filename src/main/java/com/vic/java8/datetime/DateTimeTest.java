package com.vic.java8.datetime;

import java.time.*;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;

/**
 * java8的时间日期库
 * 
 * https://www.cnblogs.com/comeboo/p/5378922.html
 * 
 * @author Victor
 * @date 2018年1月18日 上午10:14:44
 */
public class DateTimeTest {
	

	public static void main(String[] args) {
		
		LocalDate now = LocalDate.now();
//		System.out.println(now);
//		Clock clock = Clock.systemUTC();
		// System.out.println("Clock: " + clock);

		// TimeZone.getDefault();

		// testIsBefore();

//		testZone();
		
//		testLocalTime();

//		testYearMonth();
		
//		testLeapYear();
	    //1、TreeMap如不指定排序器，默认将按照key值进行升序排序，如果指定了排序器，则按照指定的排序器进行排序。  
        //2、具体的排序规则，可以在int compare()方法中进行指定。  
          
         //不指定排序器    
        /*TreeMap<String, String> treeMap1 = new TreeMap<String, String>();    
        treeMap1.put("4", "1");    
        treeMap1.put("2", "1");    
        treeMap1.put("1", "1");    
        treeMap1.put("3", "1");    
        System.out.println("treeMap1="+treeMap1);    
    
        //指定排序器    
        TreeMap<String, String> treeMap2 = new TreeMap<String, String>(new Comparator<String>(){    
    
              
             * int compare(Object o1, Object o2) 返回一个基本类型的整型，  
             * 返回负数表示：o1 小于o2，  
             * 返回0 表示：o1和o2相等，  
             * 返回正数表示：o1大于o2。  
                 
            public int compare(String o1, String o2) {    
                
                //指定排序器按照降序排列    
                return o2.compareTo(o1);    
            }       
        });    
        treeMap2.put("2", "1");    
        treeMap2.put("3", "1");    
        treeMap2.put("1", "1");    
        treeMap2.put("4", "1");    
        System.out.println("treeMap2="+treeMap2);  */  	
		
		testCalendar();
		
	}
	
	private static void testCalendar() {
		
		Calendar cal = Calendar.getInstance();
		//Mon Jan 22 20:38:58 CST 2018
		System.out.println(cal.getTime());
		
		//显示年份
		System.out.println(cal.get(Calendar.YEAR));
		
		/**
		 * 显示月份 (从0开始, 实际显示要加一)
		 */
		System.out.println(cal.get(Calendar.MONTH));
		
		//显示日
		System.out.println(cal.get(Calendar.DAY_OF_MONTH));
		
		//本周几???
		System.out.println(cal.get(Calendar.DAY_OF_WEEK));
		
		//今年的第 N 天
		System.out.println("DAY_OF_YEAR: "+cal.get(Calendar.DAY_OF_YEAR));
		
		//本月第 N 天  
		System.out.println("DAY_OF_MONTH: "+cal.get(Calendar.DAY_OF_MONTH));
		
		
		// 3小时以后  
		cal.add(Calendar.HOUR_OF_DAY, 3);  
	    int HOUR_OF_DAY = cal.get(Calendar.HOUR_OF_DAY);
	    System.out.println("HOUR_OF_DAY + 3 = " + HOUR_OF_DAY);  
	    
	}

	public static String getWeekOfDate(Date dt) {
	    String[] weekDays = {"星期一", "星期二", "星期三", "星期四", "星期五", "星期六", "星期日"};
	    Calendar cal = Calendar.getInstance();
	    cal.setTime(dt);
	    int w = cal.get(Calendar.DAY_OF_WEEK) - 2;
	    if (w < 0)
	        w = 0;
	    return weekDays[w];
	}
	
	
	/**
	 * 14、如何在java8中检查闰年
	 * LocalDate类由一个isLeapYear()方法来返回当前LocalDate对应的那年是否是闰年
	 */
	private static void testLeapYear() {
		LocalDate now = LocalDate.now();
		
		/*
		 * output:
		 * 2018-01-18 is leap year: false
		 */
		System.out.printf("%s is leap year: %s", now, now.isLeapYear());
		
	}
	
	
	/**
	 * 13、如何表示固定的日期，比如信用卡过期时间
	 * 正如MonthDay表示的是某个重复出现的日子，YearMonth是另外一个组合，
	 * 代表的是像信用卡还款日，定期存款到期日，options到期日这类的日期。
	 * 你可以用这个类找出这个月有多少天，lengthOfMonth()这个方法返回的是这个YearMonth实例有多少天，
	 * 这对于检查2月是否润2月很有用
	 */
	private static void testYearMonth() {
		YearMonth currYearMonth = YearMonth.now();
		System.out.printf("这个月的年月%s有%d天%n", currYearMonth, currYearMonth.lengthOfMonth());
		
		YearMonth creditCardExpire = YearMonth.of(2018, Month.FEBRUARY);
		System.out.printf("你输入的年月日期是 %s %n", creditCardExpire);
		
		/**
		 * 这个月的年月2018-01有31天
		 * 你输入的年月日期是 2018-02
		 */
		
	}
	

	/**
	 * 12、在java8中处理不同的时区
	 * 
	 * java8中不仅将日期和时间进行了分离，同时还有时区。
	 * 比如ZoneId代表的是某个特定时区，ZonedDateTime代表带时区的时间，等同于以前的GregorianCalendar类。
	 * 使用该类，可以将本地时间转换成另一个时区中的对应时间。
	 */
	private static void testZone() {

		// 本地时区
		LocalDateTime localDateTime = LocalDateTime.now();

		ZoneId zone = ZoneId.of(ZoneId.SHORT_IDS.get("ACT"));
		ZonedDateTime dateAndTimeInNewYork = ZonedDateTime.of(localDateTime, zone);
		System.out.println(dateAndTimeInNewYork);

	}

	/**
	 * 11、在java中如何判断某个日期在另一个日期的前面还是后面
	 * 
	 * 如何判断某个日期在另一个日期的前面还是后面或者相等，
	 * 在java8中，LocalDate类中使用isBefore()、isAfter()、equals()方法来比较两个日期。
	 * 如果调用方法的那个日期比给定的日期要早的话，isBefore()方法会返回true。 equals()方法在前面的例子中已经说明了，这里就不举例了
	 */
	private static void testIsBefore() {
		LocalDate today = LocalDate.now();
		System.out.println("today: " + today);

		LocalDate tomorrow = today.plus(1, ChronoUnit.DAYS);
		System.out.println("tomorrow: " + tomorrow);

		System.out.println(tomorrow.isAfter(today)); // true
		System.out.println(tomorrow.isBefore(today)); // false
	}

	/**
	 * 6、如何在java8中获取当前时间
	 * 这个与第一个例子获取当前日期非常相似，这里用的是LocalTime类，默认的格式是hh:mm:ss:nnn
	 */
	private static void testLocalTime() {
		LocalTime localTime = LocalTime.now();
		
		/*
		 * output: 
		 * 10:35:44.068
		 * 
		 * as you see, it doesn't contain date.
		 */
		System.out.println(localTime);
	}
	
	/**
	 * 5、在java8中如何检查重复事件，比如生日
	 * 
	 * 在java中还有一个与时间日期相关的任务就是检查重复事件，比如每月的账单日
	 * 
	 * 如何在java中判断是否是某个节日或者重复事件，使用MonthDay类。
	 * 这个类由月日组合，不包含年信息，可以用来代表每年重复出现的一些日期或其他组合。
	 * 他和新的日期库中的其他类一样也都是不可变且线程安全的，并且它还是一个值类（value class）。
	 */
	private static void testMonthDay() {
		LocalDate dateOfBirth = LocalDate.of(1990, 11, 25);
		LocalDate now = LocalDate.now();
		
		MonthDay birthday = MonthDay.of(dateOfBirth.getMonth(), dateOfBirth.getDayOfMonth());
		
		MonthDay currMonthDay = MonthDay.from(now);
		if(currMonthDay.equals(birthday)) {
			System.out.println("today is your birthday.");
		} else {
			System.out.println("sorry, today is not your birthday.");
		}
	}
	
	
}
