package com.thread;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class ThreadMain {

    public static void main(String[] args) throws Exception {
//        createThreadByRunnable();
//        createThreadByThread();

//        System.out.println("Thread之外的代码");
//        createThreadByCallable();

//        useJoin();
//        useInterrupt();
//        useInterruptWhenJoin();

//        useVolatile();
//        useDaemon();

//        useSynchronized();

//        useWaitAndNotify();
//        useReentrantLock();
//        useReadWriteLock();
//        useStampedLock();
        useTheadLocal();
    }

    public static void createThreadByRunnable() {
        new Thread(new ImplRunnable(), "线程1").start();
    }

    public static void createThreadByThread() {
        Thread thread = new ExtendsThread();
        thread.setName("线程2");
        thread.start();
    }

    public static void createThreadByCallable() throws Exception {
        Callable callable = new ImplCallable();
        FutureTask futureTask = new FutureTask(callable);
        Thread thread = new Thread(futureTask);
        thread.start();
    }

    static void useJoin() throws InterruptedException {
        System.out.println(Thread.currentThread().getName() + " start");
        Thread thread = new Thread(() -> System.out.println("hello"));
        thread.start();
        // join表示等待当前线程结束之后再执行下面的代码
        // 有个重载方法表示最多等待多长时间
        thread.join();
        System.out.println(Thread.currentThread().getName() + " end");
    }

    static void useInterrupt() throws InterruptedException {
        Thread t = new MyThread();
        t.start();
        Thread.sleep(1);
        t.interrupt();
        t.join();
        System.out.println("end");
    }

    /**
     * 当线程执行了join()在等待其他线程的时候，对线程执行interrupt()就会抛出InterruptedException异常
     */
    static void useInterruptWhenJoin() throws InterruptedException {
        Thread t = new MyThread1();
        t.start();
        Thread.sleep(1000);
        t.interrupt();
        t.join();
        System.out.println("end");
    }

    static void useVolatile() throws InterruptedException {
        MyThread2 t = new MyThread2();
        t.start();
        Thread.sleep(1);
        t.running = false;
    }

    /**
     * 守护线程是为其他线程服务的线程，在JVM中，所有非守护线程都执行完毕后，就会退出，无论有没有守护线程
     * 因此，JVM退出时，不必关心守护线程是否已结束
     * 在守护线程中，编写代码要注意：守护线程不能持有任何需要关闭的资源，例如打开文件等，因为虚拟机退出时，守护线程没有任何机会来关闭文件，这会导致数据丢失
     */
    static void useDaemon() throws InterruptedException {
        Thread t = new MyThread();
        t.setDaemon(true);
        t.start();
        Thread.sleep(1);
    }

    /**
     * 两组线程不存在竞争时，应该使用不同的锁，这样会大大提升效率
     * <p>
     * 参考<a href="https://www.liaoxuefeng.com/wiki/1252599548343744/1306580844806178">廖雪峰的Java教程</a>中AddStudentThread和AddTeacherThread
     *
     * @throws InterruptedException
     */
    static void useSynchronized() throws InterruptedException {
        Thread add = new AddThread();
        Thread dec = new DecThread();
        add.start();
        dec.start();
        add.join();
        dec.join();
        System.out.println(Counter.count);
    }

    static void useWaitAndNotify() throws InterruptedException {
        TaskQueue taskQueue = new TaskQueue();
        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Thread get = new Thread(() -> {
                while (true) {
                    try {
                        String task = taskQueue.getTaskReentrantLock();
                        System.out.println("get Task " + task);
                    } catch (InterruptedException e) {
                        return;
                    }
                }
            });
            get.start();
            threads.add(get);
        }
        Thread add = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                String task = "t-" + Math.random();
                System.out.println("add Task " + task);
                taskQueue.addTaskReentrantLock(task);
            }
        });
        add.start();
        add.join();
        Thread.sleep(100);
        for (Thread thread : threads) {
            thread.interrupt();
        }
    }

    static void useReentrantLock() throws InterruptedException {
        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
//            Thread addThread = new Thread(() -> CounterReentrantLock.add());
            Thread addThread = new Thread(() -> CounterReentrantLock.tryAdd());
            threads.add(addThread);
        }
        for (Thread thread : threads) {
            thread.start();
        }
        for (Thread thread : threads) {
            thread.join();
        }
        System.out.println(CounterReentrantLock.count);
    }

    static void useReadWriteLock() throws InterruptedException {
        List<Thread> threads = new ArrayList<>();
        CounterReadWriteLock counterReadWriteLock = new CounterReadWriteLock();
        long start = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            Thread getThread = new Thread(() -> System.out.println("当前count：" + counterReadWriteLock.get()));
            threads.add(getThread);
            if (i % 10 == 0) {
                int current = i;
                Thread addThread = new Thread(() -> {
                    System.out.println("开始写操作，当前循环次数" + current);
                    counterReadWriteLock.add();
                });
                threads.add(addThread);
            }
        }
        for (Thread thread : threads) {
            thread.start();
        }
        for (Thread thread : threads) {
            thread.join();
        }
        long end = System.currentTimeMillis();
        System.out.printf("用时：%s", end - start);
    }

    static void useStampedLock() {
        Point point = new Point();
        point.move(3, 2);
        System.out.println(point.distanceFromOrigin());
    }

    static void useTheadLocal() throws InterruptedException {
        Thread thread = new Thread(() -> {
            try(UserContext userContext = new UserContext("Bob")) {
                printCurrentUser();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        Thread thread1 = new Thread(() -> {
            try(UserContext userContext = new UserContext("Alice")) {
                printCurrentUser();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        thread.start();
        thread1.start();
        thread.join();
        thread1.join();
    }

    static void printCurrentUser() {
        System.out.println(Thread.currentThread().getName() + UserContext.currentUser());
    }

}
