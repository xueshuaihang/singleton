package com.thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author Shuaihang Xue
 * @date 2020/10/28
 */
public class CounterReadWriteLock {

    private final ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    private final Lock rLock = readWriteLock.readLock();
    private final Lock wLock = readWriteLock.writeLock();
    private int count = 0;

    public void add() {
        wLock.lock();
        try {
            count += 1;
        } finally {
            wLock.unlock();
        }
    }

    public int get() {
        rLock.lock();
        try {
            return count;
        } finally {
            rLock.unlock();
        }
    }

}
