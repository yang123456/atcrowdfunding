package cn.yang.test.day.thread.th2;

public class ThreadTestFunction {

	private int i = 0;

	public synchronized void add() {
		i++;
		System.out.println(Thread.currentThread().getName() + "add:i=" + i);
	}

	public synchronized void sub() {
		i--;
		System.out.println(Thread.currentThread().getName() + "sub:i=" + i);
	}

}