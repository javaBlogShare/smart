package com.asiainfo.smart.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author king-pan
 * @date 2018/12/14
 * @Description ${DESCRIPTION}
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class WebChatInfoRepositoryTest {

    @Autowired
    private WebChatInfoRepository webChatInfoRepository;

    @Test
    public void getTransList() {
        System.out.println(webChatInfoRepository.getTransList("2018121412"));
    }
}