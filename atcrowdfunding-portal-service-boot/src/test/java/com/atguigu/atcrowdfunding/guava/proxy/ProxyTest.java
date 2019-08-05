package com.atguigu.atcrowdfunding.guava.proxy;

import org.junit.Assert;
import org.junit.Test;

public class ProxyTest {
	@Test
	public void jdkNewProxyTest() {
		AddServiceImpl service = new AddServiceImpl();
		JdkInvocationHandlerImpl<AddService> addServiceHandler = new JdkInvocationHandlerImpl<>(service);
		AddService proxy = addServiceHandler.getProxy();
		Assert.assertEquals(3, proxy.add(1, 2));
	}

	@Test
	public void guavaNewProxyTest() {
		AddServiceImpl service = new AddServiceImpl();
		GuavaInvocationHandlerImpl<AddService> addServiceHandler = new GuavaInvocationHandlerImpl<>(AddService.class,
				service);
		AddService proxy = addServiceHandler.getProxy();
		Assert.assertEquals(3, proxy.add(1, 2));
	}
}
