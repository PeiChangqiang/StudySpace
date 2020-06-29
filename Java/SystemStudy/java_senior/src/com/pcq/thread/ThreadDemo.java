package com.pcq.thread;


/**
 * 线程启动执行必须调用start方法，但实际上执行的程序内容是run方法。 --为什么？
 * @author Administrator
 *
 */
public class ThreadDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			
		Thread t1 = new MyThread("线程A");
		Thread t2 = new MyThread("线程B");
		Thread t3 = new MyThread("线程C");
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
			System.out.println(this.name + "运行：" + i);
		}
	}
}


/**
 * 线程的命名和取得
 * @author pcq
 *
 */
class Demo1 implements Runnable {

	
	public static void main(String[] args) throws Exception {
		Thread thread = new Thread(() -> {
			for (int i = 0; i < 10; i++) {
				System.out.println("线程对象开始礼让了");
				Thread.yield();
				System.out.println(Thread.currentThread().getName() + ":" + i);
			}
		}, "线程对象");
		thread.setPriority(Thread.MAX_PRIORITY);
		System.out.println(thread.getPriority());
		thread.start();
		for (int i = 0; i < 10; i++) {
			System.out.println(Thread.currentThread().getName() + " : " + i);
		}
	}
	@Override
	public void run() {
		// TODO 自动生成的方法存根
		System.out.println(Thread.currentThread().getName());
	}
	
}




