package com.newfeature.lambda;

/**
 * @author Shuaihang Xue
 * @date 2020/7/20
 */
public class TestSimpleFunctionalInterface {

    public static void main(String[] args) {
        useSimpleFunctionalInterface();
    }

    public static void useSimpleFunctionalInterface() {
        SimpleFunctionalInterface simpleFunctionalInterface = () -> "321";
        System.out.println(simpleFunctionalInterface.apply());
    }
}
