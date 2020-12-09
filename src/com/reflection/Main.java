package com.reflection;

import java.io.Closeable;
import java.lang.reflect.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Shuaihang Xue
 * @date 2020/2/27
 */
public class Main {

    public static void main(String[] args) throws Exception {
//        getField();
//        getMethod();
//        getConstructor();
//        getSuperClass();
//        getInterface();
        testDynamicLoad();
    }

    static void getField() throws Exception {
        Student student = new Student();
        Student student1 = new Student();
        student1.setGrade(1);
        student.setGrade(6);
        Class studentClass = student.getClass();
        // 获取字段
//        System.out.println(studentClass.getField("name"));
//        System.out.println(studentClass.getField("score"));
//        System.out.println(studentClass.getDeclaredField("grade"));
        Field gradeField = studentClass.getDeclaredField("grade");
        // 字段名称
        System.out.println(gradeField.getName());
        // 字段类型，返回Class，例如：String.class
        Class type = gradeField.getType();
        // 字段修饰，可以通过Modifier的静态方法获取修饰状态
        int m = gradeField.getModifiers();
        System.out.println(Modifier.isAbstract(m));
        System.out.println(Modifier.isFinal(m));
        System.out.println(Modifier.isPublic(m));
        System.out.println(Modifier.isPrivate(m));
        // 获取字段的值，需要一个实例
        gradeField.setAccessible(true);
        Object g = gradeField.get(student);
        System.out.println(g);
        // 设置字段的值
        System.out.println("student1的grade:" + student1.getGrade());
        gradeField.set(student1, 2);
        System.out.println("student1的grade:" + gradeField.get(student1));
    }

    static void getMethod() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Class studentClass = Student.class;
//        System.out.println(studentClass.getMethod("playGame"));
//        System.out.println(studentClass.getDeclaredMethod("setGrade", int.class));
//        System.out.println(studentClass.getDeclaredMethod("priMethod"));
        // 获取Method
        Method personMethod = studentClass.getMethod("playGame", String.class);
        System.out.println(personMethod.getName());
        System.out.println(personMethod.getReturnType());
        Class[] parameterTypes = personMethod.getParameterTypes();
        for (Class parameterType : parameterTypes) {
            System.out.println(parameterType.getName());
        }
        System.out.println(personMethod.getModifiers());
        // 调用方法
        Person student = new Student();
        // 第一个参数为实例，代表用这个实例来执行方法
        personMethod.invoke(student, "730");
        // 调用静态方法
        Method parseInt = Integer.class.getMethod("parseInt", String.class);
        // 调用静态方法不需要实例，所以第一个参数写null即可
        int value = (int) parseInt.invoke(null, "730");
        System.out.println(value);
        // 调用非public方法
        Method priMethod = studentClass.getDeclaredMethod("priMethod");
        priMethod.setAccessible(true);
        priMethod.invoke(student);
        // 多态
        Method playGameMethod = Person.class.getMethod("playGame", String.class);
        playGameMethod.invoke(new Student(), "730");
        // 使用反射调用方法时，依然遵循多态，总是调用实际类型复写的方法（如果存在），上面代码实际相当于 ↓↓↓↓↓↓↓↓↓↓
        // Person student = new Student();
        // student.playGame("730");
    }

    static void getConstructor() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Constructor constructor = Integer.class.getConstructor(int.class);
        Integer integer = (Integer) constructor.newInstance(3);
        System.out.println(integer);
    }

    static void getSuperClass() throws ClassNotFoundException {
        Class integerClass = Class.forName("java.lang.Integer");
        Class n = integerClass.getSuperclass();
        System.out.println(n);
        Class o = n.getSuperclass();
        System.out.println(o);
        Class x = o.getSuperclass();
        System.out.println(x);

        // 判断Class是否可以向上转型
        System.out.println(Number.class.isAssignableFrom(Integer.class));
        System.out.println(Integer.class.isAssignableFrom(Number.class));
    }

    static void getInterface() {
        Class integerClass = Integer.class;
        Class[] interfaces = integerClass.getInterfaces();
        for (Class anInterface : interfaces) {
            System.out.println(anInterface);
        }
        // 对接口调用getSuperclass总是null，应该使用getInterfaces
        System.out.println(Closeable.class.getSuperclass());
        for (Class anInterface : Closeable.class.getInterfaces()) {
            System.out.println(anInterface);
        }
    }

    static void testDynamicLoad() throws ClassNotFoundException, NoSuchFieldException {
        Class personClass = Class.forName("com.reflection.Person");
        Field name = personClass.getField("name");
        System.out.println(name.getType());
    }

}
