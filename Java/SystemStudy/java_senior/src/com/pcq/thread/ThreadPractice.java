package com.pcq.thread;

public class ThreadPractice {

	public static void main(String[] args) {
		TicketThread t1 = new TicketThread("�ͻ�");
		new Thread(t1,"1").start();
		new Thread(t1,"2").start();
		new Thread(t1,"3").start();
	}
}


//���߳�ģ����Ʊ���򣬼�Ʊ����������Դ�����̶߳�Ʊ������ռ
class TicketThread extends Thread {
	private int tickets = 10;//10��Ʊ
	private String title;//�߳�����
	public TicketThread(String title) {
		this.title = title;
	}
	@Override
	public void run() {
		for(int i = 0; i < 100; i++) {
			if(tickets > 0) {
				System.out.println(this.getName() +"��Ʊ��Ʊ��: " + tickets--);
			}
		}
	}
}
