package com.ms.feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageInfo;
import com.ms.api.model.simple.News;

@FeignClient(path = "simple", value = "providerServer")
public interface NewsRemoteService {

    @RequestMapping(value = "/addNews", method = RequestMethod.POST)
    Boolean addNews(@RequestBody News news);

    @RequestMapping(value = "/findNewsById/{id}", method = RequestMethod.GET)
    News findNewsById(@PathVariable("id") String id);

    @RequestMapping(value = "/editNews", method = RequestMethod.POST)
    Boolean editNews(@RequestBody News news);

    @RequestMapping(value = "/findNewsByPage", method = RequestMethod.GET)
    PageInfo<News> findNewsByPage(@RequestParam(value = "keywords", required = false) String keywords, @RequestParam(value = "pageNum", required = false) Integer pageNum);

}
