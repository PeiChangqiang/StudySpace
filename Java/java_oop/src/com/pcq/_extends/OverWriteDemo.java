package com.pcq._extends;

//������д��
public class OverWriteDemo {

	public static void main(String[] args) {
		A b = new B();
		b.start();
	}
}


class A {
	public void run() {
		System.out.println("����ִ��run����...");
	}
	
	public void start() {
		this.run();
	}
}

class B extends A {
	
	public void run() {
		System.out.println("����ִ��run����...");
	}
}