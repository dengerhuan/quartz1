package cn.huawei.quartz;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.quartz.*;

import java.util.Date;
import java.util.Map;

/**
 * Created by fan on 2017/10/27.
 */
public class MyJob implements Job {

    private Logger logger = LogManager.getLogger(MyJob.class);

    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {


        JobDataMap data = jobExecutionContext.getJobDetail().getJobDataMap();


        int count = data.getInt("name");
        count++;

        data.put("name", count);
        logger.info("say hello to " + count + " at " + new Date());

    }
}
