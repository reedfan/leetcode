### 1、nginx负载均衡策略有哪几种？
轮询              默认方式
weight           权重方式
ip_hash          依据ip分配方式
least_conn       最少连接方式
fair（第三方）     响应时间方式
url_hash（第三方） 依据URL分配方式
### 2、nginx怎么保证高可用？
可以用nginx+keepalived保证高可用。
