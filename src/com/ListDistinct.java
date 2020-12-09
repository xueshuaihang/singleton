package com;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class ListDistinct {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("www");
        list.add("http");
        list.add("jpg");
        list.add("png");
        list.add("rmvb");
        list.add("jpg");
        list.add("rmvb");
        System.out.println("用java8新特性去重:" + distinct(list).toString());
        System.out.println("用List去重:" + distinctByList(list));
        System.out.println("用HashSet去重:" + distinctByHashSet(list));
    }

    /**
     * java8新特性Stream去重
     *
     * @param list
     * @return
     */
    public static List distinct(List<String> list) {
        return list.stream().distinct().collect(Collectors.toList());
    }

    /**
     * List去重
     *
     * @param list
     * @return
     */
    public static List distinctByList(List<String> list) {
        List<String> listTemp = new ArrayList<>();
        for (String s : list) {
            if (!listTemp.contains(s)) {
                listTemp.add(s);
            }
        }
        return listTemp;
    }

    /**
     * HashSet去重
     *
     * @param list
     * @return
     */
    public static List distinctByHashSet(List<String> list) {
        Set set = new HashSet(list);
        list.clear();
        list.addAll(set);
        return list;
    }
}
