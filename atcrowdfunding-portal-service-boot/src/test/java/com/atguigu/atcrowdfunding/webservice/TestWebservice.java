package com.atguigu.atcrowdfunding.webservice;

import org.apache.cxf.endpoint.Client;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;


/**
 * @ClassName:CxfClient
 * @Description:webservice客户端： 该类提供两种不同的方式来调用webservice服务 1：代理工厂方式
 *                             2：动态调用webservice
 * @author Jerry
 * @date:2018年4月10日下午4:14:07
 */
public class TestWebservice {

	public static void main(String[] args) {
		TestWebservice.main1();
		TestWebservice.main2();
	}

	/**
	 * 1.代理类工厂的方式,需要拿到对方的接口地址
	 */
	public static void main1() {
		try {
			// 接口地址
			String address = "http://localhost:8082/cxf/hello?wsdl";
			// 代理工厂
			JaxWsProxyFactoryBean jaxWsProxyFactoryBean = new JaxWsProxyFactoryBean();
			// 设置代理地址
			jaxWsProxyFactoryBean.setAddress(address);
			// 设置接口类型
			jaxWsProxyFactoryBean.setServiceClass(IHello.class);
			// 创建一个代理接口实现
			IHello us = (IHello) jaxWsProxyFactoryBean.create();
			// 数据准备
			String username = "maple";
			// 调用代理接口的方法调用并返回结果
			String result = us.sayHello(username);
			System.out.println("返回结果:" + result);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 2：动态调用
	 */
	public static void main2() {
		// 创建动态客户端
		JaxWsDynamicClientFactory dcf = JaxWsDynamicClientFactory.newInstance();
		Client client = dcf.createClient("http://localhost:8082/cxf/hello?wsdl");
		// 需要密码的情况需要加上用户名和密码
		// client.getOutInterceptors().add(new ClientLoginInterceptor(USER_NAME,
		// PASS_WORD));
		Object[] objects = new Object[0];
		try {
			// invoke("方法名",参数1,参数2,参数3....);
			objects = client.invoke("sayHello", "maple");
			System.out.println("返回数据:" + objects[0]);
		} catch (java.lang.Exception e) {
			e.printStackTrace();
		}
	}
}