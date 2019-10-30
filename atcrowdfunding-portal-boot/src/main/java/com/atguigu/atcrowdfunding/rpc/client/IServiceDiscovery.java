
package com.atguigu.atcrowdfunding.rpc.client;
 
/**
 * @author Dongguabai
 * @date 2018/11/2 9:55
 */
public interface IServiceDiscovery {
 
    /**
     * 根据接口名称发现服务调用地址
     * @param serviceName
     * @return
     */
    String discover(String serviceName);

}