
redis     incr（“reed”）表示reed+1
incrBy（"reed",5)  表示reed+5
decrBy  减
jedis.keys("*");  所有的key

jedis.lpush ()往lis里面加
lrange（）取出来
llen（）长度
lpop() 弹出
insert（）插入  after或者before某个元素  

jedis.hset("userKey","age",12);
jedis.hgetAll(userKey)
jedis.hget(userKey,"name");
jedis.hdel(userKey,"phone");
jedis.hexists(userKey,"age")是否存在
jedis.hkeys(userKey)取出所有的key
jedis.hvals(userKey)取出所有的value


set
jedis. smembers(likely) 查看有哪些成员
jedis.sunion()查交集
jedis.sdiff()   我有你没有
jedis.sinter() 查并集    应用：共同关注的好友
jedis.scard()  看有多少人


zset  有序的
排行榜
jedis.zrange()从低到高排序
jedis.zrevrange() 从高到低排序
jedis.zrangeByScoreWithScores() 

## caffeine
通常我们喜欢把cache放到redis里，可以把访问速度提升，但是redis也算是远程服务器，会有IO时间的开销，如果我们把缓存放在本地内存，
性能能进一步提升，这也就带出了二级缓存概念。有人说为什么不把cache直接放到本地，如果是单机没问题，但是集群环境下还是需要两级缓存的配合。



## 内存数据库优劣势有那些？

首先说明，nosql与内存数据库不是一回事哦。内存数据库是以内存为主要存储介质的数据库工具。由于内存的读写速度很快，因此内存数据库的最大特点就是性能好，速度快。由于内存在系统中是稀缺的资源，因此内存数据库的容量大小受物理内存的限制，因此我们这内存数据库中所管理的数据，通常只有热点或者高频数据（而不是全部数据）。而内存数据库也会被要求根据灵活的策略与磁盘数据库进行数据同步。
安全性的问题可以说是内存数据库最大的硬伤。因为内存本身有掉电丢失的天然缺陷。因此我们在使用内存数据库的时候，通常需要，提前对内存上的数据采取一些保护机制，比如备份，记录日志，热备或集群，与磁盘数据库同步等方式。

## [redis线程模型](https://blog.csdn.net/reed1991/article/details/101352104)
[select、poll、epoll之间的区别](https://blog.csdn.net/reed1991/article/details/53442946)


## redis单线程为何很快
1、完全基于内存，绝大部分请求是纯粹的内存操作，非常快速。数据存在内存中，类似于HashMap，HashMap的优势就是查找和操作的时间复杂度都是O(1)；
2、数据结构简单，对数据操作也简单，Redis中的数据结构是专门进行设计的；
3、采用单线程，避免了不必要的上下文切换和竞争条件，也不存在多进程或者多线程导致的切换而消耗 CPU，不用去考虑各种锁的问题，不存在加锁释放锁操作，没有因为可能出现死锁而导致的性能消耗；
4、使用多路I/O复用模型，非阻塞IO；
5、使用底层模型不同，它们之间底层实现方式以及与客户端之间通信的应用协议不一样，Redis直接自己构建了VM 机制 ，因为一般的系统调用系统函数的话，会浪费一定的时间去移动和请求；
以上几点都比较好理解，下边我们针对多路 I/O 复用模型进行简单的探讨：
（1）多路 I/O 复用模型
多路I/O复用模型是利用 select、poll、epoll 可以同时监察多个流的 I/O 事件的能力，在空闲的时候，会把当前线程阻塞掉，当有一个或多个流有 I/O 事件时，就从阻塞态中唤醒，于是程序就会轮询一遍所有的流（epoll 是只轮询那些真正发出了事件的流），并且只依次顺序的处理就绪的流，这种做法就避免了大量的无用操作。
这里“多路”指的是多个网络连接，“复用”指的是复用同一个线程。采用多路 I/O 复用技术可以让单个线程高效的处理多个连接请求（尽量减少网络 IO 的时间消耗），且 Redis 在内存中操作数据的速度非常快，也就是说内存内的操作不会成为影响Redis性能的瓶颈，主要由以上几点造就了 Redis 具有很高的吞吐量。


## [redis持久化](https://blog.csdn.net/reed1991/article/details/53123485)

## [如何处理redis集群中的hot Key](https://blog.csdn.net/reed1991/article/details/56956765)
其核心就是需要让请求尽量不要落在同一台机器上，要将其分散。
1、 产生一个随机值作为key的后缀，由key变成key_suffix。
2、 为了防止key在同一时间过期，过期时间也加个随机值设置成不一样
3、 当key失效时，可以data = redis.GET(bakHotKey)，先去hotKey上K拉取,拉取不到再去数据库查

redis 4.0添加了hotKey检测的功能。执行redis-cli时加上–hotkeys选项即可

## 如何保证数据库与缓存双写的一致性
最经典的缓存+数据库读写的模式，cache aside pattern

1、Cache Aside Pattern

（1）读的时候，先读缓存，缓存没有的话，那么就读数据库，然后取出数据后放入缓存，同时返回响应

（2）更新的时候，先删除缓存，然后再更新数据库

为什么是删除缓存，而不是更新缓存呢？
缓存可能涉及到很多字段的计算，如果是更新的话，每次update都要去更新，假设一个缓存涉及的表的字段，在1分钟修改了100次，
那么缓存更新100次，但是可能就读取了一次，出现大量的冷数据。
而采用删除的策略，在1分钟内不过是重新计算一次而已，开销大幅度降低。 其实这是一个lazy计算的思想，只有用到了才去计算。

先修改数据库，再删除缓存，如果删除缓存失败了怎么办？
解决思路：先删除缓存，再修改数据库。


