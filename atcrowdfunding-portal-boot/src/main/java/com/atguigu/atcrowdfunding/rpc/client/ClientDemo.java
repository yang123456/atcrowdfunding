package com.atguigu.atcrowdfunding.rpc.client;

import com.atguigu.atcrowdfunding.rpc.server.RegistryCenterConfig;

/**
 * @author Dongguabai
 * @date 2018/11/1 18:10
 */
public class ClientDemo {
 
    public static void main(String[] args) {
        /*RpcClientProxy proxy = new RpcClientProxy();
        IHelloService helloService = proxy.clientProxy(IHelloService.class, "127.0.0.1", 12345);
        String name = helloService.sayHello("张三");
        System.out.println(name);*/
 
//        IServiceDiscovery serviceDiscovery = new ServiceDiscoveryImpl(RegistryCenterConfig.CONNECTING_STR);
//        RpcClientProxy proxy = new RpcClientProxy(serviceDiscovery);
//        IHelloWorldService service = proxy.clientProxy(IHelloWorldService.class);
//        System.out.println(service.sayHello("张三"));
 
    }
}
