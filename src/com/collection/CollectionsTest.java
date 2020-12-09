package com.collection;

import com.google.common.collect.Lists;

import java.util.Collections;
import java.util.List;

/**
 * @author Shuaihang Xue
 * @date 2020/8/3
 */
public class CollectionsTest {

    public static void main(String[] args) {
//        sort();
//        shuffle();
        unmodifiableList();
    }

    static void sort() {
        List<String> list = getList();
        Collections.sort(list);
        list.forEach(System.out::println);
    }

    static void shuffle() {
        List<Integer> list = Lists.newArrayList();
        Collections.addAll(list, 1, 2, 3, 4);
        System.out.println(list);
        Collections.shuffle(list);
        System.out.println(list);
    }

    static void unmodifiableList() {
        List<String> list = getList();
        List<String> unmodifiableList = Collections.unmodifiableList(list);
//        unmodifiableList.add("element");    // throw java.lang.UnsupportedOperationException
        list = unmodifiableList;
//        list.add("orange");     // 这个操作会影响到unmodifiableList，所以在变为不可变之后要立刻扔掉list的引用
        System.out.println(unmodifiableList);
    }

    static List<String> getList() {
        return Lists.newArrayList("apple", "pear", "banana");
    }
}
