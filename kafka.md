## [系统架构中为什么要引入消息中间件](https://mp.weixin.qq.com/s?__biz=MzU0OTk3ODQ3Ng==&mid=2247484149&idx=1&sn=98186297335e13ec7222b3fd43cfae5a&chksm=fba6eaf6ccd163e0c2c3086daa725de224a97814d31e7b3f62dd3ec763b4abbb0689cc7565b0&mpshare=1&scene=1&srcid=0608fz8HKZvYxRhzFqyJ4Isq%23rd)
1.解耦  2.异步  3.削峰

### 如何选择消息队列
1、如果消息队列并不是将要构建系统的主角之一，对消息队列功能和性能都没有很高的要求，只需一个开箱即用易维护的产品，建议使用RabbitMQ。(有良好的运维界面，仅仅只是使用消息队列功能，用于异步和业务模块解耦，对性能要求不是很高。rabbitMQ能满足现阶段需求)
2、如果系统使用消息队列的场景是处理在线业务(在线业务指的是那种服务于web页面或者APP的服务，这种服务都需要很低的延迟，否则APP就会很卡，体验不好)，比如在交易系统中用消息队列传递订单，那RocketMQ的低延迟和金融级的稳定性是你需要的。
3、如果需要处理海量的消息，想收集日志、监控信息或是前端埋点这类数据，或应用场景大量使用了大数据、流计算(做事后的统计分析)相关的开源产品，那kafka是最适合的。

### [系统架构引入消息中间件有什么缺点](https://mp.weixin.qq.com/s?__biz=MzU0OTk3ODQ3Ng==&mid=2247484157&idx=1&sn=f4644be2db6b1c230846cb4d62ae5be9&chksm=fba6eafeccd163e817b420d57478829d92251a6a5fd446f81805f0983a0d95cb6853a6735c4b&mpshare=1&scene=1&srcid=06083A6RVW3ZtKQRy6Ttq8tK%23rd)
1.消息中间件可能会挂掉，导致系统可用性降低
2.可能会丢消息，导致系统稳定性下降
3.可能带来分布式一致性问题

### 如何保证消息队列的高可用？
RabbitMQ  镜像集群模式，  其实类似于redis的哨兵模式，这种不能扩展。
kafka 天然的分布式消息队列。

### 如何保证消息的顺序性？
场景：
 RabbitMQ：一个 queue，多个 consumer。比如，生产者向 RabbitMQ 里发送了三条数据，顺序依次是 data1/data2/data3，
 压入的是 RabbitMQ 的一个内存队列。有三个消费者分别从 MQ 中消费这三条数据中的一条，结果消费者2先执行完操作，
 把 data2 存入数据库，然后是 data1/data3。这不明显乱了。
办法：
 拆分多个 queue，每个 queue 一个 consumer，就是多一些 queue 而已，确实是麻烦点；
 或者就一个 queue 但是对应一个 consumer，然后这个 consumer 内部用内存队列做排队，然后分发给底层不同的 worker 来处理。
 
 Kafka：比如说我们建了一个 topic，有三个 partition。生产者在写的时候，其实可以指定一个 key，
 比如说我们指定了某个订单 id 作为 key，那么这个订单相关的数据，一定会被分发到同一个 partition 中去，
 而且这个 partition 中的数据一定是有顺序的。
消费者从 partition 中取出来数据的时候，也一定是有顺序的。到这里，顺序还是 ok 的，没有错乱。
接着，我们在消费者里可能会搞多个线程来并发处理消息。因为如果消费者是单线程消费处理，而处理比较耗时的话，
比如处理一条消息耗时几十 ms，那么 1 秒钟只能处理几十条消息，这吞吐量太低了。而多个线程并发跑的话，顺序可能就乱掉了。
解决办法：
    一个 topic，一个 partition，一个 consumer，内部单线程消费，单线程吞吐量太低，一般不会用这个。
    写 N 个内存 queue，具有相同 key 的数据都到同一个内存 queue；然后对于 N 个线程，每个线程分别消费一个内存 queue 即可，这样就能保证顺序性。


### 大量消息在 mq 里积压了几个小时了还没解决

一般这个时候，只能临时紧急扩容了，具体操作步骤和思路如下：

先修复 consumer 的问题，确保其恢复消费速度，然后将现有 consumer 都停掉。
    新建一个 topic，partition 是原来的 10 倍，临时建立好原先 10 倍的 queue 数量。
    然后写一个临时的分发数据的 consumer 程序，这个程序部署上去消费积压的数据，消费之后不做耗时的处理，直接均匀轮询写入临时建立好的 10 倍数量的 queue。
    接着临时征用 10 倍的机器来部署 consumer，每一批 consumer 消费一个临时 queue 的数据。这种做法相当于是临时将 queue 资源和 consumer 资源扩大 10 倍，以正常的 10 倍速度来消费数据。
    等快速消费完积压数据之后，得恢复原先部署的架构，重新用原先的 consumer 机器来消费消息。

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



kafka用java NIO的byteBuffer保存消息   1.节省空间， 2.不用担心GC

### Kafka中的ISR、AR又代表什么？ISR的伸缩又指什么
ISR:In-Sync Replicas 副本同步队列
AR:Assigned Replicas 所有副本
ISR是由leader维护，follower从leader同步数据有一些延迟（包括延迟时间replica.lag.time.max.ms和延迟条数replica.lag.max.messages两个维度, 当前最新的版本0.10.x中只支持replica.lag.time.max.ms这个维度），任意一个超过阈值都会把follower剔除出ISR, 存入OSR（Outof-Sync Replicas）列表，新加入的follower也会先存放在OSR中。AR=ISR+OSR。

### kafka中的broker 是干什么的
broker 是消息的代理，Producers往Brokers里面的指定Topic中写消息，Consumers从Brokers里面拉取指定Topic的消息，然后进行业务处理，broker在中间起到一个代理保存消息的中转站。

### kafka follower如何与leader同步数据
Kafka的复制机制既不是完全的同步复制，也不是单纯的异步复制。完全同步复制要求All Alive Follower都复制完，
这条消息才会被认为commit，这种复制方式极大的影响了吞吐率。而异步复制方式下，Follower异步的从Leader复制数据，
数据只要被Leader写入log就被认为已经commit，这种情况下，如果leader挂掉，会丢失数据，
kafka使用ISR的方式很好的均衡了确保数据不丢失以及吞吐率。Follower可以批量的从Leader复制数据，
而且Leader充分利用磁盘顺序读以及send file(zero copy)机制，这样极大的提高复制性能，内部批量写磁盘，
大幅减少了Follower与Leader的消息量差。

### rabbitmq事务
![](https://img-blog.csdnimg.cn/20190526221909572.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3poYW5nY29uZ3lpNDIw,size_16,color_FFFFFF,t_70)
