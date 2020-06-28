package com.pcq.array;

//引用对象数组测试
public class ArrayObject {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Student[] stus = {new Student("张三"),new Student(),new Student("李四",25)};
		for(Student stu : stus) {
			System.out.println(stu);
		}
		
		printStudentsInfo(new Student("张三"),new Student(),new Student("李四",25));
	}

	/**
	 * 可变参数，实际是个数组
	 * @param students
	 */
	public static void printStudentsInfo(Student ...students) {
		for(Student stu : students) {
			System.out.println(stu);
		}
	}
	
	
}


class Student {
	private String name;
	private int age;
	
	public Student() {
		this("no-name",20);
	}
	
	public Student(String name) {
		this(name,20);
	}
	
	public Student(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	
	public String getName() {
		return this.name;
	}
	
	public int getAge() {
		return this.age;
	}
	
	public String toString() {
		return "姓名：" + this.name + ",年龄：" + age;
	}
}