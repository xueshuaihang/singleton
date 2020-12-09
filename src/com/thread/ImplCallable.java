package com.thread;

import java.util.concurrent.Callable;

public class ImplCallable implements Callable<String> {
    @Override
    public String call() throws Exception {
        Thread.sleep(1000);
        return "我是返回值";
    }
}
