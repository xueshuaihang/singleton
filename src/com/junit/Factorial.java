package com.junit;

/**
 * @author Shuaihang Xue
 * @date 2020/8/19
 */
public class Factorial {

    public static void main(String[] args) {
        System.out.println(fact(1));
        System.out.println(fact(2));
        System.out.println(fact(3));
    }

    public static long fact(long n) {
        if (n > 20) {
            throw new ArithmeticException();
        }
        long r = 1;
        for (long i = 1; i <= n; i++) {
            r = r * i;
        }
        return r;
    }
}
