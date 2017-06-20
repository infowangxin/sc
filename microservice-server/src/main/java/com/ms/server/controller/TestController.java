package com.ms.server.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
class TestController {

    @Value("${from:local-dev-springcloud-service-A}")
    private String from;

    @RequestMapping("/from")
    public String from() {

        return this.from;
    }

    public void setFrom(String from) { 
        this.from = from;
    }

    public String getFrom() {
        return from;
    }

}