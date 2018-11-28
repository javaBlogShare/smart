package com.asiainfo.smart.quartz;

import com.asiainfo.smart.entity.QuartzJob;
import com.asiainfo.smart.entity.TaskResult;
import com.asiainfo.smart.service.QuartzJobService;
import com.asiainfo.smart.service.TaskResultService;
import com.asiainfo.smart.utils.SpringUtil;
import com.asiainfo.smart.utils.TaskUtils;
import lombok.extern.slf4j.Slf4j;
import org.quartz.*;
import org.springframework.scheduling.quartz.QuartzJobBean;

/**
 * @author king-pan
 * @date 2018/11/26
 * @Description ${DESCRIPTION}
 */
@Slf4j
public class QuartzJobFactory implements Job {
    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        JobDetail job = context.getJobDetail();
        JobKey key = job.getKey();
        String jobIdentity = "scheduleJob" + key.getGroup() + "_" + key.getName();
        Trigger trigger = context.getTrigger();
        QuartzJob scheduleJob = null;
        Object objJob = context.getMergedJobDataMap().get(jobIdentity);
        if(objJob instanceof QuartzJob){
            scheduleJob = (QuartzJob) context.getMergedJobDataMap().get(jobIdentity);
        }else {
            System.out.println(objJob);
            return;
        }
        log.info("运行任务名称 = [" + scheduleJob + "]");

        try {
            TaskResult result = TaskUtils.invokeMethod(scheduleJob);

            scheduleJob.setNextTime(trigger.getNextFireTime());
            scheduleJob.setPreviousTime(trigger.getPreviousFireTime());

            QuartzJobService jobService = SpringUtil.getBean(QuartzJobService.class);
            jobService.modifyByIdAndTime(scheduleJob.getPreviousTime(), scheduleJob.getNextTime(), scheduleJob.getJobId());

            // 写入运行结果
            TaskResultService dtsService = SpringUtil.getBean(TaskResultService.class);
            dtsService.save(result);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }

    }
}
