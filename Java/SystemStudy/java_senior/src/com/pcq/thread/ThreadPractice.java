package com.pcq.thread;

public class ThreadPractice {

	public static void main(String[] args) {
		TicketThread t1 = new TicketThread("客户");
		new Thread(t1,"1").start();
		new Thread(t1,"2").start();
		new Thread(t1,"3").start();
	}
}


//多线程模拟卖票程序，即票数是有限资源，多线程对票数的抢占
class TicketThread extends Thread {
	private int tickets = 10;//10张票
	private String title;//线程名称
	public TicketThread(String title) {
		this.title = title;
	}
	@Override
	public void run() {
		for(int i = 0; i < 100; i++) {
			if(tickets > 0) {
				System.out.println(this.getName() +"抢票，票数: " + tickets--);
			}
		}
	}
}
