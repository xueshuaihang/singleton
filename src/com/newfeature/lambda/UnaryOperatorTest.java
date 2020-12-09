package com.newfeature.lambda;

import java.util.function.UnaryOperator;

/**
 * @author Shuaihang Xue
 * @date 2020/7/20
 */
public class UnaryOperatorTest {

    public static void main(String[] args) {
        useUnaryOperator();
    }

    public static void useUnaryOperator() {
        UnaryOperator<Integer> unaryOperator = integer -> integer++;
        System.out.println(unaryOperator.apply(1));
        UnaryOperator.identity();
    }
}
