package com.asiainfo.smart.scheduled;

import com.asiainfo.smart.entity.WebChatInfo;
import com.asiainfo.smart.entity.WebChatSend;
import com.asiainfo.smart.service.WebChatInfoService;
import com.asiainfo.smart.service.WebChatSendService;
import com.asiainfo.smart.utils.DateUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @author king-pan
 * @date 2018/12/26
 * @Description 把数据从st_smart_webchat_unbundl_hm表同步到st_smart_webchat_unbundl_send表
 */
@Slf4j
@Component
public class SyncTask {


    @Autowired
    private WebChatInfoService webChatInfoService;

    @Autowired
    private WebChatSendService webChatSendService;


    /**
     * 20分钟同步上一小时的数据
     */
    //@Scheduled(fixedRate = 20 * 60 * 1000)
    public void timeToNow() {
        String hour = DateUtils.getBeforeHour();
        log.info("开始同步数据:  周期:{}", hour);
        try {
            List<WebChatInfo> infoList = webChatInfoService.getTransList("2018122409");
            syncList(infoList, hour);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }

    }

    /**
     * 2个小时同步上一天的数据
     */
    //@Scheduled(cron = "${task.hour.sync-cron}")
    //@Scheduled(fixedRate = 20 * 60 * 1000)
    public void daySync() {
        String day = DateUtils.getBeforeNDay(-1);
        log.info("开始把小时表数据同步到发送表:  周期:{}", day);
        try {
            List<WebChatInfo> infoList = webChatInfoService.getDayTransList("20181224");
            syncList(infoList, day);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
    }

    /**
     * 每天2点同步剩余所以未同步的
     */
    @Scheduled(cron = "${task.all.sync-cron}")
    public void allSync() {
        log.info("开始把小时表数据同步到发送表:  周期: 全量未同步");
        try {
            List<WebChatInfo> infoList = webChatInfoService.getAllTransList();
            syncList(infoList, "全量未同步");
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
    }

    private void syncList(List<WebChatInfo> infoList, String time) {
        if (infoList!=null && !infoList.isEmpty()) {
            List<WebChatSend> sendList = new ArrayList<>();
            for (WebChatInfo info : infoList) {
                info.setSendFlag("1");
                sendList.add(new WebChatSend(info.getChgSn(), info.getUserId(), info.getPhoneNo(), info.getUserState(), info.getStatMonth(), info.getStatDate(), info.getStatHour(), info.getStateChgTime(), info.getCHG_ORG_ID()));
            }
            webChatSendService.saveList(sendList);
            webChatInfoService.saveList(infoList);
        } else {
            log.warn("开始把小时表数据同步到发送表： 周期:{}没有需要同步的微信解绑信息.", time);
        }
    }
}
