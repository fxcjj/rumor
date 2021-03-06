package com.vic.easypoi;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.YearMonth;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.util.*;

public final class DateUtil {

    public static final String TIMEZONE = "GMT+8";

    public static final String FMT1 = "yyyy-MM-dd HH:mm:ss.SSS";
    public static final String FMT2 = "yyyy-MM-dd HH:mm:ss";
    public static final String FMT3 = "yyyyMMddHHmmss";
    public static final String FMT4 = "yyyy-MM-dd";
    public static final String FMT5 = "yyyyMMdd";
    public static final String FMT6 = "yyyy-MM";
    public static final String FMT7 = "yyyyMMddHHmmssSSS";
    public static final String FMT8 = "dd/MM/yyyy";
    public static final String FMT9 = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'";
    public static final String FMT10 = "yyyyMMddHHmm";
    public static final String START_TIME = " 00:00:00";
    public static final String END_TIME = " 23:59:59";
    public static final String FMT11 = "yyyy-MM-dd HH:mm";
    public static final String FMT12 = "HH:mm";
    public static final String FMT13 = "HH:mm:ss";
    public static final String[] weekDays = { "星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六" };
    public static final String[] dayOfWeekDays = { "日", "一", "二", "三", "四", "五", "六" };



    private DateUtil() {
    }

    /**
     * 按天标志
     */
    public final static String DAY = "DAY";

    /**
     * 按月标志
     */
    public final static String MONTH = "MONTH";

    /**
     * 按年标志
     */
    public final static String YEAR = "YEAR";

    private final static DateTimeFormatter dtnfs = DateTimeFormatter.ofPattern(FMT1);
    private final static DateTimeFormatter dtnf = DateTimeFormatter.ofPattern(FMT3);
    private final static DateTimeFormatter dtf = DateTimeFormatter.ofPattern(FMT2);
    private final static DateTimeFormatter dnf = DateTimeFormatter.ofPattern(FMT5);
    private final static DateTimeFormatter fmt4 = DateTimeFormatter.ofPattern(FMT4);
    private final static DateTimeFormatter dm = DateTimeFormatter.ofPattern(FMT6);
    private final static DateTimeFormatter fmt7 = DateTimeFormatter.ofPattern(FMT7);
    private final static DateTimeFormatter fmt10 = DateTimeFormatter.ofPattern(FMT10);


    /**
     * 根据给定格式取得当前时间
     */
    public final static String getCurrentByFormatter(String dtf) {
        return DateTimeFormatter.ofPattern(dtf).format(LocalDateTime.now());
    }

    /**
     * 当前日期时间毫秒<br/>
     * format: yyyyMMddHHmmssSSS
     */
    public final static String getCurrentDateTimeMSStr() {
        return fmt7.format(LocalDateTime.now());
    }

    /**
     * 当前年月日
     *
     * @return 返回当前年月日以中划线格式
     */
    public final static String getCurYMDStrWithHyphen() {
        return fmt4.format(LocalDateTime.now());
    }

    /**
     * 当前时间<br/>
     * format: yyyy-MM-dd HH:mm:ss.SSS
     */
    public final static String getStrTimestamp() {
        return dtnfs.format(LocalDateTime.now());
    }

    /**
     * 当前时间<br/>
     * format: yyyy-MM
     */
    public final static String getCurrentYears() {
        return dm.format(LocalDateTime.now());
    }


    /**
     * 当前时间<br/>
     * format: yyyy-MM-dd HH:mm:dd
     */
    public final static String getDateTime() {
        return dtf.format(LocalDateTime.now());
    }

    /**
     * 当前时间<br/>
     * format: yyyyMMddHHmmss
     */
    public final static String getDateTimeNoFormat() {
        return dtnf.format(LocalDateTime.now());
    }

    /**
     * 当前时间<br/>
     * format: yyyyMMddHHmm
     */
    public final static String getCurrentTimeMinute(){
        return fmt10.format(LocalDateTime.now());
    }

    public final static String getCurrentTimeMinute(long minutes){
        return fmt10.format(LocalDateTime.now().minusNanos(minutes));
    }

