package com.asiainfo.smart.entity;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

/**
 * @author king-pan
 * @date 2018/11/26
 * @Description ${DESCRIPTION}
 */
@Data
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
