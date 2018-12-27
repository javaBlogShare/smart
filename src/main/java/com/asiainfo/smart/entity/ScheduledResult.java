package com.asiainfo.smart.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * @author king-pan
 * @date 2018/12/27
 * @Description 定时任务结果表
 */
@Data
@Entity
@Table(name = "quartz_schedule_result")
public class ScheduledResult {
    @Id
    @GeneratedValue
    private Long resultId;

    /**
     * 类型: 同步任务，同步全量任务，发送任务，发送全量任务
     */
    private String type;

    /**
     * 是否成功
     */
    private Boolean success;

    /**
     * 错误消息
     */
    private String errorMsg;

    /**
     * 周期
     */
    private String hour;

    /**
     * 数据个数
     */
    private int num;

    /**
     * 持续时间
     */
    private String duration;

    /**
     * 创建时间
     */
    private Date createTime;
}
