# Table of Contents

  * [1.Bean的作用域](#1bean的作用域)
  * [2.Bean的生命周期](#2bean的生命周期)
  * [IOC的实现原理](#ioc的实现原理)
  * [AOP](#aop)
  * [SpringMVC的执行流程](#springmvc的执行流程)
  * [@transactional注解在什么情况下会失效，](#transactional注解在什么情况下会失效，)
  * [Spring 在web 容器中的启动过程](#spring-在web-容器中的启动过程)
  * [spring 解决循环依赖](#spring-解决循环依赖)
  * [spring的几种注入方式](#spring的几种注入方式)
  * [常用的一些注解](#常用的一些注解)
    * [@Resource和@Autowired](#resource和autowired)
    * [@Cacheable](#cacheable)
                * [假如值为jj](#假如值为jj)
    * [@Transactional(readOnly = true)](#transactionalreadonly--true)
    * [@Value中冒号的作用](#value中冒号的作用)
    * [[一些常用的注解](https://blog.csdn.net/reed1991/article/details/53352772)](#[一些常用的注解]httpsblogcsdnnetreed1991articledetails53352772)
  * [spring boot 与 spring cloud](#spring-boot-与-spring-cloud)


## 1.Bean的作用域

Singleton：单例模式，只会创建该Bean的唯一实例   

prototype：享元模式，每次请求都创建一个实例

request：一次Http请求，容器会返回该bean的同一实例

session：每次会话创建一个实例

globalsession：全局Httpsession中，容器会返回该bean的同一实例

[Bean的作用域和生命周期](https://blog.csdn.net/reed1991/article/details/59201366)

## 2.Bean的生命周期

 1、实例化一个Bean－－也就是我们常说的new；

 2、按照Spring上下文对实例化的Bean进行配置－－也就是IOC注入；

 3、如果这个Bean已经实现了BeanNameAware接口，会调用它实现的setBeanName(String)方法，此处传递的就是Spring配置文件中Bean的id值

 4、如果这个Bean已经实现了BeanFactoryAware接口，会调用它实现的setBeanFactory(setBeanFactory(BeanFactory)传递的是Spring工厂自身（可以用这个方式来获取其它Bean，只需在Spring配置文件中配置一个普通的Bean就可以）；

 5、如果这个Bean已经实现了ApplicationContextAware接口，会调用setApplicationContext(ApplicationContext)方法，传入Spring上下文（同样这个方式也可以实现步骤4的内容，但比4更好，因为ApplicationContext是BeanFactory的子接口，有更多的实现方法）；

 6、如果这个Bean关联了BeanPostProcessor接口，将会调用postProcessBeforeInitialization(Object obj, String s)方法，BeanPostProcessor经常被用作是Bean内容的更改，并且由于这个是在Bean初始化结束时调用那个的方法，也可以被应用于内存或缓存技术；

 7、如果 Bean 实现了 InitializingBean 接口，则 Spring 将调用 afterPropertiesSet() 方法。
 
 8、如果Bean在Spring配置文件中配置了init-method属性会自动调用其配置的初始化方法。

 9、如果这个Bean关联了BeanPostProcessor接口，将会调用postProcessAfterInitialization(Object obj, String s)方法、；

 注：以上工作完成以后就可以应用这个Bean了，那这个Bean是一个Singleton的，所以一般情况下我们调用同一个id的Bean会是在内容地址相同的实例，当然在Spring配置文件中也可以配置非Singleton，这里我们不做赘述。

 10、当Bean不再需要时，会经过清理阶段，如果Bean实现了DisposableBean这个接口，会调用那个其实现的destroy()方法；

 11、最后，如果这个Bean的Spring配置中配置了destroy-method属性，会自动调用其配置的销毁方法。
 
## spring容器的启动过程
1.首先，web容器提供其一个全局的上下文环境，这个上下文就是ServletContext，其为后面的spring IoC容器提供宿主环境；

2.其 次，在web.xml中会提供有contextLoaderListener。在web容器启动时，会触发容器初始化事件，此时 contextLoaderListener会监听到这个事件，其contextInitialized方法会被调用，

在这个方法中，spring会初始 化一个启动上下文，这个上下文被称为根上下文，即WebApplicationContext，这个就是spring的IoC容器，

在这个IoC容器初始化完毕后，spring以WebApplicationContext.ROOTWEBAPPLICATIONCONTEXTATTRIBUTE为属性Key，将其存储到ServletContext中，便于获取；

3.再 次，contextLoaderListener监听器初始化完毕后，开始初始化web.xml中配置的Servlet，这里是DispatcherServlet，这个servlet实际上是一个标准的前端控制器，用以转发、匹配、处理每个servlet请 求。

DispatcherServlet上下文在初始化的时候会建立自己的IoC上下文，用以持有spring mvc相关的bean。在建立DispatcherServlet自己的IoC上下文时，会利用WebApplicationContext.ROOTWEBAPPLICATIONCONTEXTATTRIBUTE 先从ServletContext中获取之前的根上下文(即WebApplicationContext)作为自己上下文的parent上下文。

有了这个 parent上下文之后，再初始化自己持有的上下文。这个DispatcherServlet初始化自己上下文的工作在其initStrategies方 法中可以看到，大概的工作就是初始化处理器映射、视图解析等。
这个servlet自己持有的上下文默认实现类也是 mlWebApplicationContext。初始化完毕后，spring以与servlet的名字相关(此处不是简单的以servlet名为 Key，而是通过一些转换，具体可自行查看源码)的属性为属性Key，
也将其存到ServletContext中，以便后续使用。这样每个servlet 就持有自己的上下文，即拥有自己独立的bean空间，同时各个servlet共享相同的bean，即根上下文(第2步中初始化的上下文)定义的那些 bean。

## springboot容器启动
这里核心关注2个东西：

1.@SpringBootApplication注解 实际就是个@Configuration） 里面包含@EnableAutoConfiguration总体分为两个部分：一是收集所有spring.factories中EnableAutoConfiguration相关bean的类，二是将得到的类注册到spring容器中。  
@ComponentScan：spring的自动扫描注解，可定义扫描范围，加载到IOC容器。
2.SpringApplication.run()静态方法
 获取监听器----》监听器启动，触发ApplicationStartedEvent事件=====》准备好环境，构造一个ConfigurableEnvironment=====》准备好上下文===》刷新上下文

## IOC的实现原理

Spring的IOC实现原理就是工厂模式加反射机制，通俗来讲就是根据给出的类名（字符串方式）来动态地生成对象，这种编程方式可以让对象在生成时才被决定到底是哪一种对象。

把IOC容器的工作模式看做是工厂模式的升华，可以把IOC容器看作是一个工厂，这个工厂里要生产的对象都在配置文件中给出定义，然后利用编程语言提供的反射机制，根据配置文件中给出的类名生成相应的对象。

Spring支持三种依赖注入方式，分别是属性（Setter方法）注入，构造注入和接口注入。

IOC的缺点：

1）软件系统中由于引入了第三方IOC容器，生成对象的步骤变得有些复杂，本来是两者之间的事情，又凭空多出一道手续，所以，我们在刚开始使用IOC框架的时候，会感觉系统变得不太直观。所以，引入了一个全新的框架，就会增加团队成员学习和认识的培训成本，并且在以后的运行维护中，还得让新加入者具备同样的知识体系。

2）由于IOC容器生成对象是通过反射方式，在运行效率上有一定的损耗。如果你要追求运行效率的话，就必须对此进行权衡。

3）具体到IOC框架产品（比如Spring）来讲，需要进行大量的配制工作，比较繁琐，对于一些小的项目而言，客观上也可能加大一些工作成本。

4）IOC框架产品本身的成熟度需要进行评估，如果引入一个不成熟的IOC框架产品，那么会影响到整个项目，所以这也是一个隐性的风险。 我们大体可以得出这样的结论：一些工作量不大的项目或者产品，不太适合使用IOC框架产品。另外，如果团队成员的知识能力欠缺，对于IOC框架产品缺乏深入的理解，也不要贸然引入。最后，特别强调运行效率的项目或者产品，也不太适合引入IOC框架产品。

## AOP

AOP(面向切面编程):将核心关注点和横切关注点分离开来.

核心关注点:业务主要流程

横切关注点:与业务关系不大.

AOP应用到项目中的好处,能够将与业务逻辑不相关的代码（如：日志、权限等）分离出来,减小相关业务类负担, 并能让一些通用需求（如：事务）得到更广泛的复用.

 一些概念:

1.切面:日志.安全性框架等,总之和业务逻辑没关系的就可以看做切面.

2.通知:切面中的方法

3.切入点:只有符合切入点才能把通知和目标方法结合在一起.

4.连接点:客户端调用的方法

5.织入:形成代理方法的过程.

AOP中各种通知

1.前置通知: 在目标方法执行之前

2.后置通知：在目标方法执行之后，可以根据returning获取目标方法的返回值 public void commit(JoinPoint joinPoint,Object val) * 如果目标方法遇到异常，该通知不执行

 最终通知 * 在目标方法执行之后 * 无论目标方法是否遇到异常，都执行 * 经常做一些关闭资源

异常通知 目的就是为了获取目标方法抛出的异常

环绕通知 能控制目标方法的执行，环绕通知还可以控制返回对象。

使用JDK动态代理，目标类必须实现某个接口，如果某个类没有实现接口，则不能生成动态代理对象。

CGlib必须依赖于CGlib的类库，CGlib的原理是针对目标类生成一个子类，覆盖其中的所有方法，所以目标类和方法不能声名为final类型。

[AOP](https://blog.csdn.net/reed1991/article/details/53900617)

## SpringMVC的执行流程

1.客户端请求提交到DispatcherServlet

2.DispatcherServlet查询HandlerMapping，找到处理请求的Controller

3.DispatcherServlet将请求提交到Controller

4.Controller处理请求，返回ModelAndView

5.Dispatcher查询一个或多个视图解析器，找到ModelAndView指定的视图

6.视图负责将结果显示到客户端

## mybatis一级与二级缓存

Mybatis的一级缓存是指Session缓存。一级缓存的作用域默认是一个SqlSession。Mybatis默认开启一级缓存。
也就是在同一个SqlSession中，执行相同的查询SQL，第一次会去数据库进行查询，并写到缓存中；
第二次以后是直接去缓存中取。
当执行SQL查询中间发生了增删改的操作，MyBatis会把SqlSession的缓存清空。

Mybatis的二级缓存是指mapper映射文件。二级缓存的作用域是同一个namespace下的mapper映射文件内容，
多个SqlSession共享。Mybatis需要手动设置启动二级缓存。将cacheEnabled设为true，然后在需要缓存的mapper中添加cache


## @transactional注解在什么情况下会失效，

1.如果mysql数据库引擎是maisam，则事物不起作用

2.该注解只能应用到public可见度的方法上，在proteted private 或者private方法上不起作用

  aop本质决定的，必须是public

3.注解不能继承，因此不能放在接口上
 
## Spring 在web 容器中的启动过程

1、对于一个web 应用，其部署在web 容器中，web 容器提供其一个全局的上下文环境，这个上下文就是 ServletContext ，其后面的spring IoC 容器提供宿主环境

2、在web.xml 中会提供有 contextLoaderListener。在web 容器启动时，会触发容器初始化事件，此时 contextLoaderListener 会监听到这个事件，其 contextInitialized 方法会被调用，在这个方法中，spring 会初始化一个启动上下文，这个上下文就被称为根上下文，即 WebApplicationContext ，这是一个借口类，确切的说，其实际实现类是 XmlWebApplicaitonContext 。这个就是Spring 的Ioc 容器，其对应的Bean 定义的配置由web.xml 中的 context-param 标签指定。在这个Ioc 容器初始化完毕后，spring 以WebApplicationContext.ROOTWEBAPPLICATIONEXTATTRIBUTE 为属性key，将其存储到 servletContext 中，便于获取

3、contextLoaderListener 监听器初始化完毕后，开始初始化web.xml 中配置的servlet ，这个servlet 可以配置多个，以最常见的DispatcherServlet 为例，这个servlet 实际上是一个标准的前端控制器，用以转发、匹配、处理每个servlet 请求。DispatcherServlet 上下文在初始化的时候会建立自己的Ioc 上下文，用以持有springmvc 相关的bean。在建立DispatherSrvlet 自己的Ioc 上下文时，会利用 WebApplicationContext.ROOTWEBAPPLICATIONCONTEXTATTRIBUTE 先从ServletContext 中获取之前的根上下文（即 WebApplicationContext）作为自己上下文的parent 上下文，有了这个parent 上下文之后，再初始化自己持有的上下文。这个DispatcherServlet 初始化自己上下的工作在其 initStrategies 方法中可以看到，大概的工作就是初始化处理器映射、视图解析等，这个servlet 自己持有的上下文默认实现类也是 XmlWebApplicationContext。初始化完毕后，spring以与Servlet 的名字相关的属性为属性key，将其存到servletcontext 中，以便后续使用。这样每个Servlet 都持有自己的上下文，即拥有自己独立的bean 空间，同事各个servlet 共享相同的bean，即根上下文定义的那些bean


## spring 解决循环依赖
1.重新设计结构消除循环依赖。
2.使用注解 @lazy
3.使用setter注入

## spring的几种注入方式


## 常用的一些注解

### @Resource和@Autowired
@Resource是j2ee的注解，注入方式为byName。
@Autowired是spring的注解，注入方式为byType。默认要求对象必须存在，如果允许为null值，可设置其required属性为false，
如果我们想用(byName)来配置，可以结合@Qualifier来使用







### @Cacheable
@Cacheable(cacheNames = {"nihao","hello"}, key = "#p0")
#p0为第一个参数        假如值为jj
因此会产生两个key
一个是 nihao:jj      一个是hello:jj

@Cacheable(cacheNames = {"nihao","hello"}, key = "#userName")
作用同上

也可以用bean的一个属性作为key
@Cacheable(value="users", key="#user.id")
   public User find(User user) {
      return null;
}

### @Transactional(readOnly = true)
只读事务（@Transactional(readOnly = true)）的一些概念
在将事务设置成只读后，相当于将数据库设置成只读数据库，此时若要进行写的操作，会出现错误


### @Value中冒号的作用
先说明冒号的作用 ：可以设置默认值
@Value中可以使用
@Value("${hello:defaultValue}")
private String hello;
若找不到属性值hello，那么就会默认赋值 defaultValue

### [一些常用的注解](https://blog.csdn.net/reed1991/article/details/53352772)

[BeanNameAware，BeanFactoryAware， ApplicationContextAware](https://blog.csdn.net/reed1991/article/details/53900645)

## spring boot 与 spring cloud
 spring boot 是一个快速整合第三方框架   关注的是 微观 具体关注快速方便的开发单个个体的服务 
 spring cloud 关注的是 宏观  具体关注全局的微服务协调整理治理框架 将spring boot 开发的一个个单体服务整合 并管理起来
它为各个微服务之间提供 配置管理 服务发现 断路器路由 微代理 全局锁 分布式会话 等 集成服务
举个例子 ： 一所医院  boot 是 一个一个科室    cloud 是把一个一个科室 组合起来 对外称之为 医院
存在依赖关系  cloud   离不开boot 


