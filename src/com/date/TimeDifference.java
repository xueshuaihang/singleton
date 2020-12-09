package com.date;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Calendar;
import java.util.Date;

/**
 * @author Shuaihang Xue
 * @date 2020/8/7
 */
public class TimeDifference {

    public static void main(String[] args) throws InterruptedException {
        String offDutyTimeStr;
        if (args.length == 0) {
            offDutyTimeStr = "17:30";
        } else {
            offDutyTimeStr = args[0];
        }
        String[] offDutyTimeHourAndMinute = offDutyTimeStr.split(":");
        String offDutyTimeHour = offDutyTimeHourAndMinute[0];
        String offDutyTimeMinute = offDutyTimeHourAndMinute[1];
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, Integer.valueOf(offDutyTimeHour));
        calendar.set(Calendar.MINUTE, Integer.valueOf(offDutyTimeMinute));
        calendar.clear(Calendar.SECOND);
        calendar.clear(Calendar.MILLISECOND);
        if (new Date().getTime() > calendar.getTimeInMillis()) {
            calendar.set(Calendar.DAY_OF_MONTH, calendar.get(Calendar.DAY_OF_MONTH) + 1);
        }
        while (true) {
            Thread.sleep(1000);
            offDutyTime(calendar.getTime());
        }
    }

    static void offDutyTime(Date offDutyTime) {
        int millisecondToSecond = 1000;
        int millisecondToMinute = millisecondToSecond * 60;
        int millisecondToHour = millisecondToMinute * 60;
        int millisecondToDay = millisecondToHour * 24;
        Date now = new Date();
        long differenceLong = offDutyTime.getTime() - now.getTime();
        BigDecimal milliseconds = new BigDecimal(differenceLong);
        BigDecimal[] dayAndMilliseconds = milliseconds.divideAndRemainder(new BigDecimal(millisecondToDay));
        BigDecimal day = dayAndMilliseconds[0];
        BigDecimal dayMillisecond = dayAndMilliseconds[1];
        BigDecimal[] hourAndMilliseconds = dayMillisecond.divideAndRemainder(new BigDecimal(millisecondToHour));
        BigDecimal hour = hourAndMilliseconds[0];
        BigDecimal hourMillisecond = hourAndMilliseconds[1];
        BigDecimal[] minuteAndMilliseconds = hourMillisecond.divideAndRemainder(new BigDecimal(millisecondToMinute));
        BigDecimal minute = minuteAndMilliseconds[0];
        BigDecimal minuteMillisecond = minuteAndMilliseconds[1];
        BigDecimal second = minuteMillisecond.divide(new BigDecimal(millisecondToSecond), 0, RoundingMode.HALF_UP);
//        System.out.println(day + "天" + hour + "小时" + minute + "分钟" + second + "秒");
        System.out.println(hour + "小时" + minute + "分钟" + second + "秒");


//        BigDecimal[] hourAndMilliSeconds = milliseconds.divideAndRemainder(new BigDecimal(1000 * 60 * 60));
//        BigDecimal minutes1 = hourAndMilliSeconds[1].divide(new BigDecimal(1000 * 60), RoundingMode.HALF_UP);
//        System.out.println(hourAndMilliSeconds[0] + "小时" + minutes1 + "分钟");
//        BigDecimal minutes = milliseconds.divide(new BigDecimal(1000 * 60), RoundingMode.HALF_UP);
//        System.out.println(minutes);
    }

}
