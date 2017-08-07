package com.kxw.java;

import org.apache.commons.lang3.time.DateFormatUtils;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Hello world!
 */
public class App {

    public static void main(String[] args) {
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                String time = DateFormatUtils.format(new Date(), "yyyy-MM-dd HH:mm:ss");
                System.out.println("当前时间" + time + "， hello world");
            }
        };

        Timer timer = new Timer();

        timer.schedule(task, 0, 5 * 1000L);

    }
}
