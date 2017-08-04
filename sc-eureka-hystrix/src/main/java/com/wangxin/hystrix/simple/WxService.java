package com.wangxin.hystrix.simple;

import com.alibaba.fastjson.JSON;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.wangxin.api.model.simple.News;
import com.wangxin.web.simple.NewsRemoteClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WxService {


    private static final Logger log = LoggerFactory.getLogger(WxService.class);

    @Autowired
    private NewsRemoteClient newsRemoteClient;

    /**
     * 当请求远程服务失败后会调用fallback方法
     * @return
     */
    @HystrixCommand(fallbackMethod = "fallback")
    public News getNews() {
        log.debug("# getNews()");
        News news = newsRemoteClient.getNews();
        log.debug("# News={}", JSON.toJSONString(news));
        return news;
    }

    public News fallback() {
        log.debug("# fallback");
        //TODO do something
        return null;
    }

}
