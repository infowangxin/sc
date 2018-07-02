package com.wangxin.feign.web.hystrix.simple;

import com.github.pagehelper.PageInfo;
import com.wangxin.common.api.common.exception.BusinessException;
import com.wangxin.common.api.common.exception.RemoteRequestExcepton;
import com.wangxin.common.api.model.simple.News;
import com.wangxin.feign.web.remote.simple.NewsRemoteClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class NewsRemoteClientHystrix implements NewsRemoteClient {

    private static final Logger log = LoggerFactory.getLogger(NewsRemoteClient.class);

    @Override
    public Boolean addNews(News news) throws BusinessException {
        log.error("# addNews Hystrix");
        // TODO business something
        //return null;
        throw new RemoteRequestExcepton("发布新闻信息失败");
    }

    @Override
    public News findNewsById(String id) throws BusinessException {
        log.error("# findNewsById Hystrix");
        // TODO business something
        //return null;
        throw new RemoteRequestExcepton("查看新闻信息失败");
    }

    @Override
    public Boolean editNews(News news) throws BusinessException {
        log.error("# editNews Hystrix");
        // TODO business something
        //return null;
        throw new RemoteRequestExcepton("编辑新闻信息失败");
    }

    @Override
    public PageInfo<News> findNewsByPage(String keywords, Integer pageNum) throws BusinessException {
        log.error("# findNewsByPage Hystrix");
        // TODO business something
        //return null;
        throw new RemoteRequestExcepton("获取新闻信息列表失败");
    }

    @Override
    public News getNews() throws RemoteRequestExcepton {
        log.error("# getNews Hystrix");
        // TODO business something
        //return null;
        throw new RemoteRequestExcepton("获取新闻头条信息失败");
    }
}
