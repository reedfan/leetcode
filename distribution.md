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



## [zookeeper](https://blog.csdn.net/reed1991/article/details/53811504)




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
 1、简单队列 2、work模式 
 3、订阅模式  生产者发送的消息经过交换机到达队列
 4、路由模式 根据不同的路由key发往不同的队列
 5、主题模式 在路由模式下添加通配符的概念



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

### BASE 理论
BASE 理论是对 CAP 理论的延伸，核心思想是即使无法做到强一致性（Strong Consistency，CAP 的一致性就是强一致性），但应用可以采用适合的方式达到最终一致性（Eventual Consitency）。

    基本可用(Basically Available)： 基本可用是指分布式系统在出现故障的时候，允许损失部分可用性，即保证核心可用。电商大促时，为了应对访问量激增，部分用户可能会被引导到降级页面，服务层也可能只提供降级服务。这就是损失部分可用性的体现。
    软状态(Soft State)： 软状态是指允许系统存在中间状态，而该中间状态不会影响系统整体可用性。分布式存储中一般一份数据至少会有三个副本，允许不同节点间副本同步的延时就是软状态的体现。MySQL Replication 的异步复制也是一种体现。
    最终一致性(Eventual Consistency)： 最终一致性是指系统中的所有数据副本经过一定时间后，最终能够达到一致的状态。弱一致性和强一致性相反，最终一致性是弱一致性的一种特殊情况。

ACID 和 BASE 的区别与联系：

ACID 是传统数据库常用的设计理念，追求强一致性模型。BASE 支持的是大型分布式系统，提出通过牺牲强一致性获得高可用性。

ACID 和 BASE 代表了两种截然相反的设计哲学，在分布式系统设计的场景中，系统组件对一致性要求是不同的，因此 ACID 和 BASE 又会结合使用。


### CAP
Consistency:一致性，原文翻译过来是说，对于任何从客户端发达到分布式系统的数据读取请求，要么读到最新的数据要么失败。换句话说，一致性是站在分布式系统的角度，对访问本系统的客户端的一种承诺：要么我给您返回一个错误，要么我给你返回绝对一致的最新数据，不难看出，其强调的是数据正确。

Availability:可用性，原文翻译过来是说，对于任何求从客户端发达到分布式系统的数据读取请求，都一定会收到数据，不会收到错误，但不保证客户端收到的数据一定是最新的数据。换句话说，可用性是站在分布式系统的角度，对访问本系统的客户的另一种承诺：我一定会给您返回数据，不会给你返回错误，但不保证数据最新，强调的是不出错。

Partition tolerance:分区容忍性，这个词有点怪，如果直接看中文的确有点不太好理解。那么看原文翻译怎么说的，分布式系统应该一直持续运行，即使在不同节点间同步数据的时候，出现了大量的数据丢失或者数据同步延迟。
(PS:^V^,您瞧瞧，包容度多高，简直是打不死的小强，现在应该能够理解为什么用tolerance容忍度这个词了吧。)
换句话说，分区容忍性是站在分布式系统的角度，对访问本系统的客户端的再一种承诺：我会一直运行，不管我的内部出现何种数据同步问题，强调的是不挂掉。

对于一个分布式系统而言，P是前提，必须保证，因为只要有网络交互就一定会有延迟和数据丢失，这种状况我们必须接受，必须保证系统不能挂掉。试想一下，如果稍微出现点数据丢包，我们的整个系统就挂掉的话，我们为什么还要做分布式呢？所以，按照CAP理论三者中最多只能同时保证两者的论断，对于任何分布式系统，设计时架构师能够选择的只有C或者A，要么保证数据一致性（保证数据绝对正确），要么保证可用性（保证系统不出错）。


分布式事务的解决方案？
一、两阶段提交（2PC）
两阶段提交（Two-phase Commit，2PC），通过引入协调者（Coordinator）来协调参与者的行为，并最终决定这些参与者是否要真正执行事务。
准备阶段：协调者询问参与者事务是否执行成功，参与者发回事务执行结果。
提交阶段：如果事务在每个参与者上都执行成功，事务协调者发送通知让参与者提交事务；否则，协调者发送通知让参与者回滚事务。
存在的问题
1 同步阻塞 所有事务参与者在等待其它参与者响应的时候都处于同步阻塞状态，无法进行其它操作。
2 单点问题 协调者在 2PC 中起到非常大的作用，发生故障将会造成很大影响。特别是在阶段二发生故障，所有参与者会一直等待状态，无法完成其它操作。
3 数据不一致 在阶段二，如果协调者只发送了部分 Commit 消息，此时网络发生异常，那么只有部分参与者接收到 Commit 消息，也就是说只有部分参与者提交了事务，使得系统数据不一致。
4 太过保守 任意一个节点失败就会导致整个事务失败，没有完善的容错机制。
二、补偿事务（TCC）
TCC 其实就是采用的补偿机制，其核心思想是：针对每个操作，都要注册一个与其对应的确认和补偿（撤销）操作。它分为三个阶段：
Try 阶段主要是对业务系统做检测及资源预留
Confirm 阶段主要是对业务系统做确认提交，Try阶段执行成功并开始执行 Confirm阶段时，默认 Confirm阶段是不会出错的。即：只要Try成功，Confirm一定成功。
Cancel 阶段主要是在业务执行错误，需要回滚的状态下执行的业务取消，预留资源释放。
优点： 跟2PC比起来，实现以及流程相对简单了一些，但数据的一致性比2PC也要差一些
缺点： 缺点还是比较明显的，在2,3步中都有可能失败。TCC属于应用层的一种补偿方式，所以需要程序员在实现的时候多写很多补偿的代码，在一些场景中，一些业务流程可能用TCC不太好定义及处理。

三、本地消息表（异步确保）
本地消息表与业务数据表处于同一个数据库中，这样就能利用本地事务来保证在对这两个表的操作满足事务特性，并且使用了消息队列来保证最终一致性。
在分布式事务操作的一方完成写业务数据的操作之后向本地消息表发送一个消息，本地事务能保证这个消息一定会被写入本地消息表中。
之后将本地消息表中的消息转发到 Kafka 等消息队列中，如果转发成功则将消息从本地消息表中删除，否则继续重新转发。
在分布式事务操作的另一方从消息队列中读取一个消息，并执行消息中的操作。
优点： 一种非常经典的实现，避免了分布式事务，实现了最终一致性。
缺点： 消息表会耦合到业务系统中，如果没有封装好的解决方案，会有很多杂活需要处理。
四、MQ 事务消息
第一阶段Prepared消息，会拿到消息的地址。 第二阶段执行本地事务，第三阶段通过第一阶段拿到的地址去访问消息，并修改状态。
