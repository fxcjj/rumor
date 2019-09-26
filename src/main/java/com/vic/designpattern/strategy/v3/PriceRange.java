package com.vic.designpattern.strategy.v3;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 价格范围，含头不含尾
 * @author 罗利华
 * date: 2019/8/30 15:20
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface PriceRange {

    int min() default Integer.MIN_VALUE;

    int max() default Integer.MAX_VALUE;

}
