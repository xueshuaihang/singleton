package com.newfeature.lambda;

import java.util.function.Supplier;

/**
 * @author Shuaihang Xue
 * @date 2020/7/20
 */
public class SupplierTest {

    public static void main(String[] args) {
        useSupplier();
    }

    public static void useSupplier() {
        Supplier<Student> studentSupplier = () -> new Student("小明", 1);
        System.out.println(studentSupplier.get().toString());
    }
}
