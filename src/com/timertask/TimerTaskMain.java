package com.timertask;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class TimerTaskMain {

    public static void main(String[] args) {
//        timerTaskByWhile();
//        timerTask();
        timerTaskByThreadPool();

    }

    public static void timerTaskByWhile() {
        int timeInterval = 2000;
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    System.out.println("timerTask");
                    try {
                        Thread.sleep(timeInterval);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }

    public static void timerTask() {
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                System.out.println("timerTask");
            }
        };
        Timer timer = new Timer();
        /**
         * 延时任务，delay秒后执行
         */
        timer.schedule(timerTask, 3000);

        /**
         * 延时任务，指定时间执行
         */
        Date date;
        String dateTime = "2019-08-20 20:19:30";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        date = simpleDateFormat.parse(dateTime, new ParsePosition(0));
        timer.schedule(timerTask, date);

        /**
         * 定时任务，延迟delay毫秒后，以period毫秒的间隔执行
         */
        timer.scheduleAtFixedRate(timerTask, 3000, 1000);

        /**
         * 定时任务，在firstTime这个时间开始执行，以period毫秒的间隔执行
         */
        timer.scheduleAtFixedRate(timerTask, date, 1000);
    }

    public static void timerTaskByThreadPool(){
        ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("timerTask");
            }
        };
        /**
         * 延时任务，在delay秒（TimeUnit为单位）后执行任务
         */
        scheduledExecutorService.schedule(runnable, 3, TimeUnit.SECONDS);
        /**
         * 定时任务，在initialDelay秒（TimeUnit为单位）后执行任务，之后以period为周期执行
         */
        scheduledExecutorService.scheduleAtFixedRate(runnable, 5, 1, TimeUnit.SECONDS);
    }
}
