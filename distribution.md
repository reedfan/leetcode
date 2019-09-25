
## [kafka](https://blog.csdn.net/reed1991/article/details/88729252)

## [zookeeper](https://blog.csdn.net/reed1991/article/details/53811504)

## [Dubbo](https://blog.csdn.net/reed1991/article/details/86185091)


## 分布式锁相关
zk实现分布式锁使用的是零时顺序节点
zk实现分布式锁说白了就是看看自己创建的节点序号是否最小 最小则获得分布式锁 否则继续监听

redis实现分布式锁的性能更好，redis是纯内存服务。
 zk的可靠性更好
 
## [分布式事物的几种解决方案](https://blog.csdn.net/reed1991/article/details/58128053)