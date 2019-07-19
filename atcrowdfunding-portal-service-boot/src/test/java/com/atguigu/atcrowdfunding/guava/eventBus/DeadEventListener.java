package com.atguigu.atcrowdfunding.guava.eventBus;

import com.google.common.eventbus.DeadEvent;
import com.google.common.eventbus.Subscribe;

//如果EventBus发送的消息都不是订阅者关心的称之为Dead Event。
public class DeadEventListener {
   boolean isDelivered=true;

   @Subscribe
   public void listen(DeadEvent event){
       isDelivered=false;
       
       System.out.println("获取事件源"+event.getSource());//DEAD-EVENT-BUS
       System.out.println("获取事件"+event.getEvent());//DeadEventListener event
       System.out.println(event.getSource().getClass()+"  "+event.getEvent()); //source通常是EventBus
   }

   public boolean isDelivered() {
       return isDelivered;
   }
}
