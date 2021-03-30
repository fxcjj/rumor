package com.vic.easypoi.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.Data;

/**
 * 月考勤导出vo
 * @author luolilua
 * @date 2021-03-03 15:54:39
 */
@Data
public class AttMonthExportVo {

	@Excel(name = "部门", width = 15)
	private String branchName;

	@Excel(name = "工号", width = 15)
	private String employeeCode;

	@Excel(name = "姓名", width = 15)
	private String employeeName;

	/**
	 * 考勤状态 1:正常出勤 2:外勤 3: 出差 4:年假 5:事假 6:病假 7:旷工 8:迟到 9:早退 10:缺卡 11:加班 12:调休 13:婚假 14:丧假 15:产假 16:正常休息 17:正常出勤上下班 18:陪产假 19:哺乳假 20:补卡 21:严重迟到 22:旷工迟到 99:非考勤日
	 */
	private String day1;

	/**
	 * 考勤状态
	 */
	private String day2;

	/**
	 * 考勤状态
	 */
	private String day3;

	/**
	 * 考勤状态
	 */
	private String day4;

	/**
	 * 考勤状态
	 */
	private String day5;

	/**
	 * 考勤状态
	 */
	private String day6;

	/**
	 * 考勤状态
	 */
	private String day7;

	/**
	 * 考勤状态
	 */
	private String day8;

	/**
	 * 考勤状态
	 */
	private String day9;

	/**
	 * 考勤状态
	 */
	private String day10;

	/**
	 * 考勤状态
	 */
	private String day11;

	/**
	 * 考勤状态
	 */
	private String day12;

	/**
	 * 考勤状态
	 */
	private String day13;

	/**
	 * 考勤状态
	 */
	private String day14;

	/**
	 * 考勤状态
	 */
	private String day15;

	/**
	 * 考勤状态
	 */
	private String day16;

	/**
	 * 考勤状态
	 */
	private String day17;

	/**
	 * 考勤状态
	 */
	private String day18;

	/**
	 * 考勤状态
	 */
	private String day19;

	/**
	 * 考勤状态
	 */
	private String day20;

	/**
	 * 考勤状态
	 */
	private String day21;

	/**
	 * 考勤状态
	 */
	private String day22;

	/**
	 * 考勤状态
	 */
	private String day23;

	/**
	 * 考勤状态
	 */
	private String day24;

	/**
	 * 考勤状态
	 */
	private String day25;

	/**
	 * 考勤状态
	 */
	private String day26;

	/**
	 * 考勤状态
	 */
	private String day27;

	/**
	 * 考勤状态
	 */
	private String day28;

	/**
	 * 考勤状态
	 */
	private String day29;

	/**
	 * 考勤状态
	 */
	private String day30;

	/**
	 * 考勤状态
	 */
	private String day31;

	/**
	 * 本月应出勤天数
	 */
	private Double shoAttendanceDays;

	/**
	 * 本月实际出勤天数
	 */
	private Double actAttendanceDays;

	/**
	 * 外勤天数
	 */
	private Double fieldDays;

	/**
	 * 缺卡天数
	 */
	private Double missingCardDays;

	/**
	 * 出差天数
	 */
	private Double businessDays;

	/**
	 * 本月休年假的天数
	 */
	private Double annualLeaveDays;

	/**
	 * 本月休事假天数
	 */
	private Double leaveDays;

	/**
	 * 本月休病假天数
	 */
	private Double sickLeaveDays;

	/**
	 * 本月旷工天数
	 */
	private Double completionDays;

	/**
	 * 本月休婚假天数
	 */
	private Double marriageLeaveDays;

	/**
	 * 本月休丧假天数
	 */
	private Double funeralLeaveDays;

	/**
	 * 本月迟到次数
	 */
	private Double lateArrivals;

	/**
	 * 本月早退次数
	 */
	private Double earlyRetreat;

	/**
	 * 本月调休天数
	 */
	private Double dayOff;

	/**
	 * 本月加班天数
	 */
	private Double overtimeDays;

	/**
	 * 本月餐补次数
	 */
	private Double subsidy;

	/**
	 * 补卡天数
	 */
	private Double reissueCardDays;

	/**
	 * 休息的产假
	 */
	private Double maternityLeave;

	/**
	 * 本月休息的陪产假
	 */
	private Double paternityLeave;

}
