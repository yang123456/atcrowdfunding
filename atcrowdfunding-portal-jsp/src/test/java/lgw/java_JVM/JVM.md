周阳老师视频笔记二（JVM）

1) 如何确定垃圾？

    1) 引用计数法
    
        无法解决循环引用问题，jdk不使用这种算法。
        
    2) 可达性分析算法
    
        枚举根节点做可达性分析，不可达即为垃圾。就是从 GC Root开始向下遍历搜索，能搜索到的（可达的）就是还在使用的java对象，搜索不到的（不可达的）就是垃圾。

2) 什么是GC Root？哪些对象可以作为 GC Root？

    1) 虚拟机栈中局部变量表引用的对象。
    
    2) 方法区中静态属性引用的对象。
    
    3) 方法区中常量引用的对象。
    
    4) 本地方法栈中native方法引用的对象。

3) 如何盘点查看 JVM 系统默认值？
    
    1) boolean型参数
    
        设置属性值：-XX:+或者-某个属性
        
        -（减号）表示没开启，+（加号）表示开启。
        
    2) KV设置类型
    
        设置属性值： -XX:key=value
        
    3) 查看属性的值
    
        1) 使用 jinfo -flag （参数名） （进程号） 查看某个参数是否开启。    
    
        2) 使用 jinfo -flags （进程号） 查看所有的参数值    
    
        3) java -XX:+PrintFlagsInitial    查看 JVM 初始化配置
    
        4) java -XX:+PrintFlagsFinal -version 主要用于查看修改更新  = 代表初始的值  := 代表修改以后的值
    
4) JVM常用的基本配置参数有哪些？

    1) -Xms
    
        初始内存大小，默认为物理内存的64分之1，等价于-XX:InitialHeapSize
    
    2) -Xmx
    
        最大分配内存，默认为物理内存的4分之1，等价于-XX:MaxHeapSize
    
    3) -Xss
    
        设置单个线程栈的默认初始大小，一般默认为512~1024k，等价于-XX:ThreadStackSize
    
    4) -Xmn
    
        设置新生代的大小，新生代默认是3分之1的堆内存。
    
    5) -XX:MetaSpaceSize
    
        设置元空间大小，元空间的本质和永久代类似，都是对方法区的实现。但是**元空间并不在虚拟机中**，而是**使用本地内存**。默认情况下，元空间的大小仅受本地内存限制。
    
    6) -XX:+PrintGCDetails
    
        打印GC的详细日志信息，如何阅读打印的内容，参考《深入理解java虚拟机》。
    
    7) -XX:SurvivorRatio
    
        设置新生代中E区和两个S区的比例，默认是8:1:1,例如： -XX:SurvivorRatio=4设置为 4:1:1 。
    
    8) -XX:NewRatio
    
        配置新生代和老年代在堆内存中的比例，默认是2，即新生代占1，老年代占2.新生代占老年代的3分之一。
    
    9) -XX:MaxTenuringThreshold
    
        设置对象在新生代经过多少次回收之后进入老年代，默认是15.取值应该在0~15之间。
    
5) 对强、软、弱、虚四种引用类型的理解

    java.lang.ref

    1) 强引用(Reference) demo2
    
        强引用对象就是普通的存活的java对象，对于这种强引用引用的对象，就算出现了OOM也不会对该对象进行回收。
    
    2) 软引用(SoftReference) demo3
    
        内存足够的时候不会被GC回收，当内存不够时才会被GC回收。
    
    3) 弱引用(WeakReference) demo4
    
        不考虑内存是否够用，只要进行GC就会回收。
        
        WeakHashMap
    
    4) 虚引用(PhantomReference) demo5
    
        1) 虚引用不会决定对象的周期，如果一个对象持有虚引用，它就像没有任何引用一样，在任何时候都可能被垃圾收集器回收。
        
        2) 它不能单独使用也不能通过他访问对象，必须和引用队列（ReferenceQueue）联合使用。

        3) 虚引用的主要作用是跟踪对象被垃圾回收的状态，仅仅提供一种确保对象被finalize以后，做某些事情的机制。
        
        4) PhantomReference的get方法总是返回null，因此无法访问对应的引用对象。其意义说明一个对象已经进入finalization阶段，可以被gc回收，用来实现比finalization机制更灵活的操作。
        
        5) 设置虚引用的唯一目的，就是在这个对象被收集器回收之后收到一个系统通知或者添加后续处理。    
        
    5) 引用队列(ReferenceQueue)
    
        创建引用的时候可以指定相关联的引用队列，当gc释放对象内存的时候被回收的对象的引用会先放入引用队列中。当引用队列中有数据的时候，意味着引用指向的堆内存的对象被回收了。  
        
