package com.asiainfo.smart.config;

import com.asiainfo.smart.entity.QuartzJob;
import com.asiainfo.smart.service.QuartzJobService;
import com.asiainfo.smart.service.TaskService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.scheduling.quartz.QuartzJobBean;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author king-pan
 * @date 2018/11/26
 * @Description ${DESCRIPTION}
 */
@Slf4j
@Component
public class QuartzRunner implements CommandLineRunner {

    @Autowired
    private TaskService taskService;

    @Autowired
    private QuartzJobService jobService;

    @Override
    public void run(String... args) throws Exception {
        // 可执行的任务列表
        List<QuartzJob> taskList = jobService.findByJobStatus(QuartzJob.STATUS_RUNNING);
        log.info("初始化加载定时任务......");
        for (QuartzJob job : taskList) {
            try {
                taskService.addJob(job);
            } catch (Exception e) {
                log.error("add job error: " + job.getJobName() + " " + job.getJobGroup(), e);
            }
        }
    }
}
