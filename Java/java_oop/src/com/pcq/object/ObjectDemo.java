package com.pcq.object;

/**
 * ������Ĭ�ϼ̳� Object
 * ���÷�����
 * toString(): Ĭ�������������ͺ͵�ַ��Ϣ����˿�ͨ����д�÷�������ö�����Ϣ
 * equals(): Ĭ�ϱȽϵ��ǵ�ַ�������Ҫ�Ƚ϶�����������Ҫ��д�÷���
 * @author Administrator
 *
 */
public class ObjectDemo {
	public static void main(String[] args) {
		System.out.println(null instanceof Person);
		
		Person p1 = new Person("����", 30);
		Person p2 = new Person("����", 25);
		Person p3 = new Person("����", 30);
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
	 * ��дequals����
	 */
	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof Person))//����ͬһ������,����null
			return false;
		if(this == obj)
			return true;
		Person per = (Person)obj;//����ת��
		return this.name.equals(per.name) && this.age == per.age; 
	}
}
