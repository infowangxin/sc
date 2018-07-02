package com.wangxin.consumer.thymeleaf.web.controller.simple;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
public class SystemController {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private DiscoveryClient client;

    @Value("${sc.eureka.provider.from:local}") // FIXME 待解决，目前读不到git仓库配置文件当中的值
    private String from;

    @SuppressWarnings("deprecation")
    @GetMapping({ "info", "msg" })
    public String msg() {
        ServiceInstance instance = client.getLocalServiceInstance();
        String result = from + "<br/>来自于客户端<br/>server_id:" + instance.getServiceId() + "<br/>host:" + instance.getHost() + "<br/>port:" + instance.getPort();
        logger.info(result);
        return result;
    }

}