package com.date;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

/**
 * 教程来自<a href="https://www.liaoxuefeng.com/wiki/1252599548343744/1303904694304801#0">廖雪峰的Java教程-ZonedDateTime</a>
 * @author Shuaihang Xue
 * @date 2020/8/17
 */
public class ZonedDateTimeTest {

    public static void main(String[] args) {
//        createZonedDateTime();
//        createZonedDateTimeWhitLocalDateTime();
//        conversionTimeZone();
//        becomeLocalDateTime();
        practice();
    }

    static void createZonedDateTime() {
        ZonedDateTime zonedDateTime = ZonedDateTime.now();
        ZonedDateTime zonedDateTime1 = ZonedDateTime.now(ZoneId.of("America/New_York"));
        System.out.println(zonedDateTime);
        System.out.println(zonedDateTime1);
    }

    static void createZonedDateTimeWhitLocalDateTime() {
        // 这种方式创建的LocalDateTime代表此刻的指定时区时间
        LocalDateTime localDateTime = LocalDateTime.now(ZoneId.of("America/New_York"));
        // 这种方式创建的ZonedDateTime和LocalDateTime的时间一致，只是改变了时区，不会改变时间。
        ZonedDateTime zonedDateTime = localDateTime.atZone(ZoneId.systemDefault());
        ZonedDateTime zonedDateTime1 = localDateTime.atZone(ZoneId.of("Asia/Shanghai"));
        System.out.println(localDateTime);
        System.out.println(zonedDateTime);
        System.out.println(zonedDateTime1);
    }

    static void conversionTimeZone() {
        ZonedDateTime zonedDateTime = ZonedDateTime.now(ZoneId.of("Asia/Shanghai"));
        ZonedDateTime zonedDateTime1 = zonedDateTime.withZoneSameInstant(ZoneId.of("America/New_York"));
        System.out.println(zonedDateTime);
        System.out.println(zonedDateTime1);
    }

    static void becomeLocalDateTime() {
        ZonedDateTime zonedDateTime = ZonedDateTime.now(ZoneId.of("America/New_York"));
        LocalDateTime localDateTime = zonedDateTime.toLocalDateTime();
        System.out.println(localDateTime);
    }

    /**
     * 练习题来自<a href="https://www.liaoxuefeng.com/wiki/1252599548343744/1303904694304801#0">廖雪峰的Java教程-ZonedDateTime</a>
     */
    static void practice() {
        LocalDateTime departureAtBeijing = LocalDateTime.of(2019, 9, 15, 13, 0, 0);
        int hours = 13;
        int minutes = 20;
        LocalDateTime arrivalAtNewYork = calculateArrivalAtNY(departureAtBeijing, hours, minutes);
        System.out.println(departureAtBeijing + " -> " + arrivalAtNewYork);
        // test:
        if (!LocalDateTime.of(2019, 10, 15, 14, 20, 0)
                .equals(calculateArrivalAtNY(LocalDateTime.of(2019, 10, 15, 13, 0, 0), 13, 20))) {
            System.err.println("测试失败!");
        } else if (!LocalDateTime.of(2019, 11, 15, 13, 20, 0)
                .equals(calculateArrivalAtNY(LocalDateTime.of(2019, 11, 15, 13, 0, 0), 13, 20))) {
            System.err.println("测试失败!");
        }
    }

    static LocalDateTime calculateArrivalAtNY(LocalDateTime bj, int h, int m) {
//        LocalDateTime arrivalAtBeijing = bj.plusHours(h).plusMinutes(m);
//        ZonedDateTime arrivalAtBeijingZonedDateTime = arrivalAtBeijing.atZone(ZoneId.of("Asia/Shanghai"));
//        ZonedDateTime arrivalAtNewYorkZonedDateTime = arrivalAtBeijingZonedDateTime.withZoneSameInstant(ZoneId.of("America/New_York"));
//        LocalDateTime arrivalAtNewYork = arrivalAtNewYorkZonedDateTime.toLocalDateTime();
//        return arrivalAtNewYork;
        return bj.plusHours(h)
                .plusMinutes(m)
                .atZone(ZoneId.of("Asia/Shanghai"))
                .withZoneSameInstant(ZoneId.of("America/New_York"))
                .toLocalDateTime();
    }

}
