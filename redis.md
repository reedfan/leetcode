# Table of Contents

  * [redis五种数据结构的应用场景](#redis五种数据结构的应用场景)
  * [caffeine](#caffeine)
  * [假如Redis里面有1亿个key，其中有10w个key是以某个固定的已知的前缀开头的，如果将它们全部找出来？](#假如redis里面有1亿个key，其中有10w个key是以某个固定的已知的前缀开头的，如果将它们全部找出来？)
  * [redis的线程模型](#redis的线程模型)
  * [redis分布式锁](#redis分布式锁)
  * [redis事务的实现](#redis事务的实现)
  * [一致性hash](#一致性hash)
  * [redis的过期策略](#redis的过期策略)
  * [内存数据库优劣势有那些？](#内存数据库优劣势有那些？)
  * [[redis线程模型](https://blog.csdn.net/reed1991/article/details/101352104)](#[redis线程模型]httpsblogcsdnnetreed1991articledetails101352104)
  * [redis单线程为何很快](#redis单线程为何很快)
  * [[redis持久化](https://blog.csdn.net/reed1991/article/details/53123485)](#[redis持久化]httpsblogcsdnnetreed1991articledetails53123485)
  * [redis集群](#redis集群)
  * [使用过Redis做异步队列？](#使用过redis做异步队列？)
  * [[缓存穿透、缓存击穿、缓存雪崩](https://mp.weixin.qq.com/s?__biz=MzU0OTk3ODQ3Ng==&mid=2247484884&idx=1&sn=ceb798b6e8ef0ee608a992385f7d8568&chksm=fba6edd7ccd164c155271811f7948b476955cab41b23f2333847b8c268b31cc9f3332c2e3926&mpshare=1&scene=1&srcid=0608pIX1L8Fja1H99IyorW2X%23rd)](#[缓存穿透、缓存击穿、缓存雪崩]httpsmpweixinqqcoms__bizmzu0otk3odq3ngmid2247484884idx1snceb798b6e8ef0ee608a992385f7d8568chksmfba6edd7ccd164c155271811f7948b476955cab41b23f2333847b8c268b31cc9f3332c2e3926mpshare1scene1srcid0608pix1l8fja1h99iyorw2x23rd)
  * [[如何处理redis集群中的hot Key](https://blog.csdn.net/reed1991/article/details/56956765)](#[如何处理redis集群中的hot-key]httpsblogcsdnnetreed1991articledetails56956765)
  * [如何保证数据库与缓存双写的一致性](#如何保证数据库与缓存双写的一致性)



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

## redis五种数据结构的应用场景
1、String  KV缓存
2、hash 这个一般就是可以将结构化的数据，比如一个对象（前提是这个对象没嵌套其他的对象）给缓存在redis里，然后每次读写缓存的时候，可以就操作hash里的某个字段。   redis hash用法

key=150

value={

  “id”: 150,

  “name”: “zhangsan”,

  “age”: 20

}

hget 150：id   将返回150

list：有序集合，比如某个话题被哪些用户关注

set：无序集合，自动去重    比如两个话题的关注者的交集

sorted set：排序的set，可以用在排行榜
   

## caffeine
通常我们喜欢把cache放到redis里，可以把访问速度提升，但是redis也算是远程服务器，会有IO时间的开销，如果我们把缓存放在本地内存，
性能能进一步提升，这也就带出了二级缓存概念。有人说为什么不把cache直接放到本地，如果是单机没问题，但是集群环境下还是需要两级缓存的配合。

## 假如Redis里面有1亿个key，其中有10w个key是以某个固定的已知的前缀开头的，如果将它们全部找出来？
redis的单线程的。keys指令会导致线程阻塞一段时间，线上服务会停顿，直到指令执行完毕，服务才能恢复。这个时候可以使用scan指令，scan指令可以无阻塞的提取出指定模式的key列表，但是会有一定的重复概率，在客户端做一次去重就可以了，但是整体所花费的时间会比直接用keys指令长。
[Redis中的Scan命令的使用](https://www.cnblogs.com/wy123/p/10955153.html)

## redis的线程模型
![Image text](https://img-blog.csdnimg.cn/20190925111154217.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3JlZWQxOTkx,size_16,color_FFFFFF,t_70)
Redis基于Reactor模式开发了文件事件处理器
文件事件处理器使用I/O多路复用程序来同时监听多个套接字。当一个套接字准备好执行应答、写入、读取、关闭等操作时，就会产生一个事件。尽管多个文件事件可能并发的出现。
但I/O多路复用程序会将所有产生事件的套接字列入一个队列里。然后通过这个队列，以有序、同步、每次一个套接字的方式向文件事件分派器传送套接字。当上一个事件被处理完成后才会继续向文件事件分派器传送下一个套接字。

## redis分布式锁
先拿setnx来争抢锁，抢到之后，再用expire给锁加一个过期时间防止锁忘记了释放。这样万一expire之前进程crash，就会导致锁得不到释放。
我们可以使用set命令完成setnx和expire的操作，并且这种操作是原子操作。
set key value [EX seconds] [PX milliseconds] [NX|XX]
EX seconds：设置失效时长，单位秒
PX milliseconds：设置失效时长，单位毫秒
NX：key不存在时设置value，成功返回OK，失败返回(nil)
XX：key存在时设置value，成功返回OK，失败返回(nil)

案例：设置name=p7+，失效时长100s，不存在时设置
 set name p7+ ex 100 nx
[Redis的setnx命令如何设置key的失效时间（同时操作setnx和expire）](https://blog.csdn.net/qq_30038111/article/details/90696233)

## redis事务的实现

## 一致性hash
传统hash的缺陷：hash(object)%(N)变成hash(object)%(N-1)。假如新加一台机器或者减少一台机器全乱了。
一致性hash    多个HASH（服务器A的IP地址） %  2^32映射到一个环上。 然后缓存HASH（key） %  2^32，顺时针遇到哪个服务器就落在哪个服务器上。
优势：某个服务器挂了以后只会有少量的缓存失效。

解决哈希环的倾斜： 虚拟节点

redis cluster：hash slot算法。




## redis的过期策略
定期删除+惰性删除。
1.定期删除，指的是 redis 默认是每隔 100ms 就随机抽取一些设置了过期时间的 key，检查其是否过期，如果过期就删除。
为什么是抽取，而不是全部：全部的话数据量大会卡死。
2.惰性删除 定期删除可能会导致很多过期 key 到了时间并没有被删除掉，那咋整呢？所以就是惰性删除了。这就是说，在你获取某个 key 的时候，redis 会检查一下 ，这个 key 如果设置了过期时间那么是否过期了？如果过期了此时就会删除，不会给你返回任何东西。
惰性删除还是很多没删除的话就走淘汰机制

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
RDB持久化是将当前进程中的数据生成快照保存到硬盘
手动触发：save命令会阻塞Redis服务器进程，直到RDB文件创建完毕为止，在Redis服务器阻塞期间，服务器不能处理任何命令请求。（已基本被废弃，线上环境要杜绝save的使用）
而bgsave命令会创建一个子进程，由子进程来负责创建RDB文件，父进程(即Redis主进程)则继续处理请求。
自动触发：最常见的情况是在配置文件中通过save m n，指定当m秒内发生n次变化时，会触发bgsave。

AOF是将Redis执行的每次写命令记录到单独的日志文件中（有点像MySQL的binlog）；当Redis重启时再次执行AOF文件中的命令来恢复数据。

Redis服务器默认开启RDB，关闭AOF

RDB持久化
优点：RDB文件紧凑，体积小，网络传输快，适合全量复制；恢复速度比AOF快很多。当然，与AOF相比，RDB最重要的优点之一是对性能的影响相对较小。
缺点：RDB文件的致命缺点在于其数据快照的持久化方式决定了必然做不到实时持久化，而在数据越来越重要的今天，数据的大量丢失很多时候是无法接受的，因此AOF持久化成为主流。此外，RDB文件需要满足特定格式，兼容性差（如老版本的Redis不兼容新版本的RDB文件）。

AOF持久化

与RDB持久化相对应，AOF的优点在于支持秒级持久化、兼容性好，缺点是文件大、恢复速度慢、对性能影响大。

下面分场景来讨论持久化策略的选择，下面的讨论也只是作为参考，实际方案可能更复杂更具多样性。

（1）如果Redis中的数据完全丢弃也没有关系（如Redis完全用作DB层数据的cache），那么无论是单机，还是主从架构，都可以不进行任何持久化。

（2）在单机环境下（对于个人开发者，这种情况可能比较常见），如果可以接受十几分钟或更多的数据丢失，选择RDB对Redis的性能更加有利；如果只能接受秒级别的数据丢失，应该选择AOF。

（3）但在多数情况下，我们都会配置主从环境，slave的存在既可以实现数据的热备，也可以进行读写分离分担Redis读请求，以及在master宕掉后继续提供服务。

在这种情况下，一种可行的做法是：

master：完全关闭持久化（包括RDB和AOF），这样可以让master的性能达到最好

slave：关闭RDB，开启AOF（如果对数据安全要求不高，开启RDB关闭AOF也可以），并定时对持久化文件进行备份（如备份到其他文件夹，并标记好备份的时间）；然后关闭AOF的自动重写，然后添加定时任务，在每天Redis闲时（如凌晨12点）调用bgrewriteaof。
## redis集群
主从模式（master/slaver）：master读和写，slave读，  缺点：master挂了以后，redis就不能对外服务了。
Redis Sentinal着眼于高可用，在master宕机时会自动将slave提升为master，继续提供服务。
Redis Cluster着眼于扩展性，在单个redis内存不足时，使用Cluster进行分片存储。
## 使用过Redis做异步队列？

一般使用list结构作为队列，rpush生产消息，lpop消费消息。当lpop没有消息的时候，要适当sleep一会再重试。

如果对方追问可不可以不用sleep呢？list还有个指令叫blpop，在没有消息的时候，它会阻塞住直到消息到来。

如果对方追问能不能生产一次消费多次呢？使用pub/sub主题订阅者模式，可以实现1:N的消息队列。

如果对方追问pub/sub有什么缺点？在消费者下线的情况下，生产的消息会丢失，得使用专业的消息队列如rabbitmq等。

如果对方追问redis如何实现延时队列？使用sortedset，拿时间戳作为score，消息内容作为key调用zadd来生产消息，
消费者用zrangebyscore指令获取N秒之前的数据轮询进行处理。

## [缓存穿透、缓存击穿、缓存雪崩](https://mp.weixin.qq.com/s?__biz=MzU0OTk3ODQ3Ng==&mid=2247484884&idx=1&sn=ceb798b6e8ef0ee608a992385f7d8568&chksm=fba6edd7ccd164c155271811f7948b476955cab41b23f2333847b8c268b31cc9f3332c2e3926&mpshare=1&scene=1&srcid=0608pIX1L8Fja1H99IyorW2X%23rd)
缓存穿透：查一条根本不存在的数据：
解决办法，接口层增加校验，如用户鉴权校验，id做基础校验，id<=0的直接拦截；
查不到将相应的key缓存个null ，(适用范围：key有限的，重复率比较高）
如果大量的key不存在，先用布隆过滤器过滤一下

缓存击穿：大量的请求同时查询一个 key 时，此时这个key正好失效了，就会导致大量的请求都打到数据库上面去。这种现象我们称为缓存击穿。
处理措施：1.热点数据设置永不过期
2.加互斥锁，
 ```
 @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @Autowired
    private Jedis               jedis;
    private final String        MUTEX_KEY = "MUTEX_";

    public String getData(String key) throws InterruptedException {
        String value = stringRedisTemplate.opsForValue().get(key);
        //缓存失效
        if (StringUtils.isBlank(value)) {
            //设置分布式锁，只允许一个线程去查询DB，同时指定过期时间为1min，防止del操作失败，导致死锁，缓存过期无法加载DB数据
            if (tryLock(MUTEX_KEY + key, 60L)) {
                //从数据库查询数据,将查询的结果缓存起来
                value = getValueFromDB();
                stringRedisTemplate.opsForValue().set(key, value);

                //释放分布式锁
                stringRedisTemplate.delete(MUTEX_KEY + key);
            } else {
                //当锁被占用时，睡眠5s继续调用获取数据请求
                Thread.sleep(5000);
                getData(key);}
        }
        return value;
    }

    /**
     * redis实现分布式事务锁 尝试获取锁
     * 
     * @param lockName  锁
     * @param expireTime 过期时间
     * @return
     */
    public Boolean tryLock(String lockName, long expireTime) {
        //RedisCallback redis事务管理，将redis操作命令放到事务中处理，保证执行的原子性
        String result = stringRedisTemplate.opsForValue().getOperations().execute(new RedisCallback<String>() {

            /**
             * @param key 使用key来当锁，因为key是唯一的。
             * @param value 请求标识，可通过UUID.randomUUID().toString()生成,解锁时通value参数可识别出是哪个请求添加的锁
             * @param nx 表示SET IF NOT EXIST，即当key不存在时，我们进行set操作；若key已经存在，则不做任何操作
             * @param ex 表示过期时间的单位是秒
             * @param time 表示过期时间
             */
            @Override
            public String doInRedis(RedisConnection connection) throws DataAccessException {
                return jedis.set(lockName, UUID.randomUUID().toString(), "NX", "EX", expireTime);
            }
        });

        if ("OK".equals(result)) {
            return true;
        }
        return false;
    }

    public String getValueFromDB() {
        return "";
    }
 ```
 缓存雪崩：当某一时刻发生大规模的缓存失效的情况，比如你的缓存服务宕机了，会有大量的请求进来直接打到DB上面。结果就是DB 称不住，挂掉。
 
 1.使用redis集群缓存
 2.caffiene本地缓存，redis失效的时候，还能支撑一阵
 3.Hystrix进行限流 & 降级 ，比如一秒来了5000个请求，我们可以设置假设只能有一秒 2000个请求能通过这个组件，那么其他剩余的 3000 请求就会走限流逻辑。
 4.开启redis持久化机制，尽快恢复缓存集群
## [如何处理redis集群中的hot Key](https://blog.csdn.net/reed1991/article/details/56956765)
其核心就是需要让请求尽量不要落在同一台机器上，要将其分散。
1、 产生一个随机值作为key的后缀，由key变成key_suffix。
2、 为了防止key在同一时间过期，过期时间也加个随机值设置成不一样
3、 当key失效时，可以data = redis.GET(bakHotKey)，先去hotKey上K拉取,拉取不到再去数据库查
4. 也可以设置一个互斥锁

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


