package com.atguigu.atcrowdfunding.http;

import java.util.HashMap;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.atguigu.atcrowdfunding.entity.OkHttpParam;
import com.atguigu.atcrowdfunding.entity.OkhttpResult;
import com.atguigu.atcrowdfunding.utils.OkHttpClients;

public class OkHttpClientsTest {
 
  public static void main(String[] args) throws Exception {
 
    OkHttpParam param = new OkHttpParam();
    param.setApiUrl("http://127.0.0.1:7015/api");
    param.setApiPath("/batch/btb_batchinfo");
 
    Map<String, String> map = new HashMap<>();
 
    String a = "{\"body\":{\"batch_list\":[{\"batch_code\":\"3934630\",\"box_list\":[{\"box_code\":\"3934630201807*07\",\"qty\":1,\"sku\":\"6508827101\"},{\"box_code\":\"3934630201807*07\",\"qty\":1,\"sku\":\"S970000901\"},{\"box_code\":\"3934630201807*08\",\"qty\":1,\"sku\":\"6508827101\"}],\"from_warehouse\":\"218\",\"to_warehouse\":\"1321\"}]},\"header\":{\"message_id\":\"2018080114182503500949856842\",\"sign\":\"d21caa4cad66de334fafdcfa7b345bff\",\"time_stamp\":\"1533104305350\",\"transaction_type\":\"btb_batchinfo\"}}";
 
    map.put("msg", JSON.toJSONString(a));
 
    OkhttpResult<String> result = OkHttpClients.post(param, map, String.class);
 
    System.out.println("result："+JSON.toJSONString(result));
 
 
  }
 
}
