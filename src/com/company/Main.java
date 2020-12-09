package com.company;

public class Main {

    public static void main(String[] args) {
//        Lazy singleton1 = Lazy.getInstance();
//        Lazy singleton2 = Lazy.getInstance();
//
//        singleton1.show();
//        singleton2.show();
//
//        if (singleton1 == singleton2) {
//            System.out.println("该对象的字符串表示形式");
//            System.out.println("singleton1:" + singleton1.toString());
//            System.out.println("singleton2:" + singleton2.toString());
//        }

        SingletonTest1 singleton3=SingletonTest1.getInstance();
        SingletonTest1 singleton4=SingletonTest1.getInstance();
        if(singleton3 == singleton4){
            System.out.println("该对象的字符串表示形式:");
            System.out.println("singleton3:"+singleton3.toString());
            System.out.println("singleton4:"+singleton4.toString());
        }
    }
}
