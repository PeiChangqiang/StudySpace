package com.pcq.lambda.basicpractice;

/**
 * ������ϰlambda���ʽ��ʹ��
 * 1.() -> {}
 * 2.(param) -> {}
 * 3.() - > statement
 * @author pcq
 *
 */
public class PracticeLamb {

	public PracticeLamb() {
		// TODO �Զ����ɵĹ��캯�����
	}

	public static void main(String[] args) {
		A a = (str1,str2) -> {
			return str1 == null ? -1 : str1.compareTo(str2);
		};
		System.out.println(a.compare("Adfs", "sdfs"));
		
		B b = (str) -> {
			return str.toUpperCase();
		};
		System.out.println(b.upper("sdfdsf"));
		
	}

}


@FunctionalInterface
interface A {
	int compare(String str1, String str2);
}

@FunctionalInterface
interface B {
	String upper(String str);
}

@FunctionalInterface
interface C {
	int print(int x, int y);
}