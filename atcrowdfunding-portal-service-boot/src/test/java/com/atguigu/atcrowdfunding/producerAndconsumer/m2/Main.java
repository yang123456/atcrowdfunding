package com.atguigu.atcrowdfunding.producerAndconsumer.m2;
/**
 * 
 * 一个生产者线程运行produce方法，睡眠1s；一个消费者运行一次consume方法，睡眠3s。
 * 此次实验过程中，有3个生产者和3个消费者，也就是我们说的多对多的情况。
 * 仓库的容量为10，可以看出消费的速度明显慢于生产的速度，符合设定。
 */
public class Main {

	public static void main(String[] args) {
		Storage storage = new Storage();
		Thread p1 = new Thread(new Producer(storage));
		Thread p2 = new Thread(new Producer(storage));
		Thread p3 = new Thread(new Producer(storage));

		Thread c1 = new Thread(new Consumer(storage));
		Thread c2 = new Thread(new Consumer(storage));
		Thread c3 = new Thread(new Consumer(storage));

		p1.start();
		p2.start();
		p3.start();
		c1.start();
		c2.start();
		c3.start();
		
		
		

	}
}
