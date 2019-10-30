
### Java为什么跨平台
因为Java运行在jvm上，和硬件无关


### Object类定义的九个方法

 getClass()   hashcode()   toString()  wait()  notify()  notifyAll()  wait(long times) equals() wait(long timeout int nanous)

### String为什么是final类型的

1.因为字符串是不可变的，所以是线程安全的

2.字符串是不可变的，字符串池才有可能实现，如果能变的话，A和B指向同一个地址，A改变值，B也要跟着改变了。

3.字符串是不可变的，所以它在创建的时候hashcode就被缓存了，不需要重新计算。如果可以变，比如用StringBuilder做模拟，

str1 = a ，str2 = ab， str3 = str1，str2+=b，则set中的值为两个ab，显然违背了set的本意

### == 和 equals
== 比较的是他们在内存中存放的地址
Object的equals底层调用的就是==   但是绝大部分对象都会重写equals，改为比较具体的值是否相等
 
### java中为什么要单继承，多实现

若为多继承，那么当多个父类中有重复的属性或者方法时，子类的调用结果会含糊不清，因此用了单继承。

为什么是多实现呢。

通过实现接口拓展了类的功能，若实现的多个接口中有重复的方法也没关系，因为实现类中必须重写接口中的方法，所以调用时还是调用的实现类中重写的方法。那么各个接口中重复的变量又是怎么回事呢。 

接口中，所有属性都是 static final修饰的，即常量，这个什么意思呢，由于JVM的底层机制，所有static final修饰的变量都在编译时期确定了其值，若在使用时，两个相同的常量值不同，在编译时期就不能通过。




## Collection
### ArrayList
ArrayList 线程不安全 初始容量为10，1.5倍扩容 扩容后将老数组的值复制到新数组

在每次添加新的元素时，ArrayList都会检查是否需要进行扩容操作，扩容操作带来数据向新数组的重新拷贝，所以如果我们知道具体业务数据量， 在构造ArrayList时可以给ArrayList指定一个初始容量，这样就会减少扩容时数据的拷贝问题。


### 在ArrayList的循环中删除元素，会不会出现问题？
普通for循环正序删除，删除过程中元素向左移动，不能删除重复的元素
普通for循环倒序删除，删除过程中元素向左移动，可以删除重复的元素

增强for循环删除，使用ArrayList的remove()方法删除，产生并发修改异常 ConcurrentModificationException
迭代器，使用ArrayList的remove()方法删除，产生并发修改异常 ConcurrentModificationException

原因：1）在使用For-Each快速遍历时，ArrayList内部创建了一个内部迭代器iterator，使用的是hasNext和next()方法来判断和取下一个元素。
   2）ArrayList里还保存了一个变量modCount，用来记录List修改的次数，而iterator保存了一个expectedModCount来表示期望的修改次数，在每个操作前都会判断两者值是否一样，不一样则会抛出异常；
   3）在foreach循环中调用remove()方法后，会走到fastRemove()方法，该方法不是iterator中的方法，而是ArrayList中的方法，在该方法中modCount++; 而iterator中的expectedModCount并没有改变；
   4）再次遍历时，会先调用内部类iteator中的hasNext(),再调用next(),在调用next()方法时，会对modCount和expectedModCount进行比较，此时两者不一致，就抛出了ConcurrentModificationException异常。
使用迭代器的remove方法可以正常删除

### ArrayList和Vector的区别
1）  Vector的方法都是同步的(Synchronized),是线程安全的(thread-safe)，而ArrayList的方法不是，由于线程的同步必然要影响性能，因此,ArrayList的性能比Vector好。 
2） 当Vector或ArrayList中的元素超过它的初始大小时,Vector会将它的容量翻倍,而ArrayList只增加50%的大小，这样,ArrayList就有利于节约内存空间

