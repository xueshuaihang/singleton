package com.cleancode.po;

/**
 * @author shuaihang Xue
 * @date 2019/10/27
 */
public class Complex {

    private String name;
    private int age;

    private Complex(String name, int age){
        this.name = name;
        this.age = age;
    }

    public static Complex getComplexForName(String name, int age){
        return new Complex(name, age);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Complex{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
