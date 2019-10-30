package com.atguigu.atcrowdfunding.controller;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.converter.MessageConverter;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSONObject;
import com.atguigu.atcrowdfunding.domain.LoggerMessage;
import com.atguigu.atcrowdfunding.queue.LoggerQueue;

@Controller
@RequestMapping("/websocket")
public class WebSocketController {
	// 通过simpMessagingTemplate向浏览器发送消息
	@Autowired
	private SimpMessagingTemplate messagingTemplate;

	@RequestMapping("/client")
	public String client() {

		return "websocket-client";
	}

	@RequestMapping("/logPrint")
	public String logPrint() {
		return "websocket-log";
	}

	@RequestMapping("/topic")
	public String topic() {

		return "topic";
	}

	@RequestMapping("/queue")
	public String queue() {
		return "queue";
	}

	@RequestMapping("/notify")
	public String notification() {
		return "notification";
	}

	@MessageMapping("/sayName") // 当浏览器向服务端发送请求时,通过@MessageMapping映射/sayName这个地址,类似于@ResponseMapping
	@SendTo("/topic/pullLogger") // 当服务器有消息时,会对订阅了@SendTo中的路径的浏览器发送消息
	public JSONObject say(JSONObject jsonObject) {
		try {
			// 睡眠1秒
			System.out.println("=======message=======" + jsonObject.getString("name"));
			jsonObject.put("a", jsonObject.getString("name") + "vvvv");
			jsonObject.put("b", jsonObject.getString("name") + "yyyy");
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return jsonObject;
	}

	/**
	 * 推送日志到/topic/pullLogger
	 */
	@PostConstruct
	public void pushLogger() {
		ExecutorService executorService = Executors.newFixedThreadPool(2);
		Runnable runnable = new Runnable() {
			@Override
			public void run() {
				while (true) {
					try {
						LoggerMessage log = LoggerQueue.getInstance().poll();
						if (log != null) {
							if (messagingTemplate != null)
								messagingTemplate.convertAndSend("/topic/pullLogger", log);
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		};
		executorService.submit(runnable);
		executorService.submit(runnable);

	}
}
