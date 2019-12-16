package com.pcq._extends;

/**
 * 1）private 的方法不会被继承，因此对子类是一个新的方法
 * 2）final修饰的方法不可重写。
 * 3)final修饰的属性是一个常量
 * @author Administrator
 *
 */
public class OverWriteDemo {

	public static void main(String[] args) {
		A x = new B();
		x.start();
		String a = "abc";
		final String b = "b";
		String c = "a" + b + "c";
		String c1 = "a" + "b" + "c";
		System.out.println(a == c1);
		System.out.println(a == c);
	}
}


class A {
	private void run() {
		System.out.println("父类执行run方法...");
	}
	
	public void start() {
		this.run();
	}
	
	public final void doSomething() {
		
	}
}

class B extends A {
	
	public void run() {
		System.out.println("子类执行run方法...");
	}
	
	/*public void doSomething() {
		
	}*/
}