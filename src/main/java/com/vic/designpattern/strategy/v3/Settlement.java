package com.vic.designpattern.strategy.v3;

import com.vic.designpattern.strategy.v1.CalcPrice;

/**
 * 结算
 * 有3种会员，分别为会员、超级会员、金牌会员，不同会员类型对应不同的打折方式。
 * 每消费1000增加一个级别，原价（会员）、八折（超级会员）、七折（金牌会员），
 * 消费区间在[x,1000)为原价
 * 消费区间在[1000,3000)为八折
 * 消费区间在[3000,y)为七折
 * @author Victor
 * date: 2019/8/30 10:29
 */
public class Settlement {

    /**
     * 总价
     */
    private double totalPrice;

    /**
     * 单价
     */
    private double price;

    public double buy(double price) throws Exception {
        this.price = price;
        this.totalPrice += price;
        CalcPrice calcPrice = PriceFactory.getInstance().getCalcPrice(price);
        return calcPrice.calc(price);
    }

    public static void main(String[] args) throws Exception {

        /**
         * (x,1000)
         * [1000,3000)
         * [3000,y)
         */
        Settlement s = new Settlement();
        // 会员
        System.out.println("顾客需支付：" + s.buy(999));
        // 超级
        System.out.println("顾客需支付：" + s.buy(1200));
        // 金牌
        System.out.println("顾客需支付：" + s.buy(3000));
    }

}
