package com.kxw.api;


import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.quartz.impl.triggers.CronTriggerImpl;

import java.text.ParseException;

import static org.quartz.JobBuilder.newJob;
import static org.quartz.SimpleScheduleBuilder.simpleSchedule;
import static org.quartz.TriggerBuilder.newTrigger;

/**
 * Created by kangxiongwei on 2017/7/28 15:06.
 */
public class QuartzTest {

    public static void main(String[] args) throws SchedulerException, ParseException {
        SchedulerFactory factory = new StdSchedulerFactory();
        Scheduler scheduler = factory.getScheduler();
        scheduler.start();

        JobDetail detail = newJob(HelloJob.class).withIdentity("myJob", "group1").build();
        Trigger trigger = newTrigger().withIdentity("myTrigger", "group1")
                .startNow()
                .withSchedule(simpleSchedule().withIntervalInSeconds(5).repeatForever())
                .build();


        CronTriggerImpl a = new CronTriggerImpl();
        a.setName("test");
        a.setCronExpression("*/5 * * * * ?");


        scheduler.scheduleJob(detail, a);

        scheduler.start();
    }




}
