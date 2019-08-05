package com.atguigu.atcrowdfunding.producerAndconsumer.m2;

import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 
 * 2. await() / signal()方法 在JDK5中，用ReentrantLock和Condition可以实现等待/通知模型，具有更大的灵活性。
 * 通过在Lock对象上调用newCondition()方法，将条件变量和一个锁对象进行绑定，进而控制并发程序访问竞争资源的安全。
 *
 */
public class Storage {

	// 仓库最大存储量
	private final int MAX_SIZE = 10;
	// 仓库存储的载体
	private LinkedList<Object> list = new LinkedList<Object>();
	// 锁
	private final Lock lock = new ReentrantLock();
	// 仓库满的条件变量
	private final Condition full = lock.newCondition();
	// 仓库空的条件变量
	private final Condition empty = lock.newCondition();

	public void produce() {
		// 获得锁
		lock.lock();
		while (list.size() + 1 > MAX_SIZE) {
			System.out.println("【生产者" + Thread.currentThread().getName() + "】仓库已满");
			try {
				full.await();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		list.add(new Object());
		System.out.println("【生产者" + Thread.currentThread().getName() + "】生产一个产品，现库存" + list.size());

		// 唤醒其他所有线程、释放锁
		full.signalAll();
		empty.signalAll();
		lock.unlock();
	}

	public void consume() {
		// 获得锁
		lock.lock();
		while (list.size() == 0) {
			System.out.println("【消费者" + Thread.currentThread().getName() + "】仓库为空");
			try {
				empty.await();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		list.remove();
		System.out.println("【消费者" + Thread.currentThread().getName() + "】消费一个产品，现库存" + list.size());

		// 唤醒其他所有线程、释放锁
		full.signalAll();
		empty.signalAll();
		lock.unlock();
	}
}