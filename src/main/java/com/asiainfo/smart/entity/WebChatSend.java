package com.asiainfo.smart.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * @author king-pan
 * @date 2018/11/28
 * @Description  同步微信绑定状态信息表
 */
@Data
@Entity
@ToString
@NoArgsConstructor
@Table(name = "ST_SMART_WEBCHAT_UNBUNDL_SEND")
public class WebChatSend {
    /**
     * 变更流水号
     */
    @Id
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

    public WebChatSend(String chgSn,String userId,String phoneNo,String userState,String statMonth,String statDate,String statHour,String stateChgTime,String CHG_ORG_ID){
        this.chgSn = chgSn;
        this.userId = userId;
        this.phoneNo = phoneNo;
        this.sendFlag = "0";
        this.userState = userState;
        this.statMonth = statMonth;
        this.statDate = statDate;
        this.statHour = statHour;
        this.stateChgTime = stateChgTime;
        this.CHG_ORG_ID = CHG_ORG_ID;
    }
}
