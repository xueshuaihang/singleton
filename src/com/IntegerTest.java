package com;

public class IntegerTest {
    public static void main(String[] args) {
        // Integer x = x;会被编译成Integer x = Integer.valueOf(x);而ValueOf()的源码中是先从IntegerCache中拿值的
        Integer a = 100;
        Integer b = Integer.valueOf(100);
        Integer c = 128;
        Integer d = 128;
        // true，因为都是在IntegerCache中拿的值，地址都一样
        System.out.println("a和b==:" + (a == b));
        // false，超过了IntegerCache的范围，会创建对象
        System.out.println("c和d==:" + (c == d));

        Integer e = new Integer(18);
        Integer f = new Integer(18);
        // false，new Integer会直接创建对象
        System.out.println("e和f==:" + (e == f));
    }
}
