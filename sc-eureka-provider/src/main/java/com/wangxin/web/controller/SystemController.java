package com.wangxin.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import springfox.documentation.annotations.ApiIgnore;

@ApiIgnore
@Controller
public class SystemController {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private DiscoveryClient client;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String swaggerui() {
        return "redirect:/swagger-ui.html";
    }

    @RequestMapping(value = "/msg", method = RequestMethod.GET)
    public String msg() {
        ServiceInstance instance = client.getLocalServiceInstance();
        String result = "<br/>来自于服务端<br/>server_id:" + instance.getServiceId() + "<br/>host:" + instance.getHost() + "<br/>port:" + instance.getPort() + "<br/>";
        logger.info(result);
        return result;
    }

}