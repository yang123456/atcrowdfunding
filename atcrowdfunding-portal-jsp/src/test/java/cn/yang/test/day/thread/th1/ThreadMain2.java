package cn.yang.test.day.thread.th1;
//练题1:编写程序实现,子线程循环3次,接着主线程循环5次,接着再子线程循环3次,主线程循环5次,如此反复,循环3次.

//第一种实现方式：使用synchronized关键字

public class ThreadMain2 {

	public static void main(String[] args) {
//		final ThreadFunction2 f2 = new ThreadFunction2();
		final ThreadFunction f2 = new ThreadFunction();

		// 子线程循环3次
		new Thread(new Runnable() {
			public void run() {
				for (int i = 0; i < 3; i++) {
					f2.subFunction();
				}
			}
		}).start();

		// 主线程循环3次
		for (int i = 0; i < 3; i++) {
			f2.mainFunction();
		}
	}

}

/**
 * 
 * Lock和synchronized的选择
 * 
 * 总结来说，Lock和synchronized有以下几点不同：
 * 
 * 1）Lock是一个接口，而synchronized是Java中的关键字，synchronized是内置的语言实现；
 * 
 * 2）synchronized在发生异常时，会自动释放线程占有的锁，因此不会导致死锁现象发生；而Lock在发生异常时，
 * 如果没有主动通过unLock()去释放锁，则很可能造成死锁现象，因此使用Lock时需要在finally块中释放锁；
 * 
 * 3）Lock可以让等待锁的线程响应中断，而synchronized却不行，使用synchronized时，等待的线程会一直等待下去，不能够响应中断；
 * 
 * 4）通过Lock可以知道有没有成功获取锁，而synchronized却无法办到。
 * 
 * 5）Lock可以提高多个线程进行读操作的效率。
 * 
 * 在性能上来说，如果竞争资源不激烈，两者的性能是差不多的，而当竞争资源非常激烈时（即有大量线程同时竞争），
 * 此时Lock的性能要远远优于synchronized。所以说，在具体使用时要根据适当情况选择。
 */