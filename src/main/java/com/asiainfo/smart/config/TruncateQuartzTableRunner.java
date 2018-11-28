package com.asiainfo.smart.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 * @author king-pan
 * @date 2018/11/28
 * @Description ${DESCRIPTION}
 */
@Slf4j
@Order(value = 1)
@Component
public class TruncateQuartzTableRunner implements CommandLineRunner {

    @Autowired
    private EntityManager entityManager;

    @Override
    public void run(String... args) throws Exception {
        log.info("清除quartz 分布式表数据开始====================");
        Query query = entityManager.createNativeQuery("delete from  qrtz_cron_triggers");
        query.executeUpdate();
        query = entityManager.createNativeQuery("delete from  qrtz_triggers");
        query.executeUpdate();
        query = entityManager.createNativeQuery("delete from  qrtz_locks");
        query.executeUpdate();
        query = entityManager.createNativeQuery("delete from  qrtz_job_details");
        query.executeUpdate();
        log.info("清除quartz 分布式表数据结束====================");
    }
}