### HashSet、 TreeSet、LinkedHashSet
TreeSet 大小排序, LinkedHashSet  按照顺序排序
HashSet是由一个hash表来实现的，因此，它的元素是无序的。add()，remove()，contains()方法的时间复杂度是O(1)。 另一方面，TreeSet是由一个树形的结构来实现的，它里面的元素是有序的。因此，add()，remove()，contains()方法的时间复杂度是O(logn)。
linked 也是O（1），但是性能逊色一点

### hashMap介绍
存储结构 Node[] table（哈希桶数组）  默认length为16，必须为2的n次方       负载因子为0.75

#### 1、确定hash桶的位置。
对桶的长度取模的话，运算消耗比较大。 hashmap采用hashcode&（table.length-1),效果等价，运算效率比较高
jdk 1.8  h = k.hashCode()) ^ (h >>> 16这么做可以在数组table的length比较小的时候，也能保证考虑到高低Bit都参与到Hash的计算中，同时不会有太大的开销。

#### 2、hashMap的put()方法
1、table是否为null，是的话需要resize（）进行扩容。
2、根据hashcode&（table.length-1)计算插入的数组索引，如果table[i]为null，直接添加， 判断实际存在键值对数量size是否超过了最大容量threshold，如果超过，进行扩容。
3、判断key是否存在，如果存在直接覆盖value
4、如果链表为红黑树，直接插入。如果链表为链表，插入然后看是否要将链表转为红黑树。


#### 扩容机制
使用一个容量更大的数组来代替已有的容量小的数组，transfer()方法将原有Entry数组的元素拷贝到新的Entry数组里。1.7头插，1.8尾插
jdk1.8的优化：不需要像JDK1.7的实现那样重新计算hash，只需要看看原来的hash值新增的那个bit是1还是0就好了，是0的话索引没变，是1的话索引变成“原索引+oldCap”


### hashmap的jdk1.7和jdk1.8的区别
jdk7 数组+单链表 jdk8 数组+(单链表+红黑树) 
jdk7 链表头插 jdk8 链表尾插 
    头插: resize后transfer数据时不需要遍历链表到尾部再插入
    头插: 最近put的可能等下就被get，头插遍历到链表头就匹配到了
    头插: resize后链表可能倒序; 并发resize可能产生循环链
