package com.asiainfo.smart;

import com.asiainfo.smart.utils.BossPasswordHelper;
import com.asiainfo.smart.utils.DateUtils;
import com.asiainfo.smart.utils.HttpClientUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

//@RunWith(SpringRunner.class)
//@SpringBootTest
public class SmartApplicationTests {


    //@Autowired
    private BossPasswordHelper passwordHelper;
    @Test
    public void contextLoads() {
        passwordHelper = new BossPasswordHelper();
        String time = DateUtils.getCurrentTime();
        String id = "013cdefe1";
        String password = passwordHelper.getPwd(time,id);

        String xml = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<message>\n" +
                "<head>\n" +
                "<srvid>UserInfoChangeUNbind</srvid>\n" +
                "<req_seq>"+id+"</req_seq>\n" +
                "<req_time>"+time+"</req_time>\n" +
                "<channelinfo>\n" +
                "<channelid>boss</channelid>\n" +
                "<channelpwd>"+password+"</channelpwd>\n" +
                "</channelinfo>\n" +
                "</head>\n" +
                "<Body>\n" +
                "<tagset>\n" +
                "<telnum>18827434711</telnum>\n" +
                "<changetype>1</changetype>\n" +
                "<changedate>20181205155242</changedate>\n" +
                "<changechannel></changechannel>\n" +
                "</tagset>\n" +
                "</Body>\n" +
                "</message>";
        System.out.println(time);
        String result =  HttpClientUtil.doPostXml("http://120.202.17.100:13589/hmaopnew/busiHandle.srv",xml);
        System.out.println(result);
    }

}
