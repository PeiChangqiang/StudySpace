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
//StringBuffer ���÷���insert , delete, reverse

//StringBuffer ��  StringBuilder ��������ǰ�߾߱��̰߳�ȫ�ԡ�Դ������ �ķ������� synchronized�ؼ��֡