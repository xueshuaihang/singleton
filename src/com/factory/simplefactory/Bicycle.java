package com.factory.simplefactory;

/**
 * @author Shuaihang Xue
 * @date 2019/11/23
 */
public class Bicycle implements Car {
    @Override
    public void run() {
        System.out.println("我是自行车，时速15km/h");
    }
}
