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

        new TT().tt();
    }


}
