package com.pcq._this;

/**
 * this 可以表示当前成员属性
 * 也可以表示当前对象的方法，方法分为普通方法和构造方法
 * 当使用this()时必须放在构造方法的首行。
 * 首先执行构造方法会隐式的调用super()，即父类的构造方法，
 * 因为子类可能会访问从父类继承下来的属性，因此在子类实例化之前必须实例化父类。
 * 如果this()不放在首行会导致执行super()实例化父类，当调用到this()时又会super()实例化父类。
 * 因此this()必须放在首行。
 * @author Administrator
 *
 */
public class Demo {

	public static void main(String[] args) {
		Person p = new Person();
		System.out.println(p);
		Person p1 = new Person("小明");
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