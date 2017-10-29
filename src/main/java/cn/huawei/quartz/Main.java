package cn.huawei.quartz;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by fan on 2017/10/27.
 */
public class Main {

    static Logger logger = LogManager.getLogger(Main.class);


    public static void main(String[] args) throws SchedulerException, InterruptedException {

        Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
        Trigger trigger = TriggerBuilder.newTrigger().withIdentity("trigger", "group1")
                .startNow().withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(1)
                        .withRepeatCount(100)).build();


        Trigger trigger1 = TriggerBuilder.newTrigger().withIdentity("trigger", "group1")
                .startNow().withSchedule(CronScheduleBuilder.cronSchedule("0/5 * * * * ?")).build();


        JobDetail job = JobBuilder.newJob(MyJob.class).withIdentity("job1", "group1")
                .usingJobData("name", "1").build();

        Date dd = scheduler.scheduleJob(job, trigger1);


        DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(format.format(dd));
        scheduler.start();

     /*   Thread.sleep(10000);
        scheduler.shutdown(true);*/


        logger.info("现在是喜剧了");
    }


}
