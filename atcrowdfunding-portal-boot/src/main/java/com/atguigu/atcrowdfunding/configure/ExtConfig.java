package com.atguigu.atcrowdfunding.configure;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.atguigu.atcrowdfunding.domain.Book;

/**@Description 配置类就等同以前的配置文件
 * 扩展原理:
 * BeanPostProcessor：bean的后置处理器，bean创建对象初始化前后进行拦截工作的
 *
 * BeanFactoryPostProcessor：BeanFactory的后置处理器，在BeanFactory的标准初始化之后调用
 * 所有bean的定义已经保存加载到BeanFactory，但是bean的实例还未创建
 */
@Configuration//告诉Spring这是一个配置类
@ComponentScan("com.atguigu.atcrowdfunding.processor")//相当于是xml配置文件里面的<context:component-scan base-package="com.atguigu.atcrowdfunding.processor"/>
//excludeFilters = Filter[];指定在扫描的时候按照什么规则来排除脑哪些组件
//includeFilters = Filter[];指定在扫描的时候，只需要包含哪些组件
//@ComponentScan(value = "com.ldc",includeFilters = {
//      //这里面是一个@Filter注解数组，FilterType.ANNOTATION表示的排除的规则 ：按照注解的方式来进行排除
//      //classes = {Controller.class}表示的是标有这些注解的类给纳入到IOC容器中
//      @Filter(type = FilterType.ANNOTATION, classes = {Controller.class})
//},useDefaultFilters = false)
public class ExtConfig {
	 //相当于xml配置文件中的<bean>标签，告诉容器注册一个bean
    //之前xml文件中<bean>标签有bean的class类型，那么现在注解方式的类型当然也就是返回值的类型
    //之前xml文件中<bean>标签有bean的id，现在注解的方式默认用的是方法名来作为bean的id
	 //singleton:单实例的
    //prototype:多实例的
    //request:同一次请求创建一个实例
    //session:同一个session创建的一个实例
    @Scope("prototype")
    @Bean
//    @Bean(value = "person")//通过这个value属性可以指定bean在IOC容器的id
    public Book blue() {
        return new Book();
    }

}
