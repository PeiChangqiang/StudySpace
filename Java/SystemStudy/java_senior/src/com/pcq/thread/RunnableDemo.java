package com.pcq.thread;

/**
 * ʵ��runnable�ӿ�֮�� �ͱܿ��˵��̳еľ���
 * @author Administrator
 *
 */
public class RunnableDemo {

	public static void main(String[] args) {
		/*Thread t1 = new Thread(new RunThread("�߳�A"));
		Thread t2 = new Thread(new RunThread("�߳�B"));
		Thread t3 = new Thread(new RunThread("�߳�C"));
		t1.start();
		t2.start();
		t3.start();*/
		for(int j = 0; j < 4; j++) {
			String title = "�߳�" + j;
			new Thread(()->{
			    for(int i = 0; i < 10; i++) {
			        System.out.println(title + ": " + i);
			    }
			}).start();
		}
		
	}

}



class RunThread implements Runnable {

	private String name;
	
	public RunThread(String name) {
		this.name = name;
	}
	@Override
	public void run() {
		for(int i = 0; i < 10; i++) {
			System.out.println(this.name + "���� ��" + i);
		}
		
	}
	
}