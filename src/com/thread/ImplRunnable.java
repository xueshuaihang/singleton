package com.thread;

public class ImplRunnable implements Runnable {

    @Override
    public void run() {
        try {
            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getName() + "线程休眠完成");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
