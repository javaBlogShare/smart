package com.asiainfo.smart.entity;

import javax.persistence.*;

/**
 * @author king-pan
 * @date 2018/11/28
 * @Description 微信绑定变更信息表
 */
@Entity
@Table(name = "ST_SMART_WEBCHAT_UNBUNDL_HM")
public class WebChatInfo {

    /**
     * 变更流水号
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String chgSn;
    /**
     * 用户标识
     */
    private String userId;
    /**
     * 电话号码
     */
    private String phoneNo;
    /**
     * 用户状态
     */
    private String userState;
    /**
     * 用户状态变更时间
     */
    private String stateChgTime;
    /**
     * 变更组织机构标识
     */
    private String CHG_ORG_ID;
    /**
     * 发送标记
     */
    private String sendFlag;

    /**
     * 发送标记
     */
    private String statMonth;
    /**
     * 统计日
     */
    private String statDate;

    /**
     * 统计小时
     */
    private String statHour;
}
