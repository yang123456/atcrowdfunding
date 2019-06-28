package com.atguigu.atcrowdfunding.test;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.atguigu.atcrowdfunding.activemq.MQProducer;
import com.atguigu.atcrowdfunding.entity.Mail;

public class MQ_Producer01 {
	private static final String brokerURL = "tcp://127.0.0.1:61616";
    private static final String QUEUE_NAME = "test-queue";
    private static final String TOPIC_NAME = "test-topic";

	ConnectionFactory connectionFactory = null;
	Connection connection = null;
	Session session = null;
	MessageProducer producer = null;

	@Before
	public void before() throws JMSException {
		connectionFactory = new ActiveMQConnectionFactory(brokerURL);
		connection = connectionFactory.createConnection();
		connection.start();
	}
	
	/**
	 * 队列模型
	 * @throws JMSException
	 */
	@Test
	public void testQueueProducer() throws JMSException {

		session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
		Queue queue = session.createQueue(QUEUE_NAME);
		producer = session.createProducer(queue);
		//Message message = session.createTextMessage("生产者在创建message");
//		producer.send(message);
		 //创建模拟100个消息
        for (int i = 1 ; i <= 100 ; i++){
            TextMessage message = session.createTextMessage("生产者发送message:" + i);
            //发送消息
            producer.send(message);
            //在本地打印消息
            System.out.println("我现在发的消息是：" + message.getText());
        }
	}
	
	/**
	 * 主题模型
	 * @throws JMSException
	 */
	@Test
	public void testTopicProducer() throws JMSException {
		session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
		 //创建队列目标
        Destination destination = session.createTopic(TOPIC_NAME);
        //创建一个生产者
        javax.jms.MessageProducer producer = session.createProducer(destination);
        //创建模拟100个消息
        for (int i = 1; i <= 100; i++) {
            TextMessage message = session.createTextMessage("当前message是(主题模型):" + i);
            //发送消息
            producer.send(message);
            //在本地打印消息
            System.out.println("我现在发的消息是：" + message.getText());
        }
	}

	@After
	public void after() throws JMSException {
		producer.close();
		session.close();
		connection.close();
	}



}
