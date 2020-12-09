package com.date;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author Shuaihang Xue
 * @date 2020/4/11
 */
public class DateMain {

    public static void main(String[] args) throws InterruptedException {
//        for (String arg : args) {
//            System.out.println(arg);
//        }
//        Calendar calendar = Calendar.getInstance();
//        calendar.set(Calendar.HOUR_OF_DAY, 0);
//        calendar.set(Calendar.MINUTE, 0);
//        calendar.set(Calendar.SECOND, 0);
//        calendar.set(Calendar.MILLISECOND, 0);
//        Date today = calendar.getTime();
//        calendar.add(Calendar.DATE, -1);
//        Date yesterday = calendar.getTime();
//        System.out.println(today);
//        System.out.println(yesterday);

//        compareDate();
//        test();

    }

    public static void compareDate() {
        Date date = new Date();
        Date date1 = null;
        System.out.println(date.compareTo(date1));
    }

    public static void test() {
        Date now = new Date();
        Date nowDate = removeDateHHmmSS(now);
        System.out.println(now);
        System.out.println(nowDate);
    }

    public static Date removeDateHHmmSS(Date date) {
        if (date == null)
            return null;
        Calendar cal1 = Calendar.getInstance();
        cal1.setTime(date);
        // 将时,分,秒,毫秒域清零
        cal1.set(Calendar.HOUR_OF_DAY, 0);
        cal1.set(Calendar.MINUTE, 0);
        cal1.set(Calendar.SECOND, 0);
        cal1.set(Calendar.MILLISECOND, 0);
        return cal1.getTime();
    }

}
