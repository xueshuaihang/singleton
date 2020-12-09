package com.test;

public class A {

    public static String s = "nini";

    public String a = "a";

    static {
        System.out.println("1");
    }

    public A(){
        System.out.println("2");
    }

    public void a(){
        System.out.println(s );
        System.out.println(a);
    }

    public static void hello(){
        System.out.println();
        System.out.println("nini");
    }
}
