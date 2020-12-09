package com.newfeature.lambda;

/**
 * @author Shuaihang Xue
 * @date 2020/7/20
 */
// 只要符合条件的就可以被认为是函数接口，不管是否拥有@FunctionalInterface注解
// 条件为该类或接口只有一个抽象方法，或只有一个抽象方法和若干个默认方法，静态方法
// 加上注解可以利用编译器检测是否符合条件
@FunctionalInterface
public interface SimpleFunctionalInterface {

    String apply();
}
