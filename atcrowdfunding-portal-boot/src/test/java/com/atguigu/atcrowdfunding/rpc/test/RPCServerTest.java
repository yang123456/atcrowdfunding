package com.atguigu.atcrowdfunding.rpc.test;
import com.atguigu.atcrowdfunding.rpc.server.HelloService;
import com.atguigu.atcrowdfunding.rpc.server.HelloServiceImpl;
import com.atguigu.atcrowdfunding.rpc.server.Server;
import com.atguigu.atcrowdfunding.rpc.server.ServerCenter;
public class RPCServerTest {
	public static void main(String[] args) {
		//开启一个线程
		new Thread(new Runnable() {
			@Override
			public void run() {
				//服务中心
				Server server = new ServerCenter(9999);
				//将HelloService接口及实现类 注册到 服务中心
				server.register(HelloService.class, HelloServiceImpl.class);
				server.start(); 
			}
		}).start();//start()
	}
}
