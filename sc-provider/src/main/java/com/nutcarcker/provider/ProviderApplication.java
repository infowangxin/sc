package com.nutcarcker.provider;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * start application
 *
 * @author 胡桃夹子
 * @date 2022/4/20 21:06
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ProviderApplication {

    private static final Logger LOG = LoggerFactory.getLogger(ProviderApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(ProviderApplication.class, args);
        LOG.info(">>>>>>>>>>>>>>>>>>>> start successful <<<<<<<<<<<<<<<<<<<<");
    }

}
