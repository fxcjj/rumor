package com.vic.designpattern.principle.solid.isp;

/**
 * 接口隔离原则（Interface Segregation Principle）
 * http://c.biancheng.net/view/1330.html
 * @author Victor
 * date: 2020/3/11 16:18
 */
public class ISPTest {
    public static void main(String[] args) {
        InputModule inputModule = StuScoreList.getInputModule();
        CountModule countModule = StuScoreList.getCountModule();
        PrintModule printModule = StuScoreList.getPrintModule();
        inputModule.insert();
        countModule.countAverage();
        printModule.printStuInfo();

    }
}

/**
 * 输入模块
 */
interface InputModule {
    void insert();
    void delete();
    void modify();
}

/**
 * 统计模块
 */
interface CountModule {
    void countTotalScore();
    void countAverage();
}

/**
 * 打印模块
 */
interface PrintModule {
    void printStuInfo();
    void queryStuInfo();
}

/**
 * 实现类
 */
class StuScoreList implements InputModule, CountModule, PrintModule {

    public static InputModule getInputModule() {
        return new StuScoreList();
    }

    public static CountModule getCountModule() {
        return new StuScoreList();
    }

    public static PrintModule getPrintModule() {
        return new StuScoreList();
    }

    @Override
    public void insert() {
        System.out.println("输入模块 insert 方法被调用");
    }

    @Override
    public void delete() {
        System.out.println("输入模块 delete 方法被调用");
    }

    @Override
    public void modify() {
        System.out.println("输入模块 modify 方法被调用");
    }

    @Override
    public void countTotalScore() {
        System.out.println("统计模块 countTotalScore 方法被调用");
    }

    @Override
    public void countAverage() {
        System.out.println("统计模块 countAverage 方法被调用");
    }

    @Override
    public void printStuInfo() {
        System.out.println("打印模块 printStuInfo 方法被调用");
    }

    @Override
    public void queryStuInfo() {
        System.out.println("打印模块 queryStuInfo 方法被调用");
    }
}