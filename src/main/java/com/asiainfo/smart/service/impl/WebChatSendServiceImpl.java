package com.asiainfo.smart.service.impl;

import com.asiainfo.smart.entity.WebChatInfo;
import com.asiainfo.smart.entity.WebChatSend;
import com.asiainfo.smart.repository.WebChatSendRepository;
import com.asiainfo.smart.service.WebChatSendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author king-pan
 * @date 2018/12/14
 * @Description ${DESCRIPTION}
 */
@Service
public class WebChatSendServiceImpl implements WebChatSendService {

    @Autowired
    private WebChatSendRepository webChatSendRepository;


    @Override
    public List<WebChatSend> getSendList(String hour) {
        return webChatSendRepository.findAll();
    }
}
