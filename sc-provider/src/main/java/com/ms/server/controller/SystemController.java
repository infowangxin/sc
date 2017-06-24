package com.ms.server.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SystemController {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private DiscoveryClient client;

    @RequestMapping(value = "/info", method = RequestMethod.GET)
    public String info() {
        ServiceInstance instance = client.getLocalServiceInstance();
        logger.info("server info, host:{} , port:{} , server_id:{}", instance.getHost(), instance.getPort(), instance.getServiceId());
        return "server info：, host=" + instance.getHost() + ", port:" + instance.getPort() + ", service_id:" + instance.getServiceId();
    }

}