package com.pcq._extends;

public class ExtendsPractice {

	public static void main(String[] args) {
		Manager m1 = new Manager("张三", 45, Gender.MALE, "财务部部长", 500000.00);
		Manager m2 = new Manager("李四", 55, Gender.MALE, "运行部部部长", 300000.00);
		Manager m3 = new Manager("王五", 37, Gender.FEMALE, "开发部部部长", 200000.00);
		System.out.println(m1);
		System.out.println(m2);
		System.out.println(m3);
		
		Clerk c1 = new Clerk("小张", 20, "男", "财务部", 8000.00);
		System.out.println(c1);

	}

}


//定义员工类，具有姓名、年龄、性别属性，具有构造方法 并且有打印属性信息的方法。
//定义管理层类，继承员工类，有自己的属性职务和年薪。
//定义职员类，继承员工类，有自己的属性所属部门和年薪


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
		return super.toString() + ",所属部门：" + this.deptName + ",工资：" + this.salary;
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
		return super.toString() + ",工作：" + this.job + ",年薪：" + this.income; 
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
		return "员工姓名：" + this.name + ",年龄：" + this.age + ",性别：" + gend; 
	}
	
}