package com.quartz.scheduler;

import com.quartz.job.SimpleJob;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.text.ParseException;
import java.util.Date;

/**
 * @Author:wangzhenqing
 * @Date:
 * @Description:
 */
public class CronScheduler {
    public static void main(String[] args) {
        testCronScheduler();
    }

    public static void testCronScheduler(){
        try {
            Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
            JobDetail jobDetail = new JobDetail("Cron job", "Cron group", SimpleJob.class);
            CronTrigger cronTrigger = null;
            try {
                cronTrigger = new CronTrigger("cron trigger","cronGroup","0/1 * * * * ?");
            } catch (ParseException e) {
                e.printStackTrace();
            }
            cronTrigger.setStartTime(new Date());
            scheduler.scheduleJob(jobDetail, cronTrigger);
            scheduler.start();
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }
}
