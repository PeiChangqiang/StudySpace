package com.pcq.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class CallableDemo {
	
	public static void main(String[] args) throws Exception {
		FutureTask<String> task1 = new FutureTask<String>(new CallThread("A"));
		FutureTask<String> task2 = new FutureTask<String>(new CallThread("B"));
		new Thread(task1).start();
		
		//System.out.println(task1.get());
		new Thread(task2).start();
		
	}

}


class CallThread implements Callable<String> {

	private String name;
	public CallThread(String name) {
		this.name = name;
	}
	@Override
	public String call() throws Exception {
		for(int i = 0; i < 10; i++) {
			System.out.println(this.name + ": " + i);
		}
		return "线程" + name + "执行完毕";
	}
	
}