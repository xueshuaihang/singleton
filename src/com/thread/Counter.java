package com.thread;

/**
 * @author Shuaihang Xue
 * @date 2020/8/25
 */
public class Counter {

    public static final Object lock = new Object();
    public static int count = 0;
}
