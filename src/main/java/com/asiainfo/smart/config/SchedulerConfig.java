package com.asiainfo.smart.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

/**
 * @author king-pan
 * @date 2018/11/26
 * @Description ${DESCRIPTION}
 */
@Configuration
public class SchedulerConfig {


    @Autowired
    private DataSource dataSource;
    @Autowired
    private PlatformTransactionManager transactionManager;

    @Bean(name = "schedulerFactoryBean")
    public SchedulerFactoryBean schedulerFactoryBean() {
        SchedulerFactoryBean schedulerFactoryBean = new SchedulerFactoryBean();
        schedulerFactoryBean.setDataSource(dataSource);
        schedulerFactoryBean.setTransactionManager(transactionManager);
        return schedulerFactoryBean;
    }
}
