package com.newfeature.lambda;

import java.util.function.Consumer;

/**
 * @author Shuaihang Xue
 * @date 2020/7/18
 */
public class ConsumerTest {

    public static void main(String[] args) {
        useConsumer();
    }

    public static void useConsumer() {
//        Consumer consumer = s -> System.out.println(s);
        // or
        Consumer consumer = System.out::println;
        consumer.accept("123");
    }
}
