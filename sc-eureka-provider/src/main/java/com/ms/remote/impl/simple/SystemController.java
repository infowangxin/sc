package com.ms.remote.impl.simple;

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
        String result = "来自于服务端<br/>server_id:" + instance.getServiceId() + "<br/>host:" + instance.getHost() + "<br/>port:" + instance.getPort();
        logger.info(result);
        return result;
    }

}