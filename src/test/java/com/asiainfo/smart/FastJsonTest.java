package com.asiainfo.smart;

import com.alibaba.fastjson.JSON;
import lombok.Data;

/**
 * @author king-pan
 * @date 2018/12/13
 * @Description ${DESCRIPTION}
 */
public class FastJsonTest {

    public static void main(String[] args) {
        Blog blog = new Blog();
        blog.setId(1);
        blog.setName("博客");
        blog.setUrl("hm.baidu.com/hm.gif?si=95e19731e65d0e7ffd790a84e414d878&et=0&nv=0&st=4&lt=1405989501&su=http%3A%2F%2Fwap.lehecai.com%2Flottery%2Fsfc%2F%3F_ai%3D5681&v=wap-0-0.2&rnd=8457088157");
        System.out.println(JSON.toJSONString(blog));
    }

    @Data
    private static class Blog{
        private int id;
        private String name;
        private String url;
        private String content;
    }
}
