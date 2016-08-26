package com.quartz.api;

import org.quartz.CronExpression;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Author: zhenqing.wang <wangzhenqing1008@163.com>
 * Date: 2016-08-26 11:54:11
 * Description: 测试CronExpression表达式
 */
public class CronDemo {

    public static void main(String[] args) throws Exception {
        //格式化日期的表达式，方便看观监测时间
        String dateExp = "HH:mm:ss";
        SimpleDateFormat sdf = new SimpleDateFormat(dateExp);
        //cron表达式，表示2011年内每分钟的0、20、40秒触发一次
        String exp = "0/20 * * * * ?";
        CronExpression cronExp = new CronExpression(exp);

        System.out.println("调度开始...");
        while (true){
            Date triggerDate = cronExp.getNextValidTimeAfter(new Date());
            while (triggerDate != null && new Date().equals(triggerDate)) {
                System.out.println("调度运行中...");
                System.out.println(sdf.format(triggerDate));
                triggerDate = cronExp.getNextValidTimeAfter(new Date());
            }
        }
    }
}
