# Table of Contents

  * [[单例模式](https://blog.csdn.net/reed1991/article/details/87566264)](#[单例模式]httpsblogcsdnnetreed1991articledetails87566264)
  * [[模版方法模式](https://blog.csdn.net/reed1991/article/details/87561398)](#[模版方法模式]httpsblogcsdnnetreed1991articledetails87561398)
  * [[策略模式](https://blog.csdn.net/reed1991/article/details/53425500)](#[策略模式]httpsblogcsdnnetreed1991articledetails53425500)
  * [[观察者模式](https://blog.csdn.net/reed1991/article/details/87564030)](#[观察者模式]httpsblogcsdnnetreed1991articledetails87564030)
  * [[适配器模式](https://blog.csdn.net/reed1991/article/details/53133169)](#[适配器模式]httpsblogcsdnnetreed1991articledetails53133169)
  * [[代理模式](https://blog.csdn.net/reed1991/article/details/87562997)](#[代理模式]httpsblogcsdnnetreed1991articledetails87562997)
  * [[装饰器模式](https://blog.csdn.net/reed1991/article/details/53106130)](#[装饰器模式]httpsblogcsdnnetreed1991articledetails53106130)
  * [为什么枚举可以实现单例](#为什么枚举可以实现单例)
  * [哪些设计模式可以增加系统的可扩展性](#哪些设计模式可以增加系统的可扩展性)



## [单例模式](https://blog.csdn.net/reed1991/article/details/87566264)
```
public class Singleton {
    private Singleton(){
 
    }
    private static volatile Singleton singleton = null;
    //双重加锁机制，并非加两个锁，而是进行两次判断
    public static Singleton getInstance(){
        //第一重判断，如果单例已经存在，不需要进行同步操作,直接返回实例
        if(singleton == null){
            //如果还不存在，进入同步块
            //同步块的目的是为了防止两个线程同步调用，生成多个实例
            synchronized (Singleton.class){
                //第二次判空的目的：当多个线程一起到达锁位置时，进行锁竞争，其中一个线程获取锁，
                // 如果是第一次进入则dl为null，会进行单例对象的创建，完成后释放锁，
                // 其他线程获取锁后就会被空判断拦截，直接返回已创建的单例对象。
                if(singleton == null){
                    singleton = new Singleton();
                }
            }
 
        }
        return singleton;
    }
}
```
## [模版方法模式](https://blog.csdn.net/reed1991/article/details/87561398)
所谓模版方式模式：把不变的行为搬到超类，去除子类中重复的代码来体现他的优势；当不变的和可变的行为在子类实现中混合在一起的时候，
不变的行为就会在子类中重复实现，我们通过模板方法模式把这些行为搬移到单一的地方，这样就可以帮助子类摆脱重复不变行为的纠缠。

## [策略模式](https://blog.csdn.net/reed1991/article/details/53425500)
策略模式封装了一系列的方法，并且他们可以相互替代，这些方法独立于客户端的变化而变化。

## [观察者模式](https://blog.csdn.net/reed1991/article/details/87564030)
观察者：有个接收被观察者通知的方法。
被观察者：(1)定义观察者的集合，并定义针对集合的添加、删除操作，用于增加、删除观察者
       （2）定义通知方法，用于将新情况通知给观察者
       
       
生产消费者模式：生产者推送消息到消息中心，消费者取出消息消费，同一类别下，所有消费者取到的数据是相同的
观察者模式：本质是一种生产者消费者模式，不同点：订阅者先向消息中心订阅自己感兴趣的类型数据，发布者推送消息到消费中心，订阅者最后获取到自己感兴趣的数据。

       
## [适配器模式](https://blog.csdn.net/reed1991/article/details/53133169)
类的适配器：适配器类，继承了被适配类，同时实现标准接口，单源适配，很清晰
 ```
public class Adapter extends A implements B{

	public void bMethod() {
		
	}
	
}
 ```
 对象适配器：适配器类，直接关联被适配类，同时实现标准接口   可多源适配
  ```
 public class Adapter implements B {
	private A a;
	// 可以通过构造函数传入具体需要适配的被适配类对象
    public Adapter (A a) {
        this.a = a;
    }

}
	
```
## [代理模式](https://blog.csdn.net/reed1991/article/details/87562997)
（1）代理类C与委托类B实现同一接口 A 
（2）在委托类中实现功能，在代理类的方法中中引用委托类的同名方法
（3）外部类调用委托类某个方法时，直接以接口指向代理类的实例，这正是代理的意义所在：屏蔽。
```
public class C implements A {
    @Override
    public void Amethod() {
        B b = new B();
        b.quanli();
    }
}
```

## [装饰器模式](https://blog.csdn.net/reed1991/article/details/53106130)
其作用是增强
```
public class C implements A {
    private A a;

    public Decorator(A a) {
        this.a = a;
    }
    @Override
    public void output() {
        System.out.println("这是针对房子的前段装饰增强");
        house.output();
        System.out.println("这是针对房子的后段装饰增强");
    }
}
```
装饰器中持有的目标实例是从构造器传入的，而代理中持有的目标实例是自己创建的。

那么这里又出现一个区别，代理模式和装饰器模式虽然都依赖于目标接口，但是代理针对的目标实现类是固定的，而装饰器模式可以随意指定，也就是说目标是可以自有扩展的。

## 为什么枚举可以实现单例
枚举中所有的对象都是static final的，表明只能被实例化一次
明确构造方法为私有的
为外界提供唯一的接口来获取这个方法

## 哪些设计模式可以增加系统的可扩展性
工厂模式

抽象工厂模式

观察者模式：很方便增加观察者，方便系统扩展

模板方法模式：很方便的实现不稳定的扩展点，完成功能的重用

适配器模式：可以很方便地对适配其他接口

代理模式：可以很方便在原来功能的基础上增加功能或者逻辑

责任链模式：可以很方便得增加拦截器/过滤器实现对数据的处理，比如struts2的责任链

策略模式：通过新增策略从而改变原来的执行策略


模板模式：就是基类封装好了业务逻辑，抽象出了不稳定的部分，让子类来实现，
策略模式：将变化的部分抽象成策略，通过替换不同的策略来完成业务逻辑处理的变化，比如超时活动价格策略

适配器模式：将现有的功能转换成已经给定的接口实现，比如：jdbc的适配器模式，jdbc定义好操作模式，不同的db针对jdbc来做不同的适配
观察者模式：listener模式，将操作反向依赖到变化的事物上，例如：Spring的ApplicationEvent


[spring中用到的设计模式](https://blog.csdn.net/renxing521/article/details/80614612)
