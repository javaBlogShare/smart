package com.asiainfo.smart.service.impl;

import com.asiainfo.smart.entity.TaskResult;
import com.asiainfo.smart.repository.TaskResultRepository;
import com.asiainfo.smart.service.TaskResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author king-pan
 * @date 2018/11/26
 * @Description ${DESCRIPTION}
 */
@Service
public class TaskResultServiceImpl implements TaskResultService {

    @Autowired
    private TaskResultRepository taskResultRepository;

    @Override
    public TaskResult save(TaskResult result) {
        return taskResultRepository.save(result);
    }
}
