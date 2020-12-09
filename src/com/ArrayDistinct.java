package com;

import java.util.*;
import java.util.function.IntFunction;

/**
 * 数组去重
 */
public class ArrayDistinct {
    public static void main(String[] args) {
        String[] arrStr = {"abc", "www", "hello", "test", "main", "www", "abc"};
        System.out.println("用List去重:" + Arrays.toString(distinctByList(arrStr)));
        System.out.println("用map去重:" + Arrays.toString(distinctByMap(arrStr)));
        System.out.println("用Set去重:" + Arrays.toString(distinctBySet(arrStr)));
        System.out.println("用java8新特性去重:" + Arrays.toString(distinct(arrStr)));
    }

    /**
     * 通过List去重
     *
     * @param arrStr
     * @return
     */
    public static String[] distinctByList(String[] arrStr) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < arrStr.length; i++) {
            // 如果list中不存在此元素就添加到list集合中
            if (!list.contains(arrStr[i])) {
                list.add(arrStr[i]);
            }
        }
        // list转换为array，如果参数中的数组够大，则存储在参数的数组中；否则会分配新的与参数类型相同的数组
        String[] newArrStr = list.toArray(new String[1]);
        return newArrStr;
    }

    /**
     * 通过map去重
     *
     * @param arrStr
     * @return
     */
    public static String[] distinctByMap(String[] arrStr) {
        Map<String, Object> map = new HashMap<>();
        for (int i = 0; i < arrStr.length; i++) {
            // HashMap是不允许K值重复的，如果有重复的K值，新值会覆盖掉旧值
            map.put(arrStr[i], null);
        }
        String[] newArrStr = map.keySet().toArray(new String[1]);
        return newArrStr;
    }

    /**
     * 通过HashSet去重
     *
     * @param arrStr
     * @return
     */
    public static String[] distinctBySet(String[] arrStr) {
        Set<String> set = new HashSet<>();
        for (int i = 0; i < arrStr.length; i++) {
            // HashSet底层是HashMap
            set.add(arrStr[i]);
        }
        String[] newArrStr = set.toArray(new String[1]);
        return newArrStr;
    }

    /**
     * 通过java8新特性去重
     *
     * @param arrStr
     * @return
     */
    public static String[] distinct(String[] arrStr) {
        return Arrays.asList(arrStr).stream().distinct().toArray(String[]::new);
//        return Arrays.asList(arrStr).stream().distinct().toArray(new IntFunction<String[]>() {
//            @Override
//            public String[] apply(int value) {
//                System.out.println(value);
//                return new String[value];
//            }
//        });
    }
}
