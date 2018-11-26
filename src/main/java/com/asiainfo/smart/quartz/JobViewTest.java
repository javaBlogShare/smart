package com.asiainfo.smart.quartz;

import com.asiainfo.smart.entity.QuartzJob;
import com.asiainfo.smart.service.TaskService;
import com.asiainfo.smart.utils.SpringUtil;
import org.quartz.SchedulerException;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.util.List;

/**
 * @author king-pan
 * @date 2018/11/26
 * @Description ${DESCRIPTION}
 */
public class JobViewTest {

    private TaskService taskService;

    public JobViewTest() {
        taskService = SpringUtil.getBean(TaskService.class);
    }

    public void run() {
        List<QuartzJob> jobs;
        try {
            System.out.print("All jobs: ");
            jobs = taskService.getAllJobs();
            for (QuartzJob job : jobs) {
                System.out.print(job.getJobGroup() + "_" + job.getJobName() + " " + job.getJobStatus() + "\t");
            }
            System.out.println();
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }
}
