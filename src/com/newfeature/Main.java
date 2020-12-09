package com.newfeature;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author shuaihang Xue
 * @date 2019/10/16
 */
public class Main {

    public static void main(String[] args) {
//        filter();
        Integer a = 10;
        Integer b = 5;
        System.out.println("b的float" + b.floatValue());
        System.out.println("a/b" + a / b);
        Float c = null;
        System.out.println("a/b的float" + (c = a/b.floatValue()));
        System.out.println(c * 1000F);
    }

    /**
     * 过滤
     */
    public static void filter() {
        List<Integer> integers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
        List<Integer> afterFilter = integers.stream().filter(x -> x >= 8).collect(Collectors.toList());
        afterFilter.forEach(System.out::println);
    }

}
