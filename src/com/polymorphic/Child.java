package com.polymorphic;

/**
 * @author shuaihang Xue
 * @date 2019/11/7
 */
public class Child extends Father {

    public Child(int age){
        System.out.println("我今年" + age + "岁");
    }

    public void write(){
        System.out.println("我正在上学");
    }
}
