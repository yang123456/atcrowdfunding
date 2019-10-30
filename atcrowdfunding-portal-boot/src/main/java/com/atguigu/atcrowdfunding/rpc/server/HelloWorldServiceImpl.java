package com.atguigu.atcrowdfunding.rpc.server;

public class HelloWorldServiceImpl implements IHelloWorldService{

	@Override
	public String sayHello(String name) {
		return "hello "+name;
	}

}
