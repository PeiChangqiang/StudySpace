package com.pcq.thread;


/**
 * �߳�����ִ�б������start��������ʵ����ִ�еĳ���������run������ --Ϊʲô��
 * @author Administrator
 *
 */
public class ThreadDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			
		new MyThread("�߳�A").start();
		new MyThread("�߳�B").start();
		new MyThread("�߳�C").start();
	}

}

class MyThread extends Thread {
	private String name;
	
	public MyThread(String name) {
		this.name = name;
	}
	public void run() {
		for(int i = 0; i < 10; i++) {
			System.out.println(this.name + "���У�" + i);
		}
	}
}
