package com.pcq.lambda.basicpractice;

import java.util.function.*;
/**
 * ������ϰjava�ڽ��ĺ���ʽ�ӿ�ʹ�÷�ʽ
 * 
 * 
 * �ڽ������ĸ����õģ�
 * 1.�����ͺ���ʽ�ӿ� �����в����з���ֵ
 * 2.�����ͺ���ʽ�ӿ� ���� �в����޷���ֵ
 * 3.�����ͺ���ʽ�ӿ� ���� �޲����з���ֵ
 * 4.�����ͺ���ʽ�ӿ� ���� ��Ҫ�����жϴ���
 * @author pcq
 *
 */
public class PracticeDemo {

	public PracticeDemo() {
		// TODO �Զ����ɵĹ��캯�����
	}

	public static void main(String[] args) {

		//������
		Function<String,String> f1 = String :: toLowerCase;
		System.out.println(f1.apply("Hello World"));
		
		//������
		Consumer<String> con = System.out :: println;
		con.accept("Hello World");
		
		//������
		Supplier<String> sup = "hello world" :: toUpperCase; 
		System.out.println(sup.get());
	}

}



class TestLambda {
	public static void main(String[] args) {
		Consumer<String> c1 = (s) -> System.out.println(s);
		c1.accept("x");
		//ֻ���ʷ���������Ҫʵ�������󣬲��Ҳ���������ʡ��
		Consumer<String> c2 = System.out :: println;
		c2.accept("x");
	}
}


