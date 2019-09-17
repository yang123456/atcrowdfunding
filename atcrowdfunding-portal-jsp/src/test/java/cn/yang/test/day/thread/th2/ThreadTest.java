package cn.yang.test.day.thread.th2;
 
// 面试题2:设计四个线程,其中两个线程每次对变量i加1,另外两个线程每次对i减1.
public class ThreadTest { 
      
    public static void main(String[] args){ 
    	
    	final ThreadTestFunction f = new ThreadTestFunction();
    	
    	Thread t1 = new Thread(new Runnable(){
    		public void run(){
    			f.add();
    		} 
    	});
    	
    	Thread t2 = new Thread(new Runnable(){
    		public void run(){
    			f.add();
    		} 
    	});
    	
    	Thread t3 = new Thread(new Runnable(){
    		public void run(){
    			f.sub();;
    		} 
    	});
    	
    	Thread t4 = new Thread(new Runnable(){
    		public void run(){
    			f.sub();
    		} 
    	}); 
    	 
    	t1.start();
    	t2.start();
    	t3.start();
    	t4.start();
    }  
}
