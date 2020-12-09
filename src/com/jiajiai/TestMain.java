package com.jiajiai;

import java.util.HashSet;
import java.util.Set;

public class TestMain {

    public static void main(String[] args) {
//        int i = 0;
//        int j = 0;
//
//        i = i++;
//        j = ++i;
//
//        System.out.println("i++:" + i);
//        System.out.println("j++:" + j);
        test();
    }

    public static void test(){
        Set set = new HashSet();
        System.out.println(set.add("q"));
        System.out.println(set.add("q"));
    }
}
