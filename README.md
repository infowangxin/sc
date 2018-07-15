# sc 介绍 #

`它是一个基于SpringCloud的分布式服务示例项目、集成有eureka、ribbon、feign、hystrix组件等，消费端有JSP、freemarker、thymeleaf三个版本，同时集成了shiro、swagger2等，后面会接着完善`

#### 包含工程有：
* sc-commons：用于放common公共相关类的工程，所有工程都可以引用。
* sc-eureka：Netflix Eureka云端负载均衡，一个基于REST的服务，用于定位服务，以实现云端的负载均衡和中间层服务器的故障转移。
* sc-consumer-freemarker：client端，即consumer服务消费者，前端采用的是freemarker，集成了shiro。
* sc-consumer-jsp：client端，即consumer服务消费者，前端采用的是jsp，集成了shiro。

* sc-consumer-thymeleaf：client端，即consumer服务消费者，前端采用的是thymeleaf，集成了shiro。

* sc-hystrix：集成hystrix的示例
* sc-provider：server端，即provider服务提供端，端口是随机分配的，可以启动多个服务对ribbon验证服务负载，当中集成了swagger2
* sc-feign：SpringCloud Netflix Feign，声明的接口。

#### 示例启动
* 初始化数据库，将[sc/ddl/mysql_test.sql](ddl/mysql_test.sql)脚本初始化在默认数据库当中

* 按顺序依次启动项目工程： sc-eureka、sc-provider、sc-consumer-freemarker、sc-consumer-jsp、sc-consumer-thymeleaf
` 启动方式，运行： com.wangxin.Application.main(String[]) 方法`

* 访问 sc-eureka
`浏览器访问 `[http://localhost:1111](http://localhost:1111) `，Application表格当中可以看到注册上来的server与client，表明启动都成功了`

* 访问 sc-provider
` 浏览器访问 `[http://localhost:2000/msg](http://localhost:2000/msg)` ，看到“来自于server ...”则证明访问成功`
` 浏览器访问 `[http://localhost:2000](http://localhost:2000)` ，进入swagger2 ui页面`

* 访问 sc-consumer-freemarker
`浏览器访问 `[http://localhost:3000](http://localhost:3000)`，会看到登录页面`

* 访问 sc-consumer-jsp
`浏览器访问 `[http://localhost:4000](http://localhost:4000)`，会看到登录页面`

* 访问 sc-consumer-thymeleaf
`浏览器访问 `[http://localhost:5000](http://localhost:5000)`，会看到登录页面`

[GitHub](https://github.com/wangxinforme) [issues](https://github.com/wangxinforme/sc/issues)