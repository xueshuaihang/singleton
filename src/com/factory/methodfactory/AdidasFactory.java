package com.factory.methodfactory;

/**
 * @author Shuaihang Xue
 * @date 2019/11/23
 */
public class AdidasFactory implements ClouthesFactory {
    @Override
    public Clouthes getClouthes() {
        return new Adidas();
    }
}
