package com.pcq._extends;

public class ExtendsDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//ClassMate cm = new ClassMate("����", 20, "˹̹��");
	}

}


class Person {
	private String name;
	private Integer age;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	
	public Person(String name, Integer age) {
		this.name = name;
		this.age = age;
		System.out.println("personʵ����");
	}
	
	public Person() {
		
	}
	
}

class Student extends Person {
	
	private String school;

	public Student() {
		
	}
	public Student(String name, Integer age, String school) {
		super(name, age);//����û���ṩ�޲ι��췽��������������ʵ����������ȷ���ø�����вι��졣��Ϊ������ô������ʵ��������֮ǰ����������ȷʵ�������ࡣ
		this.school = school;
		System.out.println("studentʵ����");
	}
	public String getSchool() {
		return school;
	}

	public void setSchool(String school) {
		this.school = school;
	}
	
	
}

//���̳�
class ClassMate extends Student {

	private String deskNo;
	public ClassMate(String deskNo) {
		this.deskNo = deskNo;
	}
	
	public String getDeskNo() {
		return this.deskNo;
	}
	
	
}