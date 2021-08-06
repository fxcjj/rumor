package com.vic.designpattern.chain_of_responsibility;

public class Manager extends AbstractLeader {

    private final int PERMISSIONS = 5;

    public Manager(String title) {
        super(title);
    }

    @Override
    public void toProcess(LeaveProcess lp) {
        // 超出处理的天数
        if(lp.getDays() > PERMISSIONS) {
            superior.toProcess(lp);
        } else {
            done(lp);
        }
    }
}