    /**
     * 当天<br/>
     * format: yyyy-MM-dd
     */
    public final static String getToday() {
        return LocalDate.now().toString();
    }

    /**
     * 当前日期<br/>
     * format: yyyyMMdd
     */
    public final static String getDateNoFormat() {
        return dnf.format(LocalDate.now());
    }

    /**
     * 本周开始日期<br/>
     * format: yyyy-MM-dd
     */
    public final static String getWeekStartDate() {
        LocalDate localDate = LocalDate.now();
        return localDate.minusDays(localDate.getDayOfWeek().getValue() - 1).toString();
    }

    /**
     * 一周日期<br/>
     * format: yyyy-MM-dd
     */
    public final static String getWeekBeforeDate() {
        LocalDate localDate = LocalDate.now();
        return localDate.minusWeeks(1).toString();
    }

    /**
     * 本周结束日期<br/>
     * format: yyyy-MM-dd
     */
    public final static String getWeekEndDate() {
        LocalDate localDate = LocalDate.now();
        return localDate.minusDays(localDate.getDayOfWeek().getValue() - 7).toString();
    }

    /**
     * 当月第一天<br/>
     * format: yyyy-MM-dd
     */
    public final static String getMonthStartDate() {
        return LocalDate.now().with(TemporalAdjusters.firstDayOfMonth()).toString();
    }

    /**
     * 一个月前日期<br/>
     * format: yyyy-MM-dd
     */
    public final static String getMonthBeforeDate() {
        LocalDate localDate = LocalDate.now();
        return localDate.minusMonths(1).toString();
    }

    /**
     * 当月最后一天<br/>
     * format: yyyy-MM-dd
     */
    public final static String getMonthEndDate() {
        return LocalDate.now().with(TemporalAdjusters.lastDayOfMonth()).toString();
    }


    /**
     * 当年第一天<br/>
     * format: yyyy-MM-dd
     */
    public final static String getYearStartDate() {
        return LocalDate.now().with(TemporalAdjusters.firstDayOfYear()).toString();
    }

    /**
     * 当年最后一天<br/>
     * format: yyyy-MM-dd
     */
    public final static String getYearEndDate() {
        return LocalDate.now().with(TemporalAdjusters.lastDayOfYear()).toString();
    }

    /**
     * 昨天<br/>
     * format: yyyy-MM-dd
     */
    public final static String getYesterday() {
        return LocalDate.now().minusDays(1).toString();
    }

    /**
     * 上周周开始日期<br/>
     * format: yyyy-MM-dd
     */
    public final static String getLastWeekStartDate() {
        LocalDate localDate = LocalDate.now();
        return localDate.minusDays((localDate.getDayOfWeek().getValue() - 1) + 7).toString();
    }

    /**
     * 上周结束日期<br/>
     * format: yyyy-MM-dd
     */
    public final static String getLastWeekEndDate() {
        LocalDate localDate = LocalDate.now();
        return localDate.minusDays((localDate.getDayOfWeek().getValue() - 1) + 1).toString();
    }


    /**
     * 上月月第一天<br/>
     * format: yyyy-MM-dd
     */
    public final static String getLastMonthStartDate() {
        return LocalDate.now().minusMonths(1).with(TemporalAdjusters.firstDayOfMonth()).toString();
    }

    /**
     * 上月最后一天<br/>
     * format: yyyy-MM-dd
     */
    public final static String getLastMonthEndDate() {
        return LocalDate.now().minusMonths(1).with(TemporalAdjusters.lastDayOfMonth()).toString();
    }

    /**
     * 去年第一天<br/>
     * format: yyyy-MM-dd
     */
    public final static String getLastYearStartDate() {
        return LocalDate.now().minusYears(1).with(TemporalAdjusters.firstDayOfYear()).toString();
    }

    /**
     * 去年最后一天<br/>
     * format: yyyy-MM-dd
     */
    public final static String getLastYearEndDate() {
        return LocalDate.now().minusYears(1).with(TemporalAdjusters.lastDayOfYear()).toString();
    }


    public final static String monday() {
        LocalDate localDate = LocalDate.now();
        return localDate.minusDays(localDate.getDayOfWeek().getValue() - 1).toString();
    }

