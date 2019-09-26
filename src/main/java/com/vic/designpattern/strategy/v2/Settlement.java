package com.vic.designpattern.strategy.v2;

import com.vic.designpattern.strategy.v1.CalcPrice;

/**
 * 结算
 * 有3种会员，分别为会员、超级会员、金牌会员，不同会员类型对应不同的打折方式。
 * 每消费1000增加一个级别，原价（会员）、八折（超级会员）、七折（金牌会员），
 * 消费区间在[x,1000)为原价
 * 消费区间在[1000,3000)为八折
 * 消费区间在[3000,y)为七折
 * @author 罗利华
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

    public double buy(double price) {
        this.price = price;
        this.totalPrice += price;
        CalcPrice calcPrice = PriceFactory.getInstance().getCalcPrice(price);
        return calcPrice.calc(price);
    }

}
