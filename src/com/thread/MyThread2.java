package com.thread;

/**
 * @author Shuaihang Xue
 * @date 2020/8/25
 */
public class MyThread2 extends Thread {

    public volatile boolean running = true;

    @Override
    public void run() {
        int n = 0;
        while (running) {
            n++;
            System.out.println(n + " hello");
        }
        System.out.println("end");
    }
}
