package com.lock;

import sun.misc.Unsafe;

/**
 * @author Shuaihang Xue
 * @date 2025/2/22
 */
public class SelfLock {

    private volatile int state = 0;

    private Unsafe unsafe = Unsafe.getUnsafe();

    private long offset = unsafe.objectFieldOffset(SelfLock.class.getDeclaredField("state"));

    public SelfLock() throws NoSuchFieldException {
    }

    private boolean compareAndSet(int expect, int update) {
        return unsafe.compareAndSwapInt(this, offset, expect, update);
    }
}
