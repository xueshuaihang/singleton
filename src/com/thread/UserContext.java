package com.thread;

/**
 * @author Shuaihang Xue
 * @date 2020/10/30
 */
public class UserContext implements AutoCloseable {
    static ThreadLocal<String> threadLocal = new ThreadLocal<>();

    public UserContext(String name) {
        threadLocal.set(name);
    }

    public static String currentUser() {
        return threadLocal.get();
    }

    @Override
    public void close() throws Exception {
        System.out.println("准备清除UserContext: " + currentUser());
        threadLocal.remove();
    }
}
