package com.thread;

/**
 * @author Shuaihang Xue
 * @date 2020/8/25
 */
public class MyThread1 extends Thread {

    @Override
    public void run() {
        Thread hello = new HelloThread();
        hello.start();
        try {
            hello.join();
        } catch (InterruptedException e) {
            System.out.println("在等待状态下有人调用了interrupt");
        }
        hello.interrupt();
    }
}