    public final static String tuesday() {
        LocalDate localDate = LocalDate.now();
        return localDate.minusDays(localDate.getDayOfWeek().getValue() - 2).toString();
    }

    public final static String wednesday() {
        LocalDate localDate = LocalDate.now();
        return localDate.minusDays(localDate.getDayOfWeek().getValue() - 3).toString();
    }

    public final static String thursday() {
        LocalDate localDate = LocalDate.now();
        return localDate.minusDays(localDate.getDayOfWeek().getValue() - 4).toString();
    }

    public final static String friday() {
        LocalDate localDate = LocalDate.now();
        return localDate.minusDays(localDate.getDayOfWeek().getValue() - 5).toString();
    }

    public final static String saturday() {
        LocalDate localDate = LocalDate.now();
        return localDate.minusDays(localDate.getDayOfWeek().getValue() - 6).toString();
    }

    public final static String sunday() {
        LocalDate localDate = LocalDate.now();
        return localDate.minusDays(localDate.getDayOfWeek().getValue() - 7).toString();
    }

    /**
     * 当前月的天数
     */
    public final static int daysOfCurrentMonth() {
        return YearMonth.now().lengthOfMonth();
    }

    /**
     * 今年的天数
     */
    public final static int daysOfCurrentYear() {
        return YearMonth.now().lengthOfYear();
    }

    /**
     * Date 转 LocalDate
     */
    public final static LocalDate dateToLocalDate(Date date) {
        return date == null ? null : date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    }

    /**
     * Date 转 LocalDateTime
     */
    public final static LocalDateTime dateToLocalDateTime(Date date) {
        return date == null ? null : date.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
    }

    /**
     * LocalDateTime 转 Date
     */
    public final static Date localDateToDate(LocalDateTime localDateTime) {
        return localDateTime == null ? null : Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
    }

