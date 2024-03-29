package com.vic.designpattern.principle.lod;

/**
 * 迪米特法则（Lan of Demeter），又称作最少知识法则（Least Knowledge Principle）
 * http://c.biancheng.net/view/1331.html
 * @author Victor
 * date: 2020/3/11 16:47
 */
public class LoDTest {
    public static void main(String[] args) {
        Agent agent = new Agent();
        agent.setMyStar(new Star("吴京"));
        agent.setMyFans(new Fans("水军1号"));
        agent.setMyCompany(new Company("中国传媒有限公司"));
        agent.meeting();
        agent.business();
    }
}

/**
 * 明星
 */
class Star {
    private String name;

    public Star(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

/**
 * 经纪人
 */
class Agent {
    private Star myStar;
    private Fans myFans;
    private Company myCompany;

    public void setMyStar(Star myStar) {
        this.myStar = myStar;
    }

    public void setMyFans(Fans myFans) {
        this.myFans = myFans;
    }

    public void setMyCompany(Company myCompany) {
        this.myCompany = myCompany;
    }

    public void meeting() {
        System.out.println(myFans.getName() + "与明星" + myStar.getName() + "见面了");
    }

    public void business() {
        System.out.println(myCompany.getName() + "与明星" + myStar.getName() + "洽淡业务");
    }
}

/**
 * 粉丝
 */
class Fans {
    private String name;

    public Fans(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

/**
 * 媒体公司
 */
class Company {
    private String name;

    public Company(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}