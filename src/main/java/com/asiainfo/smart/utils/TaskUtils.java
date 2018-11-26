package com.asiainfo.smart.utils;

import com.asiainfo.smart.entity.QuartzJob;
import com.asiainfo.smart.entity.TaskResult;
import lombok.extern.slf4j.Slf4j;
import org.quartz.impl.triggers.CronTriggerImpl;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.lang.reflect.Method;
import java.text.ParseException;
import java.util.Date;

/**
 * @author king-pan
 * @date 2018/11/26
 * @Description ${DESCRIPTION}
 */
@Slf4j
public class TaskUtils {
    /**
     * 通过反射调用scheduleJob中定义的方法
     *
     * @param scheduleJob
     */
    public static TaskResult invokeMethod(QuartzJob scheduleJob) {
        Object object = null;
        Class<?> clazz = null;
        TaskResult result = new TaskResult();
        ;
        long start = System.currentTimeMillis();

        try {
            // springId不为空先按springId查找bean
            String springId = scheduleJob.getSpringId();
            String beanClass = scheduleJob.getJobClass();
            if (springId != null && !"".equals(springId.trim())) {
                object = SpringUtil.getBean(springId);
            } else if (beanClass != null && !"".equals(beanClass.trim())) {
                try {
                    clazz = Class.forName(scheduleJob.getJobClass());
                    object = clazz.newInstance();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            if (object == null) {
                throw new Exception("任务名称 = [" + scheduleJob.getJobName() + "]---------------未启动成功，请检查是否配置正确！！！");
            }

            clazz = object.getClass();
            Method method = clazz.getDeclaredMethod(scheduleJob.getMethodName());
            if (method != null) {
                method.invoke(object);

                result.setSuccess(true);
            }
        } catch (Exception e) {
            String errorMsg = e.getMessage();
            log.error(errorMsg, e);
            result.setSuccess(true);
            result.setErrorMsg(errorMsg);
        }
        long end = System.currentTimeMillis();
        result.setDuration(String.valueOf((end - start)));
        result.setCreateTime(new Date());
        result.setJobId(scheduleJob.getJobId());
        return result;
    }


    /**
     * 判断cron时间表达式正确性
     *
     * @param cronExpression
     * @return
     */
    public static boolean isValidExpression(final String cronExpression) {
        CronTriggerImpl trigger = new CronTriggerImpl();
        try {
            trigger.setCronExpression(cronExpression);
            Date date = trigger.computeFirstFireTime(null);
            return date != null && date.after(new Date());
        } catch (ParseException e) {
            log.error(e.getMessage(), e);
        }
        return false;
    }

    /*
     * 任务运行状态
     */
    public enum TASK_STATE {
        NONE("NONE", "未知"),
        NORMAL("NORMAL", "正常运行"),
        PAUSED("PAUSED", "暂停状态"),
        COMPLETE("COMPLETE", ""),
        ERROR("ERROR", "错误状态"),
        BLOCKED("BLOCKED", "锁定状态");

        private String index;
        private String name;

        private TASK_STATE(String index, String name) {
            this.name = name;
            this.index = index;
        }

        public String getIndex() {
            return index;
        }

        public String getName() {
            return name;
        }
    }
}