    /**
     * LocalDate 转 Date
     */
    public final static Date localDateToDate(LocalDate localDate) {
        return localDate == null ? null : Date.from(localDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
    }

    /**
     * 格式化日期日期字符串为LocaDate，日期格式：yyyy-MM-dd, yyyyMMdd, yyyy-MM-dd HH:mm:ss, yyyyMMdd HH:mm:ss
     *
     * @param dateStr
     * @return
     */
    public final static LocalDate dateToLocalDate(String dateStr) {
        LocalDate localDate = null;
        SimpleDateFormat sdf = null;
        try {
            if (!CommUtils.isNull(dateStr)) {
                if (dateStr.length() == 10) {
                    sdf = new SimpleDateFormat("yyyy-MM-dd");
                } else if (dateStr.length() == 8) {
                    sdf = new SimpleDateFormat("yyyyMMdd");
                } else if (dateStr.length() == 19) {
                    sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                } else if (dateStr.length() == 17) {
                    sdf = new SimpleDateFormat("yyyyMMdd HH:mm:ss");
                } else {
                    return null;
                }
            }
            localDate = dateToLocalDate(sdf.parse(dateStr));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return localDate;
    }

    /**
     * 当前时间一个月前的日期
     * format: yyyy-MM-dd
     */
    public final static String getLastMonthDate() {
        return LocalDate.now().minus(1, ChronoUnit.MONTHS).toString();
    }

    /**
     * 当前时间一个月后的日期
     * format: yyyy-MM-dd
     */
    public final static String getNextMonthDate() {
        return LocalDate.now().plus(1, ChronoUnit.MONTHS).toString();
    }

    /**
     * 下个月的开始日期
     * format: yyyy-MM-dd
     */
    public final static String getNextMonthStartDate() {
        return LocalDate.now().minusMonths(-1).with(TemporalAdjusters.firstDayOfMonth()).toString();
    }

    /**
     * 下个月的结束日期
     * format: yyyy-MM-dd
     */
    public final static String getNextMonthEndDate() {
        return LocalDate.now().minusMonths(-1).with(TemporalAdjusters.lastDayOfMonth()).toString();
    }

    /**
     * 通过时间秒毫秒数判断两个时间的间隔多少天(向下取整)
     *
     * @param date1
     * @param date2
     * @return
     */
    public static Long differDaysRoundDown(Date date1, Date date2) {
        Long days = ((date2.getTime() - date1.getTime()) / (1000 * 3600 * 24));
        return days;
    }

    /**
     * 自定义时间范围，通过时间秒毫秒数判断两个时间的间隔多少天(向上取整)
     *
     * @param date1
     * @param date2
     * @return
     */
    public static Long differDaysRoundUp(Date date1, Date date2) {
        double doubleDays = (((double) (date2.getTime() - date1.getTime())) / (1000 * 3600 * 24));
        Long days = ((long) (Math.ceil(doubleDays)));
        return days;
    }

    public static Long differMinuteRoundDown(Date date1, Date date2) {
        Long days = ((date2.getTime() - date1.getTime()) / (1000 * 60));
        return days;
    }

    /**
     * 获取当日截止时间
     *
     * @param date
     * @return
     */
    public static Date getEndDate(Date date) {
        if (date == null) {
            return null;
        }
        Calendar c = Calendar.getInstance();
        c.setTime(date);// 把endDate的时间赋给日历类
        // 设置为23点59分59秒
        c.set(Calendar.HOUR_OF_DAY, 23);
        c.set(Calendar.MINUTE, 59);
        c.set(Calendar.SECOND, 59);
        c.set(Calendar.MILLISECOND, 999);
        return c.getTime();// 日历类-->日期类
    }

    /**
     * 获取当日开始时间
     *
     * @param date
     * @return
     */
    public static Date getBeginDate(Date date) {
        if (date == null) {
            return null;
        }
        Calendar c = Calendar.getInstance();
        c.setTime(date);// 把endDate的时间赋给日历类
        // 设置为00点00分00秒
        c.set(Calendar.HOUR_OF_DAY, 00);
        c.set(Calendar.MINUTE, 00);
        c.set(Calendar.SECOND, 00);
        c.set(Calendar.MILLISECOND, 000);
        return c.getTime();// 日历类-->日期类
    }

    public static LocalDate getYesterdayBeforDate(int diff, String calFlag) {
        Calendar ca = Calendar.getInstance();//得到一个Calendar的实例
        ca.setTime(new Date()); //设置时间为当前时间
        if (DateUtil.YEAR.equals(calFlag)) {
            ca.add(Calendar.YEAR, -(diff + 1));
        } else if (DateUtil.MONTH.equals(calFlag)) {
            ca.add(Calendar.MONTH, -diff);
        } else {
            ca.add(Calendar.DATE, -diff);
        }
        Date lastMonth = ca.getTime();
        System.out.println(lastMonth);
        return lastMonth.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

    }

    /**
     * 解析日期
     *
     * @param text
     * @param pattern
     * @return
     * @auther: yanxuewen
     * date: 2019/1/5 16:30
     */
    public static Date parseDate(final String text, String pattern) {
        if (StringUtils.isBlank(text)) {
            return null;
        }

        Date date = null;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(pattern);
            date = sdf.parse(text);
        } catch (Exception e) {
            throw new RuntimeException("Parse date failed: " + text);
        }
        return date;
    }

    /**
     * 日期格式化
     *
     * @param date
     * @param pattern
     * @return
     * @auther: yanxuewen
     * date: 2019/1/5 16:30
     */
    public static String formatDate(Date date, String pattern) {
        if (date == null) {
            return null;
        }

        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        return sdf.format(date);
    }


    /**
     * 日期格式化
     *
     * @param date
     * @param pattern
     * @param suffix  -- 后缀，如" 00:00:00"、" 23:59:59"
     * @return
     * @auther: yanxuewen
     * date: 2019/1/5 16:30
     */
    public static String formatDate(Date date, String pattern, String suffix) {
        if (date == null) {
            return null;
        }
        if (suffix == null) {
            suffix = "";
        }

        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        return sdf.format(date) + suffix;
    }

    /**
     * 操作日期
     *
     * @param date
     * @param field  --Calendar.field
     * @param offset
     * @return
     * @auther: yanxuewen
     * date: 2019/1/5 16:30
     */
    public static Date plusDate(Date date, int field, int offset) {
        if (date == null) {
            return null;
        }

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);

        calendar.set(field, calendar.get(field) + offset);
        return calendar.getTime();
    }

