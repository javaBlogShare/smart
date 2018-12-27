package com.asiainfo.smart.service;

import com.asiainfo.smart.entity.WebChatInfo;

import java.util.List;

/**
 * @author king-pan
 * @date 2018/12/14
 * @Description  微信用户状态变更信息表服务类
 */
public interface WebChatInfoService {

    /**
     * 查询某个时间段状态变更信息
     * @param hour yyyyMMddHH
     * @return 集合
     */
    public List<WebChatInfo> getTransList(String hour);

    /**
     * 查询上一天段状态变更信息
     * @param day
     * @return
     */
    public List<WebChatInfo> getDayTransList(String day);


    /**
     * 获取全量未同步的
     * @return
     */
    public List<WebChatInfo> getAllTransList();


    /**
     * 批量保存
     * @param infoList
     * @return
     */
    public boolean saveList(List<WebChatInfo> infoList);



}
