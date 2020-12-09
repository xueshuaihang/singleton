package com.newfeature.lambda;

import java.util.function.BiFunction;
import java.util.function.BinaryOperator;

/**
 * @author Shuaihang Xue
 * @date 2020/7/20
 */
public class BinaryOperatorTest {

    public static void main(String[] args) {
        useBinaryOperator();
    }

    public static void useBinaryOperator() {
        BinaryOperator<Integer> binaryOperator = ((integer, integer2) -> integer + integer2);
        System.out.println(binaryOperator.apply(1, 2));
    }
}
