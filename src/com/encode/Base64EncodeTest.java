package com.encode;

import java.util.Base64;

/**
 * @author Shuaihang Xue
 * @date 2020/9/14
 */
public class Base64EncodeTest {

    public static void main(String[] args) {
        encode();
        decode();
    }

    static void encode() {
        byte[] bytes = Base64.getEncoder().encode("T28493:Xsh0911.".getBytes());
        System.out.println(new String(bytes));
    }

    static void decode() {
        byte[] bytes = Base64.getDecoder().decode("VDI4NDkzOlhzaDA5MTEu");
        System.out.println(new String(bytes));
    }

}
