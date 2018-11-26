package com.asiainfo.smart.quartz;

import com.asiainfo.smart.entity.QuartzJob;
import com.asiainfo.smart.entity.TaskResult;
import com.asiainfo.smart.service.QuartzJobService;
import com.asiainfo.smart.service.TaskResultService;
import com.asiainfo.smart.utils.SpringUtil;
import com.asiainfo.smart.utils.TaskUtils;
import lombok.extern.slf4j.Slf4j;
import org.quartz.*;

/**
 * @author king-pan
 * @date 2018/11/26
 * @Description Job有状态实现类，不允许并发执行
 *  若一个方法一次执行不完下次轮转时则等待该方法执行完后才执行下一次操作
 *  主要是通过注解：@DisallowConcurrentExecution
 */
@Slf4j
@DisallowConcurrentExecution
public class QuartzJobFactoryDisallowConcurrentExecution implements Job {


    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        JobDetail job = context.getJobDetail();
        JobKey key = job.getKey();
        String jobIdentity = "scheduleJob" + key.getGroup() + "_" + key.getName();
        QuartzJob scheduleJob = (QuartzJob) context.getMergedJobDataMap().get(jobIdentity);
        Trigger trigger = context.getTrigger();
        log.info("运行任务名称 = [" + scheduleJob + "]");
        try {
            TaskResult result = TaskUtils.invokeMethod(scheduleJob);
            scheduleJob.setPreviousTime(trigger.getPreviousFireTime());
            QuartzJobService jobService = SpringUtil.getBean(QuartzJobService.class);
            scheduleJob.setNextTime(trigger.getNextFireTime());
            jobService.modifyByIdAndTime(scheduleJob.getPreviousTime(), scheduleJob.getNextTime(), scheduleJob.getJobId());
            // 写入运行结果
            TaskResultService dtsService = SpringUtil.getBean(TaskResultService.class);
            dtsService.save(result);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
    }

}
