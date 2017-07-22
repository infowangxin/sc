package com.wangxin;

import com.wangxin.common.datasource.DynamicDataSourceRegister;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.context.annotation.Import;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Import({ DynamicDataSourceRegister.class })
@EnableTransactionManagement
@ServletComponentScan
@EnableDiscoveryClient
@SpringBootApplication
@EnableConfigServer
public class Application {
    
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}