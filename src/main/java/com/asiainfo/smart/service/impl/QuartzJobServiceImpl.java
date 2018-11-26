package com.asiainfo.smart.service.impl;

import com.asiainfo.smart.entity.QuartzJob;
import com.asiainfo.smart.repository.QuartzJobRepository;
import com.asiainfo.smart.service.QuartzJobService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * @author king-pan
 * @date 2018/11/26
 * @Description ${DESCRIPTION}
 */

@Slf4j
@Service
@Transactional(rollbackFor = RuntimeException.class)
public class QuartzJobServiceImpl implements QuartzJobService {

    @Autowired
    private SchedulerFactoryBean schedulerFactoryBean;

    @Autowired
    private QuartzJobRepository repository;

    @Override
    public List<QuartzJob> findAll() {
        return repository.findAll();
    }

    @Modifying
    @Override
    public QuartzJob save(QuartzJob jobBean) {
        return repository.save(jobBean);
    }

    @Override
    public QuartzJob getOne(long jobId) {
        return repository.getOne(jobId);
    }

    @Modifying
    @Override
    public int modifyByIdAndTime(Date previousTime, Date nextTime, Long jobId) {
        return repository.modifyByIdAndTime(previousTime, nextTime, jobId);
    }

    @Override
    public List<QuartzJob> findByJobStatus(String jobStatus) {
        return repository.findByJobStatus(jobStatus);
    }

    @Override
    public List<QuartzJob> findByJobStatusNot(String jobStatus) {
        return repository.findByJobStatusIsNot(jobStatus);
    }

    @Modifying
    @Override
    public int modifyByStatus(String jobStatus, Long jobId) {
        return repository.modifyByStatus(jobStatus, jobId);
    }
}
