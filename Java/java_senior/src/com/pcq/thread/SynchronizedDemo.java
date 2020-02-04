package com.pcq.thread;

public class SynchronizedDemo {

	public static void main(String[] args) {
		TicketSeller ts = new TicketSeller();//runnable封装资源
		//模拟三个售票员卖票Thread对runnable资源进行操作
		Thread t1 = new Thread(ts, "售票员A");
		Thread t2 = new Thread(ts, "售票员B");
		Thread t3 = new Thread(ts, "售票员C");
		t1.start();
		t2.start();
		t3.start();
	}
}

class TicketSeller implements Runnable {
	private int tic = 100;// 100张票

	
	public synchronized boolean sale() {
		if (tic > 0) {
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName() + "卖票，票还剩余：" + tic--);
			return true;
		} else {
			return false;
		}
	}
	
	@Override
	public void run() {
		while (this.sale()) {
			;
		}
	}
}
