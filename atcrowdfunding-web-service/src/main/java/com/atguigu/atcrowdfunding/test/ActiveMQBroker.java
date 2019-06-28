package com.atguigu.atcrowdfunding.test;

import org.apache.activemq.broker.BrokerService;
import org.apache.activemq.broker.region.policy.PolicyEntry;
import org.apache.activemq.broker.region.policy.PolicyMap;
import org.apache.activemq.command.ActiveMQQueue;

public class ActiveMQBroker {
	public static void main(String[] args) throws Exception {
		BrokerService broker = new BrokerService();
		broker.addConnector("tcp://localhost:61616");
		broker.setPersistent(false);
		broker.setUseJmx(false); // 启用JMX监控
		// 启用Advisory指定队列的消息监控
		PolicyMap policy = new PolicyMap();
		PolicyEntry entry = new PolicyEntry();
		entry.setAdvisoryForConsumed(true);
		policy.put(new ActiveMQQueue(">"), entry);
		broker.setDestinationPolicy(policy);
		broker.start();
		while (true) {
			Thread.sleep(100000);
		}
	}
}
