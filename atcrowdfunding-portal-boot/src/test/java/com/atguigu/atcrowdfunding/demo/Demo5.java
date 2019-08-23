package com.atguigu.atcrowdfunding.demo;

import java.util.Date;

public class Demo5 {
	private static Date date = new Date();

	public static void main(String[] args) {
		System.out.println(Thread.currentThread().getName()+">>>"+date.getTime());

		new Thread(new Runnable() {

			@Override
			public void run() {
				System.out.println(Thread.currentThread().getName()+">>>"+date.getTime());
			}
		}, "aa").start();

		new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println(Thread.currentThread().getName()+">>>"+date.getTime());
			}
		}, "bb").start();

	}

}
