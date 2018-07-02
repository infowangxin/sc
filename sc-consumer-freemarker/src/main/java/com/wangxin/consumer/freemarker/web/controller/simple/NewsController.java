package com.wangxin.consumer.freemarker.web.controller.simple;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.wangxin.feign.web.remote.simple.NewsRemoteClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageInfo;
import com.wangxin.common.api.common.exception.BusinessException;
import com.wangxin.common.api.model.simple.News;

/**
 * @author 王鑫
 * @Description 新闻示例
 * @date Mar 16, 2017 3:58:01 PM
 */
@Controller
public class NewsController {

    private static final Logger log = LoggerFactory.getLogger(NewsController.class);

    @Autowired
    private NewsRemoteClient newsRemoteClient;

    /*
     * 表单提交日期绑定
     */
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }

    @RequestMapping(value = "/wx", method = RequestMethod.GET)
    public News getNews() {
        log.debug("# wx");
        return newsRemoteClient.getNews();
    }


    /**
     * @return
     * @Description 进入新增页面
     * @author 王鑫
     */
    @RequestMapping(value = "/news/add", method = RequestMethod.GET)
    public String add() {
        log.info("# 进入发布新闻页面");
        return "view/news/add";
    }

    /**
     * @param news
     * @return
     * @Description ajax保存发布新闻
     * @author 王鑫
     */
    @RequestMapping(value = "/news/add", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, String> add(@ModelAttribute("newsForm") News news) {
        boolean flag = newsRemoteClient.addNews(news);
        Map<String, String> result = new HashMap<>();
        if (flag) {
            result.put("status", "1");
            result.put("msg", "发布成功");
        } else {
            result.put("status", "0");
            result.put("msg", "发布失败");
        }
        return result;
    }

    /**
     * @return
     * @Description ajax加载新闻对象
     * @author 王鑫
     */
    @RequestMapping(value = "/news/load/{id}", method = RequestMethod.GET)
    public String load(@PathVariable String id, ModelMap map) {
        log.info("# ajax加载新闻对象");
        News news = newsRemoteClient.findNewsById(id);
        if (null == news)
            throw new BusinessException("非法参数");
        map.addAttribute("news", news);
        return "view/news/edit_form";
    }

    /**
     * @param news
     * @return
     * @Description ajax保存更新重新发布新闻
     * @author 王鑫
     */
    @RequestMapping(value = "/news/edit", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, String> edit(@ModelAttribute("newsForm") News news) {
        boolean flag = newsRemoteClient.editNews(news);
        Map<String, String> result = new HashMap<>();
        if (flag) {
            result.put("status", "1");
            result.put("msg", "发布成功");
        } else {
            result.put("status", "0");
            result.put("msg", "发布失败");
        }
        return result;
    }

    @RequestMapping(value = "/news/list", method = RequestMethod.GET)
    public String list(ModelMap map) {
        PageInfo<News> page = newsRemoteClient.findNewsByPage(null, null);
        log.debug("{}", JSON.toJSONString(page));
        map.put("page", page);
        return "view/news/list";
    }

    @RequestMapping(value = "/news/list_page", method = RequestMethod.POST)
    public String list_page(@RequestParam(value = "keywords", required = false) String keywords, @RequestParam(value = "pageNum", required = false) Integer pageNum, ModelMap map) {
        log.info("#分页查询新闻 pageNum={} , keywords={}", pageNum, keywords);
        PageInfo<News> page = newsRemoteClient.findNewsByPage(keywords, pageNum);
        map.put("page", page);
        map.put("keywords", keywords);
        return "view/news/list_page";
    }

}
