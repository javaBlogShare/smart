package com.asiainfo.smart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SmartApplication {

    public static void main(String[] args) {
        SpringApplication.run(SmartApplication.class, args);
        System.out.println("测试热加载2");
    }
}
