package com.asiainfo.smart.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author king-pan
 * @date 2018/11/26
 * @Description ${DESCRIPTION}
 */
@RestController
public class HomeController {


    @RequestMapping("/")
    public String home(){
        return "Hello World";
    }

}
