package com.pcq.thread;

public class SynchronizedDemo {

	public static void main(String[] args) {
		TicketSeller ts = new TicketSeller();//runnable��װ��Դ
		//ģ��������ƱԱ��ƱThread��runnable��Դ���в���
		Thread t1 = new Thread(ts, "��ƱԱA");
		Thread t2 = new Thread(ts, "��ƱԱB");
		Thread t3 = new Thread(ts, "��ƱԱC");
		t1.start();
		t2.start();
		t3.start();
	}
}

class TicketSeller implements Runnable {
	private int tic = 100;// 100��Ʊ

	
	public synchronized boolean sale() {
		if (tic > 0) {
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName() + "��Ʊ��Ʊ��ʣ�ࣺ" + tic--);
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
