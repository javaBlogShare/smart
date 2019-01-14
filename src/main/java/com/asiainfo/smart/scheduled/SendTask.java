package com.asiainfo.smart.scheduled;

import com.asiainfo.smart.entity.WebChatSend;
import com.asiainfo.smart.service.WebChatSendService;
import com.asiainfo.smart.utils.BossPasswordHelper;
import com.asiainfo.smart.utils.DateUtils;
import com.asiainfo.smart.utils.HttpClientUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author king-pan
 * @date 2018/12/12
 * @Description
 */
@Slf4j
@Component
public class SendTask {


    @Autowired
    private BossPasswordHelper passwordHelper;

    @Autowired
    private WebChatSendService webChatSendService;

    //@Scheduled(cron = "${task.hour.send-cron}")
    @Scheduled(fixedRate = 100 * 1000)
    public void sendHourMsg() {
        String hour = DateUtils.getNHour(-2);
        try {
            hour = "2018122409";
            log.info("开始发送微信绑定状态变更信息: 周期: {}", hour);
            List<WebChatSend> sendList = webChatSendService.getSendList(hour);
            sendList(sendList);
        } catch (Exception e) {

        }
        log.info("开始把小时表数据同步到发送表: 当前系统时间:{}", DateUtils.getCurrentTime());
    }


    //@Scheduled(cron = "${task.all.send-cron}")
    public void sendAllMsg() {
        try {
            log.info("开始发送微信绑定状态变更信息: 周期: 全量未发送");
            List<WebChatSend> sendList = webChatSendService.getAllTodoSendList();
            sendList(sendList);
        } catch (Exception e) {

        }
        log.info("开始把小时表数据同步到发送表: 当前系统时间:{}", DateUtils.getCurrentTime());
    }


    private boolean sendMsg(WebChatSend webChatSend) {
        boolean sendFlag = false;
        try {
            String chgSn = webChatSend.getChgSn();
            String time = DateUtils.getCurrentTime();
            String password = passwordHelper.getPwd(time, chgSn);
            String xml = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                    "<message>\n" +
                    "<head>\n" +
                    "<srvid>UserInfoChangeUNbind</srvid>\n" +
                    "<req_seq>" + chgSn + "</req_seq>\n" +
                    "<req_time>" + time + "</req_time>\n" +
                    "<channelinfo>\n" +
                    "<channelid>boss</channelid>\n" +
                    "<channelpwd>" + password + "</channelpwd>\n" +
                    "</channelinfo>\n" +
                    "</head>\n" +
                    "<Body>\n" +
                    "<tagset>\n" +
                    "<telnum>" + webChatSend.getPhoneNo() + "</telnum>\n" +
                    "<changetype>" + webChatSend.getRealState() + "</changetype>\n" +
                    "<changedate>" + webChatSend.getStateChgTime() + "</changedate>\n" +
                    "<changechannel></changechannel>\n" +
                    "</tagset>\n" +
                    "</Body>\n" +
                    "</message>";
            System.out.println("请求报文:\n"+xml);
            String result = HttpClientUtil.doPostXml("http://120.202.17.100:13589/hmaopnew/busiHandle.srv", xml);
            System.out.println(result);
            sendFlag = true;
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
        return sendFlag;

    }


    private void sendList(List<WebChatSend> sendList) {
        if (null != sendList && !sendList.isEmpty()) {
            for (WebChatSend send : sendList) {
                if (sendMsg(send)) {
                    //标记发送成功
                    send.setSendFlag("1");
                } else {
                    //标记发送失败
                    send.setSendFlag("2");
                }
                break;
            }
            //webChatSendService.saveList(sendList);
        }
    }
}
