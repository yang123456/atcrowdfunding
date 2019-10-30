package com.atguigu.atcrowdfunding.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import com.atguigu.atcrowdfunding.domain.ReceiveMessage;

@Controller
public class WebSocketSubController {
    @Autowired
    public SimpMessagingTemplate template;  
      
    
    @MessageMapping("/subscribe")
    public void subscribe(ReceiveMessage rm) {
        for(int i =1;i<=20;i++) {
            //广播使用convertAndSend方法，第一个参数为目的地，和js中订阅的目的地要一致
            template.convertAndSend("/topic/getResponse", rm.getName());//直接向前端推送消息
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
    
    @MessageMapping("/queue")
    public void queuw(ReceiveMessage rm) {
        System.out.println("进入方法");
        for(int i =1;i<=20;i++) {
            /*广播使用convertAndSendToUser方法，第一个参数为用户id，此时js中的订阅地址为
            "/user/" + 用户Id + "/message",其中"/user"是固定的*/
            template.convertAndSendToUser("zhangsan","/message",rm.getName());//直接向前端推送消息
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}