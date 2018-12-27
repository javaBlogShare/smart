package com.asiainfo.smart.service;

import com.asiainfo.smart.entity.WebChatInfo;
import com.asiainfo.smart.entity.WebChatSend;

import java.util.List;

/**
 * @author king-pan
 * @date 2018/12/14
 * @Description  发送微信用户状态信息表服务类
 */
public interface WebChatSendService {
    /**
     * 查询某个时间段已发送状态变更信息
     * @param hour yyyyMMddHH
     * @return 集合
     */
    public List<WebChatSend> getSendList(String hour);

    public boolean saveList(List<WebChatSend> sends);

    /**
     * 获取所有待发送的
     * @return
     */
    public List<WebChatSend> getAllTodoSendList();
}
