package com.atguigu.atcrowdfunding.guava.eventBus;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.eventbus.Subscribe;

public class ExceptionListener {

	private final static Logger LOGGER = LoggerFactory.getLogger(ExceptionListener.class);

	@Subscribe
	public void m1(final String event) {
		LOGGER.info("Received event [{}] and will take m1", event);
	}

	@Subscribe
	public void m2(final String event) {
		LOGGER.info("Received event [{}] and will take m2", event);
	}

	@Subscribe
	public void m3(final String event) {
		LOGGER.info("Received event [{}] and will take m3", event);
		throw new RuntimeException();
	}
}
