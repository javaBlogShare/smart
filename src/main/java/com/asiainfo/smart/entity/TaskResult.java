package com.asiainfo.smart.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * @author king-pan
 * @date 2018/11/26
 * @Description ${DESCRIPTION}
 */
@Data
@Entity
@Table(name = "task_result")
public class TaskResult {
    @Id
    @GeneratedValue
    private Long resultId;

    private Long jobId;

    private Boolean success;

    private String errorMsg;

    private String duration;

    private Date createTime;
}
