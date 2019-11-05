# Table of Contents

  * [[系统架构中为什么要引入消息中间件](https://mp.weixin.qq.com/s?__biz=MzU0OTk3ODQ3Ng==&mid=2247484149&idx=1&sn=98186297335e13ec7222b3fd43cfae5a&chksm=fba6eaf6ccd163e0c2c3086daa725de224a97814d31e7b3f62dd3ec763b4abbb0689cc7565b0&mpshare=1&scene=1&srcid=0608fz8HKZvYxRhzFqyJ4Isq%23rd)](#[系统架构中为什么要引入消息中间件]httpsmpweixinqqcoms__bizmzu0otk3odq3ngmid2247484149idx1sn98186297335e13ec7222b3fd43cfae5achksmfba6eaf6ccd163e0c2c3086daa725de224a97814d31e7b3f62dd3ec763b4abbb0689cc7565b0mpshare1scene1srcid0608fz8hkzvyxrhzfqyj4isq23rd)
    * [[系统架构引入消息中间件有什么缺点](https://mp.weixin.qq.com/s?__biz=MzU0OTk3ODQ3Ng==&mid=2247484157&idx=1&sn=f4644be2db6b1c230846cb4d62ae5be9&chksm=fba6eafeccd163e817b420d57478829d92251a6a5fd446f81805f0983a0d95cb6853a6735c4b&mpshare=1&scene=1&srcid=06083A6RVW3ZtKQRy6Ttq8tK%23rd)](#[系统架构引入消息中间件有什么缺点]httpsmpweixinqqcoms__bizmzu0otk3odq3ngmid2247484157idx1snf4644be2db6b1c230846cb4d62ae5be9chksmfba6eafeccd163e817b420d57478829d92251a6a5fd446f81805f0983a0d95cb6853a6735c4bmpshare1scene1srcid06083a6rvw3ztkqry6ttq8tk23rd)
  * [[kafka](https://blog.csdn.net/reed1991/article/details/88729252)](#[kafka]httpsblogcsdnnetreed1991articledetails88729252)
    * [Kafka消息保证生产的信息不丢失](#kafka消息保证生产的信息不丢失)
    * [Kafka消息保证生产的信息不重复消费](#kafka消息保证生产的信息不重复消费)
  * [rabbitMQ](#rabbitmq)
    * [rabbitMQ消费者还没来得及消费消息就宕机了怎么办](#rabbitmq消费者还没来得及消费消息就宕机了怎么办)
    * [RabbitMQ暂时放在了自己的内存中，还没来得及投递给消费者，此时RabbitMQ突然宕机了，会怎么样？](#rabbitmq暂时放在了自己的内存中，还没来得及投递给消费者，此时rabbitmq突然宕机了，会怎么样？)
  * [生产者弄丢了数据](#生产者弄丢了数据)
  * [[如何保证消息不被重复消费](https://github.com/reedfan/Java-Interview-Advanced/blob/master/docs/high-concurrency/how-to-ensure-that-messages-are-not-repeatedly-consumed.md)](#[如何保证消息不被重复消费]httpsgithubcomreedfanjava-interview-advancedblobmasterdocshigh-concurrencyhow-to-ensure-that-messages-are-not-repeatedly-consumedmd)
  * [[zookeeper](https://blog.csdn.net/reed1991/article/details/53811504)](#[zookeeper]httpsblogcsdnnetreed1991articledetails53811504)
  * [分布式锁相关](#分布式锁相关)
  * [[分布式锁的高并发优化](https://blog.csdn.net/savorTheFlavor/article/details/88841344)](#[分布式锁的高并发优化]httpsblogcsdnnetsavortheflavorarticledetails88841344)
  * [[分布式事物的几种解决方案](https://blog.csdn.net/reed1991/article/details/58128053)](#[分布式事物的几种解决方案]httpsblogcsdnnetreed1991articledetails58128053)
  * [[缓存与数据库的一致性问题](https://blog.csdn.net/reed1991/article/details/53106078)](#[缓存与数据库的一致性问题]httpsblogcsdnnetreed1991articledetails53106078)
  * [[RabbitMQ的五种工作模式](https://blog.csdn.net/reed1991/article/details/53394906)](#[rabbitmq的五种工作模式]httpsblogcsdnnetreed1991articledetails53394906)
  * [[Dubbo](https://blog.csdn.net/reed1991/article/details/86185091)](#[dubbo]httpsblogcsdnnetreed1991articledetails86185091)
  * [[Dubbo原理](https://blog.csdn.net/reed1991/article/details/53134343)](#[dubbo原理]httpsblogcsdnnetreed1991articledetails53134343)
  * [dubbo服务降级](#dubbo服务降级)
  * [集群容错](#集群容错)
    * [hystrix 断路器](#hystrix-断路器)
    * [服务熔断](#服务熔断)
    * [服务降级](#服务降级)
  * [eureka和 zookeeper,两个的区別?](#eureka和-zookeeper两个的区別)


## [系统架构中为什么要引入消息中间件](https://mp.weixin.qq.com/s?__biz=MzU0OTk3ODQ3Ng==&mid=2247484149&idx=1&sn=98186297335e13ec7222b3fd43cfae5a&chksm=fba6eaf6ccd163e0c2c3086daa725de224a97814d31e7b3f62dd3ec763b4abbb0689cc7565b0&mpshare=1&scene=1&srcid=0608fz8HKZvYxRhzFqyJ4Isq%23rd)
1.解耦  2.异步  3.削峰

### [系统架构引入消息中间件有什么缺点](https://mp.weixin.qq.com/s?__biz=MzU0OTk3ODQ3Ng==&mid=2247484157&idx=1&sn=f4644be2db6b1c230846cb4d62ae5be9&chksm=fba6eafeccd163e817b420d57478829d92251a6a5fd446f81805f0983a0d95cb6853a6735c4b&mpshare=1&scene=1&srcid=06083A6RVW3ZtKQRy6Ttq8tK%23rd)
1.消息中间件可能会挂掉，导致系统可用性降低
2.可能会丢消息，导致系统稳定性下降
3.可能带来分布式一致性问题

## [kafka](https://blog.csdn.net/reed1991/article/details/88729252)

### Kafka消息保证生产的信息不丢失
1）使用同步模式的时候，有3种状态保证消息被安全生产，在配置为1（只保证写入leader成功）的话，如果刚好leader partition挂了，数据就会丢失。
2）还有一种情况可能会丢失消息，就是使用异步模式的时候，当缓冲区满了，如果配置为0（还没有收到确认的情况下，缓冲池一满，就清空缓冲池里的消息），
数据就会被立即丢弃掉。

在数据生产时避免数据丢失的方法：
只要能避免上述两种情况，那么就可以保证消息不会被丢失。
1）就是说在同步模式的时候，确认机制设置为-1，也就是让消息写入leader和所有的副本。
2）还有，在异步模式下，如果消息发出去了，但还没有收到确认的时候，缓冲池满了，在配置文件中设置成不限制阻塞超时的时间，也就说让生产端一直阻塞，这样也能保证数据不会丢失。
在数据消费时，避免数据丢失的方法：如果使用了storm，要开启storm的ackfail机制；如果没有使用storm，确认数据被完成处理之后，再更新offset值。低级API中需要手动控制offset值。

### Kafka消息保证生产的信息不重复消费
（1）去重：将消息的唯一标识保存到外部介质中，每次消费处理时判断是否处理过；
（2）不管：大数据场景中，报表系统或者日志信息丢失几条都无所谓，不会影响最终的统计分析结

## rabbitMQ
### rabbitMQ消费者还没来得及消费消息就宕机了怎么办
 关闭autoAck的行为 ，channel.basicConsume()方法，传入的第二个参数：false
 
### RabbitMQ暂时放在了自己的内存中，还没来得及投递给消费者，此时RabbitMQ突然宕机了，会怎么样？ 
1.首先让queue持久化
2.消息到RabbitMQ的时候，需要定义这条消息也是durable，即持久化的。
一旦标记了消息是持久化之后，就会让RabbitMQ把消息持久化写入到磁盘上去，此时如果RabbitMQ还没投递数据到消费者，
结果就突然宕机了。那么再次重启的时候，就会把磁盘上持久化的消息给加载出来。


## 生产者弄丢了数据
生产者将数据发送到rabbitmq的时候，可能因为网络问题导致数据就在半路给搞丢了。
1.使用事务（性能差）：在生产者发送数据之前开启rabbitmq事务（channel.txSelect），然后发送消息，如果消息没有成功被rabbitmq接收到，那么生产者会收到异常报错，此时就可以回滚事务（channel.txRollback）
始rabbitmq事务机制，基本上吞吐量会下来，因为太耗性能。
2.可以开启confirm模式，在生产者那里设置开启confirm模式之后，你每次写的消息都会分配一个唯一的id，然后如果写入了rabbitmq中，rabbitmq会给你回传一个ack消息，告诉你说这个消息ok了。如果rabbitmq没能处理这个消息，会回调你一个nack接口，告诉你这个消息接收失败，你可以重试。而且你可以结合这个机制自己在内存里维护每个消息id的状态，如果超过一定时间还没接收到这个消息的回调，那么你可以重发。
事务机制和cnofirm机制最大的不同在于，事务机制是同步的，你提交一个事务之后会阻塞在那儿，但是confirm机制是异步的，你发送个消息之后就可以发送下一个消息，然后那个消息rabbitmq接收了之后会异步回调你一个接口通知你这个消息接收到了。
所以一般在生产者这块避免数据丢失，都是用confirm机制的。

## [如何保证消息不被重复消费](https://github.com/reedfan/Java-Interview-Advanced/blob/master/docs/high-concurrency/how-to-ensure-that-messages-are-not-repeatedly-consumed.md)
让生产者发送每条数据的时候，里面加一个全局唯一的 id，类似订单 id 之类的东西，然后你这里消费到了之后，先根据这个 id 去比如 Redis 里查一下，之前消费过吗？如果没有消费过，你就处理，然后这个 id 写 Redis。如果消费过了，那你就别处理了，保证别重复处理相同的消息即可。

## [zookeeper](https://blog.csdn.net/reed1991/article/details/53811504)


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


## 分布式锁相关
[分布式锁简单入门以及三种实现方式介绍](https://blog.csdn.net/reed1991/article/details/56680593)
zk实现分布式锁使用的是零时顺序节点
zk实现分布式锁说白了就是看看自己创建的节点序号是否最小 最小则获得分布式锁 否则继续监听

redis实现分布式锁的性能更好，redis是纯内存服务。
 zk的可靠性更好
 
## [分布式锁的高并发优化](https://blog.csdn.net/savorTheFlavor/article/details/88841344)
 核心是和ConcurrentHashMap原理类似的分段加锁
 
## [分布式事物的几种解决方案](https://blog.csdn.net/reed1991/article/details/58128053)

## [缓存与数据库的一致性问题](https://blog.csdn.net/reed1991/article/details/53106078)

## [RabbitMQ的五种工作模式](https://blog.csdn.net/reed1991/article/details/53394906)

## [Dubbo](https://blog.csdn.net/reed1991/article/details/86185091)
## [Dubbo原理](https://blog.csdn.net/reed1991/article/details/53134343)
## dubbo服务降级
mock=force:return+null 表示消费方对该服务的方法调用都直接返回 null 值，不发起远程调用。用来屏蔽不重要服务不可用时对调用方的影响。
还可以改为 mock=fail:return+null 表示消费方对该服务的方法调用在失败后，再返回 null 值，不抛异常。用来容忍不重要服务不稳定时对调用方的影响。

## 集群容错
Failover Cluster：失败自动切换，当出现失败，重试其它服务器。通常用于读操作，但重试会带来更长延迟。可通过 retries="2" 来设置重试次数(不含第一次)
Failfast Cluster：快速失败，只发起一次调用，失败立即报错。通常用于非幂等性的写操作，比如新增记录。
Failsafe Cluster：失败安全，出现异常时，直接忽略。通常用于写入审计日志等操作。
Failback Cluster：失败自动恢复，后台记录失败请求，定时重发。通常用于消息通知操作。
Forking Cluster：并行调用多个服务器，只要一个成功即返回。通常用于实时性要求较高的读操作，但需要浪费更多服务资源。可通过 forks="2" 来设置最大并行数。
Broadcast Cluster：广播调用所有提供者，逐个调用，任意一台报错则报错。通常用于通知所有提供者更新缓存或日志等本地资源信息。
### hystrix 断路器 
 
Hystrix是一个用于处理分布式系统的延迟和容错的开源库，在分布式系统里，许多依赖不可避免的会调用失败，比如超时、异常等，Hystrix能够保证在一个依赖出问题的情况下，不会导致整体服务失败，避免级联故障，以提高分布式系统的弹性。
 
“断路器”本身是一种开关装置，当某个服务单元发生故障之后，通过断路器的故障监控（类似熔断保险丝），向调用方返回一个符合预期的、可处理的备选响应（FallBack），而不是长时间的等待或者抛出调用方无法处理的异常，这样就保证了服务调用方的线程不会被长时间、不必要地占用，从而避免了故障在分布式系统中的蔓延，乃至雪崩。

### 服务熔断
熔断机制是应对雪崩效应的一种微服务链路保护机制。
当扇出链路的某个微服务不可用或者响应时间太长时，会进行服务的降级，进而熔断该节点微服务的调用，快速返回"错误"的响应信息。当检测到该节点微服务调用响应正常后恢复调用链路。在SpringCloud框架里熔断机制通过Hystrix实现。Hystrix会监控微服务间调用的状况，当失败的调用到一定阈值，缺省是5秒内20次调用失败就会启动熔断机制。熔断机制的注解是@HystrixCommand。



 ### 服务降级
整体资源快不够了，忍痛将某些服务先关掉，待渡过难关，再开启回来。
服务降级的处理是在客户端实现的，与服务端没关系。

## eureka和 zookeeper,两个的区別?
首先 说CAP 是什么  所谓的CAP  C强一致性  A可用性 P 分区容错性
 著名的CAP理论指出, 一个分布式系统不可能同时满足C(一致性)、A(可用性)和P(分区容错性)。由于分区容错性P在是分布式系统中必须要保证的,因此我们只能在A和C之间进行权衡。 

**zookeeper 遵守 CP** 

当向注册中心查询服务列表时, 我们可以容忍注册中心返回的是几分钟以前的注册信息, 但不能接受服务直接down掉不可用。也就是说,服务注册功能对一致性的要求要高于可用性。

但是zookeeper 会出现这样一种情况,   当 master节点因为网络故障与其他节点失去联系时,剩余节点会重新进行 leader选举。

问题在于,选举 leader的时间太长,30~120s,目选举期间整个zookeeper 集群都是不可用的,这就导致在选举期间注册服务瘫痪。

在云部署的环境下,因网络问题使得zookeeper 集群失去 master节点是较大概率会发生的事,虽然服务能够最终恢复,但是漫长的选举时间导致的注册长期不可用是不能容忍的。 

或许  这个回答太过于抽象  用一种其他说法来说 就是 ：当有一个zookeeper  挂了  那其他的zookeeper 会进行 一次选举 （强一致性 ： 我一定要保持数据一致性）  而在此选举期间  zookeeper  是不可用的   而当前 有用户正在使用 用户就不爽了 。

 **eureka 遵守 AP**  

Eureka:看明白了这一点,因此在设计时就优先保证可用性。

Eureka各个节点都是平等的,几个节点挂掉不会影响正常节点的工作,剩余的节点依然可以提供注册和查询服务。

而 Eureka的客户端在向某个 Eureka注册或时如果发现连接失败,则会自动切换至其它节点 

只要有一台 Eureka还在,就能保证注册服务可用(保证可用性),只不过查到的信息可能不是最新的不保证强一致性)。

除此之外, Eureka还有一种自我保护机制,如果在15分钟内超过85%的节点都没有正常的心跳,那么 Eureka就认为客户端与注册中心出现了网络故障,此时会出现以下几种情况:

1. Eureka不再从注册列表中移除因为长时间没收到心跳而应该过期的服务

2. eureka仍然能够接受新服务的注册和査询请求,但是不会被同步到其它节点上(即保证当前节点依然可用)

3.当网络稳定时,当前实例新的注册信息会被同步到其它节点中

因此, Eureka可以很好的应对因网络故障导致部分节点失去联系的情況,而不会像 zookeeper那样使整个注册服务瘫痪。 
