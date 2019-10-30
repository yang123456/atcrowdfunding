package com.atguigu.atcrowdfunding.tasks;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.atguigu.atcrowdfunding.handler.SystemWebSocketHandler;

@Component
public class NotificationTask {

	/**
	 * 定时任务不执行，注意开启注解@EnableScheduling
	 */
	@Scheduled(fixedRate = 3000)
//	@Scheduled(fixedRate = 1000 * 60 * 60 * 2) // 每隔2小时执行一次
	public void scheduleMethod() {
		new SystemWebSocketHandler().doTask();
	}
}
