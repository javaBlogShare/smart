package com.asiainfo.smart.repository;

import com.asiainfo.smart.entity.WebChatInfo;
import com.asiainfo.smart.entity.WebChatSend;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author king-pan
 * @date 2018/12/14
 * @Description ${DESCRIPTION}
 */
public interface WebChatSendRepository extends JpaRepository<WebChatSend, String> {

    /**
     * 查询所有未发送和发送失败的消息
     *
     * @param sendFlag
     * @return
     */
    List<WebChatSend> getAllBySendFlagNotIn(String sendFlag);
}
