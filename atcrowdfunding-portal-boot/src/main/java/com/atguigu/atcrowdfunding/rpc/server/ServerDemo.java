package com.atguigu.atcrowdfunding.rpc.server;

/**
 * @author Dongguabai
 * @date 2018/11/1 18:07
 */
public class ServerDemo {

	public static void main(String[] args) {
		// 之前发布服务
		/*
		 * RpcServer rpcServer = new RpcServer(); rpcServer.publisher(new
		 * HelloServiceImpl(),12345);
		 */
		// 改造后
//		IRegistryCenter registryCenter = new RegistryCenterImpl();
//		// 这里为了方便，获取ip地址就直接写了
//		RpcServer rpcServer = new RpcServer(registryCenter, "127.0.0.1:12345");
//		// 绑定服务
//		rpcServer.bind(new HelloWorldServiceImpl());
//		rpcServer.publisher();
	}

}