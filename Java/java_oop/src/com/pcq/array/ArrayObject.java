package com.pcq.array;

//���ö����������
public class ArrayObject {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Student[] stus = {new Student("����"),new Student(),new Student("����",25)};
		for(Student stu : stus) {
			System.out.println(stu);
		}
		
		printStudentsInfo(new Student("����"),new Student(),new Student("����",25));
	}

	/**
	 * �ɱ������ʵ���Ǹ�����
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
		return "������" + this.name + ",���䣺" + age;
	}
}