6) 各种OOM

    1) StackOverFlowError demo6
    
        栈溢出      
    
    2) OutOfMemoryError: demo7
    
        Java Heap Space 堆内存溢出    
    
    3) OutOfMemoryError: GC Overhead demo8
    
        超过 98% 的时间用来gc但是却仅能回收不到 2% 的内存，此时会形成恶性循环导致不停的gc使cpu负载变高。所以应该抛出该异常。大概就是，多次进行gc但是没什么效果，反而拖慢了系统的运行。
    
    4) OutOfMemoryError: Direct buffer memory demo9
    
        直接内存溢出，就是jvm之外的直接内存溢出了。使用NIO可以直接在直接内存上分配空间。
    
    5) OutOfMemoryError:unable to create new native thread demo10
    
        不能够在创建更多新的本地线程。创建的线程数超过了系统允许的最大数量就会报这个异常。
    
    6) OutOfMemoryError: MetaSpace demo11
    
        元空间溢出，元空间使用的是本地内存，它主要存放：虚拟机加载的类信息，常量池，静态变量，即时编译后的代码。
    
7) 垃圾收集器，垃圾收集算法
    
    1) 垃圾回收算法和垃圾收集器的关系？
        
        1) GC算法（引用计数、复制、标清、标整）是内存回收的方法论，垃圾收集器就是算法的落地实现。
        
        2) 到目前为止还没有完美的收集器出现，更没有万能的收集器，只能针对具体的应用最合适的收集器，进行分代收集（新生代用复制算法，老年带用标清、标整）。
    
    2) 4种垃圾收集器
    
        1) Serial 串行回收
        
            为单线程环境设计且只使用一个线程进行垃圾回收，会暂停所有的用户线程。所以不适合服务器环境。
        
        2) Parallel 并行回收
        
            多个垃圾收集线程并行工作，此时用户线程是暂停的适用于科学计算、大数据处理等弱交互应用场景。
        
        3) CMS 并发标记清除
        
            用户线程和垃圾收集线程同时执行（不一定是并行，可能交替执行），不需要停顿用户线程，适用于对响应时间有要求的场景，互联网公司常用。
        
        4) G1

            将堆内存分成不同的区域，然后并发的进行收集。
     
        5) 小结
        
            串行回收和并行回收都会出现"stop the world" 暂停应用程序。cms可以不需要暂停应用程序，但是它使用的是标记清除算法，会产生内存碎片。 
     
    3) 怎么查看服务器默认的垃圾收集器？ 
     
        使用java -XX:+PrintCommandLineFlags -version 打印出一些默认配置的参数，包括默认的垃圾收集器。
        
    4) 如何选择垃圾收集器？
        
        1) 单cpu或小内存，单机程序
        
            -XX:+UseSerialGC
            
        2) 多cpu需要最大吞吐量，如后台计算型任务
        
            -XX:+UseParallelGC 或者 -XX:+UseParallelOldGC
            
        3) 多cpu，追求停顿时间，需要快速响应，如互联网应用
        
            -XX:+UseConcMarkSweepGC 或者 -XX:+ParNewGC    
        
    5) G1垃圾收集器原理
    
        1) G1之外的收集器的特点：
            
            1) 年轻代和老年代都是各自独立且连续的内存块。
            
            2) 年轻代收集使用一个e区两个s区的赋值算法。
            
            3) 老年带收集必须扫描整个老年代区域。
            
            4) 都是以尽可能少而快速的执行GC为设计原则。
            
       
            
        
        