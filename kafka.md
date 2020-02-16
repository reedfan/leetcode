# Table of Contents

  * [[系统架构中为什么要引入消息中间件](https://mp.weixin.qq.com/s?__biz=MzU0OTk3ODQ3Ng==&mid=2247484149&idx=1&sn=98186297335e13ec7222b3fd43cfae5a&chksm=fba6eaf6ccd163e0c2c3086daa725de224a97814d31e7b3f62dd3ec763b4abbb0689cc7565b0&mpshare=1&scene=1&srcid=0608fz8HKZvYxRhzFqyJ4Isq%23rd)](#[系统架构中为什么要引入消息中间件]httpsmpweixinqqcoms__bizmzu0otk3odq3ngmid2247484149idx1sn98186297335e13ec7222b3fd43cfae5achksmfba6eaf6ccd163e0c2c3086daa725de224a97814d31e7b3f62dd3ec763b4abbb0689cc7565b0mpshare1scene1srcid0608fz8hkzvyxrhzfqyj4isq23rd)
    * [如何选择消息队列](#如何选择消息队列)
    * [[系统架构引入消息中间件有什么缺点](https://mp.weixin.qq.com/s?__biz=MzU0OTk3ODQ3Ng==&mid=2247484157&idx=1&sn=f4644be2db6b1c230846cb4d62ae5be9&chksm=fba6eafeccd163e817b420d57478829d92251a6a5fd446f81805f0983a0d95cb6853a6735c4b&mpshare=1&scene=1&srcid=06083A6RVW3ZtKQRy6Ttq8tK%23rd)](#[系统架构引入消息中间件有什么缺点]httpsmpweixinqqcoms__bizmzu0otk3odq3ngmid2247484157idx1snf4644be2db6b1c230846cb4d62ae5be9chksmfba6eafeccd163e817b420d57478829d92251a6a5fd446f81805f0983a0d95cb6853a6735c4bmpshare1scene1srcid06083a6rvw3ztkqry6ttq8tk23rd)
    * [如何保证消息队列的高可用？](#如何保证消息队列的高可用？)
    * [如何保证消息的顺序性？](#如何保证消息的顺序性？)
    * [大量消息在 mq 里积压了几个小时了还没解决](#大量消息在-mq-里积压了几个小时了还没解决)
  * [[kafka](https://blog.csdn.net/reed1991/article/details/88729252)](#[kafka]httpsblogcsdnnetreed1991articledetails88729252)
    * [Kafka消息保证生产的信息不丢失](#kafka消息保证生产的信息不丢失)
    * [Kafka消息保证生产的信息不重复消费](#kafka消息保证生产的信息不重复消费)
  * [rabbitMQ](#rabbitmq)
    * [rabbitMQ消费者还没来得及消费消息就宕机了怎么办](#rabbitmq消费者还没来得及消费消息就宕机了怎么办)
    * [RabbitMQ暂时放在了自己的内存中，还没来得及投递给消费者，此时RabbitMQ突然宕机了，会怎么样？](#rabbitmq暂时放在了自己的内存中，还没来得及投递给消费者，此时rabbitmq突然宕机了，会怎么样？)
  * [生产者弄丢了数据](#生产者弄丢了数据)
  * [[如何保证消息不被重复消费](https://github.com/reedfan/Java-Interview-Advanced/blob/master/docs/high-concurrency/how-to-ensure-that-messages-are-not-repeatedly-consumed.md)](#[如何保证消息不被重复消费]httpsgithubcomreedfanjava-interview-advancedblobmasterdocshigh-concurrencyhow-to-ensure-that-messages-are-not-repeatedly-consumedmd)
    * [Kafka中的ISR、AR又代表什么？ISR的伸缩又指什么](#kafka中的isr、ar又代表什么？isr的伸缩又指什么)
    * [Kafka中的HW、LEO、LSO、LW等分别代表什么](#kafka中的hw、leo、lso、lw等分别代表什么)
    * [Kafka中的分区器、序列化器、拦截器是否了解？它们之间的处理顺序是什么？](#kafka中的分区器、序列化器、拦截器是否了解？它们之间的处理顺序是什么？)
    * [topic的分区数可不可以增加？如果可以怎么增加？如果不可以，那又是为什么？](#topic的分区数可不可以增加？如果可以怎么增加？如果不可以，那又是为什么？)
    * [topic的分区数可不可以减少？如果可以怎么减少？如果不可以，那又是为什么？#](#topic的分区数可不可以减少？如果可以怎么减少？如果不可以，那又是为什么？)
    * [kafka中的broker 是干什么的](#kafka中的broker-是干什么的)
    * [kafka follower如何与leader同步数据](#kafka-follower如何与leader同步数据)
    * [什么情况下一个 broker 会从 isr中踢出去](#什么情况下一个-broker-会从-isr中踢出去)
    * [有哪些情况可造成重复消费](#有哪些情况可造成重复消费)
    * [那些情景下会造成消息漏消费？](#那些情景下会造成消息漏消费？)
    * [kafka 为什么那么快](#kafka-为什么那么快)
    * [kafka producer 打数据，ack  为 0， 1， -1 的时候代表啥， 设置 -1 的时候，什么情况下，leader 会认为一条消息 commit了](#kafka-producer-打数据，ack--为-0，-1，--1-的时候代表啥，-设置--1-的时候，什么情况下，leader-会认为一条消息-commit了)
    * [如果leader crash时，ISR为空怎么办](#如果leader-crash时，isr为空怎么办)
    * [kafka  unclean 配置代表啥，会对 spark streaming 消费有什么影响](#kafka--unclean-配置代表啥，会对-spark-streaming-消费有什么影响)
    * [kafka中consumer group 是什么概念](#kafka中consumer-group-是什么概念)
    * [为什么Kafka不支持读写分离？](#为什么kafka不支持读写分离？)
    * [创建topic时如何选择合适的分区数？](#创建topic时如何选择合适的分区数？)
    * [rabbitmq事务](#rabbitmq事务)


## [系统架构中为什么要引入消息中间件](https://mp.weixin.qq.com/s?__biz=MzU0OTk3ODQ3Ng==&mid=2247484149&idx=1&sn=98186297335e13ec7222b3fd43cfae5a&chksm=fba6eaf6ccd163e0c2c3086daa725de224a97814d31e7b3f62dd3ec763b4abbb0689cc7565b0&mpshare=1&scene=1&srcid=0608fz8HKZvYxRhzFqyJ4Isq%23rd)
1.解耦  2.异步  3.削峰
健壮性：消息队列可以堆积请求，所以消费端业务即使短时间死掉，也不会影响主要业务的正常进行。

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
OSR （Out-of-Sync Replied）leader副本同步滞后过多的副本
AR = ISR + OSR。正常情况下，所有的follower副本都应该与leader 副本保持 一定程度的同步，即AR=ISR，OSR集合为空。
ISR的伸缩：
leader副本负责维护和跟踪 ISR 集合中所有follower副本的滞后状态，当follower副本落后太多或失效时，leader副本会把它从 ISR 集合中剔除。
如果 OSR 集合中所有follower副本“追上”了leader副本，那么leader副本会把它从 OSR 集合转移至 ISR 集合。默认情况下，
当leader副本发生故障时，只有在 ISR 集合中的follower副本才有资格被选举为新的leader，而在 OSR 集合中的副本则没有任何机会

###  Kafka中的HW、LEO、LSO、LW等分别代表什么

![](https://img2018.cnblogs.com/blog/1024146/201909/1024146-20190908144603190-691225277.png)
LEO （Log End Offset），标识当前日志文件中下一条待写入的消息的offset。上图中offset为9的位置即为当前日志文件的 LEO，LEO 的大小相当于当前日志分区中最后一条消息的offset值加1.
分区 ISR 集合中的每个副本都会维护自身的 LEO ，而 ISR 集合中最小的 LEO 即为分区的 HW，对消费者而言只能消费 HW 之前的消息。
HW （High Watermark）俗称高水位，它标识了一个特定的消息偏移量（offset），消费者只能拉取到这个offset之前的消息。

### Kafka中的分区器、序列化器、拦截器是否了解？它们之间的处理顺序是什么？

序列化器：生产者需要用序列化器（Serializer）把对象转换成字节数组才能通过网络发送给 Kafka。而在对侧，消费者需要用反序列化器（Deserializer）把从 Kafka 中收到的字节数组转换成相应的对象。
分区器：分区器的作用就是为消息分配分区。如果消息 ProducerRecord 中没有指定 partition 字段，那么就需要依赖分区器，根据 key 这个字段来计算 partition 的值。
Kafka 一共有两种拦截器：生产者拦截器和消费者拦截器。
  生产者拦截器既可以用来在消息发送前做一些准备工作，比如按照某个规则过滤不符合要求的消息、修改消息的内容等，也可以用来在发送回调逻辑前做一些定制化的需求，比如统计类工作。
  消费者拦截器主要在消费到消息或在提交消费位移时进行一些定制化的操作。
消息在通过 send() 方法发往 broker 的过程中，有可能需要经过拦截器（Interceptor）、序列化器（Serializer）和分区器（Partitioner）的一系列作用之后才能被真正地发往 broker。拦截器（下一章会详细介绍）一般不是必需的，而序列化器是必需的。消息经过序列化之后就需要确定它发往的分区，如果消息 ProducerRecord 中指定了 partition 字段，那么就不需要分区器的作用，因为 partition 代表的就是所要发往的分区号。

处理顺序 ：拦截器->序列化器->分区器
KafkaProducer 在将消息序列化和计算分区之前会调用生产者拦截器的 onSend() 方法来对消息进行相应的定制化操作。
然后生产者需要用序列化器（Serializer）把对象转换成字节数组才能通过网络发送给 Kafka。
最后可能会被发往分区器为消息分配分区。

### topic的分区数可不可以增加？如果可以怎么增加？如果不可以，那又是为什么？

可以增加，使用 kafka-topics 脚本，结合 --alter 参数来增加某个主题的分区数，命令如下：
bin/kafka-topics.sh --bootstrap-server broker_host:port --alter --topic <topic_name> --partitions <新分区数>
当分区数增加时，就会触发订阅该主题的所有 Group 开启 Rebalance。
首先，Rebalance 过程对 Consumer Group 消费过程有极大的影响。在 Rebalance 过程中，所有 Consumer 实例都会停止消费，等待 Rebalance 完成。这是 Rebalance 为人诟病的一个方面。
其次，目前 Rebalance 的设计是所有 Consumer 实例共同参与，全部重新分配所有分区。其实更高效的做法是尽量减少分配方案的变动。
最后，Rebalance 实在是太慢了。
### topic的分区数可不可以减少？如果可以怎么减少？如果不可以，那又是为什么？#

不支持，因为删除的分区中的消息不好处理。如果直接存储到现有分区的尾部，消息的时间戳就不会递增，如此对于 Spark、Flink 这类需要消息时间戳（事件时间）的组件将会受到影响；如果分散插入现有的分区，那么在消息量很大的时候，内部的数据复制会占用很大的资源，而且在复制期间，此主题的可用性又如何得到保障？与此同时，顺序性问题、事务性问题，以及分区和副本的状态机切换问题都是不得不面对的。
### kafka中的broker 是干什么的
broker 是消息的代理，Producers往Brokers里面的指定Topic中写消息，Consumers从Brokers里面拉取指定Topic的消息，然后进行业务处理，broker在中间起到一个代理保存消息的中转站。

### kafka follower如何与leader同步数据
Kafka的复制机制既不是完全的同步复制，也不是单纯的异步复制。完全同步复制要求All Alive Follower都复制完，
这条消息才会被认为commit，这种复制方式极大的影响了吞吐率。而异步复制方式下，Follower异步的从Leader复制数据，
数据只要被Leader写入log就被认为已经commit，这种情况下，如果leader挂掉，会丢失数据，
kafka使用ISR的方式很好的均衡了确保数据不丢失以及吞吐率。Follower可以批量的从Leader复制数据，
而且Leader充分利用磁盘顺序读以及send file(zero copy)机制，这样极大的提高复制性能，内部批量写磁盘，
大幅减少了Follower与Leader的消息量差。

### 什么情况下一个 broker 会从 isr中踢出去
leader会维护一个与其基本保持同步的Replica列表，该列表称为ISR(in-sync Replica)，每个Partition都会有一个ISR，
而且是由leader动态维护 ，如果一个follower比一个leader落后太多，或者超过一定时间未发起数据复制请求，
则leader将其重ISR中移除 。

### 有哪些情况可造成重复消费

   1、Rebalance
    一个consumer正在消费一个分区的一条消息，还没有消费完，发生了rebalance(加入了一个consumer)，从而导致这条消息没有消费成功，rebalance后，另一个consumer又把这条消息消费一遍。
   2、消费者端手动提交
    如果先消费消息，再更新offset位置，导致消息重复消费。
   3、 消费者端自动提交
    设置offset为自动提交，关闭kafka时，如果在close之前，调用 consumer.unsubscribe() 则有可能部分offset没提交，下次重启会重复消费。
   4、 生产者端
    生产者因为业务问题导致的宕机，在重启之后可能数据会重发

### 那些情景下会造成消息漏消费？

    1、自动提交
    设置offset为自动定时提交，当offset被自动定时提交时，数据还在内存中未处理，此时刚好把线程kill掉，那么offset已经提交，但是数据未处理，导致这部分内存中的数据丢失。
    2、生产者发送消息
    发送消息设置的是fire-and-forget（发后即忘），它只管往 Kafka 中发送消息而并不关心消息是否正确到达。不过在某些时候（比如发生不可重试异常时）会造成消息的丢失。这种发送方式的性能最高，可靠性也最差。
    3、消费者端
    先提交位移，但是消息还没消费完就宕机了，造成了消息没有被消费。自动位移提交同理
    4、acks没有设置为all
    如果在broker还没把消息同步到其他broker的时候宕机了，那么消息将会丢失


### kafka 为什么那么快
Cache Filesystem Cache PageCache缓存
顺序写 由于现代的操作系统提供了预读和写技术，磁盘的顺序写大多数情况下比随机写内存还要快。
Zero-copy 零拷技术减少拷贝次数  （是指计算机在网络上发送文件时，不需要将文件内容拷贝到用户空间（User Space）而直接在内核空间（Kernel Space）中传输到网络的方式）

Batching of Messages 批量量处理。合并小的请求，然后以流的方式进行交互，直顶网络上限。
Pull 拉模式 使用拉模式进行消息的获取消费，与消费端处理能力相符。


### kafka producer 打数据，ack  为 0， 1， -1 的时候代表啥， 设置 -1 的时候，什么情况下，leader 会认为一条消息 commit了
1（默认）  数据发送到Kafka后，经过leader成功接收消息的的确认，就算是发送成功了。在这种情况下，如果leader宕机了，则会丢失数据。
0 生产者将数据发送出去就不管了，不去等待任何返回。这种情况下数据传输效率最高，但是数据可靠性确是最低的。
-1 producer需要等待ISR中的所有follower都确认接收到数据后才算一次发送完成，可靠性最高。当ISR中所有Replica都向Leader发送ACK时，leader才commit，这时候producer才能认为一个请求中的消息都commit了。

### 如果leader crash时，ISR为空怎么办
kafka在Broker端提供了一个配置参数：unclean.leader.election,这个参数有两个值：
true（默认）：允许不同步副本成为leader，由于不同步副本的消息较为滞后，此时成为leader，可能会出现消息不一致的情况。
false：不允许不同步副本成为leader，此时如果发生ISR列表为空，会一直等待旧leader恢复，降低了可用性。

### kafka  unclean 配置代表啥，会对 spark streaming 消费有什么影响
unclean.leader.election.enable 为true的话，意味着非ISR集合的broker 也可以参与选举，这样有可能就会丢数据，
spark streaming在消费过程中拿到的 end offset 会突然变小，导致 spark streaming job挂掉。
如果unclean.leader.election.enable参数设置为true，就有可能发生数据丢失和数据不一致的情况，
Kafka的可靠性就会降低；而如果unclean.leader.election.enable参数设置为false，Kafka的可用性就会降低。

### kafka中consumer group 是什么概念
同样是逻辑上的概念，是Kafka实现单播和广播两种消息模型的手段。同一个topic的数据，会广播给不同的group；
同一个group中的worker，只有一个worker能拿到这个数据。换句话说，对于同一个topic，每个group都可以拿到同样的所有数据，
但是数据进入group后只能被其中的一个worker消费。group内的worker可以使用多线程或多进程来实现，
也可以将进程分散在多台机器上，worker的数量通常不超过partition的数量，且二者最好保持整数倍关系，
因为Kafka在设计时假定了一个partition只能被一个worker消费（同一group内）。

### 为什么Kafka不支持读写分离？
在 Kafka 中，生产者写入消息、消费者读取消息的操作都是与 leader 副本进行交互的，从 而实现的是一种主写主读的生产消费模型。
Kafka 并不支持主写从读，因为主写从读有 2 个很明 显的缺点:
(1)数据一致性问题。数据从主节点转到从节点必然会有一个延时的时间窗口，这个时间 窗口会导致主从节点之间的数据不一致。某一时刻，在主节点和从节点中 A 数据的值都为 X， 之后将主节点中 A 的值修改为 Y，那么在这个变更通知到从节点之前，应用读取从节点中的 A 数据的值并不为最新的 Y，由此便产生了数据不一致的问题。
(2)延时问题。类似 Redis 这种组件，数据从写入主节点到同步至从节点中的过程需要经 历网络→主节点内存→网络→从节点内存这几个阶段，整个过程会耗费一定的时间。而在 Kafka 中，主从同步会比 Redis 更加耗时，它需要经历网络→主节点内存→主节点磁盘→网络→从节 点内存→从节点磁盘这几个阶段。对延时敏感的应用而言，主写从读的功能并不太适用。

### 创建topic时如何选择合适的分区数？

根据集群的机器数量和需要的吞吐量来决定适合的分区数。可以先做实验动态调整
### rabbitmq事务
![](https://img-blog.csdnimg.cn/20190526221909572.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3poYW5nY29uZ3lpNDIw,size_16,color_FFFFFF,t_70)


每一个分区只能被一个消费组中的一 个消费者所消费 。

KafkaConsumer怎么样实现多线程消费?
