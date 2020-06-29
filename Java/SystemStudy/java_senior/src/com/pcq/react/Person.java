package com.pcq.react;

public class Person {

	public Person() {
		// TODO 自动生成的构造函数存根
	}

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		Class<?> c = Person.class;
		System.out.println(c.getName());
		Class<?> c1;
		try {
			c1 = Class.forName("com.pcq.react.Person");
			System.out.println(c1.getName());
		} catch (ClassNotFoundException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		Person p = new Person();
		Class<?> c2 = p.getClass();
		System.out.println(c2.getName());
	}

}
