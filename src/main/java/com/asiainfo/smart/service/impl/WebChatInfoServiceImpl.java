package com.asiainfo.smart.service.impl;

import com.asiainfo.smart.entity.WebChatInfo;
import com.asiainfo.smart.repository.WebChatInfoRepository;
import com.asiainfo.smart.service.WebChatInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author king-pan
 * @date 2018/12/26
 * @Description ${DESCRIPTION}
 */
@Slf4j
@Service
@Transactional(rollbackFor = RuntimeException.class)
public class WebChatInfoServiceImpl implements WebChatInfoService {


    @Autowired
    private WebChatInfoRepository webChatInfoRepository;


    @Override
    public List<WebChatInfo> getTransList(String hour) {
        return webChatInfoRepository.getTransList(hour);
    }

    @Override
    public List<WebChatInfo> getDayTransList(String day) {
        return null;
    }

    @Override
    public List<WebChatInfo> getAllTransList() {
        return webChatInfoRepository.getAllTransList();
    }

    @Override
    public boolean saveList(List<WebChatInfo> infoList) {
        boolean flag = false;
        try {
            webChatInfoRepository.saveAll(infoList);
            flag = true;
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
        return flag;
    }
}
