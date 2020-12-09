package com.thread;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Shuaihang Xue
 * @date 2020/10/28
 */
public class CounterReentrantLock {
    public static final Lock lock = new ReentrantLock();
    public static int count = 0;

    public static void add() {
        lock.lock();
        try {
            count += 1;
        } finally {
            lock.unlock();
        }
    }

    public static void tryAdd() {
        // 尝试获取锁时最多等待1秒，1秒后还未获得锁，则返回false
        try {
            if (lock.tryLock(1, TimeUnit.SECONDS)) {
                try {
                    count += 1;
                } finally {
                    lock.unlock();
                }
            } else {
                // 尝试获取锁失败
                System.out.println("获得锁失败");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
