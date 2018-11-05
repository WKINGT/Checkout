import org.quartz.*;
import org.quartz.impl.JobDetailImpl;
import org.quartz.impl.StdSchedulerFactory;
import org.quartz.impl.triggers.CronTriggerImpl;

import java.util.List;

public class CFCronTriggerRunner {
	public void task(List<Long> users, String cronExpression) throws SchedulerException {
        // Initiate a Schedule Factory
        SchedulerFactory schedulerFactory = new StdSchedulerFactory();
        // Retrieve a scheduler from schedule factory
        Scheduler scheduler = schedulerFactory.getScheduler();
        
        // Initiate JobDetail with job name, job group, and executable job class
        JobDetailImpl jobDetailImpl = new JobDetailImpl();
        jobDetailImpl.setKey(new JobKey("CFJob1"));
        jobDetailImpl.getJobDataMap().put("users", users);
        // Initiate CronTrigger with its name and group name
        CronTriggerImpl cronTriggerImpl = new CronTriggerImpl();
        cronTriggerImpl.setName("CFCronTrigger1");
        try {
            // setup CronExpression
            CronExpression cexp = new CronExpression(cronExpression);
            // Assign the CronExpression to CronTrigger
            cronTriggerImpl.setCronExpression(cexp);
        } catch (Exception e) {
            e.printStackTrace();
        }
        // schedule a job with JobDetail and Trigger
        scheduler.scheduleJob(jobDetailImpl, cronTriggerImpl);
        
        // start the scheduler
        scheduler.start();
    }
}

