package com.wangxin.remote.impl.simple;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SystemController {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private DiscoveryClient client;

    @Value("${provider.from:local}")
    private String from;

    @GetMapping(value = { "/", "/index" })
    public String index() {
        String result = "from:" + from;
        logger.info(result);
        return result;
    }

    @GetMapping("/info")
    public String info() {
        ServiceInstance instance = client.getLocalServiceInstance();
        String result = "来自于服务端<br/>server_id:" + instance.getServiceId() + "<br/>host:" + instance.getHost() + "<br/>port:" + instance.getPort() + "<br/>" + from;
        logger.info(result);
        return result;
    }

}