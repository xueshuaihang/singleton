package com.thread;

import java.util.concurrent.CompletableFuture;

/**
 * @author Shuaihang Xue
 * @date 2020/10/29
 */
public class CompletableFutureMain {

    public static void main(String[] args) throws InterruptedException {
//        useCompletableFuture();
//        serialCompletableFuture();
        concurrentCompletableFuture();
    }

    static void useCompletableFuture() throws InterruptedException {
        CompletableFuture<Double> completableFuture = CompletableFuture.supplyAsync(CompletableFutureMain::fetchPrice);
        // 如果执行成功
        completableFuture.thenAccept(result -> System.out.println("price: " + result));
        // 如果执行异常
        completableFuture.exceptionally(e -> {
            e.printStackTrace();
            return null;
        });
        Thread.sleep(200);
    }

    static void serialCompletableFuture() throws InterruptedException {
        CompletableFuture<String> cfQuery = CompletableFuture.supplyAsync(() -> queryCode("中国石油"));
        CompletableFuture<Double> cfFetch = cfQuery.thenApplyAsync((code) -> fetchPrice(code));
        cfFetch.thenAccept(result -> System.out.println("price: " + result));
        Thread.sleep(1000);
    }

    static void concurrentCompletableFuture() throws InterruptedException {
        CompletableFuture<String> cfQueryFromSina = CompletableFuture.supplyAsync(() ->
                queryCode("中国石油", "https://finance.sina.com.cn/code/"));
        CompletableFuture<String> cfQueryFrom163 = CompletableFuture.supplyAsync(() ->
                queryCode("中国石油", "https://money.163.com/code/"));
        CompletableFuture<Object> cfQuery = CompletableFuture.anyOf(cfQueryFromSina, cfQueryFrom163);
        CompletableFuture<Double> cfFetchFromSina = cfQuery.thenApplyAsync((code) ->
                fetchPrice((String) code, "https://finance.sina.com.cn/price/"));
        CompletableFuture<Double> cfFetchFrom163 = cfQuery.thenApplyAsync((code) ->
                fetchPrice((String) code, "https://money.163.com/price/"));
        CompletableFuture<Object> cfFetch = CompletableFuture.anyOf(cfFetchFromSina, cfFetchFrom163);
        cfFetch.thenAccept((result) -> System.out.println("price: " + result));
        Thread.sleep(1000);
    }

    static String queryCode(String name, String url) {
        System.out.println("query code from " + url + "...");
        try {
            Thread.sleep((long) (Math.random() * 100));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "601857";
    }

    static String queryCode(String name) {
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "601857";
    }

    static Double fetchPrice(String code, String url) {
        System.out.println("query price from " + url + "...");
        try {
            Thread.sleep((long) (Math.random() * 100));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return 5 + Math.random() * 20;
    }

    static Double fetchPrice(String code) {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return 5 + Math.random() * 20;
    }

    static Double fetchPrice() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (Math.random() < 0.3) {
            throw new RuntimeException("fetch price failed");
        }
        return 5 + Math.random() * 20;
    }
}