jdk7 先扩容再put jdk8 先put再扩容  (why?有什么区别吗?)
jdk7 计算hash运算多 jdk8 计算hash运算少(http://www.jasongj.com/java/concurrenthashmap/#寻址方式-1)
jdk7 受rehash影响 jdk8 调整后是(原位置)or(原位置+旧容量)



### hashmap为什么线程不安全?
因为在多线程情况下。假如快到resize零界点的时候。多个线程同时对这个hashmap进行了put操作。操作后超过临界值。多个线程各自进行resize操作。可能导致链表成环。
然后当调用这个hashmap查找一个不存在的key。而这个key的hash结果正好等于成环的那个table的时候，就会形成死循环。 [详细参考](https://blog.csdn.net/dgutliangxuan/article/details/78779448)

### Hashmap和HashTable的区别

hashmap继承自abstractmap， hashtable继承自Dictionary

HashMap可以有一个key为null，value可以为null，     hashtable放入key和value都不能为null

HashMap不是现成安全的，       Hashtable是线程安全的，他的所有的方法都用synchronized加锁了

### hashmap的负载因子为什么是0.75

简单翻译一下就是在理想情况下,使用随机哈希码,节点出现的频率在hash桶中遵循泊松分布，同时给出了桶中元素个数和概率的对照表

从上面的表中可以看到当桶中元素到达8个的时候，概率已经变得非常小，也就是说用0.75作为加载因子，每个碰撞位置的链表长度超过８个是几乎不可能的。

### HashMap的遍历

既需要key，又需要value，用entrySet。因为entryset会多一次查询map。更优雅的方式map.forEach

只需要key，可以用keyset。

### ConcurrentHashMap
1.7 segment加锁。   1.8 cas
### hash碰撞的解决办法
1.开放地址法
2.再hash法
3.拉链法（hashmap采用此方法）

### Collection和Collections
Collections则是集合类的一个工具类/帮助类，其中提供了一系列静态方法，用于对集合中元素进行排序、搜索以及线程安全等各种操作
Collection 是一个集合接口


### 多态

同一消息可以根据发送对象的不同而采用多种不同的行为方式。

多态存在的三个必要条件

1.要有继承

2.要有重写

3.父类引用指向子类的对象

### 匿名内部类
比如现在有一个抽象类或者接口Person，要想使用它，需要先继承抽象类或者实现接口才能使用。  我们也可以在类里面直接去new这个接口或者抽象类，然后将其中的抽象方法实现。
匿名内部类也就是没有名字的内部类。正因为没有名字，所以匿名内部类只能使用一次，通常用来简化代码编写。


### 泛型

泛型：即参数化类型，所谓参数化类型，是指操作的数据类型在定义时被指定为一个参数，然后在使用时传入具体的类型。

泛型不能为基本类型

可以自定义泛型，泛型在Java集合类框架中被广泛的使用

在编译之后，程序会采取去泛型化的措施。Java中的泛型，只在编译阶段有效。在编译过程中，正确检查泛型结果后，会将泛型的相关信息擦除。也就是说，泛型信息不会进入到运行阶段。

泛型的好处:

1.泛型可以知道一个对象的限定类型是什么，比较安全

2.消除了强制类型转换，使得代码可读性好，消除了出错的机会。



### 方法覆盖与方法重载

方法覆盖：子类重新定义了父类的方法，有相同的类型、参数列表和返回类型

方法重载：同一个类有两个或者多个方法的方法名相同，但是参数不同

### 接口、抽象类

类可以实现多个接口，但是只能继承一个抽象类

Java接口中声名的变量默认是final类型的，抽象类可以包含非final类型变量

抽象类可以有默认的方法实现，接口完全抽象的，根本不存在方法的实现

抽象方法可以有public、protected、default这些修饰，接口方法默认修饰是public

AbstractMap是Map接口的实现类之一，也是HashMap、TreeMap、ConcurrentHashMap等的父类， AbstractMap提供了Map的基本实现，使得我们以后要实现一个Map不用从头开始，只需要继承AbstractMap。


 
### Java反射机制

反射机制是在运行状态中，对于任意一个类，都能知道这个类的所有属性和方法

getDeclaredField 获得一个类的所有字段

getField 获取类的public字段

getDeclaredMethods（） 获取类的所有方法

getMethods（） 返回某个类的所有公用方法

getDeclaredConstructor（） 返回所有的构造器

getConstructor（） 返回public构造函数

 

### Java反射的作用：

在IDEA中输入一个类，按".",编译器就会自动列出他的属性和方法，这里就会用到反射。

### class.forName()和ClassLoader.loadClass（className）
第一个需要初始化。一旦初始化，就会触发目标对象的static代码块，static参数也会被再次初始化
第二个不会进行初始化，静态块和静态对象就不会执行。
[反射中Class.forName()和ClassLoader.loadClass()的区别](https://blog.csdn.net/reed1991/article/details/55506729)

### 动态代理和静态代理的区别

代理模式是常用的Java设计模式，其特征是代理类与委托类有同样的接口，代理类主要负责为委托类预处理消息、过滤消息、把消息传给委托类，以及事后处理消息等。代理类与委托类之间通常会存在关联关系，一个代理类的对象与一个委托类的对象关联，代理类的对象并不真正实现服务，而是通过调用委托类的对象的相关的方法，来提供特点的服务。

按照代理类创建的时期，代理类可分为两种。

静态代理类：由程序员创建或由特定工具生成源代码，再对其编译。在程序运行前，代理类的.class文件就已经存在了。

动态代理类：在程序运行时，运用反射机制动态创建而成。

## Error类和Exception类都是Throwable类

Error 系统中的错误 Exception（异常）

checkedException try-catch捕获 比如IOexception，ClassNotFoundException

runtimeExeception 空指针，数组越界

NOClassDefFoundError是运行时报错，是一个错误（Error），

ClassNotFoundException 是一个异常，可捕获  

### throw和throws的区别和联系     
throws关键字一般用于抛出编译时的异常， 用在方法上。
throw一般是用在抛出一个异常对象，            throw new MyException("龙不吟，虎不啸");然后@ExceptionHandler里面统一捕获返回给前端
### NOClassDefFoundError和ClassNotFoundException

NOClassDefFoundError 要查找的类在编译时是存在的，运行时却找不到了，new操作来创建一个新的对象但却找不到该对象的类。

ClassNotFoundException 编译的时候就找不到，class.forName动态加载

 

### 常见的Exception

1.nullpointerExeception  2.classnotfoundExcetion 3. .arithmeticexception（数据运算异常）4. java.lang.arrayindexoutofboundsexception （数组下标越界）

5.ClassCastException（类型强制转换异常）

### StackOverflowError和OutOfMemoryError
StackOverflowError：递归过深，递归没有出口。
OutOfMemoryError：JVM空间溢出，创建对象速度高于GC回收速度。

## try..catch捕获
对于try..catch捕获异常的形式来说，对于异常的捕获，可以有多个catch。对于try里面发生的异常，他会根据发生的异常和catch里面的进行匹配(怎么匹配，按照catch块从上往下匹配)，当它匹配某一个catch块的时候，他就直接进入到这个catch块里面去了，后面在再有catch块的话，它不做任何处理，直接跳过去，全部忽略掉。如果有finally的话进入到finally里面继续执行。换句话说，如果有匹配的catch，它就会忽略掉这个catch后面所有的catch。对我们这个方法来说，抛出的是IOException，当执行etct.doSomething();时，可能会抛出IOException，一但抛出IOException，它首先进入到catch (Exception e) {}里面，先和Exception匹配，由于OExceptionextends Exception,根据多态的原则，IOException是匹配Exception的，所以程序就会进入到catch (Exception e) {}里面，进入到第一个catch后，后面的catch都不会执行了，所以catch (IOException e) {}永远都执行不到，就给我们报出了前面的错误:已捕捉到异常 java.io.IOException。

总结:在写异常处理的时候，一定要把异常范围小的放在前面，范围大的放在后面，Exception这个异常的根类一定要刚在最后一个catch里面，如果放在前面或者中间，任何异常都会和Exception匹配的，就会报已捕获到...异常的错误。

### static

修饰变量：类加载时初始化，JVM只分配一次内存，所有类共享静态变量。

修饰方法:在类加载时就存在，不依赖任何实例：static方法必须实现，不能用abstract修饰。

修饰代码块：在类加载完之后会执行代码块中的内容。static代码块有多个，JVM会按照他们在类中出现的先后顺序依次执行它们，每个代码块只被执行一次。

static final用来修饰成员变量和成员方法，可简单理解为“全局变量”！

当需要一个方法一初始化就要运行的时候，就要用static来修饰。

static方法是在调用的时候执行。static代码块和static变量在类加载的时候执行

### 序列化与反序列化

序列化：将数据分解成字节流，以便存储在文件中或在网络上传输

反序列化：打开字节流并重构对象。

在运行反序列化时，JVM会将传来的字节流的SeriaVersionUID与本地相应实体（类）的seriaVersionUID进行比较，如果相同就认为是一致的，可以进行反序列化，否则会出现序列化版本不一致异常。

如果没有显示声名序列号，程序在编译时会自己生成这个版本的序列号。在存储文件中，如果在你更改实体类的时候又会重新生成一个序列号，在程序运行的时候，Java的序列化机制在运行时判断类的serialVersionUID来验证版本一致性的。

Java序列化排除序列化字段 transient

1.序列化的两种方式 serilizable 要想某个字段不被序列化 用transient修饰（静态变量不会被序列化） 2.Externalizable 若实现的是Externalizable接口，则没有任何东西可以自动序列化，需要在writeExternal方法中进行手工指定所要序列化的变量，这与是否被transient修饰无关

### IO与NIO

IO                        NIO

面向流                   面向缓冲

阻塞IO                   非阻塞IO

无                       选择器

 

NIO的核心在于：通道和缓冲区（Buffer）， 通道表示IO源到IO设备（例如：文件，套接字）的链接，Channel负责传输，Buffer负责存储

FileInputStream/FileOutPutStream字节流

FileReader/FileWriter字符流

Channel（通道）和 buffer（缓冲区）就好像铁路和火车

### java中的基本类型
一共有8个，它们分别为：
1 字符类型：byte/8，char/16
2 基本整型：short/16，int/32，long/64
3 浮点型：float/32，double/64
4 布尔类型：boolean
String不是基本的数据类型，是final修饰的java类

### switch 
能否作用在 byte 上，能否作用在 long 上，能 否作用在 String 上?
switch只能时int 或这能转化为int型的byte,short,char,jdk1.7之后String也可以。在 switch（ expr1）中， expr1 只能是一个整数表达式或者枚举常量（更大字体），整数表达式可以是 int
基本类型或 Integer 包装类型，由于， byte,short,char 都可以隐含转换为 int，所以，这些类型以及这些类型的包装类型也是可以的。显然， long 和 String 类型都不符合 switch 的语法规定，并且不能被隐式转换成 int类型，所以，它们不能作用于 swtich 语句中。 另外由于 JDK1.7 中引入新特性，所以 swtich 语句可以接收
一个 String 类型的值， String 可以作用在 swtich 上。

## 缓存池

new Integer(123) 与 Integer.valueOf(123) 的区别在于：

new Integer(123) 每次都会新建一个对象；
Integer.valueOf(123) 会使用缓存池中的对象，多次调用会取得同一个对象的引用。
 ```
Integer x = new Integer(123);
Integer y = new Integer(123);
System.out.println(x == y);    // false
Integer z = Integer.valueOf(123);
Integer k = Integer.valueOf(123);
System.out.println(z == k);   // true
 ```

valueOf() 方法的实现比较简单，就是先判断值是否在缓存池中，如果在的话就直接返回缓存池的内容。
 ```
public static Integer valueOf(int i) {
    if (i >= IntegerCache.low && i <= IntegerCache.high)
        return IntegerCache.cache[i + (-IntegerCache.low)];
    return new Integer(i);
}
```

在 Java 8 中，Integer 缓存池的大小默认为 -128~127。
 
### 值传递和引用传递

值传递是指在调用函数时将实际数复制一份传递到函数中，这样在函数中如果对形参进行修改，将不会影响到实际参数。简单来说就是直接复制了一份数据过去，因为是直接复制，所以这种方式在复制时如果传递的数据非常大，运行效率将会降低，所以Java在传递数据量很小的时候是值传递，比如Java的基本类型：int,float,double,boolean等类型。

引用传递操作的是源数据，二维数组，List，Map等除了基本的数据类型都是引用传递。

### [强引用，软引用，弱引用](https://blog.csdn.net/reed1991/article/details/56680911)

 
 
## JVM 


## Java基础
int的自动装箱都是通过Integer.valueOf()方法来实现的，Integer的自动拆箱都是通过integer.intValue来实现的。缓存支持-128到127之间的自动装箱过程


Java的反射就是利用上面第二步加载到jvm中的.class文件来进行操作的。.class文件中包含java类的所有信息，当你不知道某个类具体信息时，可以使用反射获取class，然后进行各种操作。

Java反射就是在运行状态中，对于任意一个类，都能够知道这个类的所有属性和方法；对于任意一个对象，都能够调用它的任意方法和属性；并且能改变它的属性。总结说：反射就是把java类中的各种成分映射成一个个的Java对象，并且可以进行操作。