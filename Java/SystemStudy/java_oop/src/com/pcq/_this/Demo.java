package com.pcq._this;

/**
 * this ���Ա�ʾ��ǰ��Ա����
 * Ҳ���Ա�ʾ��ǰ����ķ�����������Ϊ��ͨ�����͹��췽��
 * ��ʹ��this()ʱ������ڹ��췽�������С�
 * ����ִ�й��췽������ʽ�ĵ���super()��������Ĺ��췽����
 * ��Ϊ������ܻ���ʴӸ���̳����������ԣ����������ʵ����֮ǰ����ʵ�������ࡣ
 * ���this()���������лᵼ��ִ��super()ʵ�������࣬�����õ�this()ʱ�ֻ�super()ʵ�������ࡣ
 * ���this()����������С�
 * @author Administrator
 *
 */
public class Demo {

	public static void main(String[] args) {
		Person p = new Person();
		System.out.println(p);
		Person p1 = new Person("С��");
		System.out.println(p1);
	}
	
}


class Person {
	private String name;
	private Integer age;
	
	public Person() {
		this(null,0);	
	}
	
	public Person(String name) {
		this(name, 10);
	}
	
	public Person(String name, Integer age) {
		this.name = name;
		this.age = age;
	}
	
	public String toString() {
		return "name : " + name + ", age : " + age;
	}
}