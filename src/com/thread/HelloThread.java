package com.thread;

/**
 * @author Shuaihang Xue
 * @date 2020/8/25
 */
public class HelloThread extends Thread {

    @Override
    public void run() {
        int n = 0;
        while (!isInterrupted()) {
            n++;
            System.out.println(n + " hello");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                break;
            }
        }
    }
}
