package com.atguigu.atcrowdfunding.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class MyListener implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent servletContextEvent) {
		System.out.println("访问了MyListener的contextInitialized方法,启动了监听");
	}

	@Override
	public void contextDestroyed(ServletContextEvent servletContextEvent) {
		System.out.println("访问了MyListener的contextDestroyed方法,销毁了监听");
	}

}
