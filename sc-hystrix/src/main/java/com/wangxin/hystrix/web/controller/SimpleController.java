package com.wangxin.hystrix.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SimpleController {

    @RequestMapping("/")
    public String hystrixDashboardIndex() {
        return "forward:/hystrix";
    }
}
