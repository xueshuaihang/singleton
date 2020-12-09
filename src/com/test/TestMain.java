package com.test;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.time.LocalDate;
import java.util.StringJoiner;

public class TestMain implements TestInterface {

    public static void main(String[] args) throws IntrospectionException {
//        A ab = new B();
//        System.out.println(A.s);
//        ab = new B();
//        LocalDate localDate = LocalDate.now();
//        System.out.println(localDate.getDayOfWeek());
//        int a = 2;
//        int b = 3;
//        int c = 4;
//        String num = a + b + c + "";
//        System.out.println(num);
//        int i;
//        TestMain testMain = new TestMain();
//        i = testMain.k;
//        System.out.println(i);

//        String[] fields = {"name", "position", "salary"};
//        String table = "employee";
//        String insert = buildInserSqlByStringJoiner(table, fields);
//        System.out.println(insert);
//        String s = "INSERT INTO employee (name, position, salary) VALUES (?, ?, ?)";
//        System.out.println(s.equals(insert) ? "测试成功" : "测试失败");

        BeanInfo beanInfo = Introspector.getBeanInfo(Person.class, Object.class);
        for (PropertyDescriptor propertyDescriptor : beanInfo.getPropertyDescriptors()) {
            System.out.println(propertyDescriptor.getName());
            System.out.println(propertyDescriptor.getDisplayName());
            System.out.println(propertyDescriptor.getPropertyType());
            System.out.println(propertyDescriptor.getReadMethod());
            System.out.println(propertyDescriptor.getWriteMethod());
            System.out.println("-----------------------------------");
        }
    }

    static String buildInsertSql(String table, String[] fields) {
        StringBuilder insert = new StringBuilder("INSERT INTO ")
                .append(table)
                .append(" ")
                .append("(");
        String fieldsStr = String.join(", ", fields);
        insert.append(fieldsStr)
                .append(") ")
                .append("VALUES ")
                .append("(");
        for (int i = 0; i < fields.length; i++) {
            insert.append("?");
            if (i < fields.length - 1) {
                insert.append(", ");
            }
        }
        insert.append(")");
        return insert.toString();
    }

    static String buildInserSqlByStringJoiner(String table, String[] fields) {
        StringJoiner sj = new StringJoiner(", ", "INSERT INTO "+ table +" (", ") VALUES (");
        for (String field : fields) {
            sj.add(field);
        }
        String s = sj.toString();
        StringJoiner sj1 = new StringJoiner(", ","",")");
        for (int i = 0; i < fields.length; i++) {
            sj1.add("?");
        }
        String s1 = sj1.toString();
        return s + s1;
    }

    private static void swap(int[] a, int i, int j) {
        int tem = a[i];
        a[i] = a[j];
        a[j] = tem;
    }

    public void test() {
        A a = new A();
        System.out.println(a.s);
    }
}
