package com.vic.generics;

import com.vic.serialization.Dog;

import java.util.ArrayList;
import java.util.List;

/**
 * 泛型中通配符 —— 无限制通配符 ?
 *
 * https://juejin.im/post/5d5789d26fb9a06ad0056bd9
 *
 * @author Victor
 * date: 2021/1/21 10:39
 */
public class GenericTest2 {

    static int countLegs(List<? extends Animal> animals) {
        int retVal = 0;
        for (Animal animal : animals) {
            retVal += animal.countLegs();
        }
        return retVal;
    }

    static int countLegs1(List<Animal> animals) {
        int retVal = 0;
        for (Animal animal : animals) {
            retVal += animal.countLegs();
        }
        return retVal;
    }

    public static void main(String[] args) {
        List<Bear> bears = new ArrayList<>();
        bears.add(new Bear());
        // 不会报错
        System.out.println(countLegs(bears));

        // 报错
//        countLegs1(bears); // 需要传Animal类型
    }

}

interface Animal {
    int countLegs();
}

class Bear implements Animal {

    @Override
    public int countLegs() {
        return 4;
    }

}




