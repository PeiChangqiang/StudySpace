package com.pcq.thread;

/**
 * 实现runnable接口之后 就避开了单继承的局限
 * @author Administrator
 *
 */
public class RunnableDemo {

	public static void main(String[] args) {
		Thread t1 = new Thread(new RunThread("线程A"));
		Thread t2 = new Thread(new RunThread("线程B"));
		Thread t3 = new Thread(new RunThread("线程C"));
		t1.start();
		t2.start();
		t3.start();
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
			System.out.println(this.name + "运行 ：" + i);
		}
		
	}
	
}