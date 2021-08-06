package com.vic.designpattern.chain_of_responsibility;

/**
 *
 * 抽象处理者
 * 定义一个处理请求的接口，包含抽象处理方法和一个后继连接。
 *
 */
public abstract class AbstractLeader {

    /**
     * 职级title
     */
    String title;

    /**
     * 后继者
     */
    AbstractLeader superior;

    public AbstractLeader(String title) {
        this.title = title;
    }

    public AbstractLeader setSuperior(AbstractLeader superior) {
        this.superior = superior;
        return superior;
    }

    /**
     * 通过
     * @param lp
     */
    public void done(LeaveProcess lp) {
        System.out.println(lp + " 被"+ title + "审批通过");
    }

    /**
     * 不通过
     * @param lp
     */
    public void failed(LeaveProcess lp) {
        System.out.println(lp + " 被"+ title + "审批不通过");
    }

    public abstract void toProcess(LeaveProcess lp);



}
