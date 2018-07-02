package com.wangxin.consumer.jsp.web.controller.simple;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SystemController {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private DiscoveryClient client;

    @SuppressWarnings("deprecation")
    @GetMapping({ "msg", "info" })
    public String msg() {
        ServiceInstance instance = client.getLocalServiceInstance();
        String result = "来自于客户端<br/>server_id:" + instance.getServiceId() + "<br/>host:" + instance.getHost() + "<br/>port:" + instance.getPort();
        logger.info(result);
        return result;
    }

}