package com.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author Shuaihang Xue
 * @date 2020/2/28
 */
public class Main {

    public static void main(String[] args) {
        // InvocationHandler负责调用方法
        InvocationHandler handler = new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println(method);
                if ("eat".equals(method.getName())) {
                    System.out.println("小狗🐕吃" + args[0]);
                }
                return "return value";
            }
        };

        Dog dynamicDog = (Dog) Proxy.newProxyInstance(Dog.class.getClassLoader(), new Class[] {Dog.class}, handler);
        String s = dynamicDog.eat("骨头");
        System.out.println(s);
    }
}
