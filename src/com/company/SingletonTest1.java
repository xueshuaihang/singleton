package com.company;

public class SingletonTest1 {
    private static class SingletonHolder {
        private static final SingletonTest1 INSTANCE = new SingletonTest1();
    }

    private SingletonTest1() {
    }

    public static final SingletonTest1 getInstance() {
        System.out.println("创建实例");
        return SingletonHolder.INSTANCE;
    }
}
