package com.atguigu.atcrowdfunding.demo;



import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.atguigu.atcrowdfunding.configure.ExtConfig;
import com.atguigu.atcrowdfunding.configure.MyConfigure;
import com.atguigu.atcrowdfunding.domain.Book;

public class Demo01 {
	public static void main(String[] args) {
//		ApplicationContext ctx=new AnnotationConfigApplicationContext(MyConfigure.class);
//		Book bean =(Book) ctx.getBean(Book.class);
//		System.out.println(bean.getId());
//		String[] beanNames = ctx.getBeanNamesForType(Book.class);
//		for (int i = 0; i < beanNames.length; i++) {
//			System.out.println(beanNames[i]);
//		}
		System.out.println("======BeanPostProcessor：bean===========");
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(ExtConfig.class);
        System.out.println(applicationContext);
        applicationContext.close();

        
        
        
	}
}
