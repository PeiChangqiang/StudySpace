package com.pcq.react;

public class Person {

	public Person() {
		// TODO �Զ����ɵĹ��캯�����
	}

	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		Class<?> c = Person.class;
		System.out.println(c.getName());
		Class<?> c1;
		try {
			c1 = Class.forName("com.pcq.react.Person");
			System.out.println(c1.getName());
		} catch (ClassNotFoundException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		Person p = new Person();
		Class<?> c2 = p.getClass();
		System.out.println(c2.getName());
	}

}
