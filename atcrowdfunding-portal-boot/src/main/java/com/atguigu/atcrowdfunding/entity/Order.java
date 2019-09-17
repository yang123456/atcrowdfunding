package com.atguigu.atcrowdfunding.entity;

import com.atguigu.atcrowdfunding.enums.OrderStateMachine;
/**
 * 订单派送场景   枚举模拟 订单状态
 */
public class Order {
	private OrderStateMachine stateMachine=OrderStateMachine.DISPATCHING;
	private String name;
	public Order nextStatus() {
		this.stateMachine=this.stateMachine.nextState();
		return this;
	}
	
	public void log() {
		System.out.println(this.stateMachine.prevState()+"--》"+this.stateMachine.name());
	}

	public OrderStateMachine getStateMachine() {
		return stateMachine;
	}

	public void setStateMachine(OrderStateMachine stateMachine) {
		this.stateMachine = stateMachine;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public static void main(String[] args) {
		Order order=new Order();
		order.setName("丝滑的肥皂");
		order.nextStatus();
		order.log();
		order.nextStatus();
		order.log();
	}
}


