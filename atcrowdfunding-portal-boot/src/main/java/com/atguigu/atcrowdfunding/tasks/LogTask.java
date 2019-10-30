package com.atguigu.atcrowdfunding.tasks;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class LogTask {

	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
	private Logger logger = LoggerFactory.getLogger(LogTask.class);
	static int count =0;
	/**
	 * 定时任务不执行，注意开启注解@EnableScheduling
	 */
	// 定义每过1秒执行任务
    @Scheduled(fixedRate = 1000)
//	@Scheduled(cron = "4-40 * * * * ?")
    public void reportCurrentTime() {
//    	System.out.println("现在时间：" + dateFormat.format(new Date()));
//    	logger.info("======LogTask====="+count++);
    }
}
