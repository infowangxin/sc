package com.nutcracker.provider;


import com.nutcracker.openfeign.okhttp.OkHttpConfig;
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
@SpringBootApplication
@EnableFeignClients(basePackages = "com.nutcracker.openfeign")
@EnableDiscoveryClient
public class ProviderApplication {

    private static final Logger LOG = LoggerFactory.getLogger(ProviderApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(ProviderApplication.class, args);
        LOG.info(">>>>>>>>>>>>>>>>>>>> sc-provider start successful <<<<<<<<<<<<<<<<<<<<");
    }

}
