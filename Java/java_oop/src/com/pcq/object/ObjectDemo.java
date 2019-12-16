package com.pcq.object;

/**
 * 所有类默认继承 Object
 * 常用方法：
 * toString(): 默认输出对象的类型和地址信息。因此可通过重写该方法来获得对象信息
 * equals(): 默认比较的是地址，如果需要比较对象内容则需要重写该方法
 * @author Administrator
 *
 */
public class ObjectDemo {
	public static void main(String[] args) {
		System.out.println(null instanceof Person);
		
		Person p1 = new Person("张三", 30);
		Person p2 = new Person("李四", 25);
		Person p3 = new Person("张三", 30);
		System.out.println(p1.equals(p2));
		System.out.println(p1.equals(p3));
	}
}


class Person {
	private String name;
	private Integer age;
	
	public Person(String name, Integer age) {
		this.name = name;
		this.age = age;
	}
	
	/**
	 * 重写equals方法
	 */
	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof Person))//不是同一个类型,包括null
			return false;
		if(this == obj)
			return true;
		Person per = (Person)obj;//向下转型
		return this.name.equals(per.name) && this.age == per.age; 
	}
}
