package com.wangxin.consumer.thymeleaf.common;

import java.util.Calendar;

import javax.servlet.ServletContext;

import com.wangxin.common.api.common.util.DateUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.ServletContextAware;

/**
 * 将version版本号写入application中，给css,js引用时用
 */
@Component
public class ApplicationContext implements ServletContextAware {

    private static final Logger log = LoggerFactory.getLogger(ApplicationContext.class);

    // @Autowired
    // private DiscoveryClient client;

    @Override
    public void setServletContext(ServletContext context) {
        String datetime = DateUtil.dateToString(Calendar.getInstance().getTime(), DateUtil.fm_yyyyMMddHHmmssSSS);
        String contextPath = context.getContextPath();
        context.setAttribute("version_css", datetime);
        context.setAttribute("version_js", datetime);

        // FIXME 此处可以不要
        // if (StringUtils.isBlank(contextPath)) {
        // ServiceInstance instance = client.getLocalServiceInstance();
        // contextPath = "http://" + instance.getHost() + ":" + instance.getPort();
        // }

        log.info("# version={} , contextPath={}", datetime, contextPath);
        context.setAttribute("ctx", contextPath);
    }

}