package com.atguigu.atcrowdfunding.test;

import java.io.StringWriter;
import java.util.Properties;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;


public class VelocityTemplate {
    public static String getVelocityTemplate(String basePath) throws Exception {
        String sysRoot = VelocityTemplate.class.getResource("").getPath();
        Properties properties = new Properties();
        //设置velocity资源加载方式为file
        properties.setProperty("resource.loader", "file");
        //设置velocity资源加载方式为file时的处理类
        properties.setProperty("file.resource.loader.class","org.apache.velocity.runtime.resource.loader.FileResourceLoader");
        properties.put("input.encoding", "UTF-8");
        properties.put("output.encoding", "UTF-8");
        //实例化一个VelocityEngine对象
        VelocityEngine velocityEngine = new VelocityEngine(properties);
        //实例化一个VelocityContext
        VelocityContext velocityContext = new VelocityContext();
        //向VelocityContext中放入键值
        velocityContext.put("username", "张三");
        velocityContext.put("password", "123456789");
        velocityContext.put("age", "20");
        //实例化一个StringWriter
        StringWriter stringWriter=new StringWriter();
        Template template = velocityEngine.getTemplate(sysRoot+basePath, "UTF-8");
        template.merge(velocityContext, stringWriter);
        return stringWriter.toString();
    }
}
