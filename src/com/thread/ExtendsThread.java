package com.thread;

public class ExtendsThread extends Thread {

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "启动");
    }
}
