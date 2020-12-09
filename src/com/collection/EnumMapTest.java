package com.collection;

import com.enums.Weekday;

import java.util.EnumMap;
import java.util.Map;

/**
 * @author Shuaihang Xue
 * @date 2020/7/24
 */
public class EnumMapTest {

    public static void main(String[] args) {
        useEnumMap();
    }

    static void useEnumMap() {
        Map<Weekday, String> map = new EnumMap<>(Weekday.class);
        map.put(Weekday.MON, "星期一");
        map.put(Weekday.TUE, "星期二");
        System.out.println(map);
        System.out.println(map.get(Weekday.MON));
    }
}
