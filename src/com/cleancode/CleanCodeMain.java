package com.cleancode;

import com.cleancode.po.Complex;

/**
 * @author shuaihang Xue
 * @date 2019/10/27
 */
public class CleanCodeMain {
    public static void main(String[] args) {
        String text = "text";
        addInfoForText(text);
        System.out.println(text);

        int count = 1;
        addOne(count);
        System.out.println(count);

        Complex complex = Complex.getComplexForName("小明", 18);
        changeComplex(complex);
        System.out.println(complex);
    }

    public static void changeComplex(Complex complex){
        complex.setName("小红");
        complex.setAge(16);
    }

    public static void addInfoForText(String text){
        text.substring(1,2);
        text = "info:" + text;
    }

    public static void addOne(int count){
//        Complex complex = new Complex();
    }

//    public static String addInfoForText(String text){
//
//    }
}
