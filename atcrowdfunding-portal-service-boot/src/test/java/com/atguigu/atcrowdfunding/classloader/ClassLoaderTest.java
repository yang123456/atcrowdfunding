package com.atguigu.atcrowdfunding.classloader;

import java.io.IOException;
import java.io.InputStream;
/**
 * 一、类加载器的基本概念
顾名思义，类加载器（class loader）用来加载 Java 类到 Java 虚拟机中。一般来说，
Java 虚拟机使用 Java 类的方式如下：Java 源程序（.java 文件）在经过 Java 编译器编译之后就被转换成 Java 字节代码（.class 文件）。
类加载器负责读取 Java 字节代码，并转换成 java.lang.Class类的一个实例。每个这样的实例用来表示一个 Java 类。
通过此实例的 newInstance()方法就可以创建出该类的一个对象。实际的情况可能更加复杂，比如 Java 字节代码可能是通过工具动态生成的，也可能是通过网络下载的。

二、类与类加载器
对于任意一个类，都需要加载它的类加载器和这个类本身来确定这个类在Java虚拟机中的唯一性，每一个类加载器都有一个独立的类名称空间。
也就是说，如果比较两个类是否是同一个类，除了这比较这两个类本身的全限定名是否相同之外，还要比较这两个类是否是同一个类加载器加载的。
即使同一个类文件两次加载到同一个虚拟机中，但如果是由两个不同的类加载器加载的，那这两个类仍然不是同一个类。 
这个相等性比较会影响一些方法，比如Class对象的equals()方法、isAssignableFrom()方法、isInstance()方法等，
还有instanceof关键字做对象所属关系判定等。下面的代码演示了不同的类加载器对instanceof关键字的影响：
 *
 */
public class ClassLoaderTest {
    public static void main(String[] args) throws Exception{
    	/**
    	 * 构造了一个简单的类加载器
    	 */
        ClassLoader loader=new ClassLoader() {
            @Override
            public Class<?> loadClass(String name)throws ClassNotFoundException{
                try{
                    String filename=name.substring(name.lastIndexOf(".")+1)+".class";
                    InputStream is=getClass().getResourceAsStream(filename);
                    if(is==null){
                        return super.loadClass(name);
                    }
                    byte[] b=new byte[is.available()];
                    is.read(b);
                    return defineClass(name,b,0,b.length);
                }catch(IOException e){
                    throw new ClassNotFoundException(name);
                }
            }
        };
//        首先是两个术语：在前面介绍类加载器的双亲委派模型的时候，提到过类加载器会首先代理给其它类加载器来尝试加载某个类。
//        这就意味着真正完成类的加载工作的类加载器和启动这个加载过程的类加载器，有可能不是同一个。
//        真正完成类的加载工作是通过调用defineClass来实现的；
//        而启动类的加载过程是通过调用loadCl	ass来实现的。
//        前者称为一个类的定义加载器（defining loader），后者称为初始加载器（initiating loader）。
        
        Object obj=loader.loadClass("com.atguigu.atcrowdfunding.classloader.ClassLoaderTest").newInstance();
        System.out.println(obj.getClass());
        System.out.println(obj.getClass().getClassLoader());//com.atguigu.atcrowdfunding.classloader.ClassLoaderTest$1@7852e922
        System.out.println(ClassLoaderTest.class.getClassLoader());//sun.misc.Launcher$AppClassLoader@73d16e93  应用程序类加载器
        System.out.println(obj instanceof com.atguigu.atcrowdfunding.classloader.ClassLoaderTest);
    }
}



/**
 * 这里构造了一个简单的类加载器，它可以加载与自己在同一个路径下的Class文件。然后使用这个类加载器去加载全限定名是com.atguigu.atcrowdfunding.classloader.ClassLoaderTest的类，
 * 并实例化了这个类的对象。从第一行输出可以看出，这个对象确实是com.atguigu.atcrowdfunding.classloader.ClassLoaderTest类的一个实例，
 * 我们打印了一下对象obj的类加载器和ClassLoaderTest的类加载器，发现确实是不同的两个不同的类加载器，
 * 最后输出表明在做instanceof检查时出现了false，这是因为这时虚拟机中有两个com.atguigu.atcrowdfunding.classloader.ClassLoaderTest类，
 * 一个是系统应用程序类加载器加载的，另一个是自定义的类加载器加载的，这两个类虽然来自同一个Class文件，但是加载它们的类加载器不同，导致类型检查时结果是false。
 */




