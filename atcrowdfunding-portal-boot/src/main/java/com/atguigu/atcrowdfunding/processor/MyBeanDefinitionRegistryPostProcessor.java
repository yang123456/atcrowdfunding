package com.atguigu.atcrowdfunding.processor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.stereotype.Component;

import com.atguigu.atcrowdfunding.domain.Book;
/**
 * 
2、BeanDefinitionRegistryPostProcessor extends BeanFactoryPostProcessor
  		postProcessBeanDefinitionRegistry();
  		在所有bean定义信息将要被加载，bean实例还未创建的；

  		优先于BeanFactoryPostProcessor执行；
  		利用BeanDefinitionRegistryPostProcessor给容器中再额外添加一些组件；

  	原理：
  		1）、ioc创建对象
  		2）、refresh()-》invokeBeanFactoryPostProcessors(beanFactory);
  		3）、从容器中获取到所有的BeanDefinitionRegistryPostProcessor组件。
  			1、依次触发所有的postProcessBeanDefinitionRegistry()方法
  			2、再来触发postProcessBeanFactory()方法BeanFactoryPostProcessor；

  		4）、再来从容器中找到BeanFactoryPostProcessor组件；然后依次触发postProcessBeanFactory()方法
 *
 */
@Component
public class MyBeanDefinitionRegistryPostProcessor implements BeanDefinitionRegistryPostProcessor {

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        System.out.println("MyBeanDefinitionRegistryPostProcessor...bean的数量"+beanFactory.getBeanDefinitionCount());
    }

    //BeanDefinitionRegistry是bean定义信息的保存中心，以后BeanFactory就是按照BeanDefinitionRegistry里面保存的每一个bean的定义信息创建bean的实例
    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
        System.out.println("MyBeanDefinitionRegistryPostProcessor...bean的数量"+registry.getBeanDefinitionCount());
        RootBeanDefinition beanDefinition = new RootBeanDefinition(Book.class);
        registry.registerBeanDefinition("hello",beanDefinition);
    }
}
