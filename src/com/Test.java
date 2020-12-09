package com;

import com.sample.Hello;

/**
 * @author Shuaihang Xue
 * @date 2020/3/3
 */
public class Test {

    public static void main(String[] args) throws IllegalAccessException, InstantiationException {
        Hello hello = new Hello();
        hello.sayHello();

        Class clazz = String.class;
        String s = (String) clazz.newInstance();

    }
}
