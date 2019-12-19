package com.pcq.singleton;

public class SingletonDemo {
	
	public static void main(String[] args) {

	}
}



//����ʽ�����ص�ʱ������˶���
class Singleton {
	
	private static final Singleton instance = new Singleton();
	
	
	public static Singleton getInstance() {
		
		return instance;
	}
	
	private Singleton() {
		
	}
}


//����ʽ����һ��ʹ�õ�ʱ���ʵ����
class Singleton2  {
	
	private static  Singleton2 instance;
	public static Singleton2 getInstance() {
		if(instance == null) {
			instance = new Singleton2();
		}
		return instance;
	}
	
	private Singleton2() {
		
	}
}