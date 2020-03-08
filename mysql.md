# Table of Contents

  * [Select执行顺序](#select执行顺序)
  * [四种索引](#四种索引)
  * [myIsam与Innodb](#myisam与innodb)
  * [如何选择](#如何选择)
    * [为什么myisam的select比innodb要快？](#为什么myisam的select比innodb要快？)
  * [聚集索引和非聚集索引](#聚集索引和非聚集索引)
  * [mysql回表](#mysql回表)
  * [覆盖索引（covering index）](#覆盖索引（covering-index）)
  * [索引的使用](#索引的使用)
    * [通过修改表结构创建索引](#通过修改表结构创建索引)
    * [创建表时直接指定索引](#创建表时直接指定索引)
  * [删除索引](#删除索引)
  * [什么时候不能使用索引](#什么时候不能使用索引)
  * [组合索引的优势](#组合索引的优势)
    * [覆盖索引](#覆盖索引)
  * [数据库优化（也叫mysql大表优化）](#数据库优化（也叫mysql大表优化）)
  * [数据库的三大范式](#数据库的三大范式)
  * [数据库ACID](#数据库acid)
    * [[ACID特性的实现原理](https://blog.csdn.net/reed1991/article/details/53446864)](#[acid特性的实现原理]httpsblogcsdnnetreed1991articledetails53446864)
  * [数据库隔离级别](#数据库隔离级别)
    * [[深入理解mysql四种隔离级别及底层实现原理（MVCC和锁）](https://blog.csdn.net/reed1991/article/details/99713045)](#[深入理解mysql四种隔离级别及底层实现原理（mvcc和锁）]httpsblogcsdnnetreed1991articledetails99713045)
  * [为什么B+树适合做索引](#为什么b树适合做索引)
      * [[InnoDB一棵B+树可以存放多少行数据？](https://www.cnblogs.com/leefreeman/p/8315844.html)innodb索引一页大小设置](#[innodb一棵b树可以存放多少行数据？]httpswwwcnblogscomleefreemanp8315844htmlinnodb索引一页大小设置)
  * [innodb为什么索引默认大小为16k](#innodb为什么索引默认大小为16k)
  * [explain](#explain)
  * [Mysql主从复制](#mysql主从复制)
  * [Left join  right join  inner join](#left-join--right-join--inner-join)
  * [MyIsam和InnerDb](#myisam和innerdb)
  * [数据库调优思路](#数据库调优思路)
  * [小表驱动大表](#小表驱动大表)
  * [exists](#exists)
  * [[彻底搞清楚分布式数据库](https://blog.csdn.net/reed1991/article/details/101206871)](#[彻底搞清楚分布式数据库]httpsblogcsdnnetreed1991articledetails101206871)
  * [[数据库分库分表](https://blog.csdn.net/reed1991/article/details/53144000)](#[数据库分库分表]httpsblogcsdnnetreed1991articledetails53144000)


## Select执行顺序

Where，group by，having，order by

1.显示学生姓名和平均分

Select  s_name, avg(score) from student

Where score >= 60 group by s_name having (s_score)>=70  order by avg(s_score) desc
## 四种索引


1.主键索引不允许空值，唯一索引允许空值，一张表中只能有一个主键索引

2.唯一索引允许一个空值，一个表中可以有多个唯一索引。

3.非唯一索引

4.组合索引：多列值组成一个索引，专门用于组合搜索，其效率大于索引合并

ps.
聚集索引：在聚集索引中，表中行的物理顺序与键值的逻辑（索引）顺序相同
前缀索引：有时候需要索引很长的字符(例如BLOB,TEXT,或者很长的VARCHAR)，这样会使得索引又大又慢。
改良方法：使用字符串的前几个字符作为索引(即前缀索引)
前缀索引的缺点：MySQL中无法使用前缀索引进行ORDER BY和GROUP BY，也无法用来进行覆盖扫描
 
聚集索引和非聚集索引的根本区别是表记录的排列顺序和与索引的排列顺序是否一致。

## myIsam与Innodb
1、InnoDB支持事务，MyISAM不支持
2、InnoDB是聚集索引， MyISAM是非聚集索引
3、InnoDB支持表、行(默认)级锁，而MyISAM支持表级锁
4、InnoDB表必须有主键（用户没有指定的话会自己找或生产一个主键），而Myisam可以没有
5、Innodb存储文件有frm、ibd，而Myisam是frm、MYD、MYI

## 如何选择
1. 是否要支持事务，如果要请选择innodb，如果不需要可以考虑MyISAM；
2. 如果表中绝大多数都只是读查询，可以考虑MyISAM，如果既有读也有写，请使用InnoDB。
3. 系统奔溃后，MyISAM恢复起来更困难，能否接受；
4. MySQL5.5版本开始Innodb已经成为Mysql的默认引擎(之前是MyISAM)，说明其优势是有目共睹的，如果你不知道用什么，那就用InnoDB，至少不会差。

### 为什么myisam的select比innodb要快？
(innoDB用的聚簇索引，myisam用的非聚簇索引。聚簇索引将数据存储与索引放到了一块，非聚簇索引将数据存储于索引分开结构，索引结构的叶子节点指向了数据的对应行）
1）数据块，INNODB要缓存，MYISAM只缓存索引块，这中间还有换进换出的减少；
2）innodb寻址要映射到块，再到行，MYISAM记录的直接是文件的OFFSET，定位比INNODB要快
3）INNODB还需要维护MVCC一致；虽然你的场景没有，但他还是需要去检查和维护


## 聚集索引和非聚集索引
主键索引的叶子节点存的是整行数据。在 InnoDB 里，主键索引也被称为聚集索引（clustered index）。

非主键索引的叶子节点内容是主键的值。在 InnoDB 里，非主键索引也被称为二级索引（secondary index）。


如果语句是 select * from T where ID=500，即 主键查询方式，则只需要搜索 ID 这棵 B+树 ；

如果语句是 select * from T where k=5，即 普通索引查询方式，则需要先搜索 k 索引树，得到 ID的值为 500，再到 ID 索引树搜索一次。这个过程称为回表 
## mysql回表
简单来说就是数据库根据索引（非主键）找到了指定记录所在行后，还需要根据主键再次到数据库里获取数据。
## 覆盖索引（covering index）
指一个查询语句的执行只用从索引中就能够取得，不必从数据表中读取。也可以称之为实现了索引覆盖。 
当一条查询语句符合覆盖索引条件时，MySQL只需要通过索引就可以返回查询所需要的数据，这样避免了查到索引后再返回表操作，
减少I/O提高效率。 如，表covering_index_sample中有一个普通索引 idx_key1_key2(key1,key2)。
当我们通过SQL语句：select key2 from covering_index_sample where key1 = ‘keytest’;的时候，
就可以通过覆盖索引查询，无需回表。



## 索引的使用
创建普通索引CREATE INDEX index_name ON table_name(col_name);
创建唯一索引CREATE UNIQUE INDEX index_name ON table_name(col_name);
创建普通组合索引CREATE INDEX index_name ON table_name(col_name_1,col_name_2);
创建唯一组合索引CREATE UNIQUE INDEX index_name ON table_name(col_name_1,col_name_2);

### 通过修改表结构创建索引
ALTER TABLE table_name ADD INDEX index_name(col_name);

### 创建表时直接指定索引
CREATE TABLE table_name (ID INT NOT NULL,col_name VARCHAR (16) NOT NULL,INDEX index_name (col_name));

## 删除索引
直接删除索引DROP INDEX index_name ON table_name;
修改表结构删除索引ALTER TABLE table_name DROP INDEX index_name;

什么时候使用聚集索引？

（1）含有大量非重复值的列

（2）使用Between 大于等返回一个范围的列

（3）连续被访问的列

（4）返回大型结果集的查询

## 什么时候不能使用索引 
不要给选择率低的字段建索引(通过索引扫描的记录数超过30%，变成全表扫描)
联合索引中:第一个索引列使用范围查询,第一个查询条件不是最左索引列 
Like查询条件列最左以通配符% 开始 
两个独立索引，其中一个用于检索，一个用于排序（索引不是越多越好，尽量合并索引） 表关联字段类型不一样（也包括长度不一样）
索引字段条件上使用函数

## 组合索引的优势
多个单列索引在多条件查询时优化器会选择最优索引策略，可能只用一个索引，也可能将多个索引全用上！ 
但多个单列索引底层会建立多个B+索引树，比较占用空间，也会浪费一定搜索效率，故如果只有多条件联合查询时最好建联合索引！

### 覆盖索引
如果一个索引包含(或覆盖)所有需要查询的字段的值，称为‘覆盖索引’。即只需扫描索引而无须回表。

## 数据库优化（也叫mysql大表优化）

1.where及order by涉及的列上建索引

2.尽量避免在where字句中对字段进行null值判断，否则将导致放弃使用索引

  Select id from t where num is null，可以在null上设置默认值0，确保num列没有null，然后select id from t where num = 0，

3.尽量避免在null字句中用！=或者>或者<操作符。

4.尽量避免在where字句中使用or来连接，如果一个字段有索引，一个字段没索引，将导致引擎放弃索引而进行全表扫描。

 select id from t where num=10 or Name = 'admin'  可优化为

select id from t where num = 10 union all select id from t where Name = 'admin'

5.in和not in也要慎用，

  select id from t where num in(1,2,3)应改为

  select id from t where num between 1 and 3

6 尽量避免在 where子句中对字段进行表达式操作

select id from t where num/2 = 100，应该为

select id from t where num = 100*2

7.应尽量避免在where子句中对字段进行函数操作

select id from t where substring(name,1,3) = ’abc’可以改为

select id from t where name like 'abc%'  注：like aa% 和 > < 这种有一点区别   like这种后面的索引并不失效
Limit千万级别的优化

limit千万级别优化，不直接使用limit，而是首先获取offset的id然后直接使用mysql limit size来获取数据

1）在我们平时使用limit 如 select * from A order by id limit 1,10; 这样在表数据很少的时候，看不出什么性能问题，
倘若达到千万级，如 select * from A order by ID limit 10000000，10； 虽然都是只查询10记录，但是这个性能让人受不了， 
2）可以这么优化，如 select * from A where id>=(select id from a limit 10000000,1)limit 10; 
其实还可以这么写 Select * from A where id between 10000000 and 10000010

 
## 数据库的三大范式

1,第一范式：字段的原子性，每一列都是不可分割的原子数据项

2.第二范式：确保表中的每列都和主键相关

产品编号与订单号并没有直接的关系

3.第三范式：任何非主属性不依赖于其他非主属性

上面的表，学号和姓名存在传递依赖，因为(学号，姓名)->成绩，学号->成绩，姓名->成绩。所以学号和姓名有一个冗余了，只需要保留一个。
数据库四种隔离级别


## 数据库ACID

A(Atomicity)原子性:数据库中事物执行的是原子操作,即不可再分,要么全部执行,要么全部不执行.

C(consistency)一致性: 只有合法的数据可以被写入数据库，否则事务应该将其回滚到最初状态。拿转账来说，假设用户A和用户B两者的钱加起来一共是5000，那么不管A和B之间如何转账，转几次，事务结束后两个用户的钱加起来应该还是5000，这就是事务的一致性。

I(Isolation)隔离性 事务的执行是互不干扰的,一个事务不可能看到其他事务运行中的某一刻的状态.

D(Durability)持久性 意味着事务完成以后,该事务对数据库所做的更改便持久的保持在数据库中.

### [ACID特性的实现原理](https://blog.csdn.net/reed1991/article/details/53446864)
 
## 数据库隔离级别
读未提交  脏读    不可重复读     幻读

读已提交         不可重复读      幻读

可重复读                       幻读

可串行化
mysql 可重复读，  大多数数据库默认隔离级别为读已提交
 

脏读：一个数据对事务进行了修改，但事务还没有提交。另一个事务可以“看到”

该事务没有提交的更新结果，如果第一个事务回滚，第二个事务在此之前看到的就是一笔脏数据

 

不可重复读：同一个事务在整个过程中对同一笔数据进行读取，每次读取结果都不同。如果事务1在事务2的更新操作之前读取一次数据，在事务2的更新操作之后再次读取同一笔数据数据，两次结果是不同的.

假如A在取款机前取款，读到银行卡余额为5000，此时他老婆拿银行卡消费了2000元，结果他想取5000元显示余额不足。。。。

 

幻读针对的是多笔记录（针对其提交前后，读取数据条数的对比）

解决了不重复读，保证了同一个事务里，查询的结果都是事务开始时的状态（一致性）。但是，如果另一个事务同时提交了新数据，

本事务再更新时，就会“惊奇的”发现了这些新数据，貌似之前读到的数据是“鬼影”一样的幻觉。

 

读未提交：读操作不加锁，写操作加排他锁（排它锁能阻止其它事务再对其锁定的数据加读或写的锁，但是对不加锁的读就不起作用了。）

读提交：写数据时，使用排它锁, 读取数据不加锁而是使用了MVCC机制。

在读已提交的级别下，都会通过MVCC获取当前数据的最新快照，不加任何锁。

存在的问题：在每次select之间有其他事务更新了我们读取的数据并提交了，那就出现了不可重复读。

可重复读：MVCC版本的生成时机，即：一次事务中只在第一次select时生成版本，后续的查询都是在这个版本上进行，从而实现了可重复读

串行化：该级别下，会自动将所有普通select转化为select ... lock in share mode执行，即针对同一数据的所有读写都变成互斥的了，可靠性大大提高，并发性大大降低。

![详细介绍请参考此文](https://blog.csdn.net/reed1991/article/details/99713045)

### [深入理解mysql四种隔离级别及底层实现原理（MVCC和锁）](https://blog.csdn.net/reed1991/article/details/99713045)

## 为什么B+树适合做索引

B树和B+树的区别：

B树，每个节点都存储key和data，所有节点组成这棵树，并且叶子节点指针为null，叶子结点不包含任何关键字信息。

B+树，所有的叶子结点中包含了全部关键字的信息，及指向含有这些关键字记录的指针，且叶子结点本身依关键字的大小自小而大的顺序链接，所有的非终端结点可以看成是索引部分，结点中仅含有其子树根结点中最大（或最小）关键字。 (而B 树的非终节点也包含需要查找的有效信息)


1.索引很大，不可能全部存储在内存，往往以索引文件的形式存储在磁盘

2.索引查找过程产生磁盘I/O消耗，评价一个数据结构作为索引的优劣的重要指标就是尽量减少磁盘I/O

B+树的数据只存储在叶子结点，在B-树的基础上每个节点存储的关键字更多，数的层级更少所以查询数据更快。

所有关键字都存储在叶子结点，所以每次查找的次数相同所以查询效率更稳定。

#### [InnoDB一棵B+树可以存放多少行数据？](https://www.cnblogs.com/leefreeman/p/8315844.html)innodb索引一页大小设置

## innodb为什么索引默认大小为16k
因为文件系统一个块的大小为4K，所以理论上设置索引页的大小为2K的倍数不会产生内存碎片，而16K能满足大多数row

## explain

通过explain可以知道mysql如何处理语句，分析出查询或是表结构的性能瓶颈。通过explain可以得到

1.表的读取顺序

2.那些索引可以被引用

3.哪些索引可以被实际引用

4.表之间的引用

5.每张表有多少行被优化器查询。

 
## Mysql主从复制

Mysql之间数据复制的基础是二进制文件（binary log file）。一台mysql数据库一旦启用二进制日志后，其作为mater，它的数据库中所有操作都会以“事件”的方式记录在二进制日志中，其他数据库作为slave通过一个I/O线程与主服务器保持通信，并监控master二进制日志文件的变化，如果发现master二进制日志文件发生变化，则会把变化复制到自己的后继日志中，然后slave的一个SQL线程会把相关的“事件”执行到自己的数据库中，以实现从数据库和主数据库的一致性，也就实现了主从复制。
## Left join  right join  inner join

Left join以左边的表作为基础，右边的表与左边的表能匹配的就匹配出来

Right join以右边的表为基础，左边的表与右边的表能匹配的就匹配出来

Inner join显示符合条件的记录

Select * from A right join B on A.id = B.id

内连接和外连接

内连接：只有两个表相匹配的行才在表中显现出来

外链接：包含表中的所有数据

## MyIsam和InnerDb

MyISAM类型不支持事务处理等高级处理，而InnoDB类型支持。MyISAM类型的表强调的是性能，其执行数度比InnoDB类型更快，但是不提供事务支持，而InnoDB提供事务支持以及外部键等高级数据库功能。

MyIsam是表级锁，InnoDB是行级锁和表级锁都可以

 

对于MyISAM的表锁，主要讨论了以下几点：

（1）共享读锁（S）之间是兼容的，但共享读锁（S）与排他写锁（X）之间，以及排他写锁（X）之间是互斥的，也就是说读和写是串行的。

（2）在一定条件下，MyISAM允许查询和插入并发执行，我们可以利用这一点来解决应用中对同一表查询和插入的锁争用问题。

  lock table table_name read local

  当concurrent_insert设置为0时，不允许并发插入,设置为1时（默认为1），表中无空洞，可以在表尾插入。置位2时，无论有没有空洞，都可在表尾插入

（3）MyISAM默认的锁调度机制是写优先，这并不一定适合所有应用，用户可以通过设置LOW_PRIORITY_UPDATES参数，或在INSERT、UPDATE、DELETE语句中指定LOW_PRIORITY选项来调节读写锁的争用。

（4）由于表锁的锁定粒度大，读写之间又是串行的，因此，如果更新操作较多，MyISAM表可能会出现严重的锁等待，可以考虑采用InnoDB表来减少锁冲突。

 为什么要有意向排它锁
比如删除某张表的时候，只需要检查表上是否有意向排他锁，不需要去检查每一行

对于InnoDB表，本文主要讨论了以下几项内容：

（1）InnoDB的行锁是基于索引实现的，如果不通过索引访问数据，InnoDB会使用表锁。

（2）介绍了InnoDB间隙锁（Next-key)机制，以及InnoDB使用间隙锁的原因。

在不同的隔离级别下，InnoDB的锁机制和一致性读策略不同。

 

在了解InnoDB锁特性后，用户可以通过设计和SQL调整等措施减少锁冲突和死锁，包括：

 

尽量使用较低的隔离级别； 精心设计索引，并尽量使用索引访问数据，使加锁更精确，从而减少锁冲突的机会；

选择合理的事务大小，小事务发生锁冲突的几率也更小；

 给记录集显式加锁时，最好一次性请求足够级别的锁。比如要修改数据的话，最好直接申请排他锁，而不是先申请共享锁，修改时再请求排他锁，这样容易产生死锁；

 不同的程序访问一组表时，应尽量约定以相同的顺序访问各表，对一个表而言，尽可能以固定的顺序存取表中的行。这样可以大大减少死锁的机会；

尽量用相等条件访问数据，这样可以避免间隙锁对并发插入的影响； 不要申请超过实际需要的锁级别；除非必须，查询时不要显示加锁；

 对于一些特定的事务，可以使用表锁来提高处理速度或减少死锁的可能。
 
 
## 数据库调优思路
1.慢查询的开启并捕获
2.explain+慢sql分析
3.show profile查询sql在mysql服务器里面的执行细节和生命周期情况
4.sql数据库服务器的参数调优

## 小表驱动大表
优化原则：小表驱动大表
select * from A where id in (select id from B)等价于
for select id from B
for select * from A where A.id = B.id
当B表的数据集必须小于A表的数据集时，用in优于exists


select * from A where exists (select 1 from B where B.id = A.id)等价于
for select id from A
for select * from B where B.id = A.id
当A表的数据集必须小于B表的数据集时，用exists优于in

## exists
select ... from table where exists (subquery)
该语法可以理解为： 将主查询的数据，放到子查询中做条件验证，根据验证结果(TRUE或FALSE)来决定主查询的数据是否得以保留。

## [彻底搞清楚分布式数据库](https://blog.csdn.net/reed1991/article/details/101206871)


## [数据库分库分表](https://blog.csdn.net/reed1991/article/details/53144000)
1.水平切割
range来分：优点：扩容容易     缺点:容易产生数据热点
hash分： 优点：平均分配请求压力   缺点：扩容比较麻烦，需要数据迁移。
2.垂直切割
将较少的访问频率很高的字段放到一个表里去，然后将较多的访问频率很低的字段放到另外一个表里去
3.如何从未分库分表切换到分库分表上









