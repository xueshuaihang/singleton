package com.factory.simplefactory;

/**
 * @author Shuaihang Xue
 * @date 2019/11/23
 */
public class CarFactory {

    public static Car getCar(CarType carType) {
        Car car = null;
        if (carType == CarType.BICYCLE) {
            car = new Bicycle();
        }
        if (carType == CarType.MOTORBIKE) {
            car = new Motorbike();
        }
        return car;
    }
}
