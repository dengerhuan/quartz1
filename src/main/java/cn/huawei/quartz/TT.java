package cn.huawei.quartz;

import org.junit.Test;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

public class TT {
    @Test
    public void tt() throws SchedulerException, InterruptedException {
        Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
       /* Trigger trigger = TriggerBuilder.newTrigger().withIdentity("trigger", "group1")
                .startNow().withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(1)
                        .withRepeatCount(100)).build();*/


        JobDetail job = JobBuilder.newJob(MyJob.class).withIdentity("job1", "group1")
                .usingJobData("name", "1").build();


        Trigger trigger = TriggerBuilder.newTrigger().withIdentity("trigger", "group1")
                .startNow().withSchedule(CronScheduleBuilder.cronSchedule("0/5 * * * * ?")).build();


        scheduler.scheduleJob(job, trigger);
        scheduler.start();

    }
}
