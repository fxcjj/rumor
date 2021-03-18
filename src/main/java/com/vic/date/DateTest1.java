package com.vic.date;

import java.util.Calendar;
import java.util.Date;

/**
 * @author Victor
 * date: 2021/3/16 14:54
 */
public class DateTest1 {

    public static void main(String[] args) {

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

        // 开始日期大于结束日期
        if(beginDate.after(endDate)) {
            return 0;
        }

        Calendar endCal = Calendar.getInstance();
        endCal.setTime(endDate);
        int endYear = endCal.get(Calendar.YEAR);
        int endMonth = endCal.get(Calendar.MONTH);
        int endDay = endCal.get(Calendar.DAY_OF_MONTH);

        Calendar startCal = Calendar.getInstance();
        startCal.setTime(beginDate);
        int startYear = startCal.get(Calendar.YEAR);
        int startMonth = startCal.get(Calendar.MONTH);
        int startDay = startCal.get(Calendar.DAY_OF_MONTH);

        // 年月相同，返回0
        if(startYear == endYear && startMonth == endMonth) {
            return 0;
        }

        // 2020-10-03 ~ 2021-03-03
        // 2020-10-06 ~ 2021-10-03
        // 获取年的差值 
        int yearInterval = endYear - startYear;

        // 如果 d1的 月-日 小于 d2的 月-日 那么 yearInterval-- 这样就得到了相差的年数
        if (endMonth < startMonth || endMonth == startMonth && endDay < startDay) {
            yearInterval--;
        }
        // 获取月数差值
        int monthInterval = (endMonth + 12) - startMonth;

        if (endDay < startDay) {
            monthInterval--;
        }
        monthInterval %= 12;
        int monthsDiff = Math.abs(yearInterval * 12 + monthInterval);
        return monthsDiff;
    }
}
