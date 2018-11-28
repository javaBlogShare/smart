package com.asiainfo.smart.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author king-pan
 * @date 2018/11/26
 * @Description ${DESCRIPTION}
 */
@RestController
public class QuartzJobController {


    @GetMapping(value = {"/task/", "/task"})
    public ModelAndView taskPage() {
        return new ModelAndView("task");
    }

    @GetMapping("/tasks")
    public Object list() {
        return null;
    }

}
