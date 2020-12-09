package com.factory.simplefactory;

/**
 * @author Shuaihang Xue
 * @date 2019/11/23
 */
public class Main {

    public static void main(String[] args) {
        Car car = CarFactory.getCar(CarType.MOTORBIKE);
        car.run();
    }
}
