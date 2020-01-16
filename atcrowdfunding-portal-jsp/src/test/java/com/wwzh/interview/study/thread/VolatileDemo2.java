package com.wwzh.interview.study.thread;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 1 验证volatile的可见性 1.1 假如 int number = 0; number变量之前根本没有添加volatile关键字修饰，没有可见性
 * 1.2 添加了 volatile int number = 0; 可以解决可见性问题。
 * 
 * 2 验证volatile不保证原子性 2.1 原子性指的是什么意思？
 * 不可分割，完整性，也即某个线程正在做某个具体业务时，中间不可以被加塞或者被分割。需要整体完整，要么同时成功，要么同时失败。
 * 
 * 2.2 volatile不保证原子性的案例演示
 * 
 */
public class VolatileDemo2 {

	public static void main(String[] args) {
		MyData1 myData = new MyData1();
		//20个线程去调用addplus方法，每个线程调用1000次，则结果应该是20000。
		for (int i = 1; i <= 20; i++) {
			new Thread(() -> {
				for (int j = 1; j <=1000; j++) {
					myData.addPlusPlus();
					myData.addAtomic();
				}
			}, String.valueOf(i)).start();

		}
		// 需要等待上面20个线程全部计算完成后，再用main线程取得最终的结果值看是多少？
		while (Thread.activeCount() > 2) {
			Thread.yield();
		}
		System.out.println(Thread.currentThread().getName() + "\t finally number value:"+myData.number);
		System.out.println(Thread.currentThread().getName() + "\t finally number value:"+myData.atomicInteger);
	}

}

class MyData1 {
	volatile int number = 0;//不保证原子性

	public  void addPlusPlus() {
		this.number++;
	}
	
	AtomicInteger atomicInteger=new AtomicInteger();
	public  void addAtomic() {
		atomicInteger.getAndIncrement();
	}

}