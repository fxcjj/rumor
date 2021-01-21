package com.vic.designpattern.strategy.v2;

import com.vic.designpattern.strategy.v1.CalcPrice;
import com.vic.designpattern.strategy.v1.GoldMember;
import com.vic.designpattern.strategy.v1.Member;
import com.vic.designpattern.strategy.v1.SuperMember;

/**
 *
 * @author Victor
 * date: 2019/8/30 13:51
 */
public class PriceFactory {

    public CalcPrice getCalcPrice(double price) {
        if(price < 1000) {
            return new Member();
        } else if(price >= 1000 && price < 3000) {
            return new SuperMember();
        } else/* if(price >= 3000) */{
            return new GoldMember();
        }
    }


    private PriceFactory() {

    }

    public static PriceFactory getInstance() {
        return new PriceFactory();
    }

}
