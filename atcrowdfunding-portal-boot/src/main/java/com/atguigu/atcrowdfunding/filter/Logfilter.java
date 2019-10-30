package com.atguigu.atcrowdfunding.filter;

import java.text.DateFormat;
import java.util.Date;

import com.atguigu.atcrowdfunding.domain.LoggerMessage;
import com.atguigu.atcrowdfunding.queue.LoggerQueue;

import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.filter.Filter;
import ch.qos.logback.core.spi.FilterReply;
/**
 *	日志过滤器
 */
public class Logfilter extends Filter<ILoggingEvent> {

	@Override
	public FilterReply decide(ILoggingEvent event) {
//		System.out.println("===========Logfilter=======decide========="+event);
		LoggerMessage loggerMessage = new LoggerMessage(event.getMessage(),
				DateFormat.getDateTimeInstance().format(new Date(event.getTimeStamp())), event.getThreadName(),
				event.getLoggerName(), event.getLevel().levelStr);
		LoggerQueue.getInstance().push(loggerMessage);
		return FilterReply.ACCEPT;
	}

}
