package com.nutcarcker.provider.web.controller;

import com.alibaba.fastjson2.JSON;
import com.nutcarcker.openfeign.client.DemoApiFeignClient;
import com.nutcarcker.openfeign.entity.AppEntity;
import com.nutcarcker.openfeign.exception.BusinessException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 胡桃夹子
 * @date 2022-01-21 18:17
 */
@RestController
public class DemoApiController {

    private static final Logger LOG = LoggerFactory.getLogger(DemoApiController.class);

    @Autowired
    private DemoApiFeignClient demoApiFeignClient;

    @GetMapping("diff/{input}")
    public String diff(@PathVariable Integer input) {
        LOG.info("# diff input={}", input);
        String result;
        try {
            AppEntity appEntity = demoApiFeignClient.getDiff(input);
            result = JSON.toJSONString(appEntity);
        } catch (BusinessException e) {
            result = e.getMessage();
            LOG.error("# BusinessException {}", result);
        } catch (Throwable e) {
            result = e.getMessage();
            LOG.error("# Exception {}", result);
        }
        LOG.debug("# {}", result);
        return result;
    }

    @GetMapping("msg/{input}")
    public String msg(@PathVariable Integer input) {
        LOG.info("# msg input={}", input);
        String result;
        try {
            AppEntity appEntity = demoApiFeignClient.getMessage(input);
            result = JSON.toJSONString(appEntity);
        } catch (BusinessException e) {
            result = e.getMessage();
            LOG.error("# BusinessException {}", result);
        } catch (Throwable e) {
            result = e.getMessage();
            LOG.error("# Exception {}", result);
        }
        return result;
    }

}
