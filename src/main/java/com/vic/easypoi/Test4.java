package com.vic.easypoi;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.params.ExcelExportEntity;
import cn.afterturn.easypoi.excel.entity.vo.BaseEntityTypeConstants;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;

/**
 * @author Victor
 * date: 2021/3/10 19:21
 */
public class Test4 {

    public static void main(String[] args) {


        for(int i = 1; i< 32; i++) {
            System.out.println("map.put("+i+", getAttDayStatusDesc(attMonth.getDay"+i+"()));");
        }



//        String dayN = "1-4";
//        String[] split = dayN.split("-");
//
//        StringBuilder sb = new StringBuilder();
//        for(String s : split) {
//            sb.append(AttDayStatusEnum.get(Integer.valueOf(s)).getRemark()).append("/");
//        }
//
//        System.out.println(sb.toString().substring(0, sb.length() - 1));

    }

    public static void main1(String[] args) {
        try {

            String curMonth = "2021-02";
            // 统计的月份
            Date startDate = DateUtil.parseDate(DateUtil.getMonthMinDate(curMonth), DateUtil.FMT2);
            Date endDate = DateUtil.parseDate(DateUtil.getMonthMaxDate(curMonth), DateUtil.FMT2);

            List<Date> betweenDates = DateUtil.getBetweenDates(startDate, endDate);

            int maxDay = betweenDates.size();

            List<ExcelExportEntity> colList = new ArrayList<ExcelExportEntity>();
            ExcelExportEntity colEntity = new ExcelExportEntity("序号", "idx");
            colEntity.setNeedMerge(true);
            colList.add(colEntity);

            colEntity = new ExcelExportEntity("部门", "branch");
            colEntity.setNeedMerge(true);
            colList.add(colEntity);

            colEntity = new ExcelExportEntity("工号", "employeeCode");
            colEntity.setNeedMerge(true);
            colList.add(colEntity);

            colEntity = new ExcelExportEntity("姓名", "employeeName");
            colEntity.setNeedMerge(true);
            colList.add(colEntity);

            colEntity = new ExcelExportEntity("项目编号", "projectCode");
            colEntity.setNeedMerge(true);
            colList.add(colEntity);

            colEntity = new ExcelExportEntity("项目名称", "projectName");
            colEntity.setNeedMerge(true);
            colList.add(colEntity);


            for(int i = 0; i < betweenDates.size(); i++) {
                Date date = betweenDates.get(i);
                ExcelExportEntity cnDayGroup = new ExcelExportEntity(DateUtil.dateToDayOfWeek(date), "cnDay"+(i+1));
                List<ExcelExportEntity> cnDayGroupColList = new ArrayList<>();
                cnDayGroupColList.add(new ExcelExportEntity(String.valueOf(i+1), "day" + (i+1), 5));
                cnDayGroup.setList(cnDayGroupColList);
                colList.add(cnDayGroup);
//
//                colEntity = new ExcelExportEntity(String.valueOf(i), "day" + i, 5);
//                colEntity.setType(BaseEntityTypeConstants.DOUBLE_TYPE);
//                colEntity.setNeedMerge(true);
////                colEntity.setNumFormat("0.00#");
//                colList.add(colEntity);
            }

            ExcelExportEntity deliColGroup = new ExcelExportEntity("本月应出勤天数为" + maxDay + "天", "shoAttendanceDays");
            List<ExcelExportEntity> deliColList = new ArrayList<>();
            deliColList.add(new ExcelExportEntity("出勤", "actAttendanceDays"));
            deliColList.add(new ExcelExportEntity("外勤", "fieldDays"));
            deliColList.add(new ExcelExportEntity("缺卡", "missingCardDays"));
            deliColList.add(new ExcelExportEntity("补卡", "fieldDays"));
            deliColList.add(new ExcelExportEntity("出差", "businessDays"));
            deliColList.add(new ExcelExportEntity("年假", "annualLeaveDays"));
            deliColList.add(new ExcelExportEntity("事假", "thingLeaveDays"));
            deliColList.add(new ExcelExportEntity("病假", "sickLeaveDays"));
            deliColList.add(new ExcelExportEntity("旷工", "completionDays"));
            deliColList.add(new ExcelExportEntity("婚假", "marriageLeaveDays"));
            deliColList.add(new ExcelExportEntity("丧假", "funeralLeaveDays"));
            deliColList.add(new ExcelExportEntity("产假", "maternityLeave"));
            deliColList.add(new ExcelExportEntity("陪产假", "paternityLeave"));
            deliColList.add(new ExcelExportEntity("迟到", "lateArrivals"));
            deliColList.add(new ExcelExportEntity("早退", "earlyRetreat"));
            deliColList.add(new ExcelExportEntity("调休(D)", "dayOff"));
            deliColList.add(new ExcelExportEntity("加班(D)", "overtimeDays"));
            deliColList.add(new ExcelExportEntity("本月餐补", "subsidy"));
            deliColGroup.setList(deliColList);
            colList.add(deliColGroup);


            List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
            for (int i = 0; i < 10; i++) {
                Map<String, Object> valMap = new HashMap<String, Object>();
                valMap.put("idx", "" + i);
                valMap.put("branch", "部门." + i);
                valMap.put("employeeCode", "工号." + i);
                valMap.put("employeeName", "姓名." + i);
                valMap.put("projectCode", "项目编号." + i);
                valMap.put("projectName", "项目名称." + i);

                // 一个月的开始~结束时间
                for(int day = 1; day <= maxDay; day++) {
                    List<Map<String, Object>> cnDayList = new ArrayList<Map<String, Object>>();
                    Map<String, Object> shoValMap = new HashMap<String, Object>();
                    shoValMap.put("day" + day, "day" + day);
                    cnDayList.add(shoValMap);
                    valMap.put("cnDay"+day, cnDayList);
                }

                List<Map<String, Object>> shoList = new ArrayList<Map<String, Object>>();
                Map<String, Object> shoValMap = new HashMap<String, Object>();
                // 本月应出勤天数为N天
                shoValMap.put("actAttendanceDays", "出勤" + i);
                shoValMap.put("fieldDays", "外勤" + i);
                shoValMap.put("missingCardDays", "缺卡" + i);
                shoValMap.put("fieldDays", "补卡" + i);
                shoValMap.put("businessDays", "出差");
                shoValMap.put("annualLeaveDays", "年假" + i);
                shoValMap.put("thingLeaveDays", "事假" + i);
                shoValMap.put("sickLeaveDays", "病假");
                shoValMap.put("completionDays", "旷工" + i);
                shoValMap.put("marriageLeaveDays", "婚假");
                shoValMap.put("funeralLeaveDays", "丧假");
                shoValMap.put("maternityLeave", "产假");
                shoValMap.put("paternityLeave", "陪产假" + i);
                shoValMap.put("lateArrivals", "迟到" + i);
                shoValMap.put("earlyRetreat", "早退" + i);
                shoValMap.put("dayOff", "调休(D)");
                shoValMap.put("overtimeDays", "加班(D)" + i);
                shoValMap.put("subsidy", "本月餐补" + i);

                shoList.add(shoValMap);
                valMap.put("shoAttendanceDays", shoList);


                list.add(valMap);
            }
//            2021年2月漪象科贸考勤表
            String[] split = curMonth.split("-");
            String title = split[0] + "年" + split[1] + "月漪象科贸考勤表";
            String sheetName = split[1] + "月考勤表";
            Workbook workbook = ExcelExportUtil.exportExcel(new ExportParams(title, sheetName), colList, list);
            FileOutputStream fos = new FileOutputStream("D:/考勤表.xls");
            workbook.write(fos);
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
