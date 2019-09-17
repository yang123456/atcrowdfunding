package cn.yang.test.day.thread.th1;
// 编写功能类,实现子线程和主线程的功能
public class ThreadFunction2 {
	
	private boolean flag = false;
	
	// 主线程要实现的功能
	public synchronized void mainFunction(){
		while(!flag){
			try {
				this.wait();
			} catch (InterruptedException e) { 
				e.printStackTrace();
			}
		}
		for(int i=0;i<5;i++){
			System.out.println("mainFunction"+i);
		} 
		this.notify();
		flag = false;
	}
	
	// 子线程要实现的功能
	public synchronized void subFunction(){
		while(flag){
			try {
				this.wait();
			} catch (InterruptedException e) { 
				e.printStackTrace();
			} 
		}
		for(int i=0;i<3;i++){
			System.out.println("subFunction"+i);
		} 
		this.notify();
		flag = true;
	}
 
}
