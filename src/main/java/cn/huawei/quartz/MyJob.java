package cn.huawei.quartz;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.quartz.*;

import java.util.Date;

/**
 * Created by fan on 2017/10/27.
 */

/**
 * 启动使用jobDataMao 传递参数
 * <p>
 * 保证多个任务间不会同时执行
 */

@DisallowConcurrentExecution
@PersistJobDataAfterExecution
public class MyJob implements Job {


    public static final String JOB_COUNT = "count";

    private Logger logger = LogManager.getLogger(MyJob.class);

    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {


        JobDataMap data = jobExecutionContext.getJobDetail().getJobDataMap();


        int count = data.getInt(JOB_COUNT);

        logger.info("say hello to " + count + " at " + new Date());

        count++;
        logger.info("current count is" + count);
        data.put(JOB_COUNT, count);
    }
}
