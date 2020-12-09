package com.generics;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

/**
 * @author Shuaihang Xue
 * @date 2020/7/14
 */
public class Test<T> {

    private T name;

    public void testMethod(Collection<?> test) {
        // 编译失败
//        test.add(1);
//        test.add("s")

        List<?> list = new ArrayList<String>();
        // 编译失败
//        String s = list.get(1);
    }

    public void testExtends(Collection<? extends Base> param) {
        // 编译失败
//        param.add(new Sub());
//        param.add(new Base());
    }

    public void testSuper(Collection<? super Sub> param) {
        param.add(new Sub());
        // 编译失败
//        param.add(new Base());
    }

    public void testString(Test<String> test) {
        System.out.println(test.name);
    }

    public void testMethodErasure(T param) {

    }

    public static void main(String[] args) throws NoSuchFieldException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {
//        erasure();
//        roundGenerics();
//        List<String> list = new ArrayList<>();
//        List<Integer> list1 = new LinkedList<>();
//        System.out.println(list.getClass());
//        System.out.println(list1.getClass());
        String[] firstTwo = pickTwo("one", "two", "three");
        System.out.println(Arrays.toString(firstTwo));
    }

    public static void erasure() throws NoSuchFieldException {
        Class c = Test.class;
        /**
         * 在泛型类被擦除的时候，类型参数如果没有指定上限，如<T>会转译成Object
         * 如果指定了上限如<? extends String>，类型参数会转译成上限类型
         */
        Field field = c.getDeclaredField("name");
        System.out.println(field.getType().getName());

        /**
         * method擦除
         * 得到的testMethodErasure方法的签命是public void com.generics.Test.testMethodErasure(java.lang.Object)
         * T被替换成了Object
         * 也就是说在用反射得到这个方法时应该用getDeclaredMethod("testMethodErasure", Object.class)
         * 否则就找不到这个方法
         */
        for (Method method : c.getDeclaredMethods()) {
            System.out.println(method);
        }
    }

    /**
     * 了解泛型擦除的原理，就可以通过反射绕过正常开发中编译器不允许的操作
     * @throws NoSuchMethodException
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     */
    public static void roundGenerics() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        List<Integer> list = new ArrayList<>();
        list.add(12);
        Method add = list.getClass().getDeclaredMethod("add", Object.class);
        add.invoke(list, "zhangsan");
        add.invoke(list, 1.5);
        for (Object o : list) {
            System.out.println(o);
        }
    }

    static <K> K[] pickTwo(K k1, K k2, K k3) {
        return asArray(k1, k2);
    }

    static <T> T[] asArray(T... objs) {
        return objs;
    }



}
