package com.pcq.singleton;

public class SingletonDemo {
	
	public static void main(String[] args) {

	}
}



//饿汉式，加载的时候就有了对象
class Singleton {
	
	private static final Singleton instance = new Singleton();
	
	
	public static Singleton getInstance() {
		
		return instance;
	}
	
	private Singleton() {
		
	}
}


//懒汉式，第一次使用的时候才实例化
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