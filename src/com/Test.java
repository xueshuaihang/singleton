package com;

import com.sample.Hello;

/**
 * @author Shuaihang Xue
 * @date 2020/3/3
 */
public class Test {

    /*public static void main(String[] args) throws IllegalAccessException, InstantiationException {
        Hello hello = new Hello();
        hello.sayHello();

        Class clazz = String.class;
        String s = (String) clazz.newInstance();

    }*/

    public static void main(String[] args) throws InstantiationException, IllegalAccessException {
//        System.out.println(Test.class.newInstance().myMethod(1));
        String num1 = "10";
        String num2 = "20";
        int i = num1.charAt(0) - '0';
        System.out.println(4 / 10);
    }

    public String myMethod(int i) {
        return "gift";
    }

    public void myMethod(int i, int a) {

    }

}
