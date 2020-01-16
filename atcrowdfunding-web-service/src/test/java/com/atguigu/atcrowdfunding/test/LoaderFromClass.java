package com.atguigu.atcrowdfunding.test;

import java.io.StringWriter;
import java.util.Properties;

import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;

/**
 * 从class(类路径)中加载模板文件
 * @author welcome
 *
 */
public class LoaderFromClass {
    
    public static void main(String[] args) throws Exception{
        //初始化参数
        Properties properties=new Properties();
        //设置velocity资源加载方式为class
        properties.setProperty("resource.loader", "class");
        //设置velocity资源加载方式为file时的处理类
        properties.setProperty("class.resource.loader.class", "org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");
        //实例化一个VelocityEngine对象
        VelocityEngine velocityEngine=new VelocityEngine(properties);
        
        //实例化一个VelocityContext
        VelocityContext context=new VelocityContext();
        //向VelocityContext中放入键值
        context.put("username", "张三");
        context.put("password", "123456789");
        context.put("age", "20");
        context.put("address", "陕西西安"); 
        context.put("blog", "http://blogjava.net/sxyx2008");
        //实例化一个StringWriter
        StringWriter writer=new StringWriter();
        
        //从src目录下加载hello.vm模板
        //假若在com.velocity.test包下有一个hello.vm文件,那么加载路径为com/velocity/test/hello.vm
        velocityEngine.mergeTemplate("com/atguigu/atcrowdfunding/test/hello.vm", "gbk", context, writer);
        
        String content = writer.toString();
        String username = (String) context.get("username");
        System.out.println(username);
        
        //velocityEngine.mergeTemplate("hello.vm", "gbk", context, writer);
        System.out.println(writer.toString());
    }
}