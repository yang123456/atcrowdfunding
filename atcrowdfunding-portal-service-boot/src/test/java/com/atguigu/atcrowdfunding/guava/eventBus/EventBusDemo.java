package com.atguigu.atcrowdfunding.guava.eventBus;

import com.google.common.eventbus.EventBus;

public class EventBusDemo {
   public static void main(String[] args) {
       EventBus eventBus=new EventBus("jack");
       /*
         如果多个subscriber订阅了同一个事件,那么每个subscriber都将收到事件通知
         并且收到事件通知的顺序跟注册的顺序保持一致
        */
       eventBus.register(new EventListener()); //注册订阅者
//       eventBus.register(new MultiEventListener());
       eventBus.post(new OrderEvent("hello")); //发布事件
       eventBus.post(new OrderEvent("world"));
       eventBus.post("!");
       
     //重写EventBus的toString方法，使eventBus的名称为DEAD-EVENT-BUS
       final EventBus eventBus1 = new EventBus(){
           @Override public String toString() {
               return "DEAD-EVENT-BUS";
           }
       };
       DeadEventListener deadEventListener = new DeadEventListener();
       eventBus1.register(deadEventListener);
       eventBus1.post("...DeadEventListener event");
   }
}
