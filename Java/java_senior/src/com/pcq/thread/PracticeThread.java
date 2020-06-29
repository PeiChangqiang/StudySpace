package com.pcq.thread;

public class PracticeThread {

	public static void main(String[] args) {
		Resource resource = new Resource();
		AddThread at = new AddThread(resource);
		SubThread st = new SubThread(resource);
		new Thread(at, "加法线程 A").start();
		new Thread(at, "加法线程 B").start();
		new Thread(st, "减法线程 A").start();
		new Thread(st, "减法线程 B").start();

	}

}


class AddThread implements Runnable {
	Resource resource;
	public AddThread(Resource resource) {
		this.resource = resource;
	}
	@Override
	public void run() {
		for (int i = 0; i < 50; i++) {
			try {
				this.resource.add();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}

class SubThread implements Runnable {
	Resource resource;
	public SubThread(Resource resource) {
		this.resource = resource;
	}
	@Override
	public void run() {
		for (int i = 0; i < 50; i++) {
			try {
				this.resource.sub();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}

class Resource {
	private int num = 0;
	private boolean flag = true;//true时只能加法，false只能减法
	
	public synchronized void add() throws Exception {
		if(!flag) {
			super.wait();
		}
		Thread.sleep(100);
		this.num++;
		System.out.println(Thread.currentThread().getName() + "加法操作：" + this.num);
		this.flag = false;
		super.notifyAll();
	}
	
	
	public synchronized void sub() throws Exception {	
		if(flag) {
			super.wait();
		}
		Thread.sleep(100);
		this.num--;
		System.out.println(Thread.currentThread().getName() + "减法操作：" + this.num);
		this.flag = true;
		super.notifyAll();
	}
}