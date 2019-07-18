package com.vic.base;

import java.util.Date;
import java.util.Locale;

/**
 * String.format方法测试
 * https://www.cnblogs.com/Dhouse/p/7776780.html
 * https://www.cnblogs.com/xytop/archive/2008/08/26/1277125.html
 *
 * @author 罗利华
 * date: 2019/7/18 19:23
 */
public class StringFormatTest {

    public static void main(String[] args) {

        // 时间指定转换符生成新的字符串
        test5();

        // 日期指定转换符生成新的字符串
//        test4();

        // 日期和时间字符串格式化
//        test3();

        // 转换符
//        test2();

        // 格式化各种数据类型
//        test1();

    }

    /**
     * 时间指定转换符生成新的字符串
     */
    private static void test5() {
        Date date = new Date();
        //H的使用
        System.out.printf("2位数字24时制的小时（不足2位前面补0）:%tH%n", date);
        //I的使用
        System.out.printf("2位数字12时制的小时（不足2位前面补0）:%tI%n", date);
        //k的使用
        System.out.printf("2位数字24时制的小时（前面不补0）:%tk%n", date);
        //l的使用
        System.out.printf("2位数字12时制的小时（前面不补0）:%tl%n", date);
        //M的使用
        System.out.printf("2位数字的分钟（不足2位前面补0）:%tM%n", date);
        //S的使用
        System.out.printf("2位数字的秒（不足2位前面补0）:%tS%n", date);
        //L的使用
        System.out.printf("3位数字的毫秒（不足3位前面补0）:%tL%n", date);
        //N的使用
        System.out.printf("9位数字的毫秒数（不足9位前面补0）:%tN%n", date);
        //p的使用
        String str = String.format(Locale.US, "小写字母的上午或下午标记(英)：%tp", date);
        System.out.println(str);
        System.out.printf("小写字母的上午或下午标记（中）：%tp%n", date);
        //z的使用
        System.out.printf("相对于GMT的RFC822时区的偏移量:%tz%n", date);
        //Z的使用
        System.out.printf("时区缩写字符串:%tZ%n", date);
        //s的使用
        System.out.printf("1970-1-1 00:00:00 到现在所经过的秒数：%ts%n", date);
        //Q的使用
        System.out.printf("1970-1-1 00:00:00 到现在所经过的毫秒数：%tQ%n", date);
    }
    /**
     * 日期指定转换符生成新的字符串
     */
    private static void test4() {
        Date date = new Date();
        //b的使用，月份简称
        String str = String.format(Locale.US,"英文月份简称：%tb",date);
        System.out.println(str);
        System.out.printf("本地月份简称：%tb%n",date);
        //B的使用，月份全称
        str=String.format(Locale.US,"英文月份全称：%tB",date);
        System.out.println(str);
        System.out.printf("本地月份全称：%tB%n",date);
        //a的使用，星期简称
        str=String.format(Locale.US,"英文星期的简称：%ta",date);
        System.out.println(str);
        //A的使用，星期全称
        System.out.printf("本地星期的简称：%tA%n",date);
        //C的使用，年前两位
        System.out.printf("年的前两位数字（不足两位前面补0）：%tC%n",date);
        //y的使用，年后两位
        System.out.printf("年的后两位数字（不足两位前面补0）：%ty%n",date);
        //j的使用，一年的天数
        System.out.printf("一年中的天数（即年的第几天）：%tj%n",date);
        //m的使用，月份
        System.out.printf("两位数字的月份（不足两位前面补0）：%tm%n",date);
        //d的使用，日（二位，不够补零）
        System.out.printf("两位数字的日（不足两位前面补0）：%td%n",date);
        //e的使用，日（一位不补零）
        System.out.printf("月份的日（前面不补0）：%te",date);
    }

    /**
     * 日期和时间字符串格式化
     */
    private static void test3() {

        Date date = new Date();
        //c的使用
        System.out.printf("全部日期和时间信息：%tc%n",date);
        //f的使用
        System.out.printf("年-月-日格式：%tF%n",date);
        //d的使用
        System.out.printf("月/日/年格式：%tD%n",date);
        //r的使用
        System.out.printf("HH:MM:SS PM格式（12时制）：%tr%n",date);
        //t的使用
        System.out.printf("HH:MM:SS格式（24时制）：%tT%n",date);
        //R的使用
        System.out.printf("HH:MM格式（24时制）：%tR",date);
    }

    /**
     * 转换符
     */
    private static void test2() {

        // $使用
        System.out.printf("格式参数$的使用: %2$d, %1$s", "abc", 99);

        // +使用
        System.out.printf("显示正负数的符号: %+d与%d %n", 99, -99);

        // 补0使用
        System.out.printf("最牛的编号是: %04d%n", 7);

        // 空格使用
        System.out.printf("Tab键的效果是: % 8d%n", 7);

        // ,使用
        System.out.printf("整数分组的效果是: %,d%n", 9989997);

        // 空格和小数点后面个数
        System.out.printf("一本书的价格是: % 50.5f元%n", 49.8);

    }

    /**
     * 格式化各种数据类型
     */
    private static void test1() {
        // 字符串
        String format = String.format("thyme, %s, %s", "beautiful", "perfume");
        System.out.println(format);

        // 字符
        System.out.printf("The upper case of the 'a' letter: %c %n", 'A');

        // 布尔
        System.out.printf("3 greater than 7: %b %n", 3 > 7);

        // 整数类型（十进制）
        System.out.printf("The digital: %d %n", 3);

        // 100的十六进制
        System.out.printf("The Hexadecimal number of 100: %x %n", 100);

        // 100的八进制
        System.out.printf("The octal number of 100: %o %n", 100);

        // 浮点
        System.out.printf("The book price: %f RMB%n", 50*0.3);

        // 十六进制浮点类型
        System.out.printf("Hexadecimal float number: %a %n", 50*0.3);

        // 指数
        System.out.printf("Exponent: %e %n", 50*0.83);

        // 在f和e中较短的
        System.out.printf("the shorter in float and exponent：%g %n", 50*0.85);

        // %%百分号
        System.out.printf("The discount: %d%% %n", 85);

        // hash值
        System.out.printf("The hash of 'A' letter: %h %n", 'A');
    }

}
