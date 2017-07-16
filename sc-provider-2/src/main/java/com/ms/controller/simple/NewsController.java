package com.ms.controller.simple;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageInfo;
import com.ms.api.model.simple.News;
import com.ms.api.service.simple.NewsService;
import com.ms.controller.BaseController;

@RestController
@RequestMapping("/simple")
public class NewsController extends BaseController {

    private static final Logger log = LoggerFactory.getLogger(NewsController.class);

    @Autowired
    private NewsService newsService;

    @PostMapping("/addNews")
    Boolean addNews(@RequestBody News news) {
        log.debug("# parameter ={}", JSON.toJSONString(news));
        boolean result = false;
        if (news != null && StringUtils.isNotBlank(news.getAddress()))
            result = newsService.addNews(news);
        log.debug("{}", result);
        return result;
    }

    @GetMapping("/findNewsById/{id}")
    News findNewsById(@PathVariable String id) {
        log.debug("# parameter ={}", id);
        News news = newsService.findNewsById(id);
        String result = JSON.toJSONString(news);
        log.debug("{}", result);
        return news;
    }

    @PostMapping("/editNews")
    Boolean editNews(@RequestBody News news) {
        log.debug("# parameter ={}", JSON.toJSONString(news));
        boolean result = newsService.editNews(news);
        log.debug("{}", result);
        return result;
    }

    @GetMapping("/findNewsByPage")
    PageInfo<News> findNewsByPage(@RequestParam(value = "keywords", required = false) String keywords, @RequestParam(value = "pageNum", required = false) Integer pageNum) {
        log.debug("# parameter , {} , {}", keywords, pageNum);
        PageInfo<News> page = newsService.findNewsByPage(pageNum, keywords);
        log.debug("{}", JSON.toJSONString(page));
        return page;
    }
}
