# Table of Contents

  * [dubbo负载均衡策略](#dubbo负载均衡策略)
  * [dubbo高可用：服务降级](#dubbo高可用：服务降级)
  * [[Dubbo](https://blog.csdn.net/reed1991/article/details/86185091)](#[dubbo]httpsblogcsdnnetreed1991articledetails86185091)
  * [dubbo工作原理](#dubbo工作原理)
  * [Dubbo的几个重要角色：](#dubbo的几个重要角色：)
  * [[Dubbo原理](https://blog.csdn.net/reed1991/article/details/53134343)](#[dubbo原理]httpsblogcsdnnetreed1991articledetails53134343)
    * [注册中心挂了可以继续通信吗？](#注册中心挂了可以继续通信吗？)
  * [dubbo高可用：集群容错](#dubbo高可用：集群容错)
  * [dubbo支持不同的通信协议](#dubbo支持不同的通信协议)
  * [dubbo支持的序列化协议](#dubbo支持的序列化协议)


## dubbo负载均衡策略
1、Random LoadBalance   随机，按权重设置随机概率。 比如 权重 1 2 3，按照1/6 1/3 1/2的随机概率分配。
2、RoundRobin LoadBalance 按照权重轮询
3、LeastActive LoadBalance 最少活跃调用数
  例如，每个服务维护一个活跃数计数器。当A机器开始处理请求，该计数器加1，此时A还未处理完成。若处理完毕则计数器减1。
  而B机器接受到请求后很快处理完毕。那么A,B的活跃数分别是1，0。当又产生了一个新的请求，则选择B机器去执行(B活跃数最小)，
  这样使慢的机器A收到少的请求。
4、ConsistentHash LoadBalance：一致性 Hash，相同参数的请求总是发到同一提供者。

## dubbo高可用：服务降级
 mock=force:return+null 表示消费方对该服务的方法调用都直接返回 null 值，不发起远程调用。用来屏蔽不重要服务不可用时对调用方的影响。
 还可以改为 mock=fail:return+null 表示消费方对该服务的方法调用在失败后，再返回 null 值，不抛异常。用来容忍不重要服务不稳定时对调用方的影响。
 
## [Dubbo](https://blog.csdn.net/reed1991/article/details/86185091)

## dubbo工作原理
服务容器负责启动，加载，运行服务提供者。
服务提供者在启动时，向注册中心注册自己提供的服务。
服务消费者在启动时，向注册中心订阅自己所需的服务。
注册中心返回服务提供者地址列表给消费者，如果有变更，注册中心将基于长连接推送变更数据给消费者。
服务消费者，从提供者地址列表中，基于软负载均衡算法，选一台提供者进行调用，如果调用失败，再选另一台调用。
服务消费者和提供者，在内存中累计调用次数和调用时间，定时每分钟发送一次统计数据到监控中心。

## Dubbo的几个重要角色：

服务提供者（Provider）：暴露服务的服务提供方，服务提供者在启动时，向注册中心注册自己提供的服务。
服务消费者（Consumer）: 调用远程服务的服务消费方，服务消费者在启动时，向注册中心订阅自己所需的服务，服务消费者，从提供者地址列表中，基于软负载均衡算法，选一台提供者进行调用，如果调用失败，再选另一台调用。
注册中心（Registry）：注册中心返回服务提供者地址列表给消费者，如果有变更，注册中心将基于长连接推送变更数据给消费者
监控中心（Monitor）：服务消费者和提供者，在内存中累计调用次数和调用时间，定时每分钟发送一次统计数据到监控中心


## [Dubbo原理](https://blog.csdn.net/reed1991/article/details/53134343)

business也就是service层，是用户编程所涉及的部分。以下的RPC和Remoting都是原理部分。

Config层就是封装配置文件的信息，就是配置文件的内存表示。

Config层下面是Proxy（服务代理层）。它会生成客户端的代理对象，生成服务端的代理对象。代理对象互相调用方法。

Proxy下面是Registry（注册层）。消费者要到注册中心去订阅。服务的发现、服务的注册。

Cluster（路由层），帮我们进行负载均衡。Invoker是调用者，同一个服务有可能在多个机器上，cluster就解决负载均衡的问题。

Monitor（监控层），每一次的调用信息都会被监控层收集。

Protocol（远程调用层），封装整个rpc调用。一次远程调用的3个核心就是：Invoker, Protocol, Exporter.

要远程调用，就要在两台机器间架起通信的管道。Remoting就是解决远程通信的问题。

Exchange（信息交换层），本质就是创建一个客户端，一个服务端，两个架起管道，数据互通。

Transport（传输层），真正传输数据是通过Transporter来封装传输的。Transporter的底层就是Netty框架。

Serialize（序列化层），数据发送前要序列化，数据接收后，反序列化。

### 注册中心挂了可以继续通信吗？
可以，因为刚开始初始化的时候，消费者会将提供者的地址等信息拉取到本地缓存，所以注册中心挂了可以继续通信。

## dubbo高可用：集群容错
Failover Cluster   失败自动切换，当出现失败，重试其它服务器。通常用于读操作
Failfast Cluster   快速失败，只发起一次调用，失败立即报错。通常用于非幂等性的写操作，比如新增记录。
Failsafe Cluster   失败安全，出现异常时，直接忽略。通常用于写入审计日志等操作。
Failback Cluster   失败自动恢复，后台记录失败请求，定时重发。通常用于消息通知操作。
Forking Cluster   并行调用多个服务器，只要一个成功即返回。通常用于实时性要求较高的读操作，但需要浪费更多服务资源。可通过 forks="2" 来设置最大并行数。
Broadcast Cluster  广播调用所有提供者，逐个调用，任意一台报错则报错。通常用于通知所有提供者更新缓存或日志等本地资源信息。

## dubbo支持不同的通信协议

1）dubbo协议  dubbo://192.168.0.1:20188

默认就是走dubbo协议的，单一长连接，NIO异步通信，基于hessian作为序列化协议

适用的场景就是：传输数据量很小（每次请求在100kb以内），但是并发量很高

为了要支持高并发场景，一般是服务提供者就几台机器，但是服务消费者有上百台，可能每天调用量达到上亿次！此时用长连接是最合适的，就是跟每个服务消费者维持一个长连接就可以，可能总共就100个连接。然后后面直接基于长连接NIO异步通信，可以支撑高并发请求。否则如果上亿次请求每次都是短连接的话，服务提供者会扛不住。

而且因为走的是单一长连接，所以传输数据量太大的话，会导致并发能力降低。所以一般建议是传输数据量很小，支撑高并发访问。

2）rmi协议

走java二进制序列化，多个短连接，适合消费者和提供者数量差不多，适用于文件的传输，一般较少用

3）hessian协议

走hessian序列化协议，多个短连接，适用于提供者数量比消费者数量还多，适用于文件的传输，一般较少用

4）http协议

走json序列化

5）webservice

走SOAP文本序列化

## dubbo支持的序列化协议

所以dubbo实际基于不同的通信协议，支持hessian、java二进制序列化、json、SOAP文本序列化多种序列化协议。但是hessian是其默认的序列化协议。
