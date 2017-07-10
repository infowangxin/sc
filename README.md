# sc 介绍 #

`它是一个基于SpringCloud的分布式服务示例项目。`

#### 包含工程有：
* sc-api：用于放common公共相关类的工程，所有工程都可以引用
* sc-consumer：分布式微服务SpringCloud的client端
* sc-provider：分布式微服务SpringCloud的server端
* sc-eureka-server：分布式微服务SpringCloud的Netflix Eureka，云端负载均衡，一个基于 REST 的服务，用于定位服务，以实现云端的负载均衡和中间层服务器的故障转移

#### 示例启动

* 启动 sc-eureka-server
` 运行 sc-eureka-server 工程 com.ms.netflix.eureka.Application.main(String[]) 方法`

* 启动 sc-provider
` 运行 sc-server 工程 com.ms.server.Application.main(String[]) 方法`

* 启动 sc-consumer
`运行 sc-client 工程 com.ms.client.Application.main(String[]) 方法`

* 访问 sc-eureka-server
`浏览器访问 http://localhost:1111 ，Application表格当中可以看到注册上来的server与client，表明启动都成功了`

* 访问 sc-provider
` 浏览器访问 http://localhost:2222/add?a=1&b=2 ，看到“来自于server, a+b=3”则证明访问成功`
`浏览器访问 http://localhost:2222/testService?a=1&b=2 ，看到“来自于server, a+b=3 , client 端口:3333”则证明访问成功`

* 访问 sc-consumer
`浏览器访问 http://localhost:3333/add?a=1&b=2 ，看到“来自于server, a+b=3 , client 端口:3333”则证明访问成功`