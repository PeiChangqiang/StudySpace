package com.pcq.entity_sql;

public class Demo {

	public static void main(String[] args) {
		
		Dept dept = new Dept("财务部","10001");
		Employee e1 = new Employee("张三", dept.getDeptNo(), "财务部领导");
		dept.setLeader(e1);
		System.out.println(dept);
		System.out.println("部门领导：" + dept.getLeader());
		Employee e2 = new Employee("李四", dept.getDeptNo());
		Employee e3 = new Employee("王五", dept.getDeptNo());
		Employee[] emps = {e1, e2, e3};
		dept.setEmployees(emps);
		dept.setLeader(e1);
		for(Employee e : dept.getEmployees()) {
			System.out.println(e);
		}
	}

}
