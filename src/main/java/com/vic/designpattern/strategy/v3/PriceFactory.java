package com.vic.designpattern.strategy.v3;

import com.vic.designpattern.strategy.v1.CalcPrice;
import com.vic.designpattern.strategy.v1.GoldMember;
import com.vic.designpattern.strategy.v1.Member;
import com.vic.designpattern.strategy.v1.SuperMember;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * 计算价格工厂
 * @author 罗利华
 * date: 2019/8/30 13:51
 */
public class PriceFactory {

    public static final String SCAN_PACKAGE = PriceFactory.class.getPackage().getName();

    private List<Class<? extends CalcPrice>> calcPriceList = new ArrayList<>();

    public CalcPrice getCalcPrice(double price) throws Exception {
        for(Class<? extends CalcPrice> clazz : calcPriceList) {
            PriceRange priceRange = clazz.getAnnotation(PriceRange.class);
            // 在此范围内
            if(priceRange.min() <= price && price < priceRange.max()) {
                return clazz.newInstance();
            }
        }
        return null;
    }

    private PriceFactory() {
        try {
            initCalcPriceList();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * 将当前类所处目录下的含有PriceRange注解的类添加到集合中
     * @throws ClassNotFoundException
     */
    private void initCalcPriceList() throws ClassNotFoundException {
        String path = System.getProperty("user.dir") + File.separator + "src" + File.separator + "main" + File.separator + "java" + File.separator + SCAN_PACKAGE.replace(".", File.separator) + File.separator;
        // D:\github\rumor\src\main\java\com\vic\designpattern\strategy\v3\
//        System.out.println("path:" + path);
        File file = new File(path);
        String[] list = file.list();
        for(String className : list) {
            String forName = SCAN_PACKAGE + "." + className.replace(".java", "");
            Class<? extends CalcPrice> clazz = (Class<? extends CalcPrice>)Class.forName(forName);
            if(clazz.isAnnotationPresent(PriceRange.class)) {
                calcPriceList.add(clazz);
            }
        }
    }

    public static PriceFactory getInstance() {
        return new PriceFactory();
    }

    public static void main(String[] args) {
        System.out.println();
    }
}
