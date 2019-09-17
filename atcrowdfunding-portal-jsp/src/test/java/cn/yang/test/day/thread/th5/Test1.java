package cn.yang.test.day.thread.th5;

/*
 * 设计一个多线程的程序如下：设计一个火车售票模拟程序。假如火车站要有100张火车票要卖出，现在有5个售票点同时售票，用5个线程模拟这5个售票点的售票情况。
 * 
 */
public class Test1 {
	public static void main(String[] args) {
		Ticket ticket = new Ticket();
		new Thread(new ticketOffice(ticket, 11), "售票点1").start();
		new Thread(new ticketOffice(ticket, 22), "售票点2").start();
		new Thread(new ticketOffice(ticket, 33), "售票点3").start();
		new Thread(new ticketOffice(ticket, 19), "售票点4").start();
		new Thread(new ticketOffice(ticket, 21), "售票点5").start();
	}
}

//火车站
class Ticket {
	public int available = 100;// 总票数

	public Ticket() {

	}

	public boolean isTicket(int ticketBuy) {//
		if (ticketBuy > available) {
			return false;
		} else {
			available -= ticketBuy;
			return true;
		}
	}
}

//代售点
class ticketOffice implements Runnable {

	Ticket ticket;// 火车站
	int ticketBuy;// 想购买的票数

	public ticketOffice(Ticket ticket, int ticketBuy) {
		this.ticket = ticket;
		this.ticketBuy = ticketBuy;
	}

	@Override
	public void run() {
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		synchronized (ticket) {
			boolean flag = ticket.isTicket(ticketBuy);
			if (flag) {
				System.out.println(Thread.currentThread().getName() + "想要购票" + ticketBuy + "---------->购票成功 剩余"
						+ ticket.available);
			} else {
				System.out.println(Thread.currentThread().getName() + "想要购票" + ticketBuy + "---------->失败");
			}
		}

	}
}
