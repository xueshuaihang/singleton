package com.date;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;

/**
 * @author Shuaihang Xue
 * @date 2020/8/18
 */
public class DateTimeFormatterTest {

    public static void main(String[] args) {
//        useFormat();
//        useParse();
//        useFormatterWithLocale();
//        staticFormatter();
        System.out.println(timestampToString(1597736727000l, Locale.CHINA, ZoneId.of("Asia/Shanghai")));
        System.out.println(timestampToString(1597736727000l, Locale.US, ZoneId.of("America/New_York")));
    }

    static void useFormat() {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(dateTimeFormatter.format(localDateTime));
        System.out.println(localDateTime.format(dateTimeFormatter));
    }

    static void useParse() {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime localDateTime = LocalDateTime.from(dateTimeFormatter.parse("2020-08-18 09:23:23"));
        LocalDateTime localDateTime1 = LocalDateTime.parse("2020-08-18 09:23:23", dateTimeFormatter);
        System.out.println(localDateTime);
        System.out.println(localDateTime1);
    }

    static void useFormatterWithLocale() {
        LocalDateTime localDateTime = LocalDateTime.now();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
        System.out.println(formatter.format(localDateTime));

        DateTimeFormatter zhFormatter = DateTimeFormatter.ofPattern("E, MMM dd, yyyy HH:mm:ss", Locale.CHINA);
        System.out.println(zhFormatter.format(localDateTime));

        DateTimeFormatter usTimeFormatter = DateTimeFormatter.ofPattern("E, MMMM dd, yyyy HH:mm:ss", Locale.US);
        System.out.println(usTimeFormatter.format(localDateTime));
    }

    static void staticFormatter() {
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(DateTimeFormatter.ISO_DATE.format(localDateTime));
        System.out.println(DateTimeFormatter.ISO_DATE_TIME.format(localDateTime));
    }

    static String timestampToString(long timestamp, Locale locale, ZoneId zoneId) {
        ZonedDateTime zonedDateTime = ZonedDateTime.ofInstant(Instant.ofEpochMilli(timestamp), zoneId);
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM, FormatStyle.SHORT);
        return dateTimeFormatter.withLocale(locale).format(zonedDateTime);
    }

}