    public static String getLastMonth() {
        LocalDate today = LocalDate.now();
        today = today.minusMonths(1);
        DateTimeFormatter formatters = DateTimeFormatter.ofPattern("yyyy-MM");
        return formatters.format(today);
    }

    /**
     * 获取上一个月第一天
     *
     * @return
     */
    public static String getUpMonthDate() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Calendar cal_1 = Calendar.getInstance();//获取当前日期
        cal_1.add(Calendar.MONTH, -1);
        cal_1.set(Calendar.DAY_OF_MONTH, 1);//设置为1号,当前日期既为本月第一天
        return format.format(cal_1.getTime()) + " 00:00:00";
    }

    /**
     * 获取上一个月最后一天
     *
     * @return
     */
    public static String getLastUpMonthDate() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Calendar cale = Calendar.getInstance();
        cale.set(Calendar.DAY_OF_MONTH, 0);//设置为1号,当前日期既为本月第一天
        return format.format(cale.getTime()) + " 23:59:59";
    }


    /**
     * 获取当前月第一天
     *
     * @return
     */
    public static String getMonthDate() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Calendar cal_1 = Calendar.getInstance();//获取当前日期
        cal_1.add(Calendar.MONTH, 0);
        cal_1.set(Calendar.DAY_OF_MONTH, 1);//设置为1号,当前日期既为本月第一天
        return format.format(cal_1.getTime()) + " 00:00:00";
    }

    /**
     * 获取当前月最后一天
     *
     * @return
     */
    public static String getLastDayMonthDate() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Calendar ca = Calendar.getInstance();
        ca.set(Calendar.DAY_OF_MONTH, ca.getActualMaximum(Calendar.DAY_OF_MONTH));
        return format.format(ca.getTime()) + " 23:59:59";
    }

    /**
     * 获取指定日期月的第一天值
     * @param date
     * @return
     */
    public static int getFirstDayDateOfMonth(final Date date) {
        final Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        final int last = cal.getActualMinimum(Calendar.DAY_OF_MONTH);
        cal.set(Calendar.DAY_OF_MONTH, last);
        return cal.get(Calendar.DAY_OF_MONTH);
//        return cal.getTime();
    }

    /**
     * 获取指定日期月的最后一天值
     * @param date
     * @return
     */
    public static int getLastDayOfMonth(final Date date) {
        final Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        final int last = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
        cal.set(Calendar.DAY_OF_MONTH, last);
        return cal.get(Calendar.DAY_OF_MONTH);
//        return cal.getTime();
    }

    /**
     * 输入日期字符串，比如201703或者2017-03，返回当月第一天的Date
     * @param month 指定月份
     * @return 返回月份第一天
     */
    public static String getMonthMinDate(String month){
        try {
            if (CommUtils.isNull(month) || (month.length() != 6 && month.length() != 7)) {
                return null;
            }
            SimpleDateFormat sdf = null;
            if (month.length() ==6) {
                sdf = new SimpleDateFormat("yyyyMM");
            } else {
                sdf = new SimpleDateFormat("yyyy-MM");
            }
            Date nowDate = sdf.parse(month);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(nowDate);
            calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMinimum(Calendar.DAY_OF_MONTH));
            return DateUtil.formatDate(calendar.getTime(), DateUtil.FMT2);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 输入日期字符串，比如201703或者2017-03，返回当月最后一天的Date
     * @param month 指定月份
     * @return 返回月份最后一天
     */
    public static String getMonthMaxDate(String month){
        try {
            if (CommUtils.isNull(month) || (month.length() != 6 && month.length() != 7)) {
                return null;
            }
            SimpleDateFormat sdf = null;
            if (month.length() ==6) {
                sdf = new SimpleDateFormat("yyyyMM");
            } else {
                sdf = new SimpleDateFormat("yyyy-MM");
            }
            Date nowDate = sdf.parse(month);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(nowDate);
            calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
            calendar.set(Calendar.HOUR_OF_DAY, 23);
            calendar.set(Calendar.MINUTE, 59);
            calendar.set(Calendar.SECOND, 59);
            calendar.set(Calendar.MILLISECOND, 999);
            return DateUtil.formatDate(calendar.getTime(), DateUtil.FMT2);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 将秒域设置为0
     *
     * @param date 日期
     * @return
     */
    public static Date secondSetZero(Date date) {
        if (date == null) {
            return null;
        }
        Calendar cal1 = Calendar.getInstance();
        cal1.setTime(date);
        // 将分秒,毫秒域清零
        cal1.set(Calendar.SECOND, 0);
        cal1.set(Calendar.MILLISECOND, 0);
        return cal1.getTime();
    }

    /**
     * 将时间域设置为日终
     *
     * @param date 日期
     * @return
     */
    public static Date timeToDayEnd(Date date) {
        if (date == null) {
            return null;
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        calendar.set(Calendar.MILLISECOND, 999);
        date = calendar.getTime();
        return date;
    }

    /**
     * 将时间域设置为日期开始
     *
     * @param date 日期
     * @return
     */
    public static Date timeToDayBegin(Date date) {
        if (date == null) {
            return null;
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        date = calendar.getTime();
        return date;
    }

    //-------------------------------------------- Private Methods
    private static String[] sortArrayDescByLen(String[] strArr) {
        if (ArrayUtils.isNotEmpty(strArr)) {
            if (strArr.length == 1) {
                return strArr;
            }

            String strTmp;
            for (int i = 0; i < strArr.length; i++) {
                for (int j = strArr.length - 1; j > i; j--) {
                    if (strArr[i].length() < strArr[j].length()) {
                        strTmp = strArr[i];
                        strArr[i] = strArr[j];
                        strArr[j] = strTmp;
                    }
                }
            }
        }

        return strArr;
    }

    /**
     * 获取两个日期字符串之间的所有日期
     *
     * @param startDate
     * @param endDate
     * @return
     */
    public static List<LocalDate> getAllDates(String startDate, String endDate) {
        //定义起始日期
        Date d1 = DateUtil.localDateToDate(DateUtil.dateToLocalDate(startDate));
        //定义结束日期
        Date d2 = DateUtil.localDateToDate(DateUtil.dateToLocalDate(endDate));
        //定义日期实例
        Calendar dd = Calendar.getInstance();
        dd.setTime(d1);//设置日期起始时间
        List<LocalDate> dates = new ArrayList<>();
        //判断是否到结束日期
        while (dd.getTime().compareTo(d2) <= 0) {
            LocalDate localDate = DateUtil.dateToLocalDate(dd.getTime());
            dates.add(localDate);
            //进行当前日期月份加1
            dd.add(Calendar.DAY_OF_MONTH, 1);
        }
        return dates;
    }

    public static void main(String[] args) {
        int[] a = new int[Integer.MAX_VALUE-1];
//        a[Integer.MAX_VALUE-1] = 111;
//        System.out.println(a[Integer.MAX_VALUE-1]);
    }

    /**
     * Java获取两个日期之间的所有日期集合
     * @param start
     * @param end
     * @return
     */
    public static List<Date> getBetweenDates(Date start, Date end) {
        List<Date> result = new ArrayList<>();
        Calendar tempStart = Calendar.getInstance();
        tempStart.setTime(start);
//        tempStart.add(Calendar.DAY_OF_YEAR, 1);

        Calendar tempEnd = Calendar.getInstance();
        tempEnd.setTime(end);
        while (tempStart.before(tempEnd)) {
            result.add(tempStart.getTime());
            tempStart.add(Calendar.DAY_OF_YEAR, 1);
        }
        return result;
    }

    /**
     * 获取两个日期时间字符串之间的所有小时
     *
     * @param startTime 开始时间
     * @param endTime   结束时间
     * @param hourRage  间隔小时数
     * @return
     */
    public static List<LocalDateTime> getAllDateHours(String startTime, String endTime, Integer hourRage) {
        List<LocalDateTime> dates = new ArrayList<>();
        if (startTime != null && endTime != null && CommUtils.isNotNull(hourRage)) {
            //定义起始日期
            Date d1 = DateUtil.parseDate(startTime, DateUtil.FMT2);
            //定义结束日期
            Date d2 = DateUtil.parseDate(endTime, DateUtil.FMT2);
            //定义日期实例
            Calendar dd = Calendar.getInstance();
            dd.setTime(d1);

            //判断是否到结束日期
            while (dd.getTime().compareTo(d2) <= 0) {
                LocalDateTime localDate = DateUtil.dateToLocalDateTime(dd.getTime());
                dates.add(localDate);
                //进行当前日期月份加1
                dd.add(Calendar.HOUR_OF_DAY, hourRage);
            }
        }

        return dates;
    }

    /**
     * 功能：增加天数。
     *
     * @param date 参照时间
     * @param days 正值时时间延后，负值时时间提前。
     * @return Date
     */
    public static Date addDays(Date date, int days) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.set(Calendar.DATE, c.get(Calendar.DATE) + days);
        return new Date(c.getTimeInMillis());
    }

    /**
     * 功能：减少天数。
     *
     * @param date 参照时间
     * @param days 天数
     * @return Date
     */
    public static Date minusDays(Date date, int days) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.set(Calendar.DATE, c.get(Calendar.DATE) + (-days));
        return new Date(c.getTimeInMillis());
    }

    /**
     * 两个日期相差的秒
     *
     * @param beginDate
     * @param endDate
     * @return
     */
    public static Long getSecondSpace(Date beginDate, Date endDate) {
        // 得到两个日期相差的秒
        long days = (endDate.getTime() - beginDate.getTime()) / (1000);
        return days;
    }

    /**
     * 两个日期相差的分钟数
     *
     * @param beginDate
     * @param endDate
     * @return
     */
    public static Long getMinutesSpace(Date beginDate, Date endDate) {
        // 得到两个日期相差的分
        long minutes = (endDate.getTime() - beginDate.getTime()) / (1000*60);
        return minutes;
    }

    /**
     * 两个日期相差的秒
     *
     * @param beginDate
     * @param endDate
     * @return
     */
    public static Long getSecondsSpace(Date beginDate, Date endDate) {
        // 得到两个日期相差的秒
        long seconds = (endDate.getTime() - beginDate.getTime()) / (1000);
        return seconds;
    }

    public static String getDateTimeString(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat(FMT2);
        return sdf.format(date);
    }

    /**
     * 获取最大日期
     *
     * @param dates
     * @return
     */
    public static Date getMax(Date... dates) {
        return Arrays.stream(dates).max(Comparator.comparing(Date::getTime)).orElse(null);
    }

    /**
     * 获取最小日期
     *
     * @param dates
     * @return
     */
    public static Date getMin(Date... dates) {
        return Arrays.stream(dates).min(Comparator.comparing(Date::getTime)).orElse(null);
    }

    /**
     * 当前时间减操作
     *
     * @param i
     * @return
     */
    public static String getAddFormatNowDate(int i) {
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        GregorianCalendar gc = new GregorianCalendar();
        gc.setTime(date);
        gc.add(5, -i);
        return sf.format(gc.getTime());
    }

    /**
     * 根据出生日期计算年龄
     *
     * @param birthday
     * @return
     */
    public static int getAge(Date birthday) {
        if (birthday == null) {
            return 0;
        }
        Calendar cal = Calendar.getInstance();
        if (cal.before(birthday)) { //出生日期晚于当前时间，无法计算
            throw new IllegalArgumentException("The birthDay is before Now.It's unbelievable!");
        }
        int yearNow = cal.get(Calendar.YEAR);  //当前年份
        int monthNow = cal.get(Calendar.MONTH);  //当前月份
        int dayOfMonthNow = cal.get(Calendar.DAY_OF_MONTH); //当前日期
        cal.setTime(birthday);
        int yearBirth = cal.get(Calendar.YEAR);
        int monthBirth = cal.get(Calendar.MONTH);
        int dayOfMonthBirth = cal.get(Calendar.DAY_OF_MONTH);
        //计算整岁数
        int age = yearNow - yearBirth;
        if (monthNow <= monthBirth) {
            if (monthNow == monthBirth) {
                if (dayOfMonthNow < dayOfMonthBirth) age--; //当前日期在生日之前，年龄减一
            } else {
                age--; //当前月份在生日之前，年龄减一
            }
        }
        return age;
    }

    /**
     * 获取当前时间的前一天的时间数据
     * @param currentdate
     * @return
     */
    public static Date getBeforeOneDay(Date currentdate) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(currentdate);
        calendar.add(Calendar.DAY_OF_MONTH, -1);
        currentdate = calendar.getTime();
        return currentdate;
    }

    /**
     * 获取当前时间的前一小时的时间数据
     * @param currentdate
     * @return
     */
    public static Date getBeforeOneHour(Date currentdate) {
        Calendar calendar = Calendar.getInstance();
        /* HOUR_OF_DAY 指示一天中的小时 */
        calendar.setTime(currentdate);
        calendar.add(Calendar.HOUR_OF_DAY, -1);
        currentdate = calendar.getTime();
        return currentdate;
    }


//    public static void main(String[] args) throws ParseException {
//        System.out.println(DateUtil.getMonthMinDate("2020-03"));
//        System.out.println(DateUtil.getMonthMaxDate("202003"));
//        System.out.println(DateUtil.getLastMonthDate());
//    }

    /**
     * 时间字符串转换为时间类型
     * @param stringDate
     * @return
     */
    public static Date getDate(String stringDate){
        Date date=null;
        SimpleDateFormat formatter=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            date=formatter.parse(stringDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    /**
     * 获取月的几号
     * @param date
     * @return
     */
   public static int getDate(Date date){
       if(date == null) {
           return 0;
       }
       Calendar cal = Calendar.getInstance();
       cal.setTime(date);
       return cal.get(Calendar.DAY_OF_MONTH);
    }

    /**
     * 获取两个日期相差的月数
     * @param endDate
     * @param beginDate
     * @return
     */
    public static int getMonthDiff(Date endDate, Date beginDate) {
        if(endDate == null || beginDate == null) {
            return 0;
        }
        Calendar c1 = Calendar.getInstance();
        Calendar c2 = Calendar.getInstance();
        c1.setTime(endDate);
        c2.setTime(beginDate);
        int year1 = c1.get(Calendar.YEAR);
        int year2 = c2.get(Calendar.YEAR);
        int month1 = c1.get(Calendar.MONTH);
        int month2 = c2.get(Calendar.MONTH);
        int day1 = c1.get(Calendar.DAY_OF_MONTH);
        int day2 = c2.get(Calendar.DAY_OF_MONTH);

        // 获取年的差值 
        int yearInterval = year1 - year2;

        // 如果 d1的 月-日 小于 d2的 月-日 那么 yearInterval-- 这样就得到了相差的年数
        if (month1 < month2 || month1 == month2 && day1 < day2) {
            yearInterval--;
        }
        // 获取月数差值
        int monthInterval = (month1 + 12) - month2;

        if (day1 < day2) {
            monthInterval--;
        }
        monthInterval %= 12;
        int monthsDiff = Math.abs(yearInterval * 12 + monthInterval);
        return monthsDiff;
    }

    /**
     * 根据字符串日期算星期几
     * @param date
     * @return
     */
    public static String dateToWeek(String date) {
        return dateToWeek(parseDate(date, DateUtil.FMT4));
    }

    /**
     * 根据date算星期几
     * @param date
     * @return
     */
    public static String dateToWeek(Date date) {
        // 获得一个日历
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        // 指示一个星期中的某天
        int w = cal.get(Calendar.DAY_OF_WEEK) - 1;
        if (w < 0) {
            w = 0;
        }
        return weekDays[w];
    }

    /**
     * 根据date算星期几
     * @param date
     * @return
     */
    public static String dateToDayOfWeek(Date date) {
        // 获得一个日历
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        // 指示一个星期中的某天
        int w = cal.get(Calendar.DAY_OF_WEEK) - 1;
        if (w < 0) {
            w = 0;
        }
        return dayOfWeekDays[w];
    }

}
