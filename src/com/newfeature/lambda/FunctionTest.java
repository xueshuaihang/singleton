package com.newfeature.lambda;

import java.util.function.Function;

/**
 * @author Shuaihang Xue
 * @date 2020/7/20
 */
public class FunctionTest {

    public static void main(String[] args) {
        useFunction();
    }

    public static void useFunction() {
        Function<Integer, String> transToString = integer -> String.valueOf(integer);
        Integer i = 5;
        String iStr = transToString.apply(i);
        System.out.println(i.getClass());
        System.out.println(iStr.getClass());
    }
}
