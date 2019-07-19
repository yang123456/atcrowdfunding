package com.atguigu.atcrowdfunding.processor;

import java.util.stream.Stream;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;
/**
 * 
 * BeanFactoryPostProcessor原理:
  1)、ioc容器创建对象
  2)、invokeBeanFactoryPostProcessors(beanFactory);
  		如何找到所有的BeanFactoryPostProcessor并执行他们的方法；
  			1）、直接在BeanFactory中找到所有类型是BeanFactoryPostProcessor的组件，并执行他们的方法
  			2）、在初始化创建其他组件前面执行
 *
 */
@Component
public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
		System.out.println("MyBeanFactoryPostProcessor...PostProcessorBeanFactory...");
		int count = beanFactory.getBeanDefinitionCount();
		String[] beanDefinitionNames = beanFactory.getBeanDefinitionNames();
		System.out.println("当前的BeanFactory中有" + count + "个Bean");
		Stream.of(beanDefinitionNames).forEach(System.out::println);
	}
}
