package com.asiainfo.smart.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.scheduling.quartz.QuartzJobBean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * @author king-pan
 * @date 2018/11/26
 * @Description  quartz定时任务信息实体Bean
 */
@Data
@Entity
@Table(name = "quartz_quart_job")
@JsonIgnoreProperties(value = {"hibernateLazyInitializer", "handler", "fieldHandler"})
public class QuartzJob implements Serializable {
    private static final long serialVersionUID = 1L;
    public static final String STATUS_RUNNING = "1";
    public static final String STATUS_NOT_RUNNING = "0";
    public static final String STATUS_DELETED = "2";
    public static final String CONCURRENT_IS = "1";
    public static final String CONCURRENT_NOT = "0";
    /**
     * 任务id
     */
    @Id
    @GeneratedValue
    private Long jobId;

    /**
     * 任务名称
     */
    private String jobName;

    /**
     * 任务分组，任务名称+组名称应该是唯一的
     */
    private String jobGroup;

    /**
     * 任务初始状态 0禁用 1启用 2删除
     */
    private String jobStatus;

    /**
     * 任务是否有状态（并发与否）
     */
    private String isConcurrent = "1";

    /**
     * 任务运行时间表达式
     */
    private String cronExpression;

    /**
     * 任务描述
     */
    private String description;

    /**
     * 任务调用类在spring中注册的bean id，如果spingId不为空，则按springId查找
     */
    private String springId;

    /**
     * 任务调用类名，包名+类名，通过类反射调用 ，如果spingId为空，则按jobClass查找
     */
    private String jobClass;

    /**
     * 任务调用的方法名
     */
    private String methodName;

    /**
     * 启动时间
     */
    private Date startTime;

    /**
     * 前一次运行时间
     */
    private Date previousTime;

    /**
     * 下次运行时间
     */
    private Date nextTime;

}
