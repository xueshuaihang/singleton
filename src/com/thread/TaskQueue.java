package com.thread;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Shuaihang Xue
 * @date 2020/8/27
 */
public class TaskQueue {

    Lock lock = new ReentrantLock();
    Condition condition = lock.newCondition();
    Queue<String> queue = new LinkedList<>();

    public synchronized void addTask(String task) {
        queue.add(task);
        this.notifyAll();
    }

    public synchronized String getTask() throws InterruptedException {
        /**
         * 这里用while，而不是if
         * 因为线程被唤醒时，需要再次获取this锁。多个线程被唤醒后，只有一个线程能获取this锁，
         * 此刻，该线程执行queue.remove()可以获取到队列的元素，然而，剩下的线程如果获取this锁后执行queue.remove()，
         * 此刻队列可能已经没有任何元素了，所以，要始终在while循环中wait()，并且每次被唤醒后拿到this锁就必须再次判断
         */
        while (queue.isEmpty()) {
            this.wait();
        }
        return queue.remove();
    }

    public void addTaskReentrantLock(String task) {
        lock.lock();
        try {
            queue.add(task);
            condition.signalAll();
        } finally {
            lock.unlock();
        }
    }

    public String getTaskReentrantLock() throws InterruptedException {
        lock.lock();
        /**
         * 这里用while，而不是if
         * 因为线程被唤醒时，需要再次获取this锁。多个线程被唤醒后，只有一个线程能获取this锁，
         * 此刻，该线程执行queue.remove()可以获取到队列的元素，然而，剩下的线程如果获取this锁后执行queue.remove()，
         * 此刻队列可能已经没有任何元素了，所以，要始终在while循环中wait()，并且每次被唤醒后拿到this锁就必须再次判断
         */
        try {
            while (queue.isEmpty()) {
//                condition.await();
                if (condition.await(1, TimeUnit.SECONDS)) {
                    // 指定时间内唤醒
                } else {
                    // 指定时间后还没有醒过来
                }
            }
            return queue.remove();
        } finally {
            lock.unlock();
        }
    }
}
