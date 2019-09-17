package cn.yang.test.day.thread.th3;

import java.util.Date;

public class ThreadSortTest {

	/**
	 * 现在有T1、T2、T3三个线程，你怎样保证T2在T1执行完后执行，T3在T2执行完后执行？
	 */
	public static void main(String[] args) {

		Thread t1 = new Thread(new Runnable() {
			public void run() {
				System.out.println(Thread.currentThread().getName() + " -- " + System.currentTimeMillis());
			}
		}, "t1");

		Thread t2 = new Thread(new Runnable() {
			public void run() {
				System.out.println(Thread.currentThread().getName() + " -- " + System.currentTimeMillis());
			}
		}, "t2");

		Thread t3 = new Thread(new Runnable() {
			public void run() {
				System.out.println(Thread.currentThread().getName() + " -- " + System.currentTimeMillis());
			}
		}, "t3");

		t1.start();
		try {
			t1.join(); // t1.join()需要等t1.start()执行之后执行才有效果
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		t2.start();
		try {
			t2.join(); // t2.join()需要等t2.start()执行之后执行才有效果
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		t3.start();

	}

}
