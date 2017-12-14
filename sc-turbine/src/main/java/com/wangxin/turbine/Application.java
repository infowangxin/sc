package com.wangxin.turbine;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.cloud.netflix.turbine.EnableTurbine;

//@ServletComponentScan
//@EnableDiscoveryClient
//@EnableFeignClients
//@EnableHystrixDashboard
//@EnableHystrix
@EnableTurbine
@SpringBootApplication
public class Application extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    // @Bean
    // public EmbeddedServletContainerCustomizer containerCustomizer() {
    // return new EmbeddedServletContainerCustomizer() {
    // @Override
    // public void customize(ConfigurableEmbeddedServletContainer container) {
    // ErrorPage error401Page = new ErrorPage(HttpStatus.UNAUTHORIZED, "/error/401.html");
    // ErrorPage error403Page = new ErrorPage(HttpStatus.FORBIDDEN, "/error/403.html");
    // ErrorPage error404Page = new ErrorPage(HttpStatus.NOT_FOUND, "/error/404.html");
    // ErrorPage error405Page = new ErrorPage(HttpStatus.METHOD_NOT_ALLOWED, "/error/405.html");
    // ErrorPage error500Page = new ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR, "/error/500.html");
    // container.addErrorPages(error401Page, error403Page, error404Page, error405Page, error500Page);
    // }
    // };
    // }

}
