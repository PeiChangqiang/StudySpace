package com.pcq.thread;


/**
 * 线程启动执行必须调用start方法，但实际上执行的程序内容是run方法。 --为什么？
 * @author Administrator
 *
 */
public class ThreadDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			
		new MyThread("线程A").start();
		new MyThread("线程B").start();
		new MyThread("线程C").start();
	}

}

class MyThread extends Thread {
	private String name;
	
	public MyThread(String name) {
		this.name = name;
	}
	public void run() {
		for(int i = 0; i < 10; i++) {
			System.out.println(this.name + "运行：" + i);
		}
	}
}
