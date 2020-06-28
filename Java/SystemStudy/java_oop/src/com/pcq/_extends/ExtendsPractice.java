package com.pcq._extends;

public class ExtendsPractice {

	public static void main(String[] args) {
		Manager m1 = new Manager("����", 45, Gender.MALE, "���񲿲���", 500000.00);
		Manager m2 = new Manager("����", 55, Gender.MALE, "���в�������", 300000.00);
		Manager m3 = new Manager("����", 37, Gender.FEMALE, "������������", 200000.00);
		System.out.println(m1);
		System.out.println(m2);
		System.out.println(m3);
		
		Clerk c1 = new Clerk("С��", 20, "��", "����", 8000.00);
		System.out.println(c1);

	}

}


//����Ա���࣬�������������䡢�Ա����ԣ����й��췽�� �����д�ӡ������Ϣ�ķ�����
//���������࣬�̳�Ա���࣬���Լ�������ְ�����н��
//����ְԱ�࣬�̳�Ա���࣬���Լ��������������ź���н


class Clerk extends Emp{
	private String deptName;
	private Double salary;
	public Clerk(String name, Integer age, String gender, String deptName, Double salary) {
		super(name, age, gender);
		this.deptName = deptName;
		this.salary = salary;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public Double getSalary() {
		return salary;
	}
	public void setSalary(Double salary) {
		this.salary = salary;
	}
	
	public String toString() {
		return super.toString() + ",�������ţ�" + this.deptName + ",���ʣ�" + this.salary;
	}
}

class Manager extends Emp{
	private String job;
	private Double income;
	public Manager(String name, Integer age, String gend, String job, Double income) {
		super(name, age, gend);
		this.job = job;
		this.income = income;
	}
	
	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public Double getIncome() {
		return income;
	}

	public void setIncome(Double income) {
		this.income = income;
	}

	public String toString() {
		return super.toString() + ",������" + this.job + ",��н��" + this.income; 
	}
}

class Emp {
	private String name;
	private Integer age;
	private String gend;
	
	public Emp(String name, Integer age, String gend) {
		this.name = name;
		this.age = age;
		this.gend = gend;
	}
	
	
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


	public String getGend() {
		return gend;
	}


	public void setGend(String gend) {
		this.gend = gend;
	}


	public String toString() {
		return "Ա��������" + this.name + ",���䣺" + this.age + ",�Ա�" + gend; 
	}
	
}