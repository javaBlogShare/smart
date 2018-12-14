package com.asiainfo.smart.quartz.job;

import lombok.extern.slf4j.Slf4j;

import java.util.Date;

/**
 * @author king-pan
 * @date 2018/11/27
 * @Description 把用户变更消息发送到其他业务系统中
 */
@Slf4j
public class WeiXinHourSendJob {

    public void run() {
        log.info("============小时同步微信绑定业务,时间: {} end   ====================", new Date());
        log.info("执行同步操作------------------------------>");
        log.info("执行同步操作------------------------------>");
        log.info("执行同步操作------------------------------>");
        log.info("执行同步操作------------------------------>");
        log.info("执行同步操作------------------------------>");
        log.info("============小时同步微信绑定业务,时间: {} begin ====================", new Date());
    }
}
