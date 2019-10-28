
# 使用线程

## 创建线程的三种方式

1.extends Thread   (Thread其实也继承了Runnable，并做了一定的封装)    

2.implements Runnable (更推荐，因为还可以继承其他父类)

3.使用callable

注：thread.setName(“设置一个线程名称”);这是一种规范，在创建线程完成以后，都需要设置名称。

```
public class CallableTest {

    public static void main(String[] args) throws Exception{

        Callable<Integer> callable = new Callable<Integer>() {

            public Integer call() throws Exception {

                return new Random().nextInt(100);

            }

        };

        //extends Runnable, Future<V>

        FutureTask<Integer> futureTask = new FutureTask<Integer>(callable);

        //既可以作为Runnable被线程执行

        new Thread(futureTask).start();

        //又可以作为Future得到Callable的结果

        System.out.println(futureTask.get());

    }

}
```

Callable接口中只有一个call()方法，和Runnable相比，该方法有返回值并允许抛出异常。但是Thread的target必须是实现了Runnable接口的类对象，所以Callable对象无法直接作为Thread对象的接口；所以要想作为target，必须同时实现Runnable接口。
Java提供了一个FutureTask类，该类实现了Runnable接口，该类的run()方法会调用Callable对象的call()方法，这样就能把Callable和Thread结合起来使用了。同时为了方便对Callable对象的操作，Java还提供了Future接口。

FutureTask 可用于异步获取执行结果或取消执行任务的场景。当一个计算任务需要执行很长时间，那么就可以用 FutureTask 来封装这个任务，主线程在完成自己的任务之后再去获取结果。
```
public class FutureTaskExample {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Long t1 = System.currentTimeMillis();
        FutureTask<Integer> futureTask = new FutureTask<Integer>(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                int result = 0;
                for (int i = 0; i < 100; i++) {
                    Thread.sleep(30);
                    result += i;
                }
                return result;
            }
        });

        Thread computeThread = new Thread(futureTask);
        computeThread.start();

        //此时可以去干其他的事情
        System.out.println("other task is running...");
        Thread.sleep(3000);

        System.out.println(System.currentTimeMillis()-t1);
        System.out.println(futureTask.get());
        System.out.println(System.currentTimeMillis()-t1);
    }
}
```


## run()和start()的区别？多次start一个线程会怎么样？

run()方法依旧只有主线程，start（）方法会启动一个线程来执行。

