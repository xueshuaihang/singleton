package com.company;

public class Lazy {
    // 懒汉式单例类，在第一次调用的时候实例化自己
    private static Lazy lazy = null;

    private Lazy() {
    }

    // 静态工厂方法
//    public static Lazy getInstance(){
//        if (lazy == null) {
//            lazy = new Lazy();
//            System.out.println("创建一次");
//        }
//        return lazy;
//    }

    /**
     * 线程安全的，性能低
     */
//    public static synchronized Lazy getInstance(){
//        if (lazy == null) {
//            lazy = new Lazy();
//        }
//        return lazy;
//    }

    /**
     * 双检锁/双重校验锁（DCL，即 double-checked locking）
     * 安全且在多线程情况下能保持较高性能
     *
     * @return
     */
    public static Lazy getInstance() {
        if (lazy == null) {
            synchronized (Lazy.class) {
                if (lazy == null) {
                    lazy = new Lazy();
                }
            }
        }
        return lazy;
    }

    public void show() {
        System.out.println("我是show");
    }

}
