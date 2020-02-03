package com.pcq.thread;


/**
 * �߳�����ִ�б������start��������ʵ����ִ�еĳ���������run������ --Ϊʲô��
 * @author Administrator
 *
 */
public class ThreadDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			
		Thread t1 = new MyThread("�߳�A");
		Thread t2 = new MyThread("�߳�B");
		Thread t3 = new MyThread("�߳�C");
		t1.setPriority(Thread.MIN_PRIORITY);
		t2.setPriority(Thread.MAX_PRIORITY);
		t3.setPriority(Thread.NORM_PRIORITY);
		t1.start();
		t2.start();
		t3.start();
	}

}

class MyThread extends Thread {
	private String name;
	
	public MyThread(String name) {
		this.name = name;
	}
	@Override
	public void run() {
		for(int i = 0; i < 10; i++) {
			System.out.println(this.name + "���У�" + i);
		}
	}
}


/**
 * �̵߳�������ȡ��
 * @author pcq
 *
 */
class Demo1 implements Runnable {

	
	public static void main(String[] args) throws Exception {
		Thread thread = new Thread(() -> {
			for (int i = 0; i < 10; i++) {
				System.out.println("�̶߳���ʼ������");
				Thread.yield();
				System.out.println(Thread.currentThread().getName() + ":" + i);
			}
		}, "�̶߳���");
		thread.setPriority(Thread.MAX_PRIORITY);
		System.out.println(thread.getPriority());
		thread.start();
		for (int i = 0; i < 10; i++) {
			System.out.println(Thread.currentThread().getName() + " : " + i);
		}
	}
	@Override
	public void run() {
		// TODO �Զ����ɵķ������
		System.out.println(Thread.currentThread().getName());
	}
	
}




