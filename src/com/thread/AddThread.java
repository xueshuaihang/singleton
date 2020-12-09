package com.thread;

/**
 * @author Shuaihang Xue
 * @date 2020/8/25
 */
public class AddThread extends Thread {

    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            synchronized (Counter.lock) {
                Counter.count += 1;
            }
        }
    }
}
