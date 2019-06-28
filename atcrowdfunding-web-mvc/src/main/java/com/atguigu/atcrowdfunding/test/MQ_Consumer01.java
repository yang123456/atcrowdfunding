package com.atguigu.atcrowdfunding.test;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MQ_Consumer01 {
	private static final String brokerURL = "tcp://127.0.0.1:61616";
	private static final String QUEUE_NAME = "test-queue";
	private static final String TOPIC_NAME = "test-topic";
	    
	ConnectionFactory connectionFactory = null;
	Connection connection = null;
	Session session = null;
	MessageConsumer consumer = null;

	@Before
	public void before() throws JMSException {
		connectionFactory = new ActiveMQConnectionFactory(brokerURL);
		connection = connectionFactory.createConnection();
		connection.start();
	}

	@Test
	public void testQueueConsumer() throws JMSException {

		session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
		Queue queue = session.createQueue(QUEUE_NAME);
		consumer = session.createConsumer(queue);
		consumer.setMessageListener(new MessageListener() {
			@Override
			public void onMessage(Message message) {
				if(message instanceof TextMessage) {
					TextMessage textMessage = (TextMessage) message;
					try {
						System.out.println("获取消息：" + textMessage.getText());
					} catch (JMSException e) {
						e.printStackTrace();
					}
				}
			}
		});

	}
	
	@Test
	public void testTopicConsumer() throws JMSException {
		session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
		//创建队列目标
        Destination destination = session.createTopic(TOPIC_NAME);
		consumer = session.createConsumer(destination);
		consumer.setMessageListener(new MessageListener() {
			@Override
			public void onMessage(Message message) {
				if(message instanceof TextMessage) {
					TextMessage textMessage = (TextMessage) message;
					try {
						System.out.println("获取消息：" + textMessage.getText());
					} catch (JMSException e) {
						e.printStackTrace();
					}
				}
			}
		});

	}

	@After
	public void after() throws JMSException {
		consumer.close();
		session.close();
		connection.close();
	}

}
