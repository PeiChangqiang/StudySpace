package com.pcq.basic_class;

public class StringBufferClass {
	public static void main(String[] args) {
		StringBuffer sb = new StringBuffer();
		String str = "hello";
		change(str);
		System.out.println(str);
	}
	
	
	static void change(String temp) {
		temp += " world !";
		System.out.println(temp);
	}
	
	
}
//StringBuffer 常用方法insert , delete, reverse

//StringBuffer 和  StringBuilder 的区别是前者具备线程安全性。源代码中 的方法均有 synchronized关键字。