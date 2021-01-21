package com.vic.java8.datetime;

import java.util.Calendar;
import java.util.Date;

/**
 * @author Victor
 * date: 2019/12/19 15:46
 */
public class DateAndCalendarTest {


    public static void main(String[] args) {

        String a = "【水象优品】亲爱的小主，我们近期即将改版，为了避免后期影响您正常使用，请您登录小程序，点击\"我的\"→【水象通】查询可用张数及金额，前往首页进行消费，如有疑问请点击\"在线客服\"咨询，感谢您的理解与支持!";
        System.out.println(a.length());

        // Date转化为Calendar
        Date date = new Date();//直接new对象，获取的是当前时间
//        System.out.println(dateToCalendar(date));

        // Calendar转化为Date
        Date date1 = calendarToDate(2019, 12, 1);
        Date date2 = calendarToDate(2020, 1, 1);
//        System.out.println(date1);
//        System.out.println(date1.getTime());
//        System.out.println(date2);
//        System.out.println(date2.getTime());


    }

    /**
     * Calendar转化为Date
     * @param year
     * @param month
     * @param day
     * @return 返回标准化的Date
     */
    public static Date calendarToDate(int year, int month, int day) {
        // create a calendar
        Calendar calendar = Calendar.getInstance();
        // 设置日历时间，月份必须减一
        calendar.set(year, month - 1, day, 0, 0, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        // 从一个 Calendar 对象中获取 Date 对象
        Date date = calendar.getTime();
        return date;
    }

    /**
     * Date转化为Calendar
     * @param date
     * @return 日历类里面有关时间的全部信息
     */
    public static Calendar dateToCalendar(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar;
    }

}
