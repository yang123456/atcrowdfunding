package com.atguigu.atcrowdfunding.rpc.client;
 
import java.util.List;
 
/**
 * 负载顶层接口
 * @author Dongguabai
 * @date 2018/11/2 10:11
 */
public interface LoadBalance {
 
    String selectHost(List<String> repos);

}