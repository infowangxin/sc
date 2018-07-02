package com.wangxin.hystrix.web.controller;

import com.wangxin.common.api.model.simple.News;
import com.wangxin.feign.web.remote.simple.NewsRemoteClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HystrixSimpleController {

    private static final Logger log = LoggerFactory.getLogger(HystrixSimpleController.class);

    @Autowired
    private NewsRemoteClient newsRemoteClient;

    @Autowired
    private DiscoveryClient client;

    @RequestMapping(value = "/wx", method = RequestMethod.GET)
    public News getNews() {
        log.debug("# wx");
        return newsRemoteClient.getNews();
    }

    @SuppressWarnings("deprecation")
    @RequestMapping(value = { "/msg" }, method = RequestMethod.GET)
    public String msg() {
        ServiceInstance instance = client.getLocalServiceInstance();
        String result = "<html><body><div>server_id:" + instance.getServiceId() + "<br/>host:" + instance.getHost() + "<br/>port:" + instance.getPort() + "<br/></div></body></html>";
        log.info(result);
        return result;
    }
}
