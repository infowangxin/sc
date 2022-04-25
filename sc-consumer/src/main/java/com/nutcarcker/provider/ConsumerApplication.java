package com.nutcarcker.provider;


import com.nutcarcker.openfeign.config.OkHttpConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * start application
 *
 * @author 胡桃夹子
 * @date 2022/4/20 21:06
 */
@ImportAutoConfiguration(classes = {OkHttpConfig.class})
@EnableFeignClients(basePackages = "com.nutcarcker.openfeign")
@EnableDiscoveryClient
@SpringBootApplication
public class ConsumerApplication {

    private static final Logger LOG = LoggerFactory.getLogger(ConsumerApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(ConsumerApplication.class, args);
        LOG.info(">>>>>>>>>>>>>>>>>>>> start successful <<<<<<<<<<<<<<<<<<<<");
    }

}
