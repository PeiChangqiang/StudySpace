package com.pcq._extends;

/**
 * 1��private �ķ������ᱻ�̳У���˶�������һ���µķ���
 * 2��final���εķ���������д��
 * 3)final���ε�������һ������
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
		System.out.println("����ִ��run����...");
	}
	
	public void start() {
		this.run();
	}
	
	public final void doSomething() {
		
	}
}

class B extends A {
	
	public void run() {
		System.out.println("����ִ��run����...");
	}
	
	/*public void doSomething() {
		
	}*/
}