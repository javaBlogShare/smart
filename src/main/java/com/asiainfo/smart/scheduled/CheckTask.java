package com.asiainfo.smart.scheduled;

import com.asiainfo.smart.utils.DateUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @author king-pan
 * @date 2018/12/12
 * @Description ${DESCRIPTION}
 */
@Slf4j
@Component
public class CheckTask {

    @Scheduled(cron = "${task.hour.check-cron}")
    public void checkTask(){
        log.info("checkTask： 检查前前8个小时到前3个小时未发送的消息");
    }

    @Scheduled(cron = "${task.day.check-cron}")
    public void checkDayTask(){
        log.info("checkTask： 检查前前8个小时到前3个小时未发送的消息");
    }


    @Scheduled(fixedRate = 20000)
    public void timeToNow1() {
        log.info("timeToNow1:   当前系统时间:{}", DateUtils.getCurrentTime());
    }

    @Scheduled(fixedRate = 20000)
    public void timeToNow2() {
        log.info("timeToNow2: 当前系统时间:{}", DateUtils.getCurrtDay());
    }



}
