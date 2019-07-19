package com.atguigu.atcrowdfunding.guava.eventBus;

import com.google.common.eventbus.Subscribe;

public class MultiEventListener {//多个订阅者

   @Subscribe
   public void listen(OrderEvent event){
       System.out.println("receive msg: "+event.getMessage());
   }

   @Subscribe
   public void listen(String message){
       System.out.println("receive msg: "+message);
   }
}
