# microservice
基于SpringCloud的分布式服务示例项目

* microservice-common-api：用于放common公共相关类的工程，所有工程都可以引用
* microservice-client-api：用于放client公共相关类的工程，所有client端都可以引用 
* microservice-server-api：用于放server公共相关类的工程，所有server端都可以引用
* microservice-client：分布式微服务SpringCloud的client端
* microservice-server：分布式微服务SpringCloud的client端
* microservice-eureka-server：分布式微服务SpringCloud的Netflix Eureka，云端负载均衡，一个基于 REST 的服务，用于定位服务，以实现云端的负载均衡和中间层服务器的故障转移