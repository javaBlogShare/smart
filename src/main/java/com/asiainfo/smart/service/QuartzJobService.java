package com.asiainfo.smart.service;

import com.asiainfo.smart.entity.QuartzJob;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.util.Date;
import java.util.List;

/**
 * @author king-pan
 * @date 2018/11/26
 * @Description ${DESCRIPTION}
 */
public interface QuartzJobService {

    public List<QuartzJob> findAll();

    public QuartzJob save(QuartzJob jobBean);

    public QuartzJob getOne(long jobId);


    public int modifyByIdAndTime(Date previousTime, Date nextTime, Long jobId);


    public List<QuartzJob> findByJobStatus(String jobStatus);

    public List<QuartzJob> findByJobStatusNot(String jobStatus);

    public int modifyByStatus(String jobStatus, Long jobId);


}
