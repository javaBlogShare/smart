package com.asiainfo.smart.repository;

import com.asiainfo.smart.entity.QuartzJob;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

import java.util.Date;
import java.util.List;

/**
 * @author king-pan
 * @date 2018/11/26
 * @Description  ${DESCRIPTION}
 */
public interface QuartzJobRepository extends JpaRepository<QuartzJob,Long> {

    /**
     *
     * @param jobStatus
     * @return
     */
    List<QuartzJob> findByJobStatus(String jobStatus);

    List<QuartzJob> findByJobStatusIsNot(String jobStatus);
    /**
     * 修改上一次执行时间和下一次执行时间
     * @param previousTime
     * @param nextTime
     * @param jobId
     * @return
     */
    @Modifying
    @Query("update QuartzJob j set j.previousTime = ?1, j.nextTime = ?2 where j.jobId = ?3")
    int modifyByIdAndTime(Date previousTime, Date nextTime, Long jobId);

    /**
     * 修改job状态
     * @param jobStatus
     * @param jobId
     * @return
     */
    @Modifying
    @Query("update QuartzJob j set j.jobStatus = ?1 where j.jobId = ?2")
    int modifyByStatus(String jobStatus, Long jobId);

}
