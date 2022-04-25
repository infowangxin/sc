package com.nutcarcker.provider.client.impl;

import com.nutcarcker.openfeign.entity.AppEntity;
import com.nutcarcker.openfeign.exception.BusinessException;
import com.nutcarcker.openfeign.client.DemoApiFeignClient;
import com.nutcarcker.provider.exception.ProviderException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 示例接口实现类
 *
 * @author 胡桃夹子
 * @date 2022-04-24 19:37
 */
@RestController
public class DemoApiFeignClientImpl implements DemoApiFeignClient {

    private static final Logger LOG = LoggerFactory.getLogger(DemoApiFeignClientImpl.class);

    private static final int TOTAL = 10;

    @Value("${spring.application.name}")
    public String name;

    @Value("${server.port}")
    public Integer port;

    @Override
    @GetMapping("/demoApi/getDiff")
    public AppEntity getDiff(Integer value) {
        if (null == value || value == 0) {
            throw new ProviderException("1001", "value is empty or zero");
        }
        int diff = TOTAL / value;
        AppEntity appEntity = new AppEntity();
        appEntity.setName(name);
        appEntity.setPort(port);
        appEntity.setDiff(diff);

        LOG.info("# appEntity={}", appEntity);
        return appEntity;
    }

    @Override
    @GetMapping("/demoApi/getMessage")
    public AppEntity getMessage(Integer value) throws BusinessException {
        try {
            // 此处线程睡眠3秒为了方便做性能测试
            Thread.sleep(11000);
            return getDiff(value);
        } catch (InterruptedException e) {
            LOG.error("# Thread.sleep fail");
            throw new BusinessException(e);
        } catch (Exception e) {
            LOG.error("# Exception error msg {}", e.getMessage());
            throw new BusinessException("value error");
        }
    }
}
