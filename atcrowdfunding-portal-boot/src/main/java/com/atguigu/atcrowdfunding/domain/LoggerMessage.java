package com.atguigu.atcrowdfunding.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Created by kl on 2017/10/9.
 * Content :日志消息实体，注意，这里为了减少篇幅，省略了get,set代码
 * https://blog.csdn.net/zhanghui3239619/article/details/78608662
 */
//二.新增日志消息实体
@Getter
@Setter
@ToString
public class LoggerMessage{

    private String body;
    private String timestamp;
    private String threadName;
    private String className;
    private String level;

    public LoggerMessage(String body, String timestamp, String threadName, String className, String level) {
        this.body = body;
        this.timestamp = timestamp;
        this.threadName = threadName;
        this.className = className;
        this.level = level;
    }

    public LoggerMessage() {
    }
}