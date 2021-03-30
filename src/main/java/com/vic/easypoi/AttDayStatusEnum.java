package com.vic.easypoi;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.List;

/**
 * 考勤天状态
 * @author luolihua
 * date: 2021/3/5 18:15
 */
@Getter
@AllArgsConstructor
public enum AttDayStatusEnum {


    NORMAL_ATT(1, "正常出勤"),
    FIELD(2, "外勤"),
    BUSINESS(3, "出差"),
    ANNUAL_LEAVE(4, "年假"),
    THING_LEAVE(5, "事假"),
    SICK_LEAVE(6, "病假"),
    COMPLETION(7, "旷工"),
    LATE_ARRIVALS(8, "迟到"),
    EARLY_RETREAT(9, "早退"),
    MISSING_CARD(10, "缺卡"),
    OVERTIME(11, "加班"),
    VACATION(12, "调休"),
    MARRIAGE_LEAVE(13, "婚假"),
    FUNERAL_LEAVE(14, "丧假"),
    MATERNITY_LEAVE(15, "产假"),
    NORMAL_REST(16, "休息"),
//    STATUS_17(17, "正常出勤上下班"), // 暂时没用
    PATERNITY_LEAVE(18, "陪产假"),
//    LACTATION_LEAVE(19, "哺乳假"), // 暂时没用
    REISSUE_CARD(20, "补卡"),
//    STATUS_21(21, "严重迟到"), // 暂时没用
//    STATUS_22(22, "旷工迟到"), // 暂时没用
    NONE_ATT_DAY(99, "非考勤日"),
    STATUS_ERROR(98, "状态异常"),
    ;

    private Integer code;
    private String remark;

    public static AttDayStatusEnum get(Integer code) {
        return Arrays.stream(values()).filter(e -> e.code.equals(code)).findFirst().orElse(STATUS_ERROR);
    }

    public static String getRemark(List<Integer> codes) {
        StringBuilder sb = new StringBuilder();
        for(Integer c : codes) {
            AttDayStatusEnum attDayStatusEnum = get(c);
            sb.append(attDayStatusEnum.getRemark()).append("/");
        }
        if(sb.length() == 0) {
            return "";
        }
        return sb.toString().substring(0, sb.length() - 1);
    }
}