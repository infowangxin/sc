package com.wangxin.provider.web.remote.impl.simple;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageInfo;
import com.wangxin.common.api.model.simple.News;
import com.wangxin.provider.service.simple.NewsService;
import com.wangxin.feign.web.remote.simple.NewsRemoteClient;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(tags = "示例模块接口类、包含新闻模块")
@RestController
@RequestMapping("/simple")
public class NewsRemoteClientImpl implements NewsRemoteClient {

    private static final Logger log = LoggerFactory.getLogger(NewsRemoteClientImpl.class);

    @Autowired
    private NewsService newsService;

    @Override
    @ApiOperation(value = "添加新闻信息", notes = "添加一条新闻信息")
    @ApiImplicitParam(name = "news", value = "新闻实体类对象", required = true, dataType = "News", paramType = "body")
    public Boolean addNews(@RequestBody News news) {
        log.debug("# parameter ={}", JSON.toJSONString(news));
        boolean result = false;
        if (news != null && StringUtils.isNotBlank(news.getAddress()))
            result = newsService.addNews(news);
        log.debug("{}", result);
        return result;
    }

    @Override
    @ApiOperation(value = "查询新闻详细信息", notes = "根据新闻对象ID查询它详细信息")
    @ApiImplicitParam(name = "id", value = "新闻对象ID", required = true, dataType = "String", paramType = "path")
    public News findNewsById(@PathVariable("id") String id) {
        log.debug("# parameter ={}", id);
        News news = newsService.findNewsById(id);
        String result = JSON.toJSONString(news);
        log.debug("{}", result);
        return news;
    }

    @Override
    @ApiOperation(value = "修改新闻信息", notes = "根据新闻ID修改新闻信息")
    @ApiImplicitParam(name = "news", value = "新闻实体类对象", required = true, dataType = "News", paramType = "body")
    public Boolean editNews(@RequestBody News news) {
        log.debug("# parameter ={}", JSON.toJSONString(news));
        boolean result = newsService.editNews(news);
        log.debug("{}", result);
        return result;
    }

    @Override
    @ApiOperation(value = "分页查询新闻信息", notes = "分页查询新闻信息")
    @ApiImplicitParams({ @ApiImplicitParam(name = "keywords", value = "查询关键字", required = false, dataType = "String", paramType = "query"), @ApiImplicitParam(name = "pageNum", value = "分页查询的页码", required = false, dataType = "Integer", defaultValue = "1", paramType = "query") })
    public PageInfo<News> findNewsByPage(@RequestParam(value = "keywords", required = false) String keywords, @RequestParam(value = "pageNum", required = false) Integer pageNum) {
        log.debug("# parameter , {} , {}", keywords, pageNum);
        PageInfo<News> page = newsService.findNewsByPage(pageNum, keywords);
        log.debug("{}", JSON.toJSONString(page));
        return page;
    }

    @Override
    @ApiOperation(value = "查询新闻", notes = "查询新闻")
    public News getNews() {
        try {
            log.debug("# sleep 6000 millis");
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        News n = newsService.findNewsByTitle("test");
        log.debug("# News={}", JSON.toJSONString(n, true));
        return n;
    }
}
