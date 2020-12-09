package com.factory.simplefactory;

/**
 * @author Shuaihang Xue
 * @date 2019/11/23
 */
public class Motorbike implements Car {
    @Override
    public void run() {
        System.out.println("我是摩托车，时速80km/h");
    }
}
