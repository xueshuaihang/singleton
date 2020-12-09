package com.company;

public class Hungry {
    // 饿汉模式，在类初始化时，已经加载
    private static Hungry hungry = new Hungry();

    private Hungry(){}

    public static Hungry getInstance(){
        return hungry;
    }
}
