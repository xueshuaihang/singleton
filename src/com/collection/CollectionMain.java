package com.collection;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Shuaihang Xue
 * @date 2020/7/24
 */
public class CollectionMain {

    public static void main(String[] args) {
        practiceFindMissNumber();
    }

    static void practiceFindMissNumber() {
        // 构造从start到end的序列：
        final int start = 10;
        final int end = 20;
        List<Integer> list = new ArrayList<>();
        for (int i = start; i <= end; i++) {
            list.add(i);
        }
        // 洗牌算法shuffle可以随机交换List中的元素位置:
//        Collections.shuffle(list);
        // 随机删除List中的一个元素:
        int removed = list.remove((int) (Math.random() * list.size()));
//        int found = findMissingNumber(start, end, list);
        int found = findMissingNumberBySumAndSubtract(start, end, list);
        System.out.println(list.toString());
        System.out.println("missing number: " + found);
        System.out.println(removed == found ? "测试成功" : "测试失败");
    }

    static int findMissingNumber(int start, int end, List<Integer> list) {
        List<Integer> allNumbers = new ArrayList<>();
        for (int i = start; i <= end ; i++) {
            allNumbers.add(i);
        }
        int found = -1;
        for (int i = 0; i < allNumbers.size(); i++) {
            if (allNumbers.get(i) == list.get(i)) {
                continue;
            } else {
                found = allNumbers.get(i);
                break;
            }
        }
        return found;
    }

    /**
     * 使用全量数字总和 - list(丢失一位数字)中数字总和
     * <p>
     * 求出缺少的数字
     * @param start
     * @param end
     * @param list
     * @return
     */
    static int findMissingNumberBySumAndSubtract(int start, int end, List<Integer> list) {
        int sum = list.stream().reduce(Integer::sum).orElse(0);
        // 高斯求和 (首数+尾数)*项数/2
        // 项数 = 尾数-首数+1
        return (start + end) * (end - start + 1) / 2 - sum;
    }

}
