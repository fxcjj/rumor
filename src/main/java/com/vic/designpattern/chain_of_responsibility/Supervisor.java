package com.vic.designpattern.chain_of_responsibility;

public class Supervisor extends AbstractLeader {

    private final int PERMISSIONS = 10;

    public Supervisor(String title) {
        super(title);
    }

    @Override
    public void toProcess(LeaveProcess lp) {
        // 超出处理的天数
        if(lp.getDays() > PERMISSIONS) {
            failed(lp);
        } else {
            done(lp);
        }
    }
}
