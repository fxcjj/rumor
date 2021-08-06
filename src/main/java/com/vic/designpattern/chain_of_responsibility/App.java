package com.vic.designpattern.chain_of_responsibility;

/**
 *
 * http://c.biancheng.net/view/1383.html
 */
public class App {

    public static void main(String[] args) {
        AbstractLeader director = new Director("主管");
        AbstractLeader manager = new Manager("经理");
        AbstractLeader supervisor = new Supervisor("总监");

        // 设置审批流程
        director.setSuperior(manager).setSuperior(supervisor);

        // 请假2天
        LeaveProcess lp1 = new LeaveProcess("请假", "家里有事儿", 2);
        director.toProcess(lp1);

        // 请假3天
        LeaveProcess lp2 = new LeaveProcess("请假", "身体不舒服", 3);
        director.toProcess(lp2);

        // 请假6天
        LeaveProcess lp3 = new LeaveProcess("请假", "休年假", 6);
        director.toProcess(lp3);

        // 请假100天
        LeaveProcess lp4 = new LeaveProcess("请假", "去玩喽", 100);
        director.toProcess(lp4);

    }
}
