package com.date;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

/**
 * @author Shuaihang Xue
 * @date 2020/8/18
 */
public class InstantTest {

    public static void main(String[] args) {
//        getCurrentTimeWithInstant();
//        transferToZonedDateTime();
//        dateToLocalDateTime();
//        calendarToLocalDateTime();
//        zonedDateTimeToDate();
//        zonedDateTimeToCalendar();
        test();

    }

    static void getCurrentTimeWithInstant() {
        Instant instant = Instant.now();
        // 秒
        System.out.println(instant.getEpochSecond());
        // 毫秒
        System.out.println(instant.toEpochMilli());
        System.out.println(instant.toString());
    }

    static void transferToZonedDateTime() {
        Instant instant = Instant.ofEpochMilli(1597736727000l);
        ZonedDateTime zonedDateTime = instant.atZone(ZoneId.of("Asia/Shanghai"));
        System.out.println(zonedDateTime);
    }

//    ------------------------新旧API的转换------------------------

    static void dateToLocalDateTime() {
        Date date = new Date();
        Instant instant = dateToInstant(date);
        ZonedDateTime zonedDateTime = instant.atZone(ZoneId.systemDefault());
        LocalDateTime localDateTime = zonedDateTime.toLocalDateTime();
        System.out.println(localDateTime);
    }

    static Instant dateToInstant(Date date) {
        return date.toInstant();
    }

    static void calendarToLocalDateTime() {
        Calendar calendar = Calendar.getInstance();
        Instant instant = calendar.toInstant();
        ZonedDateTime zonedDateTime = instant.atZone(calendar.getTimeZone().toZoneId());
        LocalDateTime localDateTime = zonedDateTime.toLocalDateTime();
        System.out.println(localDateTime);
    }

    static void zonedDateTimeToDate() {
        ZonedDateTime zonedDateTime = ZonedDateTime.now();
        long time = zonedDateTime.toEpochSecond() * 1000;
        Date date = new Date(time);
        System.out.println(date);
    }

    static void zonedDateTimeToCalendar() {
        ZonedDateTime zonedDateTime = ZonedDateTime.now();
        long time = zonedDateTime.toEpochSecond() * 1000;
        Calendar calendar = Calendar.getInstance();
        calendar.clear();
        calendar.setTimeZone(TimeZone.getTimeZone(zonedDateTime.getZone().getId()));
        calendar.setTimeInMillis(time);
        System.out.println(calendar.getTime());
    }

    static void test() {
        LocalDateTime localDateTime = LocalDateTime.now();
        LocalDateTime todayLocalDateTime = localDateTime.withHour(0).withMinute(0).withSecond(0).withNano(0);
        ZonedDateTime zonedDateTime = ZonedDateTime.of(todayLocalDateTime, ZoneId.systemDefault());
        System.out.println(zonedDateTime.toInstant().toEpochMilli());
        System.out.println(zonedDateTime.toEpochSecond() * 1000);
        System.out.println(Date.from(zonedDateTime.toInstant()));
        System.out.println(new Date(zonedDateTime.toEpochSecond() * 1000));
    }

}
