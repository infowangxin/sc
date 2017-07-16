package com.ms.web.controller.simple;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageInfo;
import com.ms.api.model.simple.News;

/**
 * @Description 新闻示例
 * @author 王鑫
 * @date Mar 16, 2017 3:58:01 PM
 */
@Controller
public class NewsController {

    private static final Logger log = LoggerFactory.getLogger(NewsController.class);

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    /**
     * @Description 获取服务端地址，采用的是轮循模式
     * @author 王鑫
     * @return 服务端地址
     */
    public String getServerAddress() {
        ServiceInstance instance = this.loadBalancerClient.choose("service");
        String serverAddress = "http://" + instance.getHost() + ":" + Integer.toString(instance.getPort()) + "/";
        log.debug("# server adderss={}", serverAddress);
        return serverAddress;
    }

    private boolean addNews(News news) {
        log.debug("# parameter ={}", JSON.toJSONString(news));
        RestTemplate restTemplate = new RestTemplate();
        Boolean res = restTemplate.postForObject(getServerAddress() + "simple/addNews/", news, Boolean.class);
        return res;
    }

    private News findNewsById(String id) {
        log.debug("# parameter ={}", id);
        RestTemplate restTemplate = new RestTemplate();
        News res = restTemplate.getForObject(getServerAddress() + "simple/findNewsById/" + id, News.class);
        return res;
    }

    private boolean editNews(News news) {
        log.debug("# parameter ={}", JSON.toJSONString(news));
        RestTemplate restTemplate = new RestTemplate();
        Boolean res = restTemplate.postForObject(getServerAddress() + "simple/editNews/", news, Boolean.class);
        return res;
    }

    @SuppressWarnings("unchecked")
    private PageInfo<News> findNewsByPage(Integer pageNum, String keywords) {
        log.debug("# parameter , {}  , {}", pageNum, keywords);
        RestTemplate restTemplate = new RestTemplate();
        Map<String, Object> parameter = new HashMap<String, Object>();
        parameter.put("pageNum", pageNum);
        parameter.put("keywords", keywords);
        PageInfo<News> res = restTemplate.getForObject(getServerAddress() + "simple/findNewsByPage/", PageInfo.class, parameter);
        return res;
    }

    /*
     * 表单提交日期绑定
     */
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }

    /**
     * @Description 进入新增页面
     * @author 王鑫
     * @return
     */
    @RequestMapping(value = "/news/add", method = RequestMethod.GET)
    public String add() {
        log.info("# 进入发布新闻页面");
        return "view/news/add";
    }

    /**
     * @Description ajax保存发布新闻
     * @author 王鑫
     * @param news
     * @return
     */
    @RequestMapping(value = "/news/add", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, String> add(@ModelAttribute("newsForm") News news) {
        boolean flag = addNews(news);
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
     * @Description ajax加载新闻对象
     * @author 王鑫
     * @return
     */
    @RequestMapping(value = "/news/load/{id}", method = RequestMethod.GET)
    public String load(@PathVariable String id, ModelMap map) {
        log.info("# ajax加载新闻对象");
        News news = findNewsById(id);
        map.addAttribute("news", news);
        return "view/news/edit_form";
    }

    /**
     * @Description ajax保存更新重新发布新闻
     * @author 王鑫
     * @param news
     * @return
     */
    @RequestMapping(value = "/news/edit", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, String> edit(@ModelAttribute("newsForm") News news) {
        boolean flag = editNews(news);
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
        PageInfo<News> page = findNewsByPage(null, null);
        log.debug("{}", JSON.toJSONString(page));

        map.put("page", page);
        return "view/news/list";
    }

    @RequestMapping(value = "/news/list_page", method = RequestMethod.POST)
    public String list_page(@RequestParam(value = "keywords", required = false) String keywords, @RequestParam(value = "pageNum", required = false) Integer pageNum, ModelMap map) {
        log.info("#分页查询新闻 pageNum={} , keywords={}", pageNum, keywords);
        PageInfo<News> page = findNewsByPage(pageNum, keywords);
        map.put("page", page);
        map.put("keywords", keywords);
        return "view/news/list_page";
    }

}
