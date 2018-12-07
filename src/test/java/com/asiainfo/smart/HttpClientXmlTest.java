package com.asiainfo.smart;

import com.asiainfo.smart.utils.HttpClientUtil;
import org.junit.Test;

/**
 * @author king-pan
 * @date 2018/12/7
 * @Description ${DESCRIPTION}
 */
public class HttpClientXmlTest {



    @Test
    public void test(){
        String xml = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<message>\n" +
                "<head>\n" +
                "<srvid>UserInfoChangeUNbind</srvid>\n" +
                "<req_seq>0b1a3162</req_seq>\n" +
                "<req_time>20181205155242</req_time>\n" +
                "<channelinfo>\n" +
                "<channelid>boss</channelid>\n" +
                "<channelpwd>2ff0c192e726cf4c49e94bdbb20f4e15</channelpwd>\n" +
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
       String result =  HttpClientUtil.doPostXml("http://120.202.17.100:13589/hmaopnew/busiHandle.srv",xml);
        System.out.println(result);
    }
}
