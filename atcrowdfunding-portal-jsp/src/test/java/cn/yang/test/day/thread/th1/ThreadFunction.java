package cn.yang.test.day.thread.th1;
 
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
 
// 编写功能类,实现子线程和主线程的功能
public class ThreadFunction extends Thread{
	
	private boolean flag = false;
	Lock lock = new ReentrantLock();
	Condition con = lock.newCondition();
	
    // 主线程要实现的功能
	public void mainFunction(){ 
		System.out.println("1.主线程开始"+" -- flag="+flag);
		lock.lock();
		try{ 
			while(!flag){ 
				try {
					System.out.println("2.主线程等待"+" -- flag="+flag);
					con.await();   // 使当前线程加入 await() 等待队列中，并释放当锁，当其他线程调用signal()会重新请求锁。与Object.wait()类似。
				} catch (InterruptedException e) { 
					e.printStackTrace();
				} 
			}  
			System.out.println("7.主线程开始循环5次"+" -- flag="+flag);
			for(int i=0;i<5;i++){ 
				System.out.println("mainFunction"+i+" -- flag="+flag); 
			}
			flag = false;
			System.out.println("8.唤醒子线程"+" -- flag="+flag);
			con.signal();  // 唤醒一个在 await()等待队列中的线程。与Object.notify()相似
		}finally{
			lock.unlock(); 
		}
		 
		
		
	}
	
    // 子线程要实现的功能
	public void subFunction(){ 
		System.out.println("3.子线程开始"+" -- flag="+flag);
		lock.lock(); 
		try{
			while(flag){
				try {
					System.out.println("6.子线程等待"+" -- flag="+flag);
					con.await();  // 使当前线程加入 await() 等待队列中，并释放当锁，当其他线程调用signal()会重新请求锁。与Object.wait()类似。
				} catch (InterruptedException e) { 
					e.printStackTrace();
				}  
			}
			System.out.println("4.子线程开始循环3次"+" -- flag="+flag);
			for(int i=0;i<3;i++){
				System.out.println("subFunction"+i+" -- flag="+flag);
			}
			flag = true;
			System.out.println("5.唤醒主线程"+" -- flag="+flag);
			con.signal(); // 唤醒一个在 await()等待队列中的线程。与Object.notify()相似
		}finally{
			lock.unlock();  
		}  
	} 
}
