package com.date;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.time.temporal.TemporalField;

/**
 * @author Shuaihang Xue
 * @date 2020/8/13
 */
public class LocalDateTimeTest {

    public static void main(String[] args) {
//        useLocalDateAndLocalTime();
//        createLocalDateAndLocalTime();
//        parseLocalDateTime();
//        useDateTimeFormatter();
//        addOrMinusLocalDateTime();
//        useWithOnLocalDateTime();
//        compareLocalDateTime();
//        useDuration();
        usePeriod();
    }

    static void useLocalDateAndLocalTime() {
        LocalDate localDate = LocalDate.now();
        LocalTime localTime = LocalTime.now();
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDate);
        System.out.println(localTime);
        System.out.println(localDateTime);
        System.out.println(localDateTime.toLocalDate());
        System.out.println(localDateTime.toLocalTime());
    }

    static void createLocalDateAndLocalTime() {
        LocalDate localDate = LocalDate.of(2020, 8, 12);
        LocalTime localTime = LocalTime.of(11, 30 , 00);
        LocalDateTime localDateTime = LocalDateTime.of(localDate, localTime);
        System.out.println(localDate);
        System.out.println(localTime);
        System.out.println(localDateTime);
    }

    static void parseLocalDateTime() {
        LocalDate localDate = LocalDate.parse("2020-08-12");
        LocalTime localTime = LocalTime.parse("21:30:00");
        LocalDateTime localDateTime = LocalDateTime.parse("2020-08-12T21:30:00");
        System.out.println(localDate);
        System.out.println(localTime);
        System.out.println(localDateTime);
    }

    static void useDateTimeFormatter() {
        LocalDateTime localDateTime = LocalDateTime.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String dateTimeStr = dateTimeFormatter.format(localDateTime);
        System.out.println(dateTimeStr);
        System.out.println(LocalDateTime.from(dateTimeFormatter.parse("2020-08-15 09:31:49")));
        System.out.println(LocalDateTime.parse("2020-08-15 09:31:49", dateTimeFormatter));
    }

    static void addOrMinusLocalDateTime() {
        LocalDateTime localDateTime = LocalDateTime.of(2020, 6, 30, 11, 30, 15);
        System.out.println(localDateTime);
        System.out.println(localDateTime.plusDays(2).minusHours(1).minusMinutes(30));
        System.out.println(localDateTime.plusMonths(1));
    }

    static void useWithOnLocalDateTime() {
        LocalDateTime localDateTime = LocalDateTime.of(2020, 6, 30, 11, 30, 15);
        System.out.println(localDateTime.withMonth(8).withSecond(0));
        // 本月第一天的00:00
        System.out.println(LocalDate.now().withDayOfMonth(1).atStartOfDay());
        // 本月最后一天
        System.out.println(LocalDate.now().with(TemporalAdjusters.lastDayOfMonth()));
        // 下个月第一天
        System.out.println(LocalDate.now().plusMonths(1).withDayOfMonth(1));
        // or
        System.out.println(LocalDate.now().with(TemporalAdjusters.firstDayOfNextMonth()));
        // 本月第一个周一
        System.out.println(LocalDate.now().with(TemporalAdjusters.firstInMonth(DayOfWeek.MONDAY)));
    }

    static void compareLocalDateTime() {
        LocalDateTime localDateTime = LocalDateTime.now();
        LocalDateTime localDateTime1 = localDateTime.withYear(2019);
        LocalDateTime localDateTime2 = localDateTime.withYear(2021);
        System.out.println(localDateTime.isAfter(localDateTime1));
        System.out.println(localDateTime.isBefore(localDateTime2));
        System.out.println(localDateTime.isEqual(localDateTime));
    }

    static void useDuration() {
        LocalDateTime localDateTime = LocalDateTime.now();
        LocalDateTime localDateTime1 = localDateTime.withHour(17).withMinute(30).withSecond(0).withNano(0);
        Duration duration = Duration.between(localDateTime, localDateTime1);
        System.out.println(duration);
        System.out.println(duration.getSeconds());
    }

    static void usePeriod() {
        LocalDate localDate = LocalDate.now();
        LocalDate localDate1 = LocalDate.of(2020, 10, 1);
        Period period = Period.between(localDate, localDate1);
        Period period1 = localDate.until(localDate1);
        System.out.println(period);
        System.out.println(period1);
    }

}
