package com.pcq.thread;

public class ExDemo {

	public static void main(String[] args) {
		DataBox db = new DataBox(20);
		Producter pd = new Producter(db);
		Consumer cs = new Consumer(db);
		Thread t1 = new Thread(pd);
		Thread t2 = new Thread(cs);
		t1.start();
		t2.start();

	}

}

class Consumer implements Runnable {

	private DataBox db;
	public Consumer(DataBox db) {
		this.db = db;
	}
	@Override
	public void run() {
			int key = db.getKey();
			System.out.println("����key : " + key);

		
	}
	
}


class Producter implements Runnable {

	private DataBox db;
	
	public Producter(DataBox db) {
		this.db =db;
	}
	@Override
	public void run() {
			int key = (int)(Math.random() * 100);
			System.out.println("����key : " + key);
			db.setKey(key);	
	}
	
}


class DataBox {
	private int[] keys;
	private int index;//�±�
	private boolean flag = true;//��������ָʾ��,true ������������������, false�������Ѳ���������
	public DataBox(int size) {
		this.keys = new int[size];
		this.index = 0;
	}
	
	
	//Ϊ�˼����ﲻ�ж�index������������С�Ĺ�ϵ��ֻ�Ǽ򵥵Ĳ��Զ��̴߳�����������
	public synchronized int getKey() {
		if (flag) {
			try {
				super.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		int key;
		if (index > 0) {
			try {
				key = keys[index--];
				return key;
			} finally {
				this.flag = true;
				super.notify();
			}
			
		} else {
			throw new RuntimeException("�������Ѿ�û��Ԫ��");
		}		
	}
	
	public synchronized void setKey(int key) {
		if(!flag) {
			try {
				super.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		this.keys[index++] = key;
		//�Ѿ��������ˣ�֪ͨ �ȴ����������߳�
		this.flag = false;
		super.notify();
	}
	
	public synchronized int getIndex() {
		return this.index;
	}
}