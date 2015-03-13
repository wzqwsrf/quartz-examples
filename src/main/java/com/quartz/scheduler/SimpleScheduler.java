package com.quartz.scheduler;

import com.quartz.job.SimpleJob;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.util.Date;

/**
 * @Author:wangzhenqing
 * @Date:
 * @Description:
 */
public class SimpleScheduler {
    public static void main(String[] args) {
        testSimpleScheduler();
    }

    public static void testSimpleScheduler(){
        try {
            Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
            JobDetail jobDetail = new JobDetail("Simple job", "SimpleGroup", SimpleJob.class);
            Trigger trigger = TriggerUtils.makeSecondlyTrigger();
            trigger.setName("test");
            trigger.setStartTime(new Date());
            scheduler.scheduleJob(jobDetail, trigger);
            scheduler.start();
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }


}
