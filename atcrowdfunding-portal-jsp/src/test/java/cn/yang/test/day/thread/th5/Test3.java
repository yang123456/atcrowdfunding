package cn.yang.test.day.thread.th5;

/*
 *  编写多线程程序，模拟多个人通过一个山洞的模拟。这个山洞每次只能通过一个人，每个人通过山洞的时间为5秒，有10个人同时准备过此山洞，显示每次通过山洞人的姓名和顺序。
 */
public class Test3 {
	public static void main(String[] args) {
		Hole hole = new Hole();
		for (int i = 0; i < 10; i++) {
			new Thread(new People(hole), "爬洞" + i).start();
		}
	}
}

//洞
class Hole {
	public int order = 0;// 初始化顺序

	public Hole() {
		// TODO Auto-generated constructor stub
	}

}

//人
class People implements Runnable {
	Hole hole;

	public People(Hole hole) {
		this.hole = hole;
	}

	@Override
	public void run() {
		synchronized (hole) {
			try {
				Thread.sleep(2000);// 爬洞时间
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName() + "----->穿过山洞----->顺序为" + ++hole.order);
		}
	}

}
