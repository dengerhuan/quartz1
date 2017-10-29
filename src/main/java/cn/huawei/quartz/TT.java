package cn.huawei.quartz;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TT {


    @Test
    public void ST() throws SchedulerException, InterruptedException {
        new TT().tt();
    }

    static Logger logger = LogManager.getLogger(TT.class);

    @Test
    public void tt() throws SchedulerException, InterruptedException {
        Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();


        Trigger trigger = TriggerBuilder.newTrigger().withIdentity("trigger", "group1")
                .startNow().withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(1)
                        .withRepeatCount(100)).build();


        Trigger trigger1 = TriggerBuilder.newTrigger().withIdentity("trigger", "group1")
                .withSchedule(CronScheduleBuilder.cronSchedule("0/5 * * * * ?")).build();


        JobDetail job = JobBuilder.newJob(MyJob.class).withIdentity("job1", "group1")
                .build();

        job.getJobDataMap().put(MyJob.JOB_COUNT, 1);

        Date dd = scheduler.scheduleJob(job, trigger1);

        scheduler.start();

    }
}
