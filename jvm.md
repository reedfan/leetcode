# Table of Contents

  * [加载器的种类](#加载器的种类)
  * [类加载器工作机制](#类加载器工作机制)
  * [强引用和弱引用](#强引用和弱引用)
  * [双亲委派模式优势](#双亲委派模式优势)
  * [JVM内存模型](#jvm内存模型)
  * [垃圾回收](#垃圾回收)
    * [GC的触发条件](#gc的触发条件)
    * [JVM垃圾回收器](#jvm垃圾回收器)
  * [JVM调优](#jvm调优)
  * [[GC调优相关](https://blog.csdn.net/reed1991/article/details/53363354)](#[gc调优相关]httpsblogcsdnnetreed1991articledetails53363354)
    * [线上CPU100%排查](#线上cpu100排查)
    * [jvm的一些工具](#jvm的一些工具)
    * [[Java开发必须掌握的线上问题排查命令](https://blog.csdn.net/reed1991/article/details/53900573)](#[java开发必须掌握的线上问题排查命令]httpsblogcsdnnetreed1991articledetails53900573)


## 加载器的种类

String这种   启动类加载器  jre/lib/rt.jar

扩展类加载器   jre/lib/ext/*.jar

自己写的     应用类加载器

。           自定义加载器

## 类加载器工作机制

1.装载：将Java二进制代码导入jvm中，生成Class文件。

2.连接过程

　　（1）验证：确保被加载类的正确性，即确保被加载的类符合javac编译的规范

　　（2）准备：为类的静态变量分配内存，并初始化为默认值

　　（3）解析：将类中的符号引用转化为直接引用

　　 注：符号引用即一个Java源文件在被编译时，在不清楚被引用类实际内存地址的情况下，会使用能唯一识别并定位到目标的符号来代替。如A类引用了B类，编译时A并不知道B类实际的内存地址，故可以使用能唯一识别B的符号来代替。而当类加载时，编译后的.class文件实际已被调入内存，可知道A,B类的实际内存地址，当引用的目标已被加载入内存，则此时的引用为直接引用。

3.初始化

　初始化过程为类的静态变量赋予正确的初始值（与连接过程的准备阶段不同，如int类型的静态变量，JVM的默认值为0，遇到static int a = 3的代码时，准备阶段首先是赋值为0，初始化阶段才赋值为3

## 强引用和弱引用

引用类型    被垃圾回收的时间       用途               生存时间

强引用        从来不会        对象的一般状态         JVM停止运行时终止

软引用       内存不足时         对象缓存             内存不足时终止

弱引用      在垃圾回收时        对象缓存               GC运行后终止

 ```
public static void main(String[] args) {
        String str = new String("abc");    //强引用
        SoftReference<String> softReference = new SoftReference<>(str); //软引用
        str = null;    //去掉强引用
        System.gc();   //垃圾回收器进行回收
        System.out.println(softReference.get());
        String strNew = new String("123");

        WeakReference<String> weakReference = new WeakReference<>(strNew);//弱引用
        strNew = null;
        System.gc();
        System.out.println(weakReference.get());
    }
  ```
  输出结果为 abc  null

## 双亲委派模式优势

采用双亲委派模式的是好处是Java类随着它的类加载器一起具备了一种带有优先级的层次关系，通过这种层级关可以避免类的重复加载，当父亲已经加载了该类时，就没有必要子ClassLoader再加载一次。其次是考虑到安全因素，java核心api中定义类型不会被随意替换，假设通过网络传递一个名为java.lang.Integer的类，通过双亲委托模式传递到启动类加载器，而启动类加载器在核心Java API发现这个名字的类，发现该类已被加载，并不会重新加载网络传递的过来的java.lang.Integer，而直接返回已加载过的Integer.class，这样便可以防止核心API库被随意篡改。可能你会想，如果我们在classpath路径下自定义一个名为java.lang.SingleInterge类(该类是胡编的)呢？该类并不存在java.lang中，经过双亲委托模式，传递到启动类加载器中，由于父类加载器路径下并没有该类，所以不会加载，将反向委托给子类加载器加载，最终会通过系统类加载器加载该类。但是这样做是不允许，因为java.lang是核心API包，需要访问权限，强制加载将会报出如下异常

java.lang.SecurityException: Prohibited package name: java.lang

 
## JVM内存模型

1.程序计数器：是一个数据结构，用于保存当前正常执行的程序的内存地址。Java虚拟机的多线程就是通过线程轮流切换并分配处理器时间来实现的， 为了线程切换后能恢复到正确的位置，每条线程都需要一个独立的程序计数器，互不影响，该区域为“线程私有”。

2.Java虚拟机栈：线程私有的，与线程生命周期相同，用于存储局部变量表，操作栈，方法返回值。局部变量表放着基本数据类型，还有对象的引用。

3.本地方法栈：跟虚拟机栈很像，不过它是为虚拟机使用到的Native方法服务。hashcode方法是native的.wait(long times) notify  notifyAll也是native的

4.Java堆：所有线程共享的一块内存区域，对象实例几乎都在这分配内存。

5.方法区：各个线程共享的区域，储存虚拟机加载的类信息，常量，静态变量，编译后的代码。

6.运行时常量池：代表运行时每个class文件中的常量表。包括几种常量：编译时的数字常量、方法或者域的引用。

java类加载在方法区。




## 垃圾回收

新生代：复制算法     老年代：标记清除、标记整理

引用计数法   可达性算法

在java中可以作为GC Roots的对象有以下几种：

1.虚拟机栈中引用的对象、

2.方法区类静态属性引用的对象、

3.方法区常量池引用的对象、

4.本地方法栈JNI引用的对象

### GC的触发条件
youngGC的eden区满则触发youngGC，将eden区和一个servivor区存活的对象分配到另一个servivor区。
第一次youngGC是将eden区存活的内存分到其中一个servivor分区
默认15次youngGC还没被回收就会进入老年代,对象很大也会直接进入老年代

 
老生代回收用广度   占用内存大点，但是速度快点
新生代回收用深度    深度优先算法占内存少，因为有回溯，但移动较慢

java 1.8 永久代消失了，由元空间取代
[JVM 1.8 永久代---元空间 的变动](https://blog.csdn.net/reed1991/article/details/54286557)


### JVM垃圾回收器

Serial收集器           单线程        新生代         复制算法      客户端
Serial Old            单线程        老年代         标记整理      客户端
ParNew                多线程        新生代         复制算法      Server端（配合老年代的cms收集器使用）
parallel scavenge     多线程        新生代         复制算法      追求达到可控的吞吐量。
parallel old          多线程        老年代         标记整理      吞吐量优先的场合优先考虑Parallel Scavenge收集器+ Parallel Old收集器的组合。
cms                   多线程        老年代         标记清除      追求响应速度

G1收集器是标记整理算法，不会产生内存空间碎片。
可预测停顿的时间模型。
将Java堆分成多个大小相等的独立区域，新生代和老年代不再是物理隔阂了，他们是一部分可以不连续的独立区域的集合。

因为和用户线程一起执行，不能在空间将满时再清理。
 -XX:CMSInitiatingOccupancyFraction设置触发GC的阈值。 设定老年代空间被使用多少后触发。
 如果不幸内存预留空间不足，就会引起concurrent mode failure.
在CMS遇到空间不足时，可以使用串行收集器作为后备。
 
[CMS收集器和G1收集器的区别](https://blog.csdn.net/reed1991/article/details/54407070)
CMS收集器是老年代收集器，可以配合新生代的Serial和ParNew收集器一起使用。使用的是标记清除算法，容易产生内存碎片。
4个步骤： 1.初始标记--》并发标记--》重新标记--》并发清除  （初始标记、重新标记）仍需STW。但初始标记仅仅只标记了一下GC Roots能直接关联到的对象，速度很快。
而重新标记则是修正并发标记期间因用户程序继续运行而导致标记产生变动的那一部分对象的标记记录，虽然一般比初始标记阶段稍长，但要远小于并发标记时间。

## JVM调优

-Xms  初始堆大小 (starting)

-Xmx  最大堆大小 (max)

-Xmn  年轻代大小  (new)

 

-XX:NewSize  设置年轻代大小

-XX:NewRatio 设置新生代和老年代的比值  设置为4表示新生代:老年代=1:4,即年轻代占堆的5分之一

-XX:SurvivorRatio 8表示两个Survivor:eden = 2：8，


-XX:printGC  打印简要GC日志
-XX:+PrintGCDetails   打印出GC详细信息

## [GC调优相关](https://blog.csdn.net/reed1991/article/details/53363354)

### 线上CPU100%排查
1.jps查看进程号
jps(Java Virtual Machine Process Status Tool)
jps主要用来输出JVM中运行的进程状态信息。
2.top -Hp pid可以查看某个进程的线程信息
-H 显示线程信息，-p指定pid
printf "%x\n" 8600 
jstack 8591|grep 2198

排查内存溢出
jmap可以打印dump文件，打印出来以后，可以用jprofiler或者mat来看
[内存泄露排查工具MAT的使用](https://blog.csdn.net/reed1991/article/details/53649082)


### jvm的一些工具
jstack主要用来查看某个Java进程内的线程堆栈信息。
jstat主要是 jvm相关的一些信息
jmap  生成存储快照    [jvm 性能调优工具之 jmap](https://blog.csdn.net/reed1991/article/details/55270998)

### [Java开发必须掌握的线上问题排查命令](https://blog.csdn.net/reed1991/article/details/53900573)
