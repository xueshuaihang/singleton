package com;

import com.google.common.collect.Lists;
import com.test.A;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;

public class Main {

    public static void main(String[] args) {
//        Parent parent = new Child();
//        System.out.println(parent.sayHello());
//        String s = new String("hello");
//        change(s);
//        System.out.println(s);
//        A a = new A();
//        a.hashCode()


//        Scanner sc = new Scanner(System.in);
//        System.out.println("输入n");
//        Integer n = sc.nextInt();
//        System.out.println(mul(n));

//        String s;
//        System.out.println("s=" + s);

//        System.out.println(returnTest());

//        Object status = null;
//        String statusString = (String) status;
//        System.out.println(statusString);

//        Map<String, Object> map = new HashMap<>();
//        map.put("integer", 1);
//        map.put("string", "2");
//        Integer integer = (Integer) map.get("integer");
//        Integer string = Integer.valueOf(map.get("string").toString());
//        System.out.println(integer);
//        System.out.println(string);

//        String epicTypeName = "版本(日常)";
//        int beginIndex = epicTypeName.indexOf("(") + 1;
//        int endIndex = epicTypeName.lastIndexOf(")");
//        epicTypeName = epicTypeName.substring(beginIndex, endIndex);
//        System.out.println(epicTypeName);

//        System.out.println(0%2);
//        System.out.println(1%2);
//        System.out.println(2%2);
//        System.out.println(3%2);
//        System.out.println(4%2);
//        System.out.println(5%2);

//        SimpleDateFormat sf = new SimpleDateFormat("yyyyMMddHH");
//
//        Calendar now = Calendar.getInstance();
//        System.out.println(sf.format(now.getTime()));
//        now.add(Calendar.DAY_OF_MONTH, 1);
//        System.out.println(sf.format(now.getTime()));
//        testNull(Arrays.asList(1, 2, 3, 4), null);
//        testByteEquals();

//        System.out.println("t28493".toUpperCase());

//        Set<String> set1 = new HashSet<>();
//        Set<String> set2 = new HashSet<>();
//        set1.add("T28493");
//        set2.add("T28493");
//        set2.add("123");
//        set1.addAll(set2);
//        for (String s : set1) {
//            System.out.println(s);
//        }

        List<BigDecimal> bigDecimals = Lists.newArrayList();
        System.out.println(bigDecimals.stream().reduce(BigDecimal::add).orElse(BigDecimal.ZERO));
    }

    static void testByteEquals() {
        System.out.println((byte)0 == 0);
    }

    static <T> void testNull(List<T> list, Integer a) {
        System.out.println(a);
    }

    private static int testReturn() {
        int i = 1;
        try {
            i++;
            System.out.println("try:" + i);
        } catch (Exception e) {
            i++;
            System.out.println("catch:" + i);
            return i;
        } finally {
            i++;
            System.out.println("finally:" + i);
            return i;
        }
//        i++;
//        return i;
    }

    public static boolean returnTest() {
        try {
            return true;
        } catch (Exception e) {

        } finally {
            return false;
        }
    }

    public static Integer mul(Integer n) {
        if (n.equals(1)) {
            return 1 * n;
        } else {
            return 1 * n * mul(n - 1);
        }
    }
}
