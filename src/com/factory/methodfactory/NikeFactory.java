package com.factory.methodfactory;

/**
 * @author Shuaihang Xue
 * @date 2019/11/23
 */
public class NikeFactory implements ClouthesFactory {
    @Override
    public Clouthes getClouthes() {
        return new Nike();
    }
}