多次start一个线程会报错 java.lang.IllegalThreadStateException [具体原因](https://blog.csdn.net/reed1991/article/details/58597542)





# 线程之间的协作

## 线程间通信：

1、wait()、notify(）机制

2、同步方法

3、while轮询

4、使用condition控制线程通信
```
public class ConTest {

    final Lock lock = new ReentrantLock();
    /*
    一个Condition的实例必须与一个Lock绑定，因此Condition一般都是作为Lock的内部实现。
     */
    final Condition condition = lock.newCondition();

    public static void main(String[] args) {
        ConTest conTest = new ConTest();
        conTest.new Consumer().start();
        conTest.new Producer().start();

    }


    class Consumer extends Thread{
        @Override
        public void run() {
            try {
                lock.lock();
                System.out.println("我在等一个新信号"+this.currentThread().getName());
                condition.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println("拿到一个信号"+this.currentThread().getName());
                lock.unlock();
            }
        }
    }

    class Producer extends Thread{
        @Override
        public void run() {
            produce();
        }

        private void produce() {
            try {
                lock.lock();
                System.out.println("我拿到锁"+this.currentThread().getName());
                condition.signalAll();
                System.out.println("我发出了一个信号："+this.currentThread().getName());
            } finally{
                lock.unlock();
            }
        }

    }

}

```
4.join()方法挂起调用线程的执行，直到被调用的对象完成它的执行
```
/**
 * 现在有T1、T2、T3三个线程，你怎样保证T2在T1执行完后执行，T3在T2执行完后执行？
 * join()方法挂起调用线程的执行，直到被调用的对象完成它的执行
 * 在t2线程中，t2本身就是调用线程，所谓的调用线程就是调用了t.join()方法的线程对象既t1

 */
public class JoinDemo {

    public static void main(String[] args) {
        //初始化线程t1,由于后续有匿名内部类调用这个对象,需要用final修饰
        final Thread t1 = new Thread(new Runnable() {
            public void run() {
                System.out.println("t1 is running");
            }
        });
        //初始化线程t2,由于后续有匿名内部类调用这个对象,需要用final修饰
        final Thread t2 = new Thread(new Runnable() {


            public void run() {
                try {
                    //t1调用join方法,t2会等待t1运行完之后才会开始执行后续代码
                    t1.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    System.out.println("t2 is running");
                }
            }
        });
        //初始化线程t3
        Thread t3 = new Thread(new Runnable() {
            public void run() {
                try {
                    //t2调用join方法,t3会等待t2运行完之后才会开始执行后续代码
                    t2.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    System.out.println("t3 is running");
                }
            }
        });
        //依次启动3个线程
        t1.start();
        t2.start();
        t3.start();
    }
}
```
##

## 为什么JAVA要提供 wait/notify 机制？
是为了避免轮询带来的性能损失
[深入理解wait/notify/notifyAll的作用](https://blog.csdn.net/reed1991/article/details/53782250)

## Sleep和wait

sleep来自Thread类，wait来自Object类

sleep必须捕获异常，而wait、notify不需要捕获异常

sleep方法没有释放锁，wait释放锁，进入等待池等待，出让系统资源，需要其他线程调用notify方法将其唤醒

 wait多用于线程交互   sleep多用于暂停执行

## join 
让主线程等待子线程结束后再运行。

作用1：让线程顺序执行

 ```
 /**
  * 现在有T1、T2、T3三个线程，你怎样保证T2在T1执行完后执行，T3在T2执行完后执行？
  * join()方法挂起调用线程的执行，直到被调用的对象完成它的执行
  * 在t2线程中，t2本身就是调用线程，所谓的调用线程就是调用了t.join()方法的线程对象既t1
 
  */
 public class JoinDemo {
 
     public static void main(String[] args) {
         //初始化线程t1,由于后续有匿名内部类调用这个对象,需要用final修饰
         final Thread t1 = new Thread(new Runnable() {
             public void run() {
                 System.out.println("t1 is running");
             }
         });
         //初始化线程t2,由于后续有匿名内部类调用这个对象,需要用final修饰
         final Thread t2 = new Thread(new Runnable() {
 
 
             public void run() {
                 try {
                     //t1调用join方法,t2会等待t1运行完之后才会开始执行后续代码
                     t1.join();
                 } catch (InterruptedException e) {
                     e.printStackTrace();
                 } finally {
                     System.out.println("t2 is running");
                 }
             }
         });
         //初始化线程t3
         Thread t3 = new Thread(new Runnable() {
             public void run() {
                 try {
                     //t2调用join方法,t3会等待t2运行完之后才会开始执行后续代码
                     t2.join();
                 } catch (InterruptedException e) {
                     e.printStackTrace();
                 } finally {
                     System.out.println("t3 is running");
                 }
             }
         });
         //依次启动3个线程
         t1.start();
         t2.start();
         t3.start();
     }
 }
 ```
 

 
# JAVA 线程池

## Java四种线程池

newFixedThreadPool 创建一个定长线程池，超出的线程会放在队列中等待corePoolSize为nThread，maximumPoolSize为nThread适用：执行长期的任务，性能好很多

newScheduledThreadPool 创建一个定长线程池，支持定时及周期性任务执行。corePoolSize为传递来的参数，maximumPoolSize为Integer.MAX_VALUE适用：周期性执行任务的场景

newCachedThreadPool创建一个可缓存线程池，如果线程池长度超过处理需要，可灵活回收空闲线程，若无可回收，则新建线程。适用：执行很多短期异步的小程序或者负载较轻的服务器corePoolSize为0；maximumPoolSize为Integer.MAX_VALUE

newSingleThreadExecutor 创建一个单线程化的线程池，它只会用唯一的工作线程来执行任务，保证所有任务按照指定顺序(FIFO, LIFO, 优先级)执行。corePoolSize为1，maximumPoolSize为1 通俗：创建只有一个线程的线程池，且线程的存活时间是无限的；当该线程正繁忙时，对于新任务会进入阻塞队列中(无界的阻塞队列)

 

## 相比new Thread，Java提供的四种线程池的好处在于

1.重用存在的线程，减少对象的创建、销毁的开销

2.提高响应速度，当任务到达时，任务可以不需要等待线程创建就可以立即执行。

3.提高线程的可管理性，线程是稀缺资源，如果无限的创建，不仅消耗系统资源，还会降低系统的稳定性，使用线程池可以进行统一的分配、调优和监控。

 
## 线程池任务执行流程：

核心线程----》工作队列---〉》非核心线程----〉》拒绝策略

当线程池小于corePoolSize时，新提交任务将创建一个新线程执行任务，即使此时线程池中存在空闲线程。

当线程池达到corePoolSize时，新提交任务将被放入workQueue中，等待线程池中任务调度执行

当workQueue已满，且maximumPoolSize>corePoolSize时，新提交任务会创建新线程执行任务

当提交任务数超过maximumPoolSize时，新提交任务由RejectedExecutionHandler处理

当线程池中超过corePoolSize线程，空闲时间达到keepAliveTime时，关闭空闲线程

当设置allowCoreThreadTimeOut(true)时，线程池中corePoolSize线程空闲时间达到keepAliveTime也将关闭
 
## 核心线程和工作线程的区别

工作线程设置了过期时间，当线程池中线程数大于corepoolsize时，keepalivetime为多余空闲线程等待任务的最长时间，超过这个时间后多余的线程将会被终止。

## 线程池核心线程数如何确定 

如果是CPU密集型任务，就需要尽量压榨CPU，参考值可以设为 NCPU+1

如果是IO密集型任务，参考值可以设置为2*NCPU

## 线程池的核心参数

corePollsize：核心线程数

maximunPoolSize:最大线程数

keepAliveTime:空闲的线程保留时间

TimeUnit: 空闲线程保留时间单位

BlockingQueue<Runnable>阻塞队列，存储等待执行的任务 ArrayBlockingQueue LinkedBlockingQueue SynchronousQueue可选

ThreadFactory：线程工厂，用来创建线程

RejectedExecutionHandler:队列已满

AbortPolicy 丢弃任务并抛出异常

DiscardPolicy 丢弃任务，不抛出异常

### SychronousQueue
 1：插入操作必须等待另一个线程的的删除，删除操作必须等待另一个线程的插入操作
 如put插入然后等待另一个线程的take或poll  take 移除元素等待等待另一个线程put或add操作，等到对应操作后实现transfer，传给相应的消费者
 2：容量为0，并没有任何元素插入到队列当中


### 为什么单线程池和固定线程池使用的任务阻塞队列是LinkedBlockingQueue()，而缓存线程池使用的是SynchronousQueue()呢？
因为单线程池和固定线程池中，线程数量是有限的，因此提交的任务需要在LinkedBlockingQueue队列中等待空余的线程；而缓存线程池中，线程数量几乎无限（上限为Integer.MAX_VALUE），因此提交的任务只需要在SynchronousQueue队列中同步移交给空余线程即可。
 

## 为什么不建议使用Excutors来创建线程池
newCachedThreadPool 只会重用空闲并且可用的线程，所以上述代码只能不停地创建新线程，在 64-bit JDK 1.7 中 -Xss 默认是 1024k，也就是 1M，那就是需要 10000*1M = 10G 的堆外内存空间来给线程使用，但是我的机器总共就 8G 内存，不够创建新的线程，所以就 OOM 了。
总结一下：所以这个 newCachedThreadPool 大家一般不用就是这样的原因，因为它的最大值是在初始化的时候设置为 Integer.MAX_VALUE，一般来说机器都没那么大内存给它不断使用。当然知道可能出问题的点，就可以去重写一个方法限制一下这个最大值，但是出于后期维护原因，一般来说用 newFixedThreadPool 也就足够了。 
    
Executors创建的线程池存在OOM的风险。[具体原因](https://www.hollischuang.com/archives/2888)

# 线程同步

## 线程安全的概念

当一个程序对一个线程安全的方法或者语句进行访问的时候，其他的不能再进行操作了

## volatile

volatile的本质是告诉jvm，当前变量在寄存器中的值是不确定的，需要从主存中读取。

Volatile可以禁止语义重排

volatile保证可见性
（1）修改volatile变量时会强制将修改后的值刷新的主内存中。
（2）修改volatile变量后会导致其他线程工作内存中对应的变量值失效。因此，再读取该变量值的时候就需要重新从读取主内存中的值。
通过这两个操作，就可以解决volatile变量的可见性问题。

volatile保证有序性
禁止语义重排

Volatile的作用实例：很多线程用同一个标识符判断某件事是否执行，当一个线程改变这个标识的时候，能立即被其他线程看见
 ```
public class TestVolatile {
    public static void main(String[] args) {
        ThreadDeMo td = new ThreadDeMo();
        new Thread(td).start();

        while (true){
            if(td.isFlag()){
                System.out.println("------------------");
                break;
            }
        }
    }

}

class ThreadDeMo implements Runnable{
    //不加volatile,将不会强制从主存读取数据，主程序读到的flag一直是false
    //将会一直阻塞住
    private volatile boolean flag = false;

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public void run() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        flag = true;
        System.out.println("flag="+flag);

    }
}
 ```
## 线程同步的几种方式

1.同步方法，用synchronized关键字修饰的方法

2.同步代码块，用synchronized修饰的代码块

3.使用可重入锁RetrantLock实现同步

4.使用局部变量实现同步（ThreadLocal）

5.使用阻塞队列实现的同步（LinkedBlockingQueue）

6.使用原子变量实现同步

## lock和synchronized

lock                                synchronized

接口                                    关键字

可以让等待锁的线程响应中断                一直等下去

可以知道有没有成功获取锁                     不行

读写锁可以提高多个线程进行读操作的效率

需要收到在finally中unlock
synchronized底层是悲观锁，LOCK是乐观锁，基于cas   

## CAS，全称Compare And Swap（比较与交换），解决多线程并行情况下使用锁造成性能损耗的一种机制。

实现思想 CAS（V, A, B），V为内存地址、A为预期原值，B为新值。如果内存地址的值与预期原值相匹配，那么将该位置值更新为新值。否则，说明已经被其他线程更新，处理器不做任何操作；无论哪种情况，它都会在 CAS 指令之前返回该位置的值。而我们可以使用自旋锁，循环CAS，重新读取该变量再尝试再次修改该变量，也可以放弃操作。   

ABA问题：1.加版本号校验，每次修改变量值时，对应增加版本号。
2.大量线程高并发操作，会造成很多空轮询：LongAdder尝试使用分段CAS以及自动分段迁移的方式来大幅度提升多线程高并发执行CAS操作的性能 [jdk1.8cas优化](https://mp.weixin.qq.com/s?__biz=MzU0OTk3ODQ3Ng==&mid=2247484070&idx=1&sn=c1d49bce3c9da7fcc7e057d858e21d69&chksm=fba6eaa5ccd163b3a935303f10a54a38f15f3c8364c7c1d489f0b1aa1b2ef293a35c565d2fda&mpshare=1&scene=1&srcid=0608QzOXG2l0z2QyfVaCKqRH%23rd)

     

## Synchronized小结

①一个对象里面如果有多个synchronized方法，某一个时刻内，只要一个线程去调用其中的一个synchronized方法了，其他的线程都只能等待，换句话说，某一时刻内，只能有唯一一个线程去访问这些synchronized方法。


②锁的是当前对象this，被锁定后，其他线程都不能进入到当前对象的其他的synchronized方法。


③加个普通方法后发现和同步锁无关。


④换成静态同步方法后，情况又变化


⑤所有的非静态同步方法用的都是同一把锁 -- 实例对象本身，也就是说如果一个实例对象的非静态同步方法获取锁后，该实例对象的其他非静态同步方法必须等待获取锁的方法释放锁后才能获取锁，可是别的实例对象的非静态同步方法因为跟该实例对象的非静态同步方法用的是不同的锁，所以毋须等待该实例对象已经取锁的非静态同步方法释放锁就可以获取他们自己的锁。


⑥所有的静态同步方法用的也是同一把锁 -- 类对象本身，这两把锁是两个不同的对象，所以静态同步方法与非静态同步方法之间不会有竞争条件。但是一旦一个静态同步方法获取锁后，其他的静态同步方法都必须等待该方法释放锁后才能获取锁，而不管是同一个实例对象的静态同步方法之间，还是不同的实例对象的静态同步方法之间，只要它们是同一个实例对象


无论synchronized关键字加在方法上还是对象上，如果它作用的对象是非静态的，则它取得的是锁是对象； 如果synchronized作用的对象是一个静态方法或一个类，则它取得的锁是对类。
 
## synchronized 的底层怎么实现

同步代码块(Synchronization)基于进入和退出管程(Monitor)对象实现。每个对象有一个监视器锁（monitor）。当monitor被占用时就会处于锁定状态，线程执行monitorenter指令时尝试获取monitor的所有权，过程如下：

如果monitor的进入数为0，则该线程进入monitor，然后将进入数设置为1，该线程即为monitor的所有者。

如果线程已经占有该monitor，只是重新进入，则进入monitor的进入数加1.

如果其他线程已经占用了monitor，则该线程进入阻塞状态，直到monitor的进入数为0，再重新尝试获取monitor的所有权。

被 synchronized 修饰的同步方法并没有通过指令monitorenter和monitorexit来完成（理论上其实也可以通过这两条指令来实现），不过相对于普通方法，其常量池中多了ACC_SYNCHRONIZED标示符。JVM就是根据该标示符来实现方法的同步的：当方法调用时，调用指令将会检查方法的 ACC_SYNCHRONIZED 访问标志是否被设置，如果设置了，执行线程将先获取monitor，获取成功之后才能执行方法体，方法执行完后再释放monitor。在方法执行期间，其他任何线程都无法再获得同一个monitor对象。 其实本质上没有区别，只是方法的同步是一种隐式的方式来实现，无需通过字节码来完成

可重入锁：一个线程在获取了锁之后，再去获取同一个锁，这个时候仅仅是把状态值state进行累加，释放一次锁，状态减1，状态值为0的时候，才是线程把锁释放了，其他线程才有机会获取锁。
非公平锁：当线程A执行完之后，要唤醒线程B是需要时间的，而且线程B醒来后还要再次竞争锁，所以如果在切换过程当中，来了一个线程C，那么线程C是有可能获取到锁的，如果C获取到了锁，B就只能继续乖乖休眠了。

公平锁：就是很公平，在并发环境中，每个线程在获取锁的时候会先查看此锁维护的等待队列，如果为空，或者当前线程线程是等待队列的第一个，就占有锁，否则就会加入到等待队列中，以后会按照FIFO的规则从队列中取到自己。
new RenentrantLock(boolean fair)；将fair设为true就是公平锁。

非公平锁比较粗鲁，上来就直接尝试占有锁，如果尝试失败，就再采用类似公平锁那种方式

## synchronized 对象锁和全局锁
static synchronized   和synchronized(xxx.class）是全局锁
synchronized 和 synchronized(this）是对象锁
 

##  锁优化的思路
1.减少锁持有时间  只在线程安全要求的代码块上加锁
2.减小锁的粒度  典型例子   concurrentHashMap
3.锁分离  读写锁 readWriteLock   linkedBlockingQueue 从头部取出数据，从尾部放数据
4.锁粗化  比如两个同步代码块之间不需要做其他的工作，或者做其他的工作时间很短，可以整合成一次锁请求
5.所消除   在及时编译时，如果发现不可能共享的对象，则可以消除这些对象的锁操作

锁升级
锁的四个状态
无锁状态、偏向锁状态、轻量级锁状态、重量级锁

## [微服务注册中心的读写锁优化](https://mp.weixin.qq.com/s?__biz=MzU0OTk3ODQ3Ng==&mid=2247484129&idx=1&sn=d2a95310db5751b152ba070caee4ebae&chksm=fba6eae2ccd163f48aef9d98a4dbb55d578a24af710e1436cc876fe3119b03135532e16d80bc&mpshare=1&scene=1&srcid=06089KYIxoL86LbBEP44hsnV%23rd)
 ```
 //服务注册
 public void register(){
    writeLock.lock();
    //将服务实例信息加入
    writeLock.unLock();
 
 }
 
  //读取服务注册
 public Map register(){
    readLock.lock();
    //读取服务实例信息
    readLock.unLock();
 
 }
  ```
[Java -- 偏向锁、轻量级锁、自旋锁、重量级锁](https://blog.csdn.net/reed1991/article/details/53143734)

# JUC
 
## AQS AbstractQueuedSynchronized 抽象的队列同步器

AQS的实现依赖内部同步队列（FIFO双向队列），如果当前线程获取同步状态失败，AQS会将该线程以及其等待状态信息构造成一个Node，将其加入同步队列器的尾部，同时阻塞当前线程，当同步状态释放时，唤醒队列的头结点。

private transient volatile Node head;

tail;

private volatile int state;

state=0 表示可用

release的同步状态相对简单，需要找到头结点的后继结点进行唤醒，若后继结点为空或处于cancel状态，从后向前遍历找寻一个正常结点，唤醒其对应的线程。

AQS 定义两种资源方式 Exlusive（独占，只有一个线程能执行，如ReentrantLock）和share
（共享，多个线程同时执行，如semaphore/countDownLatch)   

共享式：同一时刻可以有多个线程同时获取到同步状态，这也是"共享的"的意义所在，其待重写的尝试获取同步状态的方法tryAcquireShared返回值为int

1.当返回值大于0时，表示获取同步状态成功，同时还有剩余同步状态可供其他线程获取

2.当返回值等于0时，表示获取同步状态成功，但没有可用的同步状态了。

3.当返回值小于0时 ，表示同步获取失败。


释放同步锁-- releaseShared


AQS是JUC中很多同步组件的构建基础，简单来讲，它内部实现主要是状态变量state和一个FIFO队列来完成，同步队列的头结点是当前获取到同步状态的结点，获取同步状态state失败的线程，会被构造成一个结点（或共享式或独占式）加入到同步队列尾部（采用自旋CAS来保证此操作的线程安全），随后线程会阻塞；释放时唤醒头结点的后继结点，使其加入对同步状态的争夺中。

　　AQS为我们定义好了顶层的处理实现逻辑，我们在使用AQS构建符合我们需求的同步组件时，只需重写tryAcquire，tryAcquireShared，tryRelease，tryReleaseShared几个方法，来决定同步状态的释放和获取即可，至于背后复杂的线程排队，线程阻塞/唤醒，如何保证线程安全，都由AQS为我们完成了，这也是非常典型的模板方法的应用。AQS定义好顶级逻辑的骨架，并提取出公用的线程入队列/出队列，阻塞/唤醒等一系列复杂逻辑的实现，将部分简单的可由使用者决定的操作逻辑延迟到子类中去实现。

[具体参考](https://blog.csdn.net/reed1991/article/details/90447676)


## Java ExecutorService中execute()和submit()方法的区别

方法execute()没有返回值，而submit()方法可以有返回值（通过Callable和Future接口）

方法execute()在默认情况下异常直接抛出（即打印堆栈信息），不能捕获，但是可以通过自定义ThreadFactory的方式进行捕获（通过setUncaughtExceptionHandler方法设置），而submit()方法在默认的情况下可以捕获异常

方法execute()提交的未执行的任务可以通过remove(Runnable)方法删除，而submit()提交的任务即使还未执行也不能通过remove(Runnable)方法删除
 

## CountDownLatch和cyclicBarrier

CountDownLatch:一个线程（或者多个），等待另外N个线程完成某个事情之后才能执行

CountDownLatch（）最重要的方法是countDown（）和await（），前者主要倒数一次，后者是等待倒数到达0，如果没有到达0，就只能等待了。

CyclicBarrier：N个线程相互等待，任何一个线程完成之前，所有线程都必须等待，任何一个线程完成之前，所有线程都必须等待。 await（）调用一次加1

CountDownLatch，重点是那个一个线程，是它在等待，而另外那N的线程在把“某个事情”做完之后可以继续等待，可以终止。

而对于cyclicBarrier来说，重点是那N个线程，他们之间任何一个没有完成，所有的线程都必须等待。

CountDownLatch是计数器，线程完成一个记一个，就像报数一样，只不过是递减的。

cyclicBarrier更像一个水闸，线程执行就像水流，在水闸处都会堵住，等到水满（线程到齐）了，才开始泄流。

 

## Semaphore 信号量

acquire（）要么通过成功获取信号量（信号量减1),要么一直等待下去，直到有线程释放信号量或超时。release（）释放会将信号量加1

Future接口，表示异步计算的结果

## ThreadLocal

ThreadLocal采用的是以空间换时间的方式，为每个线程提供一份变量副本。每一个线程都可以独立的改变自己的副本。

ThreadLocal类中有一个map，用于存储每一个线程的变量副本，map中元素为的键为线程对象，而值为对应线程的变量副本。

同步机制是为了同步多个线程对相同资源的并发访问，是多个线程间进行通信的有效方式，

而ThreadLocal是隔离多个线程的数据共享，从根本上就不存在多个线程之间共享资源。

所有如果需要进行多个线程之间通信，用同步机制，如果要隔离多个线程之间的共享冲突，采用ThreadLocal

### ThreadLocal内存泄漏问题
每个thread中都存在一个map, map的类型是ThreadLocal.ThreadLocalMap. Map中的key为一个threadlocal实例. 这个Map的确使用了弱引用,不过弱引用只是针对key. 每个key都弱引用指向threadlocal. 当把threadlocal实例置为null以后,没有任何强引用指向threadlocal实例,所以threadlocal将会被gc回收. 但是,我们的value却不能回收,因为存在一条从current thread连接过来的强引用. 只有当前thread结束以后, current thread就不会存在栈中,强引用断开, Current Thread, Map, value将全部被GC回收.
所以得出一个结论就是只要这个线程对象被gc回收，就不会出现内存泄露，但在threadLocal设为null和线程结束这段时间不会被回收的，就发生了我们认为的内存泄露。其实这是一个对概念理解的不一致，也没什么好争论的。最要命的是线程对象不被回收的情况，这就发生了真正意义上的内存泄露。比如使用线程池的时候，线程结束是不会销毁的，会再次使用的。就可能出现内存泄露。

### ThreadLocal和synchronized

ThreadLocal使用场合主要解决多线程中数据数据因并发产生不一致问题。ThreadLocal为每个线程的中并发访问的数据提供一个副本，通过访问副本来运行业务，这样的结果是耗费了内存，单大大减少了线程同步所带来性能消耗，也减少了线程并发控制的复杂度。
 
ThreadLocal不能使用原子类型，只能使用Object类型。ThreadLocal的使用比synchronized要简单得多。
 
ThreadLocal和Synchonized都用于解决多线程并发访问。但是ThreadLocal与synchronized有本质的区别。synchronized是利用锁的机制，使变量或代码块在某一时该只能被一个线程访问。而ThreadLocal为每一个线程都提供了变量的副本，使得每个线程在某一时间访问到的并不是同一个对象，这样就隔离了多个线程对数据的数据共享。而Synchronized却正好相反，它用于在多个线程间通信时能够获得数据共享。
 
Synchronized用于线程间的数据共享，而ThreadLocal则用于线程间的数据隔离。
 
当然ThreadLocal并不能替代synchronized,它们处理不同的问题域。Synchronized用于实现同步机制，比ThreadLocal更加复杂。

## [守护线程和用户线程的区别](https://blog.csdn.net/reed1991/article/details/53427243)