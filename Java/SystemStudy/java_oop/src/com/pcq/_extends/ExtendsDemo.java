package com.pcq._extends;

public class ExtendsDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//ClassMate cm = new ClassMate("张三", 20, "斯坦福");
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
		System.out.println("person实例化");
	}
	
	public Person() {
		
	}
	
}

class Student extends Person {
	
	private String school;

	public Student() {
		
	}
	public Student(String name, Integer age, String school) {
		super(name, age);//父类没有提供无参构造方法，因此子类必须实例化必须明确调用父类的有参构造。因为不管怎么样，在实例化子类之前，必须先正确实例化父类。
		this.school = school;
		System.out.println("student实例化");
	}
	public String getSchool() {
		return school;
	}

	public void setSchool(String school) {
		this.school = school;
	}
	
	
}

//多层继承
class ClassMate extends Student {

	private String deskNo;
	public ClassMate(String deskNo) {
		this.deskNo = deskNo;
	}
	
	public String getDeskNo() {
		return this.deskNo;
	}
	
	
}