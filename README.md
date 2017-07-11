# sc 介绍 #

`它是一个基于SpringCloud的分布式服务示例项目。`

#### 包含工程有：
* sc-api：用于放common公共相关类的工程，所有工程都可以引用
* sc-consumer-freemarker：分布式微服务SpringCloud的client端，前端采用的是freemarker
* sc-consumer-jsp：分布式微服务SpringCloud的client端，前端采用的是jsp
* sc-provider：分布式微服务SpringCloud的server端
* sc-eureka-server：分布式微服务SpringCloud的Netflix Eureka，云端负载均衡，一个基于 REST 的服务，用于定位服务，以实现云端的负载均衡和中间层服务器的故障转移

#### 示例启动
* 初始化数据库，将[sc/ddl/mysql_test.sql]()脚本初始化在默认数据库当中

* 按顺序依次启动项目工程： sc-eureka-server、sc-provider、sc-consumer-freemarker、sc-consumer-jsp
` 启动方式，运行： com.ms.Application.main(String[]) 方法`

* 访问 sc-eureka-server
`浏览器访问 http://localhost:1111 ，Application表格当中可以看到注册上来的server与client，表明启动都成功了`

* 访问 sc-provider
` 浏览器访问 http://localhost:2222/add?a=1&b=2 ，看到“来自于server, a+b=3”则证明访问成功`
`浏览器访问 http://localhost:2222/testService?a=1&b=2 ，看到“来自于server, a+b=3 , client 端口:3333”则证明访问成功`

* 访问 sc-consumer-jsp
`浏览器访问 http://localhost:3333，会看到登录页面

* 访问 sc-consumer-freemarker
`浏览器访问 http://localhost:4444，全看到登录页面