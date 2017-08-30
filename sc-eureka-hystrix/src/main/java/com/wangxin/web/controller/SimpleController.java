package com.wangxin.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SimpleController {

    private static final Logger log = LoggerFactory.getLogger(SimpleController.class);


    @Autowired
    private DiscoveryClient client;


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String hystrixDashboardIndex(){
        return "forward:/hystrix";
    }

    @RequestMapping(value = {"/msg", "info"}, method = RequestMethod.GET)
    @ResponseBody
    public String msg() {
        ServiceInstance instance = client.getLocalServiceInstance();
        String result = "server_id:" + instance.getServiceId() + "<br/>host:" + instance.getHost() + "<br/>port:" + instance.getPort() + "<br/>";
        log.info(result);
        return result;
    }
}
