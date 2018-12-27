package com.asiainfo.smart.service.impl;

import com.asiainfo.smart.entity.WebChatSend;
import com.asiainfo.smart.repository.WebChatSendRepository;
import com.asiainfo.smart.service.WebChatSendService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author king-pan
 * @date 2018/12/14
 * @Description ${DESCRIPTION}
 */
@Slf4j
@Service
@Transactional(rollbackFor = RuntimeException.class)
public class WebChatSendServiceImpl implements WebChatSendService {

    @Autowired
    private WebChatSendRepository webChatSendRepository;


    @Override
    public List<WebChatSend> getSendList(String hour) {
        return webChatSendRepository.findAll();
    }

    @Override
    public boolean saveList(List<WebChatSend> sends) {
        boolean flag = false;
        try {
            webChatSendRepository.saveAll(sends);
            flag = true;
        } catch (Exception e) {
            flag = false;
            log.error(e.getMessage(), e);
        }
        return flag;
    }

    @Override
    public List<WebChatSend> getAllTodoSendList() {
        return webChatSendRepository.getAllBySendFlagNotIn("0");
    }
}
