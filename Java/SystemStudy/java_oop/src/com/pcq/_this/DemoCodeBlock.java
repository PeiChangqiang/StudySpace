package com.pcq._this;
/**
 * ��ִ�о�̬����飬�ٹ���飬���ִ�й��췽��
 * ����̬�����ִֻ��һ�Σ���Ҫ��Ϊ����֮�еľ�̬���Գ�ʼ��
 * @author Administrator
 *
 */
public class DemoCodeBlock {

	static {
		System.out.println("������������ִ�У�����������ִ��ǰ��һЩ׼������");
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("������ִ��");
		new A();
		new A();
	}

}


class A {
	public A() {
		System.out.println("���췽��ִ��");
	}
	{
		System.out.println("��������ִ��");
	}
	
	static {
		System.out.println("��̬�����ִ��");
	}
}