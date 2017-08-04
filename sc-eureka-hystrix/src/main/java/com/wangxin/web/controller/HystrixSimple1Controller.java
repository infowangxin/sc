package com.wangxin.web.controller;

import com.wangxin.api.model.simple.News;
import com.wangxin.hystrix.simple.WxService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HystrixSimple1Controller {

    private static final Logger log = LoggerFactory.getLogger(HystrixSimple1Controller.class);

    @Autowired
    private WxService wxService;


    @GetMapping("/wx")
    public News wx() {
        log.debug("# wx");
        return wxService.getNews();
    }


}
