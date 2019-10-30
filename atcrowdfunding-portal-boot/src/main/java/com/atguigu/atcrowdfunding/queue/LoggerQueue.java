package com.atguigu.atcrowdfunding.queue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import com.atguigu.atcrowdfunding.domain.LoggerMessage;

import lombok.extern.slf4j.Slf4j;

//三. 创建一个阻塞队列，作为日志系统输出的日志的一个临时载体
@Slf4j
public class LoggerQueue {
    //队列大小
    public static final int QUEUE_MAX_SIZE = 10000;
    private static LoggerQueue alarmMessageQueue = new LoggerQueue();
    //阻塞队列
    private BlockingQueue<LoggerMessage> blockingQueue= new LinkedBlockingQueue<>(QUEUE_MAX_SIZE);

    private LoggerQueue() {
    }

    public static LoggerQueue getInstance() {
        return alarmMessageQueue;
    }
    /**
     * 消息入队
     * @param log
     * @return
     */
    public boolean push(LoggerMessage logMsg) {
    	log.debug("=========消息入队=============="+logMsg);
        return this.blockingQueue.add(logMsg);//队列满了就抛出异常，不阻塞
    }
    /**
     * 消息出队
     * @return
     */
    public LoggerMessage poll() {
        LoggerMessage result = null;
        try {
            result = this.blockingQueue.take();
        	log.debug("=========消息出队=============="+result);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return result;
    }
}