package com.asiainfo.smart.scheduled;

import com.asiainfo.smart.utils.DateUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @author king-pan
 * @date 2018/12/12
 * @Description
 */
@Slf4j
@Component
public class SendTask {

    @Scheduled(fixedRate = 20000)
    public void timeToNow() {
        log.info("当前系统时间:{}", DateUtils.getCurrentTime());
    }

    @Scheduled(cron = "${task.hour.send-cron}")
    public void sendMsg() {
        log.info("sendMsg: 当前系统时间:{}", DateUtils.getCurrentTime());
    }
}
