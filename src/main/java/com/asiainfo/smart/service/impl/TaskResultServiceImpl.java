package com.asiainfo.smart.service.impl;

import com.asiainfo.smart.entity.TaskResult;
import com.asiainfo.smart.repository.TaskResultRepository;
import com.asiainfo.smart.service.TaskResultService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author king-pan
 * @date 2018/11/26
 * @Description ${DESCRIPTION}
 */
public class TaskResultServiceImpl implements TaskResultService {

    @Autowired
    private TaskResultRepository taskResultRepository;

    @Override
    public TaskResult save(TaskResult result) {
        return taskResultRepository.save(result);
    }
}
