package com.factory.methodfactory;

import sun.misc.BASE64Encoder;

import java.security.MessageDigest;
import java.util.*;

/**
 * @author Shuaihang Xue
 * @date 2019/11/23
 */
public class Main {

    public static void main(String[] args) {
//        ClouthesFactory clouthesFactory = new NikeFactory();
//        Clouthes clouthes = clouthesFactory.getClouthes();
//        clouthes.bePutOn();
//        printChars("2","3");

        //storyKey=DEPPON-17396， cdee测试提交3
        //storyKey=DEPPON-17395 , cdee功能测试3
        List<String> list = new ArrayList<>();
        System.out.println(list.toString());
        addStoryKey(list, "DEPPON-11111 BY LIMH");

        list.forEach(System.out::print);
//        System.out.println(1);
//        try {
//            testException();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        System.out.println(1);
//        Object o = true;
//        boolean testb = (boolean) o;
//        if (testb && testb) {
//            System.out.println(true);
//        }
//        System.out.println("out");

//        List<Map<String, Object>> resultMaps = new ArrayList<>();
//        Map<String, Object> resultMap1 = new HashMap<>();
//        Map<String, Object> resultMap2 = new HashMap<>();
//        Map<String, Object> resultMap3 = new HashMap<>();
//        // 如果desc，完成在第一个
//        resultMap1.put("status", "完成");
//        resultMap2.put("status", "上线成功");
//        resultMap3.put("status", "上线成功");
//        resultMaps.add(resultMap1);
//        resultMaps.add(resultMap2);
//        resultMaps.add(resultMap3);
//        orderByStatus(resultMaps, "ACS");
//        System.out.println(resultMaps.toString());

    }

    private static void printChars(String... chars) {
        for (int i = 0; i < chars.length; i++) {
            System.out.println(chars[i]);
        }
    }

    private static void addStoryKey(List<String> storyKeyList, String msg) {
        if (msg != null && msg.contains("storyKey=")) {
            String str = msg.substring(msg.indexOf("storyKey=") + 9);
            String storyKey = str.contains(",") ? str.substring(0, str.indexOf(",")) : str;
            storyKeyList.add(storyKey);
        }
    }

    private static Clouthes testException() {
        try {
            System.out.println(1 / 0);
        } catch (Exception e) {
            e.printStackTrace();
//            throw new NullPointerException("测试异常");
        }
        return new Nike();
    }

    private static void orderByStatus(List<Map<String, Object>> resultMapList, String sortOrder) {
        String sortOrderLower = sortOrder.toLowerCase();
        Collections.sort(resultMapList, new Comparator<Map<String, Object>>() {
            @Override
            public int compare(Map<String, Object> o1, Map<String, Object> o2) {
                String status1 = (String) o1.get("status");
                String status2 = (String) o2.get("status");
                if (sortOrderLower.equals("desc")){
                    int a = status2.compareTo(status1);
                    return a;
                }
                int b = status1.compareTo(status2);
                return b;
            }
        });
    }


}
