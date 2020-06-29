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
			System.out.println("消费key : " + key);

		
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
			System.out.println("生产key : " + key);
			db.setKey(key);	
	}
	
}


class DataBox {
	private int[] keys;
	private int index;//下标
	private boolean flag = true;//生产消费指示灯,true 允许生产不允许消费, false允许消费不允许生产
	public DataBox(int size) {
		this.keys = new int[size];
		this.index = 0;
	}
	
	
	//为了简化这里不判断index和数组容量大小的关系。只是简单的测试多线程处理容器数据
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
			throw new RuntimeException("数组中已经没有元素");
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
		//已经生产好了，通知 等待的消费者线程
		this.flag = false;
		super.notify();
	}
	
	public synchronized int getIndex() {
		return this.index;
	}
}