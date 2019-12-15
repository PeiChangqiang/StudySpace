package com.pcq._extends;

//方法重写。
public class OverWriteDemo {

	public static void main(String[] args) {
		A b = new B();
		b.start();
	}
}


class A {
	public void run() {
		System.out.println("父类执行run方法...");
	}
	
	public void start() {
		this.run();
	}
}

class B extends A {
	
	public void run() {
		System.out.println("子类执行run方法...");
	}
}