package com.pcq.thread;

public class StopThread {
	static boolean flag = true;
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		
		new Thread(() -> {
			int num = 0;
			while (flag) {
				try {
					Thread.sleep(100);
				} catch (Exception e) {
					e.printStackTrace();
				}
				System.out.println(Thread.currentThread().getName() + "执行 : " + num++);
			}
			
			
		}, "正在执行线程").start();
		Thread.sleep(500);
		flag = false;
	}

}
